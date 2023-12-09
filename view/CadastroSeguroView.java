package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class CadastroSeguroView extends JFrame {

	private static final long serialVersionUID = 1615480617627032734L;

	private JPanel contentPane;
	
	private JTabbedPane tabbedPane;

	private JPanel listPane; // Painel de Listagem por categoria

	private JComboBox<String> categoriasList;
	private JTextArea textAreaList;
	private JLabel lblFiltroPorCategoria;
	
	private JPanel formPane; // Painel de cadastro

	private JTextField txtDescricao;
	private JTextField txtPercentualTarifa;
	private JTextArea textArea;
	private JComboBox<String> cbbCategoriaVeiculo;

	public CadastroSeguroView() {
		initialize();
	}

	private void initialize() {
		setTitle("Veículo");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 338);

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
		
		lblFiltroPorCategoria = new JLabel("Filtro por categoria");
		lblFiltroPorCategoria.setBounds(12, 0, 150, 15);
		listPane.add(lblFiltroPorCategoria);
		
	}
	
	private void initListPane() {

		CatalogoController controller = MainController.getCatalogoController();

		listPane.setLayout(null);

		categoriasList = new JComboBox<String>(new Vector<String>(controller.getCategorias()));

		categoriasList.setBounds(6, 21, 330, 27);

		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(346, 20, 109, 29);

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar();
			}
		});

		textAreaList = new JTextArea();
		textAreaList.setBounds(12, 60, 320, 193);

		listPane.add(categoriasList);
		listPane.add(textAreaList);

		listPane.add(btnListar);
	}
	
	
	private void initFormPane() {


		CatalogoController controller = MainController.getCatalogoController();

		formPane.setLayout(null);

		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setBounds(17, 4, 61, 16);

		JLabel lblPercentualTarifa = new JLabel("Percentual tarifa");
		lblPercentualTarifa.setBounds(12, 33, 130, 16);
		
		cbbCategoriaVeiculo = new JComboBox<String>(new Vector<String>(controller.getCategorias()));
		cbbCategoriaVeiculo.setBounds(134, 94, 216, 27);
		
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
		
		formPane.add(lblDescricao);
		formPane.add(txtDescricao);

		formPane.add(lblPercentualTarifa);
		formPane.add(txtPercentualTarifa);
		
		formPane.add(lblCategoriaVeiculo);
		formPane.add(cbbCategoriaVeiculo);

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
