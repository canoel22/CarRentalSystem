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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
	private JComboBox<String> cbbCategoria;

	public CadastroSeguroView() {
		initialize();
	}

	private void initialize() {
		setTitle("Seguros");

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

		tabbedPane.add("Cadastro", formPane);
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
		lblDescricao.setBounds(12, 20, 107, 16);

		JLabel lblPercentualTarifa = new JLabel("Percentual tarifa");
		lblPercentualTarifa.setBounds(22, 58, 130, 16);

		JLabel lblCategoria = new JLabel("Categoria do Veículo");
		lblCategoria.setBounds(12, 99, 208, 16);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(164, 16, 130, 26);
		txtDescricao.setColumns(10);

		txtPercentualTarifa = new JTextField();
		txtPercentualTarifa.setBounds(165, 54, 86, 26);
		txtPercentualTarifa.setColumns(10);

		cbbCategoria = new JComboBox<String>(new Vector<String>(controller.getCategorias()));
		cbbCategoria.setBounds(163, 94, 216, 27);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(77, 152, 117, 29);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSalvar();

			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(194, 152, 117, 29);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCancelar();
			}
		});

		formPane.add(lblDescricao);
		formPane.add(txtDescricao);

		formPane.add(lblPercentualTarifa);
		formPane.add(txtPercentualTarifa);

		formPane.add(lblCategoria);
		formPane.add(cbbCategoria);

		formPane.add(btnSalvar);
		formPane.add(btnCancelar);

	}

	private void actionSalvar() {
		CatalogoController controller = MainController.getCatalogoController();

		try {
			String descricao = txtDescricao.getText();

			String percentualTarifaStr = txtPercentualTarifa.getText();
			int percentualTarifa = Integer.parseInt(percentualTarifaStr);

			String categoria = (String) cbbCategoria.getSelectedItem();

			controller.addSeguro(descricao, percentualTarifa, categoria);

		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(this, "Tipo inserido inválido!");
			return;

		} catch (Exception e) {
			e.printStackTrace();
		}

		limparForm();

	}

	private void actionListar() {

		CatalogoController controller = MainController.getCatalogoController();

		String nomeCategoria = (String) categoriasList.getSelectedItem();

		List<String> lista = controller.getSegurosCat(nomeCategoria);

		textAreaList.setText(null);

		for (String strSeguro : lista) {
			textAreaList.append(String.format("%s\n", strSeguro));
		}
	}

	private void limparForm() {
		txtDescricao.setText("");
		txtPercentualTarifa.setText("");
	}

	private void actionCancelar() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
