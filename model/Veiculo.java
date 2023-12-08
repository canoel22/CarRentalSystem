package model;

import java.util.ArrayList;

public class Veiculo {

	private final String placa;
	private final String cor;
	private final int anoFabricacao;
	private EStatusVeiculo status;
	private int quilometragem;

	private final Modelo modelo;
	private ArrayList<Locacao> locacoes = new ArrayList<Locacao>();

	public Veiculo(String placa, String cor, int anoFabricacao, Modelo modelo) {
		this.placa = placa;
		this.cor = cor;
		this.anoFabricacao = anoFabricacao;
		this.modelo = modelo;
	}

	public int getQuilometragem() {
		return quilometragem;
	}
	
	public void setQuilometragem(int quilometragem) {
		this.quilometragem = quilometragem;
	}
	
	public Modelo getModelo() {
		return modelo;
	}
	
	public EStatusVeiculo getStatus() {
		return status;
	}

	public void setStatus(EStatusVeiculo status) {
		this.status = status;
	}

	public String getPlaca() {
		return placa;
	}

	public String getCor() {
		return cor;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}
}