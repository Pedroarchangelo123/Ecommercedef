package com.senai.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.senai.ecommerce.dto.UsuarioDTO;
import com.senai.ecommerce.services.UsuarioService;

public class UsuarioController {
	 @Autowired
	 private UsuarioService usuarioService;
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<UsuarioDTO> buscarusuario(@PathVariable Long id){
		 return ResponseEntity.ok(usuarioService.buscarUsuario(id));	
	 }
}
