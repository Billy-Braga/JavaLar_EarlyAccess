package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

import model.Bugs;
import model.Devs;
import model.Planeta;
import model.Plano;
import view.PainelBotões;
import view.PainelJavaLar;

public class ActionController implements ActionListener {

	private PainelBotões painelBotões;
	private Plano plano;
	private List<Planeta> planetas;
	private List<Planeta> falecidos;
	private int indexPlaneta = 0;
	private ArrayList<Bugs> listaBugs = new ArrayList<>();
	private ArrayList<Bugs> bugsRemovidos = new ArrayList<>();
	private ArrayList<Devs> devsRemovidos = new ArrayList<>();
	private PainelJavaLar painelJavaLar;
	private int quantidadeBugs = 0;
	private int quantidadeDevs = 0;
	private JavaLarDAO relatório;
	private String arquivo;

	public ActionController(List<Planeta> planetas, PainelJavaLar painelJavaLar, PainelBotões painelBotões) {
		this.plano = new Plano();
		this.painelBotões = painelBotões;
		this.planetas = planetas;
		this.painelJavaLar = painelJavaLar;
		relatório = new JavaLarDAO(plano, planetas, painelJavaLar, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ArrayList<Bugs> bugsRemovidos = new ArrayList<>();
		ArrayList<Devs> devsRemovidos = new ArrayList<>();
		List<Planeta> falecidos = new ArrayList<>();

		if (e.getSource() == painelBotões.getBotãoInstante()) {
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

				} catch (IOException | NumberFormatException ex) {
					ex.printStackTrace();
				}
			}

		}
		if (e.getSource() == painelBotões.getBotãoRelatório()) {
			relatório.inserirDados(plano, planetas);
		}

		if (e.getSource() == painelBotões.getBotãoLerDados()) {
			relatório.analisarDados();
		}

		if (e.getSource() == painelBotões.getBotãoGravar()) {
			relatório.gravarSaída();
		}

	}

	public String getArquivo() {
		return arquivo;
	}

}
