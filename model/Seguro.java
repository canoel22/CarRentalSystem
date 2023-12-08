package model;

public class Seguro {
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
