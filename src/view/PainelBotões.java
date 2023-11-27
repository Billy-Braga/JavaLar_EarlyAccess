package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.ActionController;
import control.RelatórioDAO;
import model.Bugs;
import model.Devs;
import model.Planeta;
import model.Plano;

public class PainelBotões extends JPanel {

	private BotõesJavaLar botãoInstante, botãoLerArquivo, botãoRelatório, botãoLerDados, botãoGravar;
	private List<Planeta> planetas;
	private List<Planeta> falecidos;
	private int indexPlaneta = 0;
	private ArrayList<Bugs> listaBugs = new ArrayList<>();
	private ArrayList<Bugs> bugsRemovidos = new ArrayList<>();
	private ArrayList<Devs> devsRemovidos = new ArrayList<>();
	private PainelJavaLar painelJavaLar;
	private int quantidadeBugs = 0;
	private int quantidadeDevs = 0;
	private RelatórioDAO relatório;
	private String arquivo;
	private JLabel instantes;
	private JLabel título;
	private Plano plano;
	private ActionController controle;

	public PainelBotões(List<Planeta> planetas, PainelJavaLar painelJavaLar) {

		controle= new ActionController(planetas, painelJavaLar, this);

		ImageIcon navezona = new ImageIcon("C:\\Users\\enzov\\eclipse-workspace\\ProvaFinal\\src\\icons\\talvez.gif");

		botãoInstante = new BotõesJavaLar("Processar próximo instante");
		botãoLerArquivo = new BotõesJavaLar("Ler novo arquivo de entrada");
		botãoRelatório = new BotõesJavaLar("Gravar Relatório");
		botãoLerDados = new BotõesJavaLar("Ler dados de outros\n participantes");
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
