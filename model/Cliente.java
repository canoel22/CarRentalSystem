package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Cliente implements Serializable {
	
	private static final long serialVersionUID = 4275623360457068349L;
	
	private String nome;	
	private String email;
	private String telefone;
	
	private Endereco endereco;
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	
	public Cliente(String nome, String email, String telefone, Endereco endereco) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;	
	}

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
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