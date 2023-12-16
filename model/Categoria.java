package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Categoria implements Serializable {

	private static final long serialVersionUID = 2047187435370298060L;

	private final String nome;
	private double tarifaDiaria;

	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	private ArrayList<Seguro> seguros = new ArrayList<Seguro>();

	public Categoria(String nome, double tarifaDiaria) {
		this.nome = nome;
		this.tarifaDiaria = tarifaDiaria;
	}

	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public ArrayList<Seguro> getSeguros() {
		return seguros;
	}

	public void setSeguros(ArrayList<Seguro> seguros) {
		this.seguros = seguros;
	}

	public String getNome() {
		return nome;
	}

	public double getTarifaDiaria() {
		return tarifaDiaria;
	}

	public void setTarifaDiaria(double tarifaDiaria) {
		this.tarifaDiaria = tarifaDiaria;
	}

	public void addVeiculo(Veiculo veiculo) {
		veiculos.add(veiculo);
	}

	public void removeVeiculo(Seguro seguro) {
		seguros.remove(seguro);
	}

	public void addSeguro(Seguro seguro) {
		seguros.add(seguro);
	}

	public void removeSeguro(Veiculo veiculo) {
		veiculos.remove(veiculo);
	}

	public StringBuilder listarItens() {
		StringBuilder builder = new StringBuilder();
		return builder;
	}

}
