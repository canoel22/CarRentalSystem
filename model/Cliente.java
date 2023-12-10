package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Cliente implements Serializable {
	
	private static final long serialVersionUID = 4275623360457068349L;
	
	private String nome;	
	private String email;
	private long telefone;
	
	private Endereco endereco;
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void getContato() {
		
	}
	

}