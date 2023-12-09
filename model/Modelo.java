package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Modelo implements Serializable {

	private static final long serialVersionUID = 449607386537647735L;

	private final String nome;
	private final int anoModelo;
	private final String fabricante;
	
	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	
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

	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	public void addVeiculo (Veiculo veiculo) {
		veiculos.add(veiculo);
	}
	
	
}
