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
		this.momento=pedido.getMomento();
		this.status= pedido.getStatus();	
		this.clienteID= pedido.getCliente().getId();
	
}
	
	public PedidoDTO() {

	}
	public PedidoDTO(Long id, Instant momento, StatusDoPedido status, Long clienteID) {
		this.id = id;
		this.momento = momento;
		this.status = status;
		this.clienteID = clienteID;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getMomento() {
		return momento;
	}
	public void setMomento(Instant momento) {
		this.momento = momento;
	}
	public StatusDoPedido getStatus() {
		return status;
	}
	public void setStatus(StatusDoPedido status) {
		this.status = status;
	}
	public Long getClienteID() {
		return clienteID;
	}
	public void setClienteID(Long clienteID) {
		this.clienteID = clienteID;
	}
}