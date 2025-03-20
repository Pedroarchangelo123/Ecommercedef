package com.senai.ecommerce.dto;

import java.time.Instant;

import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.entities.StatusDoPedido;

public class PedidoDTO {
 private Long id;
	private Instant momento;
	private StatusDoPedido status;
	private Long clienteID;
	public PedidoDTO(Pedido pedido) {
		this.id= pedido.getId();
		this.status= pedido.getStatus();	
		this.clienteID= pedido.getCliente().getId();
	
}
}