package model;

import java.io.Serializable;
import java.util.Date;

public class Pagamento implements Serializable{
	
	private static final long serialVersionUID = -4876013713910747039L;
	
	private final EFormaPagamento tipo;
	private final Date data;
	private final double valor;
	private final MotivoPagamento motivo;
	private final String descricao;
	
	public Pagamento (EFormaPagamento tipo, Date data, double valor, MotivoPagamento motivo, String descricao){
		this.tipo = tipo;
		this.data = data;
		this.valor = valor;
		this.motivo = motivo;
		this.descricao = descricao;
	}

	public EFormaPagamento getTipo() {
		return tipo;
	}

	public Date getData() {
		return data;
	}

	public double getValor() {
		return valor;
	}

	public MotivoPagamento getMotivo() {
		return motivo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
