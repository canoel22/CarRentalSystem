package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.LocacaoController;
import controller.MainController;

public class LocacaoView extends JFrame {

	private static final long serialVersionUID = 5541485229247134819L;

	private JPanel contentPane;

	private JTabbedPane tabbedPane;

	private JPanel listPane; // Painel de Listagem de reservas por cliente

	private JTextArea textAreaList;
	private JLabel lblLocacoes;

	private JPanel formPaneInicio; // Painel de cadastro

	private JComboBox<UUID> cbbReserva;
	private JComboBox<String> cbbVeiculosCat;
	private JTextField txtCondutor;
	private JTextField txtDataInicio;
	private JTextField txtHoraInicio;

	private JPanel formPaneFim; // Painel de cadastro

	private JComboBox<UUID> cbbLocacao;
	private JTextField txtQuilometragem;
	private JTextField txtDataFim;
	private JTextField txtHoraFim;

	public LocacaoView() {
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

		formPaneInicio = new JPanel();
		formPaneFim = new JPanel();
		listPane = new JPanel();

		initFormPaneInicio();
		initFormPaneFim();
		initListPane();

		tabbedPane.add("Listagem", listPane);
		tabbedPane.add("Locacão", formPaneInicio);
		tabbedPane.add("Devolução", formPaneFim);

	}

