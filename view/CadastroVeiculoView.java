package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CatalogoController;
import controller.MainController;
import model.EStatusVeiculo;

public class CadastroVeiculoView extends JFrame {

	private static final long serialVersionUID = 7008206866340731712L;

	private JPanel contentPane;

	private JTabbedPane tabbedPane;

	private JPanel listPane; // Painel de Listagem

	private JComboBox<String> modelosList;
	private JTextArea textAreaList;

	private JPanel formPane; // Painel do Formulario

	private JTextField txtPlaca;
	private JTextField txtAnoFabricacao;
	private JTextField txtCor;
	private JTextField txtQuilometragem;
	private JComboBox<EStatusVeiculo> cbbStatusVeiculo;
	private JComboBox<String> cbbModeloVeiculo;

	public CadastroVeiculoView() {
		initialize();
	}

	public void initialize() {
		setTitle("Veículo");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 338);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		listPane = new JPanel();
		formPane = new JPanel();

		initListPane();
		initFormPane();

		tabbedPane.add("Listagem", listPane);
		tabbedPane.add("Cadastro", formPane);
	}

	private void initListPane() {

		CatalogoController controller = MainController.getCatalogoController();

		listPane.setLayout(null);

		modelosList = new JComboBox<String>(new Vector<String>(controller.getModelos()));

		modelosList.setBounds(6, 21, 330, 27);

		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(346, 20, 109, 29);

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar();
			}
		});

		textAreaList = new JTextArea();
		textAreaList.setBounds(12, 60, 320, 193);

		listPane.add(modelosList);
		listPane.add(textAreaList);

		listPane.add(btnListar);
	}

	private void initFormPane() {

		CatalogoController controller = MainController.getCatalogoController();

		formPane.setLayout(null);

		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(17, 22, 61, 16);

		JLabel lblAnoFabricacao = new JLabel("Ano Fabricação");
		lblAnoFabricacao.setBounds(17, 50, 130, 16);

		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(17, 155, 71, 16);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(17, 192, 61, 16);

		JLabel lblQuilometragem = new JLabel("Quilometragem");
		lblQuilometragem.setBounds(17, 117, 130, 16);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(17, 83, 61, 16);

		txtPlaca = new JTextField();
		txtPlaca.setBounds(134, 18, 130, 26);
		txtPlaca.setColumns(10);

		txtAnoFabricacao = new JTextField();
		txtAnoFabricacao.setBounds(134, 46, 86, 26);
		txtAnoFabricacao.setColumns(10);

		txtCor = new JTextField();
		txtCor.setBounds(134, 151, 86, 26);
		txtCor.setColumns(10);

		txtQuilometragem = new JTextField();
		txtQuilometragem.setBounds(134, 113, 86, 26);
		txtQuilometragem.setColumns(10);

		cbbStatusVeiculo = new JComboBox<>();
		cbbStatusVeiculo.setBounds(134, 187, 130, 27);
		cbbStatusVeiculo.setModel(new DefaultComboBoxModel<EStatusVeiculo>(EStatusVeiculo.values()));

		cbbModeloVeiculo = new JComboBox<String>(new Vector<String>(controller.getModelos()));
		cbbModeloVeiculo.setBounds(133, 78, 216, 27);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(101, 233, 117, 29);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSalvar();
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(218, 233, 117, 29);

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

		formPane.add(lblStatus);
		formPane.add(cbbStatusVeiculo);

		formPane.add(lblModelo);
		formPane.add(cbbModeloVeiculo);

		formPane.add(lblQuilometragem);
		formPane.add(txtQuilometragem);

		formPane.add(btnSalvar);
		formPane.add(btnCancelar);
	}

	private void actionSalvar() {
		CatalogoController controller = MainController.getCatalogoController();

		try {
			String placa = txtPlaca.getText();

			int anoFabricacao = Integer.parseInt(txtAnoFabricacao.getText());

			String cor = txtCor.getText();

			EStatusVeiculo statusVeiculo = (EStatusVeiculo) cbbStatusVeiculo.getSelectedItem();

			int quilometragem = Integer.parseInt(txtQuilometragem.getText());

			String modeloVeiculo = (String) cbbModeloVeiculo.getSelectedItem();

			controller.addVeiculo(placa, anoFabricacao, cor, statusVeiculo, quilometragem, modeloVeiculo);

		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(this, "Formato campo codigo: 0\nFormato campo preço: 0.00");
			return;

		} catch (Exception e) {
			e.printStackTrace();
		}

		limparForm();

	}

	private void actionListar() {

		CatalogoController controller = MainController.getCatalogoController();

		String nomeCategoria = (String) cbbModeloVeiculo.getSelectedItem();

		List<String> lista = controller.getVeiculos(nomeCategoria);

		textAreaList.setText(null);

		for (String strItem : lista) {
			textAreaList.append(String.format("%s\n", strItem));
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
