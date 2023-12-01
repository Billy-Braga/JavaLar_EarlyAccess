package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import control.planetas.Planeta;
import control.plano.Bugs;
import control.plano.Devs;
import control.plano.Plano;
import model.DadosRelatório;
import model.JavaLarDAO;
import view.PainelBotões;
import view.PainelJavaLar;

public class ActionController implements ActionListener {

	private PainelBotões painelBotões;
	private Plano plano;
	private List<Planeta> planetas;
	private int indexPlaneta = 0;
	private PainelJavaLar painelJavaLar;
	private int quantidadeBugs = 0;
	private int quantidadeDevs = 0;
	private JavaLarDAO dadosDAO;
	private String arquivo;
	private ArrayList<DadosRelatório> dadosObtidos;
	private JLabel aviso;
	private boolean arquivoLido=false;

	public ActionController(List<Planeta> planetas, PainelJavaLar painelJavaLar, PainelBotões painelBotões) {
		this.plano = new Plano();
		this.painelBotões = painelBotões;
		this.planetas = planetas;
		this.painelJavaLar = painelJavaLar;
		dadosDAO = new JavaLarDAO(plano, planetas, painelJavaLar, this);
		aviso = new JLabel();
		aviso.setForeground(Color.WHITE);
		aviso.setText("Meu fi, selecione o arquivo, por gentileza");
		aviso.setFont(new Font("Old English Text MT",Font.PLAIN,18));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ArrayList<Bugs> bugsRemovidos = new ArrayList<>();
		ArrayList<Devs> devsRemovidos = new ArrayList<>();
		List<Planeta> falecidos = new ArrayList<>();

		if (e.getSource() == painelBotões.getBotãoInstante()) {
			
			 if (!arquivoLido) {

		            UIManager.put("OptionPane.informationIcon", new ImageIcon("C:\\Users\\enzov\\eclipse-workspace\\ProvaFinal\\src\\view\\icones\\fesch.png"));
		            JOptionPane.showMessageDialog(null, aviso, "                         Tu esqueceu do arquivo meu chapa!!", JOptionPane.INFORMATION_MESSAGE);
		            UIManager.put("OptionPane.informationIcon", UIManager.getIcon("OptionPane.informationIcon"));

		            return;
		        }else {
			for (Planeta planeta : planetas) {
				planeta.mover();
				planeta.rotacionar();
			}

			for (int i = 0; i < quantidadeBugs; i++) {
				Bugs novoBug = new Bugs(painelJavaLar.getPlano());
				painelJavaLar.getPlano().listaBugs.add(novoBug);

			}
			for (int i = 0; i < quantidadeDevs; i++) {
				Devs novoDev = new Devs(painelJavaLar.getPlano());
				painelJavaLar.getPlano().listaDevs.add(novoDev);

			}
			painelJavaLar.getPlano().atualizarPlano(planetas, painelJavaLar.getListaCélulas());
			painelJavaLar.getPlano().verificarColisãoBugs((List<Planeta>) planetas, (ArrayList<Bugs>) bugsRemovidos);
			painelJavaLar.getPlano().verificarColisãoDevs((List<Planeta>) planetas, (ArrayList<Devs>) devsRemovidos);
			painelJavaLar.getPlano().explodirPlanetas((List<Planeta>) planetas, (ArrayList<Planeta>) falecidos);
			painelJavaLar.getPlano().analisarQuadrantes();
		        }
		}
		if (e.getSource() == painelBotões.getBotãoLerArquivo()) {
			JFileChooser fileChooser = new JFileChooser();

			int result = fileChooser.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION) {
				java.io.File selectedFile = fileChooser.getSelectedFile();

				arquivo = selectedFile.getName();

				try (Scanner scanner = new Scanner(selectedFile)) {
					if (scanner.hasNextLine()) {
						scanner.nextLine();
					}

					while (scanner.hasNextLine()) {
						String linha = scanner.nextLine();
						String[] componentes = linha.split(",");
						for (int i = 1; i < componentes.length; i++) {
							int instantes = Integer.parseInt(componentes[i]);

							if (planetas.get(indexPlaneta).getNome().equals("Java") == false) {
								Planeta planeta = planetas.get(indexPlaneta);
								planeta.setInstantes(instantes);

							}

							indexPlaneta = (indexPlaneta + 1) % planetas.size();
						}

						quantidadeBugs = Integer.parseInt(componentes[componentes.length - 2]);
						quantidadeDevs = Integer.parseInt(componentes[componentes.length - 1]);
					}
					arquivoLido=true;

				} catch (IOException | NumberFormatException ex) {
					ex.printStackTrace();
				}
			}

		}
		if (e.getSource() == painelBotões.getBotãoRelatório()) {
			dadosDAO.inserirDados(plano, planetas);
			dadosComputadosLabel();
		}

		if (e.getSource() == painelBotões.getBotãoLerDados()) {
			try {
				DadosRelatório dados = new DadosRelatório();
				dadosObtidos = dados.buscarOsDados();
				dadosLidosLabel();
			} catch (Exception e2) {
				
			}
		}

		if (e.getSource() == painelBotões.getBotãoGravar()) {
			try {
				DadosRelatório dados = new DadosRelatório();
				dados.enviarDados(dadosObtidos);
				dadosEnviadosLabel();
			} catch (Exception e2) {
				
			}
		}

	}

	private void dadosComputadosLabel() {
		JLabel sucesso = new JLabel();
		sucesso.setText("Sucesso, mestre 😎");
		sucesso.setForeground(Color.WHITE);
		sucesso.setFont(new Font("Franklin Gothic Heavy",Font.PLAIN,18));
		JOptionPane.showMessageDialog(null, sucesso, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	}

	private void dadosEnviadosLabel() {
		JLabel dadosEnviados = new JLabel();
		dadosEnviados.setText("Dados enviados, meu grande Messias!");
		dadosEnviados.setForeground(Color.WHITE);
		dadosEnviados.setFont(new Font("Franklin Gothic Heavy",Font.PLAIN,18));
		JOptionPane.showMessageDialog(null, dadosEnviados, "Dados enviados com extremo sucesso", JOptionPane.INFORMATION_MESSAGE);
	}

	private void dadosLidosLabel() {
		JLabel dadosLidos = new JLabel();
		dadosLidos.setText("Dados Computados, minha altarquia ");
		dadosLidos.setForeground(Color.WHITE);
		dadosLidos.setFont(new Font("Franklin Gothic Heavy",Font.PLAIN,18));
		JOptionPane.showMessageDialog(null, dadosLidos, "Dados perfeitamente lidos", JOptionPane.INFORMATION_MESSAGE);
	}

	public String getArquivo() {
		return arquivo;
	}

}
