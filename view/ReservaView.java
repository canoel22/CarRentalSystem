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

import controller.ClienteController;
import controller.LocacaoController;
import controller.MainController;

public class ReservaView extends JFrame {

	private static final long serialVersionUID = -8533454427135734983L;

	private JPanel contentPane;

	private JTabbedPane tabbedPane;

	private JPanel listPane; // Painel de Listagem de reservas por cliente

	private JTextArea textAreaList;
	private JComboBox<String> cbbClientes;
	private JLabel lblClientes;

	private JPanel formPane; // Painel de cadastro

	private JTextField txtNumReserva;
	private JTextField txtInicioReserva;
	private JTextField txtFimReserva;
	private JTextField txtValorTarifaDiaria;
	private JComboBox<String> cbbCategoriasList;

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

		lblClientes = new JLabel("Reservas por cliente");
		lblClientes.setBounds(12, 27, 207, 15);
		listPane.add(lblClientes);

		tabbedPane.add("Cadastro", formPane);
	}

	private void initListPane() {

		ClienteController controller = MainController.getClienteController();

		listPane.setLayout(null);

		cbbClientes = new JComboBox<String>(new Vector<String>(controller.getClientes()));

		cbbClientes.setBounds(6, 21, 330, 27);

		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(346, 20, 109, 29);

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar();
			}
		});

		textAreaList = new JTextArea();
		textAreaList.setBounds(12, 60, 320, 193);

		listPane.add(lblClientes);
		listPane.add(cbbClientes);

		listPane.add(btnListar);
	}

	private void initFormPane() {

		formPane.setLayout(null);

		JLabel lblNumReserva = new JLabel("Número de Reserva");
		lblNumReserva.setBounds(12, 4, 144, 16);

		JLabel lblInicioReserva = new JLabel("Inicio da reserva");
		lblInicioReserva.setBounds(12, 33, 130, 16);

		JLabel lblFimReserva = new JLabel("Fim da reserva");
		lblFimReserva.setBounds(12, 63, 130, 16);

		JLabel lblValorTarifaDiaria = new JLabel("Valor da tarifa diária");
		lblValorTarifaDiaria.setBounds(0, 140, 162, 16);

		JLabel lblCategoriasList = new JLabel("Categoria");
		lblCategoriasList.setBounds(12, 99, 71, 16);

		cbbCategoriasList = new JComboBox<String>(
				new Vector<String>(MainController.getCatalogoController().getCategorias()));
		cbbCategoriasList.setBounds(134, 94, 216, 27);

		txtNumReserva = new JTextField();
		txtNumReserva.setBounds(158, 0, 130, 26);
		txtNumReserva.setColumns(10);

		txtInicioReserva = new JTextField();
		txtInicioReserva.setBounds(158, 29, 130, 26);
		txtInicioReserva.setColumns(10);

		txtFimReserva = new JTextField();
		txtFimReserva.setBounds(158, 59, 130, 26);
		txtFimReserva.setColumns(10);

		txtValorTarifaDiaria = new JTextField();
		txtValorTarifaDiaria.setBounds(158, 136, 130, 26);
		txtValorTarifaDiaria.setColumns(10);

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

		formPane.add(lblNumReserva);
		formPane.add(txtNumReserva);

		formPane.add(lblInicioReserva);
		formPane.add(txtInicioReserva);

		formPane.add(lblFimReserva);
		formPane.add(txtFimReserva);

		formPane.add(lblValorTarifaDiaria);
		formPane.add(txtValorTarifaDiaria);

		formPane.add(lblCategoriasList);
		formPane.add(cbbCategoriasList);
		
		formPane.add(btnSalvar);
		formPane.add(btnCancelar);
	}

	private void actionSalvar() {
		LocacaoController controller = MainController.getLocacaoController();

		try {

			int numReserva = Integer.parseInt(txtNumReserva.getText());

			String inicioReserva = txtInicioReserva.getText();

			String fimReserva = txtFimReserva.getText();

			int valorTarifaDiaria = Integer.parseInt(txtValorTarifaDiaria.getText());

			String categoria = (String) cbbCategoriasList.getSelectedItem();

			controller.addReserva(numReserva, inicioReserva, fimReserva, valorTarifaDiaria, categoria);

		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(this, "Tipo inserido inválido!");
			return;

		} catch (Exception e) {
			e.printStackTrace();
		}

		limparForm();

	}

	private void actionListar() {

		LocacaoController controller = MainController.getLocacaoController();

		String nomeCliente = (String) cbbClientes.getSelectedItem();

		List<String> lista = controller.getReservaCliente(nomeCliente);

		textAreaList.setText(null);

		for (String strReserva : lista) {
			textAreaList.append(String.format("%s\n", strReserva));
		}
	}

	private void limparForm() {
		txtNumReserva.setText("");
		txtInicioReserva.setText("");
		txtFimReserva.setText("");
		txtValorTarifaDiaria.setText("");
	}

	private void actionCancelar() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

}
