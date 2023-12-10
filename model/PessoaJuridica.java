package model;

public class PessoaJuridica extends Cliente {

	private static final long serialVersionUID = 5599450373375427185L;

	private final long cnpj;
	private String nomePessoaContato;

	public PessoaJuridica(long cnpj, String nomePessoaContato, String nome, long telefone, String email,
			Endereco endereco) {
		super(nome, email, telefone, endereco);
		this.cnpj = cnpj;
		this.nomePessoaContato = nomePessoaContato;
	}

	public long getCnpj() {
		return cnpj;
	}

	public String getNomePessoaContato() {
		return nomePessoaContato;
	}

	public void setNomePessoaContato(String nomePessoaContato) {
		this.nomePessoaContato = nomePessoaContato;
	}

}
