package model;

import java.util.Date;

public class PessoaFisica extends Cliente {

	private static final long serialVersionUID = -6949786183798229303L;

	private final long cpf;
	private long numCNH;
	private Date validadeCNH;


	public PessoaFisica(long cpf, long numCNH, Date validadeCNH, String nome, long telefone, String email,
			Endereco endereco) {
		super(nome, email, telefone, endereco);
		this.cpf = cpf;
		this.numCNH = numCNH;
		this.validadeCNH = validadeCNH;
	}


	public void setNumCNH(long numCNH) {
		this.numCNH = numCNH;
	}

	public void setValidadeCNH(Date validadeCNH) {
		this.validadeCNH = validadeCNH;
	}

	public long getCpf() {
		return cpf;
	}

	public long getNumCNH() {
		return numCNH;
	}

	public Date getValidadeCNH() {
		return validadeCNH;
	}

}
