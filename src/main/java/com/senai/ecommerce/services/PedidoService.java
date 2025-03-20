package com.senai.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.senai.ecommerce.dto.PedidoDTO;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.entities.Usuario;
import com.senai.ecommerce.repositories.PedidoRepository;
import com.senai.ecommerce.repositories.UsuarioRepository;

public class PedidoService {
 @Autowired
 private PedidoRepository pedidoRepository;
 @Autowired
 private UsuarioRepository usuarioRepository;
 
 public PedidoDTO criarPedido(Long usuarioID, Pedido pedido) {
	 Usuario usuario = usuarioRepository.findById(usuarioID)
			 .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	 pedido.setCliente(usuario);
	 pedido = pedidoRepository.save(pedido);
	 return new PedidoDTO(pedido);
 }
}
