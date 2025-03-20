package com.senai.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.senai.ecommerce.dto.PedidoDTO;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.services.PedidoService;


public class PedidoController {
	 @Autowired
	 private PedidoService pedidoService;
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<PedidoDTO> criarPedido(@PathVariable Long usuarioId, @RequestBody Pedido pedido){
		 return ResponseEntity.ok(pedidoService.criarPedido(usuarioId, pedido));	
	 }
}
