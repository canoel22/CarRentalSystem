package model;

import java.util.ArrayList;
import java.util.Date;

public class Reserva {
	private final int numReserva;
	private final Date inicioReserva;
	private final Date fimReserva;
	private final int valorTarifaDiaria;

	private Categoria categoria;
	private ArrayList<Seguro> segurosContratados = new ArrayList<Seguro>();
	
	public Reserva(int numReserva, Date inicioReserva, Date fimReserva, int valorTarifaDiaria) {
		this.numReserva = numReserva;
		this.inicioReserva = inicioReserva;
		this.fimReserva = fimReserva;
		this.valorTarifaDiaria = valorTarifaDiaria;
	}

	public int getNumReserva() {
		return numReserva;
	}

	public Date getInicioReserva() {
		return inicioReserva;
	}

	public ArrayList<Seguro> getSegurosContratados() {
		return segurosContratados;
	}

	public void setSegurosContratados(ArrayList<Seguro> segurosContratados) {
		this.segurosContratados = segurosContratados;
	}

	public Date getFimReserva() {
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
