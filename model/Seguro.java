package model;

import java.io.Serializable;

public class Seguro implements Serializable{
	
	private static final long serialVersionUID = 7796372954156733114L;
	
	private final String descricao;
	private final int percentualTarifa;
	
	public Seguro (String descricao, int percentualTarifa) {
		this.descricao = descricao;
		this.percentualTarifa = percentualTarifa;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getPercentualTarifa() {
		return percentualTarifa;
	}
	
	
}
