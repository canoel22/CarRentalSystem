package model;

import java.util.ArrayList;	

public class Categoria {

	private final String nome;
	private double tarifaDiaria;
	
	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private ArrayList<Seguro> seguros = new ArrayList<Seguro>();
	


	public Categoria(String nome) {
		this.nome = nome;
	}


	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}


	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}


	public ArrayList<Reserva> getReservas() {
		return reservas;
	}


	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
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
	
	public void addVeiculo (Veiculo veiculo) {
		veiculos.add(veiculo);
	}
	
	public void removeVeiculo (Veiculo veiculo) {
		veiculos.remove(veiculo);
	}
	
	public StringBuilder listarItens () {
		StringBuilder builder = new StringBuilder();
		return builder;
	}
	
	
	
}
