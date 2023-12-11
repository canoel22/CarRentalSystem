package model;

public class PessoaJuridica extends Cliente {

	private static final long serialVersionUID = 5599450373375427185L;

	private final String cnpj;
	private String nomePessoaContato;

	public PessoaJuridica(String cnpj, String nomePessoaContato, String nome, String telefone, String email,
			Endereco endereco) {
		super(nome, email, telefone, endereco);
		this.cnpj = cnpj;
		this.nomePessoaContato = nomePessoaContato;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getNomePessoaContato() {
		return nomePessoaContato;
	}

	public void setNomePessoaContato(String nomePessoaContato) {
		this.nomePessoaContato = nomePessoaContato;
	}

}
