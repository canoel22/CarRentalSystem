package model;

import java.util.ArrayList;
import java.util.Date;

public class Locacao {
	private final Date dataHoraRetirada;
	private final long kmRetirada; 
	private Date dataHoraDevolucao;
	private long kmDevolucao; 
	
	private PessoaFisica condutor;
	private ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
	
	public PessoaFisica getCondutor() {
		return condutor;
	}

	public void setCondutor(PessoaFisica condutor) {
		this.condutor = condutor;
	}

	
	public Locacao(Date dataHoraRetirada, long kmRetirada) {
		this.dataHoraRetirada = dataHoraRetirada;
		this.kmRetirada = kmRetirada;	
	}

	public ArrayList<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(ArrayList<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Date getDataHoraDevolucao() {
		return dataHoraDevolucao;
	}

	public void setDataHoraDevolucao(Date dataHoraDevolucao) {
		this.dataHoraDevolucao = dataHoraDevolucao;
	}

	public long getKmDevolucao() {
		return kmDevolucao;
	}

	public void setKmDevolucao(long kmDevolucao) {
		this.kmDevolucao = kmDevolucao;
	}

	public Date getDataHoraRetirada() {
		return dataHoraRetirada;
	}

	public long getKmRetirada() {
		return kmRetirada;
	}

}