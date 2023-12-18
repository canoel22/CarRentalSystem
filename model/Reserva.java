package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Reserva implements Serializable {

	private static final long serialVersionUID = 3094834473305359132L;

	private final UUID numReserva = UUID.randomUUID();
	private final Date inicioReserva;
	private final Date fimReserva;
	private final double valorTarifaDiaria;

	private final Categoria categoria;
	private final Cliente cliente;
	private List<Seguro> segurosContratados = new ArrayList<Seguro>();

	public Reserva(Date inicioReserva, Date fimReserva, double valorTarifaDiaria, Categoria categoria, Cliente cliente,
			List<Seguro> segurosContratados) {
		this.inicioReserva = inicioReserva;
		this.fimReserva = fimReserva;
		this.valorTarifaDiaria = valorTarifaDiaria;
		this.categoria = categoria;
		this.cliente = cliente;
		this.segurosContratados = segurosContratados;
	}

	public UUID getNumReserva() {
		return numReserva;
	}

	public Date getInicioReserva() {
		return inicioReserva;
	}

	public List<Seguro> getSegurosContratados() {
		return segurosContratados;
	}

	public void setSegurosContratados(ArrayList<Seguro> segurosContratados) {
		this.segurosContratados = segurosContratados;
	}

	public Date getFimReserva() {
		return fimReserva;
	}

	public double getValorTarifaDiaria() {
		return valorTarifaDiaria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
