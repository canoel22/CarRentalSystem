package model;

import java.io.Serializable;

public abstract class Cliente implements Serializable {

	private static final long serialVersionUID = 4275623360457068349L;

	private String nome;
	private String email;
	private long telefone;

	private Endereco endereco;

	public Cliente(String nome, String email, long telefone, Endereco endereco) {
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