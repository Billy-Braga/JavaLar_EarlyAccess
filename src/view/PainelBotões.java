package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import model.Planeta;

public class PainelBotões extends JPanel implements ActionListener{

	private BotõesJavaLar botãoInstante, botãoLerArquivo, botãoRelatório, botãoLerDados, botãoGravar;
	private List<Planeta> planetas;
	private PainelJavaLar painelJavaLar;
	private JLabel instantes;
	private JLabel título;
	

	public PainelBotões(List<Planeta> planetas, PainelJavaLar painelJavaLar) {
		
		
		this.painelJavaLar= painelJavaLar;
		this.planetas = planetas;
		ImageIcon navezona = new ImageIcon("C:\\Users\\enzov\\eclipse-workspace\\ProvaFinal\\src\\icons\\talvez.gif");

		
		instantes= new JLabel("Selecione a quantidade de instantes:");
		instantes.setForeground(new Color(201,218,248));
		instantes.setFont(new Font("Old English Text MT", Font.BOLD, 17));
		título= new JLabel("                                           Selecionar Instantes");
		título.setForeground(new Color(81, 37, 125));;
		
		botãoInstante = new BotõesJavaLar("Processar próximo instante");
		botãoLerArquivo = new BotõesJavaLar("Ler novo arquivo de entrada");
		botãoRelatório = new BotõesJavaLar("Gravar Relatório");
		botãoLerDados = new BotõesJavaLar("Ler dados de outros\n participantes");
		botãoGravar = new BotõesJavaLar("Gravar arquivo de saída");
		this.setBackground(new Color(21,21,43));
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
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== botãoInstante) {
			for(Planeta planeta : planetas) {
				int movimento = planeta.getMovimento();
				planeta.mover( movimento);
			}
			 painelJavaLar.getPlano().atualizarPlanetas(planetas, painelJavaLar.getListaCélulas());
			revalidate();
			repaint();
		}
		if (e.getSource() == botãoLerArquivo) {
			Object[] opções = { "10", "50", "100", "500", "1000", "1500", "2000" };
			ImageIcon FischerJonatas = new ImageIcon("C:\\Users\\enzov\\eclipse-workspace\\ProvaFinal\\src\\icons\\fesch.png");
			JOptionPane.showOptionDialog(null, instantes, "                                           Selecionar Instantes",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, FischerJonatas, opções, opções[0]);
			
		}

		

	};
}
