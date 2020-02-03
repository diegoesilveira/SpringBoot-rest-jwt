package br.com.diego.domain;

import java.util.Date;

public class Pedido {
	
	private Integer id;
	private Date instante;
	
	private Pagamento pagamento;
	
	private Cliente cliente;
	
	private Endereco enderecoEntrega;
	
	public Pedido() {
		
	}

	public Pedido(Integer id, Date instante, Pagamento pagamento, Cliente cliente, Endereco enderecoEntrega) {
		
		this.id = id;
		this.instante = instante;
		this.pagamento = pagamento;
		this.cliente = cliente;
		this.enderecoEntrega = enderecoEntrega;
	}
	
	
	
	

}