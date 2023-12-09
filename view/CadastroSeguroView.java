package view;

import java.awt.EventQueue;
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

public class CadastroSeguroView extends JFrame {

	private static final long serialVersionUID = 1615480617627032734L;
	
	private JPanel contentPane;
	
	private JLabel lblDescricao;
	private JLabel lblPercentualTarifa;
	
	private JTextField txtDescricao;
	private JTextField txtPercentualTarifa;
	private JTextArea textArea;
	
	private JButton btnSalvar;
	private JButton btnListar;


	public CadastroSeguroView() {
		initialize();
	}
	
	private void initialize() {
		
		setTitle("Cadastro de seguro");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(6, 0, 61, 16);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(85, 0, 213, 26);
		txtDescricao.setColumns(20);
		

		lblPercentualTarifa = new JLabel("Percentual de tarifa:");
		lblPercentualTarifa.setBounds(6, 30, 176, 16);

		txtPercentualTarifa = new JTextField();
		txtPercentualTarifa.setBounds(122, 30, 176, 26);
		txtPercentualTarifa.setColumns(20);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(310, 24, 117, 29);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSalvar();
			}
		});

		textArea = new JTextArea();
		textArea.setBounds(6, 100, 344, 167);

		btnListar = new JButton("Listar");
		btnListar.setBounds(310, 54, 117, 29);

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar();
			}
		});

		contentPane.add(lblDescricao);
		contentPane.add(txtDescricao);
		contentPane.add(lblPercentualTarifa);
		contentPane.add(txtPercentualTarifa);
		contentPane.add(btnSalvar);

		contentPane.add(textArea);
		contentPane.add(btnListar);

		actionListar();
	}
	private void actionSalvar() {
		CatalogoController controller = MainController.getCatalogoController();

		String descricao = txtDescricao.getText();
		String percentualTarifaStr = txtPercentualTarifa.getText();
		int percentualTarifa = Integer.parseInt(percentualTarifaStr);

		controller.addSeguro(descricao, percentualTarifa);

		limparForm();

		actionListar();

	}

	private void actionListar() {

		CatalogoController controller = MainController.getCatalogoController();

		textArea.setText(null);
		for (String descricao : controller.getSeguros()) {
			textArea.append(String.format("%s\n", descricao));
		}
	}

	private void limparForm() {
		txtDescricao.setText("");
		txtPercentualTarifa.setText("");
	}
}
