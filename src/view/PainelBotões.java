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
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Bugs;
import model.Devs;
import model.Planeta;
import model.Plano;

public class PainelBotões extends JPanel implements ActionListener {

	private BotõesJavaLar botãoInstante, botãoLerArquivo, botãoRelatório, botãoLerDados, botãoGravar;
	private List<Planeta> planetas;
	private List<Planeta> falecidos;
	private int indexPlaneta = 0;
	private ArrayList<Bugs> listaBugs = new ArrayList<>();
	private ArrayList<Bugs> bugsRemovidos = new ArrayList<>();
	private ArrayList<Devs> devsRemovidos = new ArrayList<>();
	private PainelJavaLar painelJavaLar;
	private JLabel instantes;
	private JLabel título;
	private Plano plano;

	public PainelBotões(List<Planeta> planetas, PainelJavaLar painelJavaLar) {

		this.plano = new Plano();
		this.painelJavaLar = painelJavaLar;
		this.planetas = planetas;

		ImageIcon navezona = new ImageIcon("C:\\Users\\enzov\\eclipse-workspace\\ProvaFinal\\src\\icons\\talvez.gif");

		instantes = new JLabel("Selecione a quantidade de instantes:");
		instantes.setForeground(new Color(201, 218, 248));
		instantes.setFont(new Font("Old English Text MT", Font.BOLD, 17));
		título = new JLabel("                                           Selecionar Instantes");
		título.setForeground(new Color(81, 37, 125));
		;

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
		botãoInstante.addActionListener(this);
		botãoLerArquivo.addActionListener(this);
		botãoRelatório.addActionListener(this);
		botãoLerDados.addActionListener(this);
		botãoGravar.addActionListener(this);

	}

	public BotõesJavaLar getBotãoInstante() {
		return botãoInstante;
	}

	public BotõesJavaLar getBotãoLerArquivo() {
		return botãoLerArquivo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 ArrayList<Bugs> bugsRemovidos = new ArrayList<>();
		 ArrayList<Devs> devsRemovidos = new ArrayList<>();
		 List<Planeta> falecidos= new ArrayList<>();
		 
		if (e.getSource() == botãoInstante) {
			for (Planeta planeta : planetas) {

				planeta.mover();
				planeta.rotacionar();
				System.out.println("A posição do planeta " +planeta.getNome()+" é " + planeta.getX()+ "," + planeta.getY());
				System.out.println("No planeta" +planeta.getNome()+ " passou-se " + planeta.getTempoRodado() + " horas");
			}

			for (int i = 0; i < 3; i++) {
				Bugs novoBug = new Bugs(painelJavaLar.getPlano());
			    painelJavaLar.getPlano().listaBugs.add(novoBug);

			}
			for (int i = 0; i < 3; i++) {
			    Devs novoDev = new Devs(painelJavaLar.getPlano());
			    painelJavaLar.getPlano().listaDevs.add(novoDev);

			}
			painelJavaLar.getPlano().atualizarPlano(planetas, painelJavaLar.getListaCélulas());
			painelJavaLar.getPlano().verificarColisãoBugs((List<Planeta>) planetas,(ArrayList<Bugs>) bugsRemovidos);
			painelJavaLar.getPlano().verificarColisãoDevs((List<Planeta>) planetas,(ArrayList<Devs>) devsRemovidos);
			painelJavaLar.getPlano().explodirPlanetas((List<Planeta>) planetas,(ArrayList<Planeta>) falecidos);
			painelJavaLar.getPlano().analisarQuadrantes();
			
			
			revalidate();
			repaint();

		}
		if (e.getSource() == botãoLerArquivo) {
		    JFileChooser fileChooser = new JFileChooser();
		  

		    int result = fileChooser.showOpenDialog(null);

		    if (result == JFileChooser.APPROVE_OPTION) {
		        java.io.File selectedFile = fileChooser.getSelectedFile();
		        System.out.println("Arquivo selecionado: " + selectedFile.getAbsolutePath());

		        try (Scanner scanner = new Scanner(selectedFile)) {
		            if (scanner.hasNextLine()) {
		                scanner.nextLine();
		            }

		            while (scanner.hasNextLine()) {
		                String linha = scanner.nextLine();
		                String[] componentes = linha.split(",");
		                for (int i = 1; i < componentes.length; i++) {
	                        int instantes = Integer.parseInt(componentes[i]);
	                        System.out.println(instantes);
	                        if (planetas.get(indexPlaneta).getNome().equals("Java")==false) {
	                            Planeta planeta = planetas.get(indexPlaneta);
	                            planeta.setInstantes(instantes);
	                            System.out.println(planeta);
	                        }
	                 
	                        indexPlaneta = (indexPlaneta + 1) % planetas.size();
	                    }

		                
		                int quantatidadeBugs = Integer.parseInt(componentes[componentes.length - 2]);
	                    int quantidadeDevs = Integer.parseInt(componentes[componentes.length - 1]);
		            }
		            
		        } catch (IOException | NumberFormatException ex) {
		            ex.printStackTrace();
		        }
		    } 
		}
		
		if (e.getSource() == botãoRelatório) {
			
		}
		if (e.getSource() == botãoLerDados) {

		}
		
		if (e.getSource() == botãoGravar) {
			
		}
	};
}
