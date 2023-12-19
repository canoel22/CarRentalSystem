package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LocacaoController;
import controller.MainController;
import model.EStatusVeiculo;
import model.Veiculo;

public class LimpezaView extends JFrame {

	private static final long serialVersionUID = 5825115089420576799L;

	private JPanel contentPane;

	private JLabel lblLocacao;

	private JComboBox<UUID> cbbLocacao;

	private JButton btnLimpo;
	private JButton btnPagar;

	public LimpezaView() {
		initialize();
	}

	private void initialize() {

		setTitle("Limpeza");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 218);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		lblLocacao = new JLabel("UUID da locação:");
		lblLocacao.setBounds(12, 17, 176, 16);

		cbbLocacao = new JComboBox<UUID>(new Vector<UUID>(MainController.getLocacaoController().getDevolucoesUUID()));
		cbbLocacao.setBounds(177, 12, 216, 27);

		btnLimpo = new JButton("Limpeza feita");
		btnLimpo.setBounds(130, 70, 185, 29);

		btnLimpo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionLimpo();
			}
		});

		btnPagar = new JButton("Pagar");
		btnPagar.setBounds(130, 111, 185, 29);

		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPagar();
			}
		});

		contentPane.add(lblLocacao);
		contentPane.add(cbbLocacao);

		contentPane.add(btnLimpo);
		contentPane.add(btnPagar);
	}

	private void actionLimpo() {
		LocacaoController controller = MainController.getLocacaoController();

		UUID locacao = (UUID) cbbLocacao.getSelectedItem();
		Veiculo veiculo = controller.getLocacao(locacao).getVeiculo();

		try {
			veiculo.setStatus(EStatusVeiculo.DISPONIVEL);
			MainController.save();
			verificacoes.Verificacoes.exibirPopupSucesso("Disponivel", "Veículo disponível");
		} catch (Exception e) {
			verificacoes.Verificacoes.exibirPopup("Erro", "" + e);
		}

	}

	private void actionPagar() {
		PagamentoView pagamentoView = new PagamentoView();
		pagamentoView.setVisible(true);
	}

}
