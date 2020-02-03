package br.com.diego.domain;

import br.com.diego.domain.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento{

	private Integer numeroDeParcelas;

	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
}
