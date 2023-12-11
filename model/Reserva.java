package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Reserva implements Serializable {

	private static final long serialVersionUID = 3094834473305359132L;

	private final int numReserva;
	private final String inicioReserva;
	private final String fimReserva;
	private final int valorTarifaDiaria;

	private Categoria categoria;
	private ArrayList<Seguro> segurosContratados = new ArrayList<Seguro>();

	public Reserva(int numReserva, String inicioReserva, String fimReserva, int valorTarifaDiaria, Categoria categoria) {
		this.numReserva = numReserva;
		this.inicioReserva = inicioReserva;
		this.fimReserva = fimReserva;
		this.valorTarifaDiaria = valorTarifaDiaria;
		this.categoria = categoria;
	}

	public int getNumReserva() {
		return numReserva;
	}

	public String getInicioReserva() {
		return inicioReserva;
	}

	public ArrayList<Seguro> getSegurosContratados() {
		return segurosContratados;
	}

	public void setSegurosContratados(ArrayList<Seguro> segurosContratados) {
		this.segurosContratados = segurosContratados;
	}

	public String getFimReserva() {
		return fimReserva;
	}

	public int getValorTarifaDiaria() {
		return valorTarifaDiaria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
