package model;

import java.io.Serializable;

public class Veiculo implements Serializable {

	private static final long serialVersionUID = 924528742543802098L;

	private final String placa;
	private final String cor;
	private final int anoFabricacao;
	private EStatusVeiculo status;
	private int quilometragem;

	private final Modelo modelo;

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