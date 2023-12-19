package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.CatalogoController;
import controller.LocacaoController;
import controller.MainController;
import model.Seguro;

public class ReservaView extends JFrame {

	private static final long serialVersionUID = -8533454427135734983L;

	private JPanel contentPane;

	private JTabbedPane tabbedPane;

	private JPanel listPane; // Painel de Listagem de reservas por cliente

	private JTextArea textAreaList;
	private JLabel lblReservas;

	private JPanel formPane; // Painel de cadastro

	private JComboBox<Long> cbbCliente;
	private JTextField txtInicioReserva;
	private JTextField txtFimReserva;
	private JTextField txtValorTarifaDiaria;
	private JComboBox<String> cbbCategoriasList;

	JPanel segurosPane; // Painel de seguros
	double valorInicial;

	public ReservaView() {
		initialize();
	}

	private void initialize() {
		setTitle("Reservas");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 440);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		formPane = new JPanel();
		listPane = new JPanel();

		initFormPane();
		initListPane();

		tabbedPane.add("Listagem", listPane);

		tabbedPane.add("Cadastro", formPane);
	}

	private void initListPane() {

		listPane.setLayout(null);

		lblReservas = new JLabel("Reservas");
		lblReservas.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservas.setBounds(63, 12, 207, 15);

		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(231, 5, 109, 29);

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar();
				System.out.println("oi");
			}
		});

		textAreaList = new JTextArea();
		textAreaList.setBounds(12, 46, 401, 300);

		listPane.add(lblReservas);
		listPane.add(btnListar);
		listPane.add(textAreaList);
	}

	private void initFormPane() {

		formPane.setLayout(null);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(12, 14, 144, 16);

		JLabel lblNumReserva = new JLabel("Número de Reserva");
		lblNumReserva.setBounds(12, 4, 144, 16);

		JLabel lblInicioReserva = new JLabel("Inicio da reserva");
		lblInicioReserva.setBounds(12, 55, 130, 16);

		JLabel lblFimReserva = new JLabel("Fim da reserva");
		lblFimReserva.setBounds(12, 83, 130, 16);

		JLabel lblValorTarifaDiaria = new JLabel("Valor da tarifa diária");
		lblValorTarifaDiaria.setBounds(12, 290, 162, 16);

		JLabel lblCategoriasList = new JLabel("Categoria");
		lblCategoriasList.setBounds(12, 123, 71, 16);

		JLabel lblSeguros = new JLabel("Seguros");
		lblSeguros.setBounds(12, 160, 71, 16);

		cbbCliente = new JComboBox<Long>(new Vector<Long>(MainController.getClienteController().getClientes()));
		cbbCliente.setBounds(158, 10, 216, 27);

		cbbCategoriasList = new JComboBox<String>(
				new Vector<String>(MainController.getCatalogoController().getCategorias()));
		cbbCategoriasList.setBounds(158, 120, 216, 27);

		txtInicioReserva = new JTextField();
		txtInicioReserva.setBounds(158, 50, 130, 26);
		txtInicioReserva.setColumns(10);

		txtFimReserva = new JTextField();
		txtFimReserva.setBounds(158, 80, 130, 26);
		txtFimReserva.setColumns(10);

		txtValorTarifaDiaria = new JTextField();
		txtValorTarifaDiaria.setEnabled(false);
		txtValorTarifaDiaria.setBounds(173, 285, 130, 26);
		txtValorTarifaDiaria.setColumns(10);

		JButton btnCalcValor = new JButton("Calcular valor");
		btnCalcValor.setBounds(10, 250, 140, 29);

		btnCalcValor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCalcValor();
			}
		});

		segurosPane = new JPanel();
		segurosPane.setSize(216, 100);
		segurosPane.setLocation(158, 150);
		formPane.add(segurosPane, BorderLayout.CENTER);
		segurosPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		cbbCategoriasList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearPanel();
				iniciaValorTarifa();
				actionListarSeguros(segurosPane);
			}
		});

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(101, 323, 117, 29);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSalvar();
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(218, 323, 117, 29);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCancelar();
			}
		});

		formPane.add(lblCliente);
		formPane.add(cbbCliente);

		formPane.add(lblInicioReserva);
		formPane.add(txtInicioReserva);

		formPane.add(lblFimReserva);
		formPane.add(txtFimReserva);

		formPane.add(lblValorTarifaDiaria);
		formPane.add(txtValorTarifaDiaria);

		formPane.add(lblCategoriasList);
		formPane.add(cbbCategoriasList);

		formPane.add(lblSeguros);

		formPane.add(btnSalvar);
		formPane.add(btnCancelar);
		formPane.add(btnCalcValor);
	}

	private void actionSalvar() {
		LocacaoController controller = MainController.getLocacaoController();

		Long cliente = (Long) cbbCliente.getSelectedItem();
		String inicioReservaStr = txtInicioReserva.getText();
		String formatoData = "dd/MM/yyyy";
		SimpleDateFormat formato = new SimpleDateFormat(formatoData);
		try {
			Date inicioReserva = formato.parse(inicioReservaStr);

			String fimReservaStr = txtFimReserva.getText();
			SimpleDateFormat formato2 = new SimpleDateFormat(formatoData);
			try {
				Date fimReserva = formato2.parse(fimReservaStr);
				if (!fimReserva.after(inicioReserva)) {
					verificacoes.Verificacoes.exibirPopup("Erro", "Insira um intervalo de datas válido!");
					return;
				}

				actionCalcValor();
				double valorTarifaDiaria = Double.parseDouble(txtValorTarifaDiaria.getText());

				String categoria = (String) cbbCategoriasList.getSelectedItem();

				List<Seguro> segurosSelecionados = new ArrayList<>();
				segurosSelecionados = MainController.getCatalogoController().getSegurosSelecionados(segurosPane,
						categoria);

				UUID numReserva = controller.addReserva(cliente, inicioReserva, fimReserva, categoria,
						segurosSelecionados, valorTarifaDiaria);
				verificacoes.Verificacoes.exibirPopupSucesso("Sucesso",
						"Cadastro realizado com sucesso! Seu UUID é " + numReserva);

			} catch (ParseException e) {
				verificacoes.Verificacoes.exibirPopup("Erro", "Data inválida! Insira como: dd/mm/aaaa");
				return;
			}
		} catch (ParseException e) {
			verificacoes.Verificacoes.exibirPopup("Erro", "Data inválida! Insira como: dd/mm/aaaa");
			return;
		}

		limparForm();

	}

	private void actionCalcValor() {
		CatalogoController controller = MainController.getCatalogoController();
		try {

			double valorTarifa = valorInicial;
			List<Double> segurosSelecionados = new ArrayList<>();
			for (Component component : segurosPane.getComponents()) {

				if (component instanceof JCheckBox) {
					JCheckBox checkBox = (JCheckBox) component;

					if (checkBox.isSelected()) {
						String strPercentTarifa = checkBox.getText().replaceAll("[^0-9.]", "");

						segurosSelecionados.add(Double.parseDouble(strPercentTarifa));
					}
				}
			}
			valorTarifa = controller.atualizaTarifa(valorTarifa, segurosSelecionados);
			txtValorTarifaDiaria.setText(Double.toString(valorTarifa));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e);
		}

	}

	private void iniciaValorTarifa() {
		CatalogoController controller = MainController.getCatalogoController();

		String nomeCategoria = (String) cbbCategoriasList.getSelectedItem();
		txtValorTarifaDiaria.setText(Double.toString(controller.getTarifa(nomeCategoria)));
		valorInicial = Double.parseDouble(txtValorTarifaDiaria.getText());
	}

	protected void actionListarSeguros(JPanel segurosPanel) {
		CatalogoController controller = MainController.getCatalogoController();

		String nomeCategoria = (String) cbbCategoriasList.getSelectedItem();
		controller.showSeguros(segurosPanel, nomeCategoria);
	}

	private void actionListar() {

		LocacaoController controller = MainController.getLocacaoController();

		List<String> lista = controller.getReservas();

		textAreaList.setText(null);

		for (String strReserva : lista) {
			textAreaList.append(String.format("%s\n", strReserva));
		}
	}

	private void limparForm() {
		txtInicioReserva.setText("");
		txtFimReserva.setText("");
		txtValorTarifaDiaria.setText("");
	}

	private void clearPanel() {
		segurosPane.removeAll();
		segurosPane.revalidate();
		segurosPane.repaint();
	}

	private void actionCancelar() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

}
