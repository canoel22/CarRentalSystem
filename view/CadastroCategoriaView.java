package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CatalogoController;
import controller.MainController;

public class CadastroCategoriaView extends JFrame {

	private static final long serialVersionUID = -9092665626363625341L;

	private JPanel contentPane;

	private JLabel lblNome;
	private JLabel lblTarifaDiaria;

	private JTextField txtNome;
	private JTextField txtTarifaDiaria;
	private JTextArea textArea;

	private JButton btnSalvar;
	private JButton btnListar;

	public CadastroCategoriaView() {
		initialize();
	}

	private void initialize() {

		setTitle("Cadastro de categoria");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(6, 0, 61, 16);

		txtNome = new JTextField();
		txtNome.setBounds(85, 0, 213, 26);
		txtNome.setColumns(20);

		lblTarifaDiaria = new JLabel("Tarifa Diária:");
		lblTarifaDiaria.setBounds(6, 30, 176, 16);

		txtTarifaDiaria = new JTextField();
		txtTarifaDiaria.setBounds(105, 30, 193, 26);
		txtTarifaDiaria.setColumns(20);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(310, 0, 117, 29);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSalvar();
			}
		});

		textArea = new JTextArea();
		textArea.setBounds(6, 100, 344, 167);

		btnListar = new JButton("Listar");
		btnListar.setBounds(310, 41, 117, 29);

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar();
			}
		});

		contentPane.add(lblNome);
		contentPane.add(txtNome);
		contentPane.add(lblTarifaDiaria);
		contentPane.add(txtTarifaDiaria);
		contentPane.add(btnSalvar);

		contentPane.add(textArea);
		contentPane.add(btnListar);

		actionListar();
	}

	private void actionSalvar() {
		CatalogoController controller = MainController.getCatalogoController();

		String nome = txtNome.getText();
		String tarifaDiariaStr = txtTarifaDiaria.getText();
		Double tarifaDiaria = Double.parseDouble(tarifaDiariaStr);

		controller.addCategoria(nome, tarifaDiaria);

		limparForm();

		actionListar();

	}

	private void actionListar() {

		CatalogoController controller = MainController.getCatalogoController();

		textArea.setText(null);
		for (String nomeCategoria : controller.getCategorias()) {
			textArea.append(String.format("%s\n", nomeCategoria));
		}
	}

	private void limparForm() {
		txtNome.setText("");
		txtTarifaDiaria.setText("");
	}
}