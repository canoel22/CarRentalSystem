package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categoria implements Serializable {

	private static final long serialVersionUID = 2047187435370298060L;

	private final String nome;
	private double tarifaDiaria;

	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	private List<Seguro> seguros = new ArrayList<Seguro>();

	public Categoria(String nome, double tarifaDiaria) {
		this.nome = nome;
		this.tarifaDiaria = tarifaDiaria;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public List<Seguro> getSeguros() {
		return seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
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
