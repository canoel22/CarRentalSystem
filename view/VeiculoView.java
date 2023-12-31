package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
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

import controller.CatalogoController;
import controller.MainController;

public class VeiculoView extends JFrame {

	private static final long serialVersionUID = 7008206866340731712L;

	private JPanel contentPane;

	private JTabbedPane tabbedPane;

	private JPanel listPane1; // Painel de Listagem por modelo

	private JComboBox<String> modelosList;
	private JTextArea textAreaList;

	private JPanel listPane2; // Painel de Listagem por categoria

	private JComboBox<String> categoriasList;
	private JTextArea textAreaList2;

	private JPanel formPane; // Painel do Formulario

	private JTextField txtPlaca;
	private JTextField txtAnoFabricacao;
	private JTextField txtCor;
	private JTextField txtQuilometragem;
	private JComboBox<String> cbbModeloVeiculo;
	private JComboBox<String> cbbCategoriaVeiculo;
	private JLabel lblFiltroPorCategoria;

	public VeiculoView() {
		initialize();
	}

	public void initialize() {
		setTitle("Veículo");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 477, 352);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		formPane = new JPanel();
		listPane1 = new JPanel();
		listPane2 = new JPanel();

		initFormPane();
		initListPane1();
		initListPane2();

		tabbedPane.add("Listagem", listPane1);

		tabbedPane.add("Listagem", listPane2);

		lblFiltroPorCategoria = new JLabel("Filtro por categoria");
		lblFiltroPorCategoria.setBounds(12, 0, 150, 15);
		listPane2.add(lblFiltroPorCategoria);

