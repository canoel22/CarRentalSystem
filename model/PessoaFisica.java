package model;

import java.util.ArrayList;

public class PessoaFisica extends Cliente {

	private static final long serialVersionUID = -6949786183798229303L;

	private final String cpf;
	private String numCNH;
	private String validadeCNH;

	private ArrayList<Locacao> locacoes = new ArrayList<Locacao>();

	public ArrayList<Locacao> getLocacoes() {
		return locacoes;
	}

	public PessoaFisica(String cpf, String numCNH, String validadeCNH, String nome, String telefone, String email,
			Endereco endereco) {
		super(nome, email, telefone, endereco);
		this.cpf = cpf;
		this.numCNH = numCNH;
		this.validadeCNH = validadeCNH;
	}

	public void setLocacoes(ArrayList<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

	public void setNumCNH(String numCNH) {
		this.numCNH = numCNH;
	}

	public void setValidadeCNH(String validadeCNH) {
		this.validadeCNH = validadeCNH;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNumCNH() {
		return numCNH;
	}

	public String getValidadeCNH() {
		return validadeCNH;
	}

}
