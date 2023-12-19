package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Locacao implements Serializable {

	private static final long serialVersionUID = 4043876049413554598L;

	private final Date dataHoraRetirada;
	private final long kmRetirada;
	private Date dataHoraDevolucao;
	private long kmDevolucao;

	private PessoaFisica condutor;
	private List<Pagamento> pagamentos = new ArrayList<Pagamento>();
	private Veiculo veiculo;
	private Reserva reserva;

	public Locacao(Date dataHoraRetirada, long kmRetirada, PessoaFisica condutor, Veiculo veiculo, Reserva reserva) {
		this.dataHoraRetirada = dataHoraRetirada;
		this.kmRetirada = kmRetirada;
		this.condutor = condutor;
		this.veiculo = veiculo;
		this.reserva = reserva;

	}

	public PessoaFisica getCondutor() {
		return condutor;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void addPagamento(EFormaPagamento tipo, double valor, EMotivoPagamento motivo, String descricao) {
		pagamentos.add(new Pagamento(tipo, valor, motivo, descricao));
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

	public Veiculo getVeiculo() {
		return veiculo;
	}


	public Reserva getReserva() {
		return reserva;
	}

}
