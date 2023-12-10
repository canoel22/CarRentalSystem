package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import controller.MainController;
import javax.swing.SwingConstants;

public class ClienteView extends JFrame {

	private static final long serialVersionUID = -404362399095556136L;

	private JPanel contentPane;

	private JTabbedPane tabbedPane;

	private JPanel listPane; // Painel de Listagem por categoria

	private JTextArea textAreaList;
	private JLabel lblClientes;

	private JPanel formPane; // Painel de cadastro

	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtComplemento;
	private JComboBox<String> cbbTipoUsuario;
	private JTextField txtCPF;
	private JTextField txtCNH;
	private JTextField txtValCNH;
	private JTextField txtCNPJ;
	private JTextField txtContato;

	public ClienteView() {
		initialize();
	}

	private void initialize() {
		setTitle("Clientes");

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

		lblClientes = new JLabel("Lista de usuários");
		lblClientes.setBounds(12, 27, 150, 15);
		listPane.add(lblClientes);

		tabbedPane.add("Cadastro", formPane);
	}

	private void initListPane() {

		ClienteController controller = MainController.getClienteController();

		listPane.setLayout(null);

		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(147, 20, 109, 29);

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar();
			}
		});

		textAreaList = new JTextArea();
		textAreaList.setBounds(12, 60, 401, 300);

		listPane.add(textAreaList);

		listPane.add(btnListar);
	}

	private void initFormPane() {

		ClienteController controller = MainController.getClienteController();

		formPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 36, 107, 16);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 66, 130, 16);		
	
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(0, 98, 208, 16);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(220, 14, 208, 16);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(220, 40, 208, 16);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(220, 66, 208, 16);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(220, 95, 208, 16);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setVerticalAlignment(SwingConstants.BOTTOM);
		lblComplemento.setBounds(176, 123, 208, 16);

		JLabel lblTipoUsuario = new JLabel("Tipo de Usuário:");
		lblTipoUsuario.setBounds(36, 163, 208, 16);

		JLabel lblCPF = new JLabel("CPF:");;
		lblCPF.setBounds(80, 204, 208, 16);

		JLabel lblCNH = new JLabel("Número CNH:");
		lblCNH.setBounds(20, 230, 208, 16);

		JLabel lblValCNH = new JLabel("Validade CNH:");
		lblValCNH.setBounds(12, 260, 208, 16);

		JLabel lblCNPJ= new JLabel("CNPJ:");
		lblCNPJ.setBounds(80, 204, 208, 16);

		JLabel lblContato = new JLabel("Nome de pessoa para contato:");
		lblContato.setBounds(20, 230, 208, 16);

		txtNome = new JTextField();
		txtNome.setBounds(72, 32, 130, 26);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(72, 62, 130, 26);
		txtEmail.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(72, 94, 130, 26);
		txtTelefone.setColumns(10);
		
		txtRua = new JTextField();
		txtRua.setBounds(285, 10, 130, 26);
		txtRua.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setBounds(285, 33, 130, 26);
		txtNumero.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(285, 62, 130, 26);
		txtBairro.setColumns(10);
		
		txtCidade= new JTextField();
		txtCidade.setBounds(285, 90, 130, 26);
		txtCidade.setColumns(10);
		
		txtComplemento= new JTextField();
		txtComplemento.setBounds(285, 120, 130, 26);
		txtComplemento.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(140, 200, 130, 26);
		txtCPF.setColumns(10);
		
		cbbTipoUsuario =  new JComboBox<>(new String[] { "Pessoa Física", "Pessoa Jurídica" });
		cbbTipoUsuario.setBounds(184, 158, 216, 27);
		
		txtCNH = new JTextField();
		txtCNH.setBounds(140, 230, 130, 26);
		txtCNH.setColumns(10);
		
		txtValCNH = new JTextField();
		txtValCNH.setBounds(140, 258, 130, 26);
		txtValCNH.setColumns(10);
		
		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(140, 200, 130, 26);
		txtCNPJ.setColumns(10);
		
		txtContato = new JTextField();
		txtContato.setBounds(140, 230, 130, 26);
		txtContato.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(91, 300, 117, 29);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSalvar();

			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(207, 300, 117, 29);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCancelar();
			}
		});
		
		formPane.add(lblNome);
		formPane.add(txtNome);
		
		formPane.add(lblTelefone);
		formPane.add(txtTelefone);
		
		formPane.add(lblEmail);
		formPane.add(txtEmail);
		
		formPane.add(lblRua);
		formPane.add(txtRua);
		
		formPane.add(lblNumero);
		formPane.add(txtNumero);
		
		formPane.add(lblBairro);
		formPane.add(txtBairro);
		
		formPane.add(lblCidade);
		formPane.add(txtCidade);
		
		formPane.add(lblComplemento);
		formPane.add(txtComplemento);
		
		formPane.add(lblTipoUsuario);
		formPane.add(cbbTipoUsuario);
		
		formPane.add(btnSalvar);
		formPane.add(btnCancelar);

		
		// Adiciona ação ao ComboBox para exibir/ocultar campoInformacaoExtra
		cbbTipoUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tipoUsuarioSelecionado = (String) cbbTipoUsuario.getSelectedItem();
				if ("Pessoa Física".equals(tipoUsuarioSelecionado)) {
					formPane.add(lblCPF);
					formPane.add(txtCPF);
					formPane.add(lblCNH);
					formPane.add(txtCNH);
					formPane.add(lblValCNH);
					formPane.add(txtValCNH);
				} else {
					formPane.add(lblCNPJ);
					formPane.add(txtCNPJ);
					formPane.add(lblContato);
					formPane.add(txtContato);
				}
			}
		}
			
	}


}
