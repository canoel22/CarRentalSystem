package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.CatalogoController;
import controller.MainController;

public class CadastroModeloView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JLabel lblNome;
	private JLabel lblanoModelo;
	private JLabel lblFabricante;

	private JTextField txtNome;
	private JTextField txtanoModelo;
	private JTextField txtFabricante;
	private JTextArea textArea;

	private JButton btnSalvar;
	private JButton btnListar;

	public CadastroModeloView() {
		initialize();
	}

	private void initialize() {

		setTitle("Cadastro de modelo");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(6, 0, 61, 16);

		txtNome = new JTextField();
		txtNome.setBounds(52, 0, 294, 26);
		txtNome.setColumns(20);
		

		lblanoModelo = new JLabel("Ano do modelo:");
		lblanoModelo.setBounds(6, 30, 61, 16);

		txtanoModelo = new JTextField();
		txtanoModelo.setBounds(52, 30, 294, 26);
		txtanoModelo.setColumns(20);
		
		
		lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setBounds(6, 60, 61, 16);

		txtFabricante = new JTextField();
		txtFabricante.setBounds(52, 60, 294, 26);
		txtFabricante.setColumns(20);
		
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(360, 16, 117, 29);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSalvar();
			}
		});

		textArea = new JTextArea();
		textArea.setBounds(6, 100, 344, 167);

		btnListar = new JButton("Listar");
		btnListar.setBounds(360, 57, 117, 29);

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar();
			}
		});

		contentPane.add(lblNome);
		contentPane.add(txtNome);
		contentPane.add(lblanoModelo);
		contentPane.add(txtanoModelo);
		contentPane.add(lblFabricante);
		contentPane.add(txtFabricante);
		contentPane.add(btnSalvar);

		contentPane.add(textArea);
		contentPane.add(btnListar);

		actionListar();
	}

	private void actionSalvar() {
		CatalogoController controller = MainController.getCatalogoController();

		String nome = txtNome.getText();
		String anoModeloStr = txtanoModelo.getText();
		int anoModelo = Integer.parseInt(anoModeloStr);
		String fabricante = txtFabricante.getText();

		controller.addModelo(nome, anoModelo, fabricante);

		limparForm();

		actionListar();

	}

	private void actionListar() {

		CatalogoController controller = MainController.getCatalogoController();

		textArea.setText(null);
		for (String nomeCategoria : controller.getModelos()) {
			textArea.append(String.format("%s\n", nomeCategoria));
		}
	}

	private void limparForm() {
		txtNome.setText("");
		txtanoModelo.setText("");
		txtFabricante.setText("");
	}
}
