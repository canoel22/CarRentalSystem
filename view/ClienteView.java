package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import controller.ClienteController;
import controller.MainController;
import model.Endereco;

public class ClienteView extends JFrame {

	private static final long serialVersionUID = -404362399095556136L;

	private JPanel contentPane;

	private JTabbedPane tabbedPane;

	private JPanel listPane; // -> Painel de Listagem por categoria

	private JTextArea textAreaList;
	private JLabel lblClientes;

	private JPanel listPaneJ; // -> Painel de Listagem por categoria

	private JTextArea textAreaListJ;
	private JLabel lblClientesJ;

	private JPanel formPane; // -> Painel de cadastro

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
		listPaneJ = new JPanel();

		initFormPane();
		initListPane();
		initListPaneJ();

		tabbedPane.add("Listagem", listPane);
		tabbedPane.add("Listagem", listPaneJ);

		lblClientes = new JLabel("Lista de pessoas físicas");
		lblClientes.setBounds(12, 27, 207, 15);
		listPane.add(lblClientes);

		lblClientesJ = new JLabel("Lista de pessoas jurídicas");
		lblClientesJ.setBounds(12, 27, 196, 15);
		listPaneJ.add(lblClientesJ);

		tabbedPane.add("Cadastro", formPane);
	}

	private void initListPane() {

		listPane.setLayout(null);

		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(194, 20, 109, 29);

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar1();
			}
		});

		textAreaList = new JTextArea();
		textAreaList.setBounds(12, 60, 401, 300);

		listPane.add(textAreaList);

		listPane.add(btnListar);
	}

	private void initListPaneJ() {

		listPaneJ.setLayout(null);

		JButton btnListarJ = new JButton("Listar");
		btnListarJ.setBounds(214, 20, 109, 29);

		btnListarJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar2();
			}
		});

		textAreaListJ = new JTextArea();
		textAreaListJ.setBounds(12, 60, 401, 300);

		listPaneJ.add(textAreaListJ);

		listPaneJ.add(btnListarJ);
	}

	private void initFormPane() {

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

		JLabel lblCPF = new JLabel("CPF:");
		;
		lblCPF.setBounds(80, 204, 208, 16);

		JLabel lblCNH = new JLabel("Número CNH:");
		lblCNH.setBounds(20, 230, 208, 16);

		JLabel lblValCNH = new JLabel("Validade CNH:");
		lblValCNH.setBounds(12, 260, 208, 16);

		JLabel lblCNPJ = new JLabel("CNPJ:");
		lblCNPJ.setBounds(180, 204, 208, 16);

		JLabel lblContato = new JLabel("Nome de pessoa para contato:");
		lblContato.setBounds(20, 235, 260, 16);

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

		txtCidade = new JTextField();
		txtCidade.setBounds(285, 90, 130, 26);
		txtCidade.setColumns(10);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(285, 120, 130, 26);
		txtComplemento.setColumns(10);

		txtCPF = new JTextField();
		txtCPF.setBounds(140, 200, 130, 26);
		txtCPF.setColumns(10);

		cbbTipoUsuario = new JComboBox<>(new String[] { "Pessoa Física", "Pessoa Jurídica" });
		cbbTipoUsuario.setBounds(184, 158, 216, 27);

		txtCNH = new JTextField();
		txtCNH.setBounds(140, 230, 130, 26);
		txtCNH.setColumns(10);

		txtValCNH = new JTextField();
		txtValCNH.setBounds(140, 258, 130, 26);
		txtValCNH.setColumns(10);

		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(245, 200, 130, 26);
		txtCNPJ.setColumns(10);

		txtContato = new JTextField();
		txtContato.setBounds(245, 230, 130, 26);
		txtContato.setColumns(10);

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

		formPane.add(lblCPF);
		formPane.add(txtCPF);

		formPane.add(lblCNH);
		formPane.add(txtCNH);

		formPane.add(lblValCNH);
		formPane.add(txtValCNH);

		formPane.add(lblCNPJ);
		formPane.add(txtCNPJ);

		formPane.add(lblContato);
		formPane.add(txtContato);

		lblCPF.setVisible(false);
		txtCPF.setVisible(false);
		lblCNH.setVisible(false);
		txtCNH.setVisible(false);
		lblValCNH.setVisible(false);
		txtValCNH.setVisible(false);
		lblCNPJ.setVisible(false);
		txtCNPJ.setVisible(false);
		lblContato.setVisible(false);
		txtContato.setVisible(false);

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

		// Adiciona ação ao ComboBox para exibir/ocultar campoInformacaoExtra
		cbbTipoUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tipoUsuarioSelecionado = (String) cbbTipoUsuario.getSelectedItem();
				if ("Pessoa Física".equals(tipoUsuarioSelecionado)) {
					lblCPF.setVisible(true);
					txtCPF.setVisible(true);
					lblCNH.setVisible(true);
					txtCNH.setVisible(true);
					lblValCNH.setVisible(true);
					txtValCNH.setVisible(true);
					lblCNPJ.setVisible(false);
					txtCNPJ.setVisible(false);
					lblContato.setVisible(false);
					txtContato.setVisible(false);
				} else {
					lblCNPJ.setVisible(true);
					txtCNPJ.setVisible(true);
					lblContato.setVisible(true);
					txtContato.setVisible(true);
					lblCPF.setVisible(false);
					txtCPF.setVisible(false);
					lblCNH.setVisible(false);
					txtCNH.setVisible(false);
					lblValCNH.setVisible(false);
					txtValCNH.setVisible(false);
				}
			}
		});

		formPane.add(btnSalvar);
		formPane.add(btnCancelar);
	}

	private void actionSalvar() {
		ClienteController controller = MainController.getClienteController();

		try {
			String nome = txtNome.getText();

			String email = txtEmail.getText();
			if (!verificacoes.Verificacoes.validarEmail(email)) {
				verificacoes.Verificacoes.exibirPopup("Erro", "Email inválido!");
				return;
			}

			String telefoneStr = txtTelefone.getText();
			long telefone = Long.parseLong(telefoneStr);
			if (telefoneStr.length() != 12 || telefoneStr.charAt(3) != '9') {
				verificacoes.Verificacoes.exibirPopup("Erro",
						"O telefone deve ter exatamente 12 dígitos: (DDD)9XXXX-XXXX (sem espaços ou caracteres entre os números)");
				return;
			}

			String rua = txtNome.getText();
			String numeroStr = txtNumero.getText();
			try {
				int numero = Integer.parseInt(numeroStr);
				String bairro = txtBairro.getText();
				String cidade = txtCidade.getText();
				String complemento = txtComplemento.getText();

				if (!verificacoes.Verificacoes.verificarCamposPreenchidos(nome, rua, bairro, cidade, complemento)) {
					verificacoes.Verificacoes.exibirPopup("Erro", "Por favor, preencha todos os campos.");
					return;
				}

				controller.addEndereco(rua, numero, bairro, cidade, complemento);

				Endereco endereco = controller.getEnderecos(rua, numero, bairro, cidade, complemento);

				String opcaoEscolhida = (String) cbbTipoUsuario.getSelectedItem();

				if ("Pessoa Física".equals(opcaoEscolhida)) {

					String cpfStr = txtCPF.getText();
					if (!verificacoes.Verificacoes.validarCPF(cpfStr)) {
						verificacoes.Verificacoes.exibirPopup("Erro", "CPF inválido!");
						return;
					}
					long cpf = Long.parseLong(cpfStr);

					String cnhStr = txtCNH.getText();
					if (cnhStr.length() != 11) {
						verificacoes.Verificacoes.exibirPopup("Erro", "CNH inválida!");
						return;
					}
					try {
						long cnh = Long.parseLong(cnhStr);

						String valCNHStr = txtValCNH.getText();
						String formatoData = "dd/MM/yyyy";
						SimpleDateFormat formato = new SimpleDateFormat(formatoData);
						try {
							Date valCNH = formato.parse(valCNHStr);
							Date hoje = new Date();
							if (!valCNH.after(hoje)) {
								verificacoes.Verificacoes.exibirPopup("Erro",
										"CNH vencida! Não é possível fazer o cadastro!");
							}

							controller.addPessoaFisica(nome, email, telefone, endereco, cpf, cnh, valCNH);
							verificacoes.Verificacoes.exibirPopupSucesso("Sucesso", "Cadastro realizado com sucesso!");
							System.out.printf("Cadastrou fisica");

						} catch (ParseException e) {
							verificacoes.Verificacoes.exibirPopup("Erro", "Data inválida! Insira como: dd/mm/aaaa");
							return;
						}

					} catch (NumberFormatException e) {
						verificacoes.Verificacoes.exibirPopup("Erro",
								"A CNH informada nao é valida, digite somente números");
						return;
					}

				} else {
					String cnpjStr = txtCNPJ.getText();
					if (!verificacoes.Verificacoes.validarCPF(cnpjStr)) {
						verificacoes.Verificacoes.exibirPopup("Erro", "CNPJ inválido!");
						return;
					}
					long cnpj = Long.parseLong(cnpjStr);

					String contato = txtContato.getText();

					controller.addPessoaJuridica(nome, email, telefone, endereco, cnpj, contato);
					verificacoes.Verificacoes.exibirPopupSucesso("Sucesso", "Cadastro realizado com sucesso!");
					System.out.printf("Cadastrou juridica");

					if (!verificacoes.Verificacoes.verificarCamposPreenchidos(contato)) {
						System.out.println("Por favor, preencha todos os campos.");
						return;
					}
				}

			} catch (NumberFormatException e) {
				verificacoes.Verificacoes.exibirPopup("Erro",
						"O número do endereço informado nao é valido, digite somente numeros");
				return;
			}

		} catch (

		NumberFormatException e) {
			verificacoes.Verificacoes.exibirPopup("Erro", "O telefone informado nao é valido, digite somente numeros");
			return;
		}

		limparForm();

	}

	private void actionListar1() {

		ClienteController controller = MainController.getClienteController();

		List<String> lista = controller.getPessoasFisicas();

		textAreaList.setText(null);

		for (String strCliente : lista) {
			textAreaList.append(String.format("%s\n", strCliente));
		}
	}

	private void actionListar2() {

		ClienteController controller = MainController.getClienteController();

		List<String> lista = controller.getPessoasJuridicas();

		textAreaListJ.setText(null);

		for (String strClienteJ : lista) {
			textAreaListJ.append(String.format("%s\n", strClienteJ));
		}
	}

	private void limparForm() {
		txtNome.setText("");
		txtTelefone.setText("");
		txtEmail.setText("");
		txtRua.setText("");
		txtNumero.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		txtComplemento.setText("");
		txtCPF.setText("");
		txtCNH.setText("");
		txtValCNH.setText("");
		txtCNPJ.setText("");
		txtContato.setText("");

	}

	private void actionCancelar() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

}
