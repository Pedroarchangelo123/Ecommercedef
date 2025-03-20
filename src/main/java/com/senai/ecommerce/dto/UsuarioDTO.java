package com.senai.ecommerce.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.senai.ecommerce.entities.Usuario;

public class UsuarioDTO {
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String senha;
	private List<PedidoDTO> pedidos;
	public UsuarioDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.telefone = usuario.getTelefone();
		this.senha = usuario.getSenha();
		this.pedidos = usuario.getPedidos().stream()
				.map(PedidoDTO::new	)
				.collect(Collectors.toList());
	}


}
