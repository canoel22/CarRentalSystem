package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.UUID;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LocacaoController;
import controller.MainController;
import model.EFormaPagamento;
import model.EMotivoPagamento;

public class PagamentoView extends JFrame {

	private static final long serialVersionUID = 6289417436824808081L;

	private JPanel contentPane;

	private JLabel lblLocacao;
	private JLabel lblTipoPgt;
	private JLabel lblValor;
	private JLabel lblMotivoPgt;
	private JLabel lblDescricaoPgt;

	private JComboBox<UUID> cbbLocacao;
	private JComboBox<EFormaPagamento> cbbTipoPgt;
	private JTextField txtValor;
	private JComboBox<EMotivoPagamento> cbbMotivoPgt;
	private JTextField txtDescricaoPgt;

	private JButton btnSalvar;

	public PagamentoView() {
		initialize();
	}

	private void initialize() {

		setTitle("Pagamento");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		lblLocacao = new JLabel("UUID da locação:");
		lblLocacao.setBounds(12, 17, 176, 16);

		cbbLocacao = new JComboBox<UUID>(new Vector<UUID>(MainController.getLocacaoController().getDevolucoesUUID()));
		cbbLocacao.setBounds(177, 12, 216, 27);

		lblTipoPgt = new JLabel("Forma de pagamento:");
		lblTipoPgt.setBounds(12, 62, 176, 16);

		cbbTipoPgt = new JComboBox<EFormaPagamento>(EFormaPagamento.values());
		cbbTipoPgt.setBounds(177, 57, 216, 27);

		lblValor = new JLabel("Valor:");
		lblValor.setBounds(12, 155, 176, 16);

		txtValor = new JTextField();
		txtValor.setBounds(177, 151, 176, 26);
		txtValor.setColumns(20);

		lblMotivoPgt = new JLabel("Motivo do pagamento:");
		lblMotivoPgt.setBounds(12, 112, 182, 16);

		cbbMotivoPgt = new JComboBox<EMotivoPagamento>(EMotivoPagamento.values());
		cbbMotivoPgt.setBounds(177, 107, 216, 27);
		cbbMotivoPgt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionValor();
			}
		});

		lblDescricaoPgt = new JLabel("Descrição do pagamento:");
		lblDescricaoPgt.setBounds(12, 208, 196, 16);

		txtDescricaoPgt = new JTextField();
		txtDescricaoPgt.setBounds(204, 204, 176, 26);
		txtDescricaoPgt.setColumns(20);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(149, 256, 117, 29);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSalvar();
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(218, 323, 117, 29);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCancelar();
			}
		});

		contentPane.add(lblLocacao);
		contentPane.add(cbbLocacao);

		contentPane.add(lblTipoPgt);
		contentPane.add(cbbTipoPgt);

		contentPane.add(lblValor);
		contentPane.add(txtValor);

		contentPane.add(lblDescricaoPgt);
		contentPane.add(txtDescricaoPgt);
		
		contentPane.add(lblMotivoPgt);
		contentPane.add(cbbMotivoPgt);

		contentPane.add(btnSalvar);
		contentPane.add(btnCancelar);
	}

	private void actionSalvar() {
		LocacaoController controller = MainController.getLocacaoController();

		UUID locacao = (UUID) cbbLocacao.getSelectedItem();
		EFormaPagamento tipo = (EFormaPagamento) cbbTipoPgt.getSelectedItem();
		String valorStr = txtValor.getText();
		try {
			double valor = Double.parseDouble(valorStr);

			EMotivoPagamento motivo = (EMotivoPagamento) cbbMotivoPgt.getSelectedItem();
			String descricao = txtDescricaoPgt.getText();

			if (!verificacoes.Verificacoes.verificarCamposPreenchidos(valorStr, descricao)) {
				verificacoes.Verificacoes.exibirPopup("Erro", "Por favor, preencha todos os campos.");
				return;
			}

			if (controller.addPagamento(locacao, valor, tipo, motivo, descricao)) {
				verificacoes.Verificacoes.exibirPopupSucesso("Sucesso", "Pagamento realizado com sucesso!");
			}

		} catch (NumberFormatException e) {
			verificacoes.Verificacoes.exibirPopup("Erro", "Insira apenas números");
			return;
		}

		limparForm();

	}

	private void actionCancelar() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

	private void actionValor() {
		LocacaoController locacaoController = MainController.getLocacaoController();

		if (cbbMotivoPgt.getSelectedItem() == EMotivoPagamento.LOCACAO) {
			UUID numLocacao = (UUID) cbbLocacao.getSelectedItem();
			double valor = LocacaoController.getValorTotalLocacao(locacaoController.getLocacao(numLocacao));
			txtValor.setText("" + valor);
			txtValor.setEditable(false);
		} else if (cbbMotivoPgt.getSelectedItem() == EMotivoPagamento.LIMPEZA) {
			txtValor.setText("100");
			txtValor.setEditable(false);
		} else if (cbbMotivoPgt.getSelectedItem() == EMotivoPagamento.REPAROS) {
			txtValor.setText("300");
			txtValor.setEditable(false);
		} else if (cbbMotivoPgt.getSelectedItem() == EMotivoPagamento.MULTA) {
			txtValor.setText("Digite o valor da multa");
			txtValor.setEditable(true);
		}
	}

	private void limparForm() {
		txtDescricaoPgt.setText("");
		txtValor.setText("");
	}
}