		JLabel lblNewLabel = new JLabel("Filtro por modelo");
		lblNewLabel.setBounds(6, 0, 150, 15);
		listPane1.add(lblNewLabel);
		tabbedPane.add("Cadastro", formPane);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategoria.setBounds(12, 66, 130, 16);
		formPane.add(lblCategoria);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setHorizontalAlignment(SwingConstants.LEFT);
		lblModelo.setBounds(12, 100, 130, 16);
		formPane.add(lblModelo);
	}

	private void initListPane1() {

		CatalogoController controller = MainController.getCatalogoController();

		listPane1.setLayout(null);

		modelosList = new JComboBox<String>(new Vector<String>(controller.getModelos()));

		modelosList.setBounds(6, 21, 330, 27);

		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(346, 20, 109, 29);

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar1();
			}
		});

		textAreaList = new JTextArea();
		textAreaList.setBounds(12, 60, 438, 193);

		listPane1.add(modelosList);
		listPane1.add(textAreaList);

		listPane1.add(btnListar);
	}

	private void initListPane2() {

		CatalogoController controller = MainController.getCatalogoController();

		listPane2.setLayout(null);

		categoriasList = new JComboBox<String>(new Vector<String>(controller.getCategorias()));

		categoriasList.setBounds(6, 21, 330, 27);

		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(346, 20, 109, 29);

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar2();
			}
		});

		textAreaList2 = new JTextArea();
		textAreaList2.setBounds(12, 60, 438, 193);

		listPane2.add(categoriasList);
		listPane2.add(textAreaList2);

		listPane2.add(btnListar);
	}

	private void initFormPane() {

		CatalogoController controller = MainController.getCatalogoController();

		formPane.setLayout(null);

		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(17, 4, 61, 16);

		JLabel lblAnoFabricacao = new JLabel("Ano Fabricação");
		lblAnoFabricacao.setBounds(12, 33, 130, 16);

		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(12, 130, 71, 16);

		JLabel lblQuilometragem = new JLabel("Quilometragem");
		lblQuilometragem.setBounds(12, 166, 130, 16);

		txtPlaca = new JTextField();
		txtPlaca.setBounds(134, 0, 130, 26);
		txtPlaca.setColumns(10);

		txtAnoFabricacao = new JTextField();
		txtAnoFabricacao.setBounds(134, 29, 86, 26);
		txtAnoFabricacao.setColumns(10);

		txtCor = new JTextField();
		txtCor.setBounds(134, 126, 86, 26);
		txtCor.setColumns(10);

		txtQuilometragem = new JTextField();
		txtQuilometragem.setBounds(134, 162, 86, 26);
		txtQuilometragem.setColumns(10);

		cbbModeloVeiculo = new JComboBox<String>(new Vector<String>(controller.getModelos()));
		cbbModeloVeiculo.setBounds(134, 94, 216, 27);

		cbbCategoriaVeiculo = new JComboBox<String>(new Vector<String>(controller.getCategorias()));
		cbbCategoriaVeiculo.setBounds(133, 60, 216, 27);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(100, 210, 117, 29);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSalvar();
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(216, 210, 117, 29);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCancelar();
			}
		});

		formPane.add(lblPlaca);
		formPane.add(txtPlaca);

		formPane.add(lblAnoFabricacao);
		formPane.add(txtAnoFabricacao);

		formPane.add(lblCor);
		formPane.add(txtCor);

		formPane.add(cbbModeloVeiculo);
		formPane.add(cbbCategoriaVeiculo);

		formPane.add(lblQuilometragem);
		formPane.add(txtQuilometragem);

		formPane.add(btnSalvar);
		formPane.add(btnCancelar);
	}

	private void actionSalvar() {
		CatalogoController controller = MainController.getCatalogoController();

		try {
			String placa = txtPlaca.getText();
			if (!verificacoes.Verificacoes.validarPlaca(placa)) {
				verificacoes.Verificacoes.exibirPopup("Erro", "Placa inválida!");
				return;
			}

			String anoFabricacaoStr = txtAnoFabricacao.getText();
			int anoFabricacao = Integer.parseInt(anoFabricacaoStr);
			if (verificacoes.Verificacoes.anoMaiorQueAtual(anoFabricacao)) {
				verificacoes.Verificacoes.exibirPopup("Erro", "Ano inválido!");
				return;
			}

			String cor = txtCor.getText();

			String quilometragemStr = txtQuilometragem.getText();
			try {
				int quilometragem = Integer.parseInt(quilometragemStr);

				String modeloVeiculo = (String) cbbModeloVeiculo.getSelectedItem();

				String categoriaVeiculo = (String) cbbCategoriaVeiculo.getSelectedItem();

				if (!verificacoes.Verificacoes.verificarCamposPreenchidos(cor)) {
					verificacoes.Verificacoes.exibirPopup("Erro", "Por favor, preencha todos os campos.");
					return;
				}

				if (controller.addVeiculo(placa, anoFabricacao, cor, quilometragem, modeloVeiculo, categoriaVeiculo)) {
					verificacoes.Verificacoes.exibirPopupSucesso("Sucesso", "Cadastro realizado com sucesso!");
				}

			} catch (NumberFormatException e) {
				verificacoes.Verificacoes.exibirPopup("Erro",
						"A quilometragem informada nao é valida, digite somente números");
				return;
			}

		} catch (NumberFormatException e) {
			verificacoes.Verificacoes.exibirPopup("Erro", "O ano informado nao é valido, digite somente números");
			return;
		}
		limparForm();

	}

	private void actionListar1() {

		CatalogoController controller = MainController.getCatalogoController();

		String nomeModelo = (String) modelosList.getSelectedItem();

		List<String> lista = controller.getVeiculosMod(nomeModelo);

		textAreaList.setText(null);

		for (String strVeiculo : lista) {
			textAreaList.append(String.format("%s\n", strVeiculo));
		}
	}

	private void actionListar2() {

		CatalogoController controller = MainController.getCatalogoController();

		String nomeCategoria = (String) categoriasList.getSelectedItem();

		List<String> lista = controller.getVeiculosCat(nomeCategoria);

		textAreaList2.setText(null);

		for (String strVeiculo : lista) {
			textAreaList2.append(String.format("%s\n", strVeiculo));
		}
	}

	private void limparForm() {
		txtPlaca.setText("");
		txtAnoFabricacao.setText("");
		txtCor.setText("");
		txtQuilometragem.setText("");
	}

	private void actionCancelar() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
