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

public class ManutencaoView extends JFrame {

	private static final long serialVersionUID = 8380803308688517596L;

	private JPanel contentPane;

	private JLabel lblLocacao;

	private JComboBox<UUID> cbbLocacao;

	private JButton btnFeito;
	private JButton btnPagar;
	private JButton btnManutencao;

	public ManutencaoView() {
		initialize();
	}

	private void initialize() {

		setTitle("Manutenção");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 255);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		lblLocacao = new JLabel("UUID da locação:");
		lblLocacao.setBounds(12, 17, 176, 16);

		cbbLocacao = new JComboBox<UUID>(new Vector<UUID>(MainController.getLocacaoController().getDevolucoesUUID()));
		cbbLocacao.setBounds(177, 12, 216, 27);

		btnFeito = new JButton("Manutenção feita");
		btnFeito.setBounds(130, 70, 185, 29);

		btnFeito.addActionListener(new ActionListener() {
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
		
		btnManutencao = new JButton("Fazer manutenção");
		btnManutencao.setBounds(130, 157, 185, 29);

		btnManutencao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionManutencao();
			}
		});

		contentPane.add(lblLocacao);
		contentPane.add(cbbLocacao);

		contentPane.add(btnFeito);
		contentPane.add(btnPagar);
		contentPane.add(btnManutencao);
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
	
	private void actionManutencao() {
		LocacaoController controller = MainController.getLocacaoController();

		UUID locacao = (UUID) cbbLocacao.getSelectedItem();
		Veiculo veiculo = controller.getLocacao(locacao).getVeiculo();

		try {
			veiculo.setStatus(EStatusVeiculo.MANUTENCAO);
			MainController.save();
			verificacoes.Verificacoes.exibirPopupSucesso("Manutenção", "Veículo em manutenção");
		} catch (Exception e) {
			verificacoes.Verificacoes.exibirPopup("Erro", "" + e);
		}

	}

	private void actionPagar() {
		PagamentoView pagamentoView = new PagamentoView();
		pagamentoView.setVisible(true);
	}

}
