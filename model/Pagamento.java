package model;

import java.util.Date;

public class Pagamento {
	private final FormaPagamento tipo;
	private final Date data;
	private final int valor;
	private final MotivoPagamento motivo;
	private final String descricao;
	
	public Pagamento (FormaPagamento tipo, Date data, int valor, MotivoPagamento motivo, String descricao){
		this.tipo = tipo;
		this.data = data;
		this.valor = valor;
		this.motivo = motivo;
		this.descricao = descricao;
	}

	public FormaPagamento getTipo() {
		return tipo;
	}

	public Date getData() {
		return data;
	}

	public int getValor() {
		return valor;
	}

	public MotivoPagamento getMotivo() {
		return motivo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
