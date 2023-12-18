package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import model.Locacao;
import model.Pagamento;
import model.Reserva;
import model.Seguro;

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

	public UUID addReserva(String cliente, Date inicioReserva, Date fimReserva, String categoria,
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

	public List<String> getReservas() {
		List<String> lista = new ArrayList<>();

		for (Reserva reserva : reservas.values())
			lista.add(String.format("%s\t%s\t", reserva.getNumReserva(), reserva.getCliente()));

		return lista;

	}

}