	private void initListPane() {

		listPane.setLayout(null);

		lblLocacoes = new JLabel("Locações");
		lblLocacoes.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocacoes.setBounds(63, 12, 207, 15);

		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(231, 5, 109, 29);

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar();
			}
		});

		textAreaList = new JTextArea();
		textAreaList.setBounds(12, 46, 401, 300);

		listPane.add(lblLocacoes);
		listPane.add(btnListar);
		listPane.add(textAreaList);
	}

	private void initFormPaneInicio() {
		LocacaoController controller = MainController.getLocacaoController();

		formPaneInicio.setLayout(null);

		JLabel lblReserva = new JLabel("Reserva");
		lblReserva.setBounds(12, 14, 144, 16);

		JLabel lblVeiculos = new JLabel("Veículos disponíveis");
		lblVeiculos.setBounds(12, 55, 144, 16);

		JLabel lblCondutor = new JLabel("Condutor");
		lblCondutor.setBounds(12, 165, 162, 16);

		JLabel lblDataInicio = new JLabel("Data da locação");
		lblDataInicio.setBounds(12, 93, 130, 16);

		JLabel lblHoraInicio = new JLabel("Hora da Locação");
		lblHoraInicio.setBounds(12, 130, 130, 16);

		cbbReserva = new JComboBox<UUID>(new Vector<UUID>(MainController.getLocacaoController().getReservasUUID()));
		cbbReserva.setBounds(158, 10, 216, 27);
		cbbReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UUID reserva = (UUID) cbbReserva.getSelectedItem();
				atualizaCbbVeiculosCat(controller.getReserva(reserva).getCategoria().getVeiculosDisponiveis());
			}
		});

		cbbVeiculosCat = new JComboBox<String>();
		cbbVeiculosCat.setBounds(158, 50, 216, 27);

		txtCondutor = new JTextField();
		txtCondutor.setBounds(158, 160, 130, 26);
		txtCondutor.setColumns(10);

		txtDataInicio = new JTextField();
		txtDataInicio.setBounds(158, 90, 130, 26);
		txtDataInicio.setColumns(10);

		txtHoraInicio = new JTextField();
		txtHoraInicio.setBounds(158, 125, 130, 26);
		txtHoraInicio.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(101, 243, 117, 29);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSalvarLocacao();
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(218, 243, 117, 29);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCancelar();
			}
		});

		formPaneInicio.add(lblReserva);
		formPaneInicio.add(cbbReserva);

		formPaneInicio.add(lblVeiculos);
		formPaneInicio.add(cbbVeiculosCat);

		formPaneInicio.add(lblCondutor);
		formPaneInicio.add(txtCondutor);

		formPaneInicio.add(lblDataInicio);
		formPaneInicio.add(txtDataInicio);

		formPaneInicio.add(lblHoraInicio);
		formPaneInicio.add(txtHoraInicio);

		formPaneInicio.add(btnSalvar);
		formPaneInicio.add(btnCancelar);
	}

	private void initFormPaneFim() {

		formPaneInicio.setLayout(null);

		JLabel lblLocacao = new JLabel("Locação");
		lblLocacao.setBounds(12, 14, 144, 16);

		JLabel lblQuilometragem = new JLabel("Quilometragem");
		lblQuilometragem.setBounds(12, 55, 144, 16);

		JLabel lblDataFim = new JLabel("Data da devolução");
		lblDataFim.setBounds(12, 93, 160, 16);

		JLabel lblHoraFim = new JLabel("Hora da devolução");
		lblHoraFim.setBounds(12, 135, 170, 16);

		cbbLocacao = new JComboBox<UUID>(new Vector<UUID>(MainController.getLocacaoController().getLocacoesUUID()));
		cbbLocacao.setBounds(150, 10, 216, 27);

		txtQuilometragem = new JTextField();
		txtQuilometragem.setBounds(150, 50, 130, 26);
		txtQuilometragem.setColumns(10);

		txtDataFim = new JTextField();
		txtDataFim.setBounds(150, 89, 130, 26);
		txtDataFim.setColumns(10);

		txtHoraFim = new JTextField();
		txtHoraFim.setBounds(150, 130, 130, 26);
		txtHoraFim.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(101, 243, 117, 29);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSalvarDevolucao();
				System.out.println("teste");
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(218, 243, 117, 29);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCancelar();
			}
		});
		formPaneFim.setLayout(null);

		formPaneFim.add(lblLocacao);
		formPaneFim.add(cbbLocacao);

		formPaneFim.add(lblQuilometragem);
		formPaneFim.add(txtQuilometragem);

		formPaneFim.add(lblDataFim);
		formPaneFim.add(txtDataFim);

		formPaneFim.add(lblHoraFim);
		formPaneFim.add(txtHoraFim);

		formPaneFim.add(btnSalvar);
		formPaneFim.add(btnCancelar);
	}

	private void actionSalvarLocacao() {
		LocacaoController controller = MainController.getLocacaoController();

		UUID reserva = (UUID) cbbReserva.getSelectedItem();
		String dataInicioStr = txtDataInicio.getText();
		String formatoData = "dd/MM/yyyy";
		SimpleDateFormat formato = new SimpleDateFormat(formatoData);
		try {
			formato.parse(dataInicioStr);

			String horaInicioStr = txtHoraInicio.getText();
			String formatoHora = "HH:mm";
			SimpleDateFormat formato2 = new SimpleDateFormat(formatoHora);
			try {
				formato2.parse(horaInicioStr);

				String veiculo = (String) cbbVeiculosCat.getSelectedItem();

				String condutorStr = txtCondutor.getText();
				if (!verificacoes.Verificacoes.validarCPF(condutorStr)) {
					verificacoes.Verificacoes.exibirPopup("Erro", "CPF inválido!");
					return;
				}
				Long condutor = Long.parseLong(condutorStr);
				if (!verificacoes.Verificacoes.temCliente(condutor)) {
					verificacoes.Verificacoes.exibirPopup("Erro", "CPF não cadastrado no sistema!");
					return;
				}

				if (controller.addLocacao(reserva, dataInicioStr, horaInicioStr, veiculo, condutor)) {
					verificacoes.Verificacoes.exibirPopupSucesso("Sucesso", "Cadastro realizado com sucesso!");
				}
				
			} catch (ParseException e) {
				verificacoes.Verificacoes.exibirPopup("Erro", "Hora inválida! Insira como: hh:mm");
				return;
			}
		} catch (ParseException e) {
			verificacoes.Verificacoes.exibirPopup("Erro", "Data inválida! Insira como: dd/mm/aaaa");
			return;
		}

		limparForm1();

	}

	private void actionSalvarDevolucao() {
		LocacaoController controller = MainController.getLocacaoController();

		UUID locacao = (UUID) cbbLocacao.getSelectedItem();
		String kmDevolucaoStr = txtQuilometragem.getText();
		Long kmDevolucao = Long.parseLong(kmDevolucaoStr);
		String dataFimStr = txtDataFim.getText();
		String formatoData = "dd/MM/yyyy";
		SimpleDateFormat formato = new SimpleDateFormat(formatoData);
		try {
			formato.parse(dataFimStr);

			String horaFimStr = txtHoraFim.getText();
			String formatoHora = "HH:mm";
			SimpleDateFormat formato2 = new SimpleDateFormat(formatoHora);
			try {
				formato2.parse(horaFimStr);

				if (controller.addDevolucao(locacao, kmDevolucao, dataFimStr, horaFimStr)) {
					verificacoes.Verificacoes.exibirPopupSucesso("Sucesso", "Cadastro realizado com sucesso!");
				}

			} catch (ParseException e) {
				verificacoes.Verificacoes.exibirPopup("Erro", "Hora inválida! Insira como: hh:mm");
				return;
			}
		} catch (ParseException e) {
			verificacoes.Verificacoes.exibirPopup("Erro", "Data inválida! Insira como: dd/mm/aaaa");
			return;
		}

		limparForm2();

	}

	private void actionListar() {

		LocacaoController controller = MainController.getLocacaoController();

		List<String> lista = controller.getLocacoes();

		textAreaList.setText(null);

		for (String strLocacao : lista) {
			textAreaList.append(String.format("%s\n", strLocacao));
		}
	}

	private void limparForm1() {
		txtCondutor.setText("");
		txtDataInicio.setText("");
		txtHoraInicio.setText("");
	}

	private void limparForm2() {
		txtQuilometragem.setText("");
		txtDataFim.setText("");
		txtHoraFim.setText("");
	}

	private void actionCancelar() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

	private void atualizaCbbVeiculosCat(List<String> list) {
		cbbVeiculosCat.removeAllItems();

		for (String veiculo : list) {
			cbbVeiculosCat.addItem(veiculo);
		}
	}
}