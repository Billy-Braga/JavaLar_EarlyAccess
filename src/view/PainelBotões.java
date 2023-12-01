package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import control.ActionController;
import control.planetas.Planeta;
import control.plano.Plano;

public class PainelBotões extends JPanel {

	private BotõesJavaLar botãoInstante, botãoLerArquivo, botãoRelatório, botãoLerDados, botãoGravar;
	private List<Planeta> planetas;
	private PainelJavaLar painelJavaLar;
	private Plano plano;
	private ActionController controle;

	public PainelBotões(List<Planeta> planetas, PainelJavaLar painelJavaLar) {

		controle = new ActionController(planetas, painelJavaLar, this);

		ImageIcon navezona = new ImageIcon("C:\\Users\\enzov\\eclipse-workspace\\ProvaFinal\\src\\view\\icones\\talvez.gif");

		botãoInstante = new BotõesJavaLar("Processar próximo instante");
		botãoLerArquivo = new BotõesJavaLar("Ler novo arquivo de entrada");
		botãoRelatório = new BotõesJavaLar("Gravar Relatório");
		botãoLerDados = new BotõesJavaLar("Ler dados de outros cidadãos");
		botãoGravar = new BotõesJavaLar("Gravar arquivo de saída");
		this.setBackground(new Color(21, 21, 43));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createMatteBorder(-1, -1, -1, -1, navezona));

		this.add(Box.createVerticalStrut(60));
		this.add(botãoInstante);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(botãoLerArquivo);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(botãoRelatório);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(botãoLerDados);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(botãoGravar);
		this.add(Box.createRigidArea(new Dimension(0, 60)));
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(310, 0));
		this.setVisible(true);
		botãoInstante.addActionListener(controle);
		botãoLerArquivo.addActionListener(controle);
		botãoRelatório.addActionListener(controle);
		botãoLerDados.addActionListener(controle);
		botãoGravar.addActionListener(controle);

	}

	public BotõesJavaLar getBotãoInstante() {
		return botãoInstante;
	}

	public BotõesJavaLar getBotãoLerArquivo() {
		return botãoLerArquivo;
	}

	public BotõesJavaLar getBotãoRelatório() {
		return botãoRelatório;
	}

	public BotõesJavaLar getBotãoLerDados() {
		return botãoLerDados;
	}

	public BotõesJavaLar getBotãoGravar() {
		return botãoGravar;
	}

}
