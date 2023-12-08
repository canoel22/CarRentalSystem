package model;

import java.io.Serializable;

public class Modelo implements Serializable {

	private static final long serialVersionUID = 449607386537647735L;

	private final String nome;
	private final int anoModelo;
	private final String fabricante;
	
	
	public Modelo(String nome, int anoModelo, String fabricante) {
		this.nome = nome;
		this.anoModelo = anoModelo;
		this.fabricante = fabricante;
	}
	
	public String getNome() {
		return nome;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public String getFabricante() {
		return fabricante;
	}
	
	
}
