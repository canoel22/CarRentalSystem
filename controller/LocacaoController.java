package controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import model.EFormaPagamento;
import model.EMotivoPagamento;
import model.EStatusVeiculo;
import model.Locacao;
import model.Pagamento;
import model.PessoaFisica;
import model.Reserva;
import model.Seguro;
import model.Veiculo;

public class LocacaoController implements Serializable {

	private static final long serialVersionUID = -8942447860066317791L;

	private Map<UUID, Reserva> reservas;
	private Map<UUID, Locacao> locacoes;
	private Map<UUID, Pagamento> pagamentos;

	public LocacaoController() {

		reservas = new TreeMap<>();
		locacoes = new TreeMap<>();
		pagamentos = new TreeMap<>();
	}

	public UUID addReserva(Long cliente, Date inicioReserva, Date fimReserva, String categoria,
			List<Seguro> segurosSelecionados, double valorTarifaDiaria) {

		ClienteController clienteController = MainController.getClienteController();
		CatalogoController catalogoController = MainController.getCatalogoController();

		Reserva reserva = new Reserva(inicioReserva, fimReserva, valorTarifaDiaria,
				catalogoController.getCategoriaNome(categoria), clienteController.getCliente(cliente),
				segurosSelecionados);

		reservas.put(reserva.getNumReserva(), reserva);

		MainController.save();

		return reserva.getNumReserva();
	}

	public Reserva getReserva(UUID numReserva) {
		return reservas.get(numReserva);
	}

	public List<String> getReservas() {
		List<String> lista = new ArrayList<>();

		for (Reserva reserva : reservas.values())
			lista.add(String.format("%s\t -> %s\t", reserva.getNumReserva(), reserva.getCliente().getNome()));

		return lista;
	}

	public List<UUID> getReservasUUID() {
		List<UUID> lista = new ArrayList<>();

		for (Reserva reserva : reservas.values())
			lista.add(reserva.getNumReserva());

		return lista;
	}

	public boolean addLocacao(UUID reserva, String dataInicioStr, String horaInicioStr, String veiculo, Long condutor) {
		ClienteController clienteController = MainController.getClienteController();
		CatalogoController catalogoController = MainController.getCatalogoController();

		Reserva reserva1 = reservas.get(reserva);
		PessoaFisica condutor1 = (PessoaFisica) clienteController.getCliente(condutor);
		int indiceEspaco = veiculo.indexOf(" ");
		String placa = null;
		if (indiceEspaco != -1) {
			placa = veiculo.substring(0, indiceEspaco);
		}
		Veiculo veiculo1 = (Veiculo) catalogoController.getVeiculo(placa);
		System.out.println(veiculo);
		String dataHoraStr = dataInicioStr + " " + horaInicioStr;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			Date dataHoraInicio = formato.parse(dataHoraStr);

			locacoes.put(reserva,
					new Locacao(dataHoraInicio, veiculo1.getQuilometragem(), condutor1, veiculo1, reserva1));

			reservas.remove(reserva);
			veiculo1.setStatus(EStatusVeiculo.ALUGADO);

			MainController.save();

		} catch (ParseException e) {
			verificacoes.Verificacoes.exibirPopup("Erro", "Hora inválida! Insira como: hh:mm");
			return false;
		}
		return true;

	}

	public Locacao getLocacao(UUID numLocacao) {
		return locacoes.get(numLocacao);
	}

	public List<String> getLocacoes() {
		List<String> lista = new ArrayList<>();

		for (Locacao locacao : locacoes.values())
			lista.add(String.format("%s\t -> %s\nInicio: %s\n", locacao.getVeiculo().getPlaca(),
					locacao.getCondutor().getNome(), locacao.getDataHoraRetirada()));

		return lista;
	}

	public List<UUID> getLocacoesUUID() {
		List<UUID> lista = new ArrayList<>();

		for (UUID locacao : locacoes.keySet()) {
			if (locacoes.get(locacao).getDataHoraDevolucao() == null) { // pega as locações que ainda não tiveram
																		// devolução
				lista.add(locacao);
			}
		}
		return lista;
	}
	
	public List<UUID> getDevolucoesUUID() {
		List<UUID> lista = new ArrayList<>();

		for (UUID locacao : locacoes.keySet()) {
			if (locacoes.get(locacao).getDataHoraDevolucao() != null) { // pega as locações que ainda não tiveram
																		// devolução
				lista.add(locacao);
			}
		}
		return lista;
	}

	public boolean addDevolucao(UUID locacao, Long kmDevolucao, String dataFimStr, String horaFimStr) {

		Locacao locacao1 = locacoes.get(locacao);

		String dataHoraStr = dataFimStr + " " + horaFimStr;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			Date dataHoraFim = formato.parse(dataHoraStr);

			locacao1.setKmDevolucao(kmDevolucao);
			locacao1.setDataHoraDevolucao(dataHoraFim);
			locacao1.getVeiculo().setStatus(EStatusVeiculo.DISPONIVEL);

			MainController.save();

		} catch (ParseException e) {
			verificacoes.Verificacoes.exibirPopup("Erro", "Hora inválida! Insira como: hh:mm");
			return false;
		}
		return true;
	}

	public boolean addPagamento(UUID locacao, double valor, EFormaPagamento tipo, EMotivoPagamento motivo,
			String descricao) {
		Locacao locacao1 = locacoes.get(locacao);

		pagamentos.put(locacao, new Pagamento(tipo, valor, motivo, descricao));
		locacao1.addPagamento(tipo, valor, motivo, descricao);

		MainController.save();
		return true;
	}

	public static double getValorTotalLocacao(Locacao locacao) {
		double valor = locacao.getReserva().getValorTarifaDiaria();

		long milissegundosInicial = locacao.getDataHoraRetirada().getTime();
		long milissegundosFinal = locacao.getDataHoraDevolucao().getTime();
		long diferencaMilissegundos = milissegundosFinal - milissegundosInicial;
		long qtdDias = TimeUnit.MILLISECONDS.toDays(diferencaMilissegundos);

		valor *= qtdDias;
		return valor;
	}

}
