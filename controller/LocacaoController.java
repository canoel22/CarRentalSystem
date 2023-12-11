package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.Locacao;
import model.Pagamento;
import model.Reserva;

public class LocacaoController implements Serializable {

	private static final long serialVersionUID = -8942447860066317791L;

	private Map<String, Reserva> reservas;
	private Map<String, Locacao> locacoes;
	private Map<String, Pagamento> pagamentos;

	public LocacaoController() {

		reservas = new TreeMap<>();
		locacoes = new TreeMap<>();
		pagamentos = new TreeMap<>();
	}

	public void addReserva(int numReserva, String inicioReserva, String fimReserva, int valorTarifaDiaria,
			String categoria) {
		// Categoria categoria1 = MainController.getCatalogoController().get(categoria);
		// // retorna objeto Categoria para chave do map

		// Reserva reserva = new Reserva(numReserva, inicioReserva, fimReserva,
		// valorTarifaDiaria, categoria1);

		// reservas.put(reserva.getNumReserva(), reserva);

		// if (categoria1 != null)
		// categoria1.addReserva(reserva);

		// MainController.save();
	}

	public List<String> getReservaCliente(String nomeCliente) {
		// Cliente cliente = clientes.get(nomeCliente);

		// System.out.printf("%s", cliente.getNome());

		List<String> lista = new ArrayList<>();

		// for (Reserva reserva : cliente.getReserva())
		// lista.add(String.format("%s\t%d\t%s\t%s\t%d\t%s\t", reserva.getNumReserva(),
		// reserva.getInicioReserva(),
		// reserva.getFimReserva(), reserva.getValorTarifaDiaria()));

		return lista;

	}

}
