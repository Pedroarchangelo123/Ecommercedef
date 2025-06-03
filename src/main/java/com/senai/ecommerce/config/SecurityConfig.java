package com.senai.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
public class SecurityConfig {
	@Autowired
	SecurityFilter securityFilter; //Injeção de dependência do filtro de segurança personalizado
	
	
	@Bean	//Para encriptar a senha usamos esse método que retorna a senha encriptada.	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		}
//	  @Bean //Ele permite que todos façam login, ou seja sem depender do token
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//	    	http.csrf(csrf -> csrf.disable());
//	    	http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
//	    	return http.build();
//	    }
	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http	
				.csrf(csrf -> csrf.disable()) //Desabilita a proteção CSRF
				.sessionManagement(session -> session
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //Define a política de sessão como sem estado
				.authorizeHttpRequests(authorize -> authorize 
						.requestMatchers(HttpMethod.POST, "/usuario/login").permitAll() //Permite acesso ao endpoint de login
						.requestMatchers(HttpMethod.POST, "/usuario/salvar").permitAll()//Permite acesso ao endpoint de salvar usuário
						.requestMatchers(HttpMethod.POST, "/produto/criar").hasRole("ADM")//Permite acesso ao endpoint de criar produto apenas para usuários com a role ADM
						.requestMatchers(HttpMethod.DELETE, "/produto/{id}").hasRole("ADM")
						.anyRequest().authenticated() //Exige autenticação para qualquer outra requisição
						)
				.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) //Adiciona o filtro de segurança antes do filtro de autenticação padrão
				.build(); //O build finaliza a configuração do filtro de segurança
			
	}
}
