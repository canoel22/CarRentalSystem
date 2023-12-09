package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class MenuView extends JFrame {

	private static final long serialVersionUID = 1L;

	private ButtonGroup G1;

	private JRadioButton jRadioButton;
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton3;
	private JRadioButton jRadioButton4;
	private JRadioButton jRadioButton5;
	private JRadioButton jRadioButton6;
	private JRadioButton jRadioButton7;
	private JRadioButton jRadioButton8;
	private JRadioButton jRadioButton9;

	public MenuView() {
		initialize();
	}

	private void initialize() {

		setSize(450, 450);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		G1 = new ButtonGroup();

		jRadioButton = new JRadioButton();
		jRadioButton.setText("Catálogo veículos");
		jRadioButton.setBounds(100, 60, 300, 21);
		this.add(jRadioButton);

		jRadioButton1 = new JRadioButton();
		jRadioButton1.setText("Cadastro Cliente");
		jRadioButton1.setBounds(100, 80, 300, 21);
		this.add(jRadioButton1);

		jRadioButton2 = new JRadioButton();
		jRadioButton2.setText("Cadastro Veículo");
		jRadioButton2.setBounds(100, 100, 300, 21);
		this.add(jRadioButton2);

		jRadioButton3 = new JRadioButton();
		jRadioButton3.setText("Cadastro Modelo");
		jRadioButton3.setBounds(100, 120, 300, 21);
		this.add(jRadioButton3);

		jRadioButton4 = new JRadioButton();
		jRadioButton4.setText("Reserva");
		jRadioButton4.setBounds(100, 140, 300, 21);
		this.add(jRadioButton4);

		jRadioButton5 = new JRadioButton();
		jRadioButton5.setText("Início locação");
		jRadioButton5.setBounds(100, 160, 300, 21);
		this.add(jRadioButton5);

		jRadioButton6 = new JRadioButton();
		jRadioButton6.setText("Fim locação");
		jRadioButton6.setBounds(100, 180, 300, 21);
		this.add(jRadioButton6);

		jRadioButton7 = new JRadioButton();
		jRadioButton7.setText("Pagamento");
		jRadioButton7.setBounds(100, 200, 300, 21);
		this.add(jRadioButton7);

		jRadioButton8 = new JRadioButton();
		jRadioButton8.setText("Pagamento extra");
		jRadioButton8.setBounds(100, 220, 300, 21);
		this.add(jRadioButton8);

		jRadioButton9 = new JRadioButton();
		jRadioButton9.setText("Liberação manutenção");
		jRadioButton9.setBounds(100, 240, 300, 21);
		this.add(jRadioButton9);

		G1.add(jRadioButton);
		G1.add(jRadioButton1);
		G1.add(jRadioButton2);
		G1.add(jRadioButton3);
		G1.add(jRadioButton4);
		G1.add(jRadioButton5);
		G1.add(jRadioButton6);
		G1.add(jRadioButton7);
		G1.add(jRadioButton8);
		G1.add(jRadioButton9);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionContinuar();
			}
		});

		btnNewButton.setBounds(154, 320, 85, 21);
		this.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Bem vindo ao sistema de locação!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(100, 30, 300, 21);
		this.getContentPane().add(lblNewLabel);

	}

	private void actionContinuar() {

		if (jRadioButton.isSelected()) {
			//CatalogoVeiculoView catalogoVeiculoView = new CatalogoVeiculoView();
			//catalogoVeiculoView.setVisible(true);

		} else if (jRadioButton1.isSelected()) {
			//CadastroClienteView cadastroClienteView = new CadastroClienteView();
			//cadastroClienteView.setVisible(true);

		} else if (jRadioButton2.isSelected()) {
			CadastroVeiculoView cadastroVeiculoView = new CadastroVeiculoView();
			cadastroVeiculoView.setVisible(true);

		} else if (jRadioButton3.isSelected()) {
			CadastroModeloView cadastroModeloView = new CadastroModeloView();
			cadastroModeloView.setVisible(true);

		} else if (jRadioButton4.isSelected()) {
			//ReservaView reservaView = new ReservaView();
			//reservaView.setVisible(true);

		} else if (jRadioButton5.isSelected()) {
			//InicioLocacaoView inicioLocacaoView = new InicioLocacaoView();
			//inicioLocacaoView.setVisible(true);

		} else if (jRadioButton6.isSelected()) {
			//FimLocacaoView fimLocacaoView = new FimLocacaoView();
			//fimLocacaoView.setVisible(true);

		} else if (jRadioButton7.isSelected()) {
			//PagamentoView pagamentoView = new PagamentoView();
			//pagamentoView.setVisible(true);

		} else if (jRadioButton8.isSelected()) {
			//PagamentoExtraView pagamentoExtraView = new PagamentoExtraView();
			//pagamentoExtraView.setVisible(true);

		} else if (jRadioButton9.isSelected()) {
			//ManutencaoView manutencaoView = new ManutencaoView();
			//manutencaoView.setVisible(true);
		}
	}

}
