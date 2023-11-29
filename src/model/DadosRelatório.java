package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import control.ActionController;
import control.EscreverDados;
import control.JavaLarDAO;
import view.PainelJavaLar;

public class DadosRelatório {
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome_arquivo() {
		return nome_arquivo;
	}

	public void setNome_arquivo(String nome_arquivo) {
		this.nome_arquivo = nome_arquivo;
	}

	private String nome;
	private int matricula;
	private String nome_arquivo;
	public List<Planeta> planetas;
	private JavaLarDAO javaLarDAO;
	public PainelJavaLar painelJavaLar;
	public ActionController actionController;
	public Plano plano;
	public String[] infos;

	public DadosRelatório(String nome, int matricula, String nome_arquivo, String infos[]) {
		javaLarDAO = new JavaLarDAO(plano, planetas, painelJavaLar, actionController);
		this.nome = nome;
		this.matricula = matricula;
		this.nome_arquivo = nome_arquivo;
		this.infos = infos;
	}

	public DadosRelatório() {
		javaLarDAO = new JavaLarDAO(plano, planetas, painelJavaLar, actionController);
	}

	public ArrayList<DadosRelatório> buscarOsDados() {
		ArrayList<DadosRelatório> listaDados = javaLarDAO.selecionarDados();
		return listaDados;
	}

	public void enviarDados(ArrayList<DadosRelatório> listaDados) {
		EscreverDados e = new EscreverDados();

		ArrayList<String> nomes = new ArrayList<>();
		nomes.add(listaDados.get(0).getNome());
		String[] planetas = { "Python", "Javascript", "Ruby", "Php", "C#", "C++", "C" };
		String planetaAmaldiçoado = "";
		String nomeCampeãoDeVendas = "";
		int matrículaCampeã = 0;
		int horasTotais = 0;
		int anosTotais = 0;
		int indiceMaiorValor = 0;
		int[] bugsTotais = new int[4];
		int[] devsTotais = new int[4];
		int[] velocidadeMediaPlanetas = new int[7];
		int[] contExplosao = new int[7];// explosoes que ocorreram em cada planeta

		for (DadosRelatório dadosRelatório : listaDados) {

			for (int i = 0; i < 7; i++) {// 14 21 -> indice da velocidade dos planetas
				if (Integer.parseInt(dadosRelatório.infos[i + 14]) == 0) {
					contExplosao[i]++;
				}

				velocidadeMediaPlanetas[i] += Integer.parseInt(dadosRelatório.infos[i + 14]); // obter velocidade media
																								// de cada planeta

				horasTotais += Integer.parseInt(dadosRelatório.infos[i + 21]);// 10 - horas totais dos planetas
				anosTotais += Integer.parseInt(dadosRelatório.infos[i + 28]);// 11 - anos totais dos planetas
			}

			int maiorValor = Integer.parseInt(dadosRelatório.infos[14]);// valor inicial de vida

			for (int i = 14; i < 21; i++) {
				if (Integer.parseInt(dadosRelatório.infos[i]) > maiorValor) {// olhando qual planeta tem mais vida
					maiorValor = Integer.parseInt(dadosRelatório.infos[i]);
					indiceMaiorValor = i;
				}
			}

			for (int i = 35; i < 43; i++) {
				if (i < 39)
					bugsTotais[i - 35] += Integer.parseInt(dadosRelatório.infos[i]);

				else
					devsTotais[i - 39] += Integer.parseInt(dadosRelatório.infos[i]);
			}

		}
		planetaAmaldiçoado = planetas[encontrarMaiorValor(contExplosao)];
		int maxContagem = 0;
		for (String nomeUnico : nomes) {/// olhar nome mais frequente
			int contagem = contarRepetidos(nomeUnico, listaDados);

			if (contagem > maxContagem) {
				maxContagem = contagem;
				nomeCampeãoDeVendas = nomeUnico;
			}
		}
		for (DadosRelatório dadosRelatório : listaDados) {
			if (nomeCampeãoDeVendas.equals(dadosRelatório.getNome()) == true)
				matrículaCampeã = dadosRelatório.getMatricula();
		}

		String mediaDeVelocidades = "";
		for (int i = 0; i < 7; i++) {

			mediaDeVelocidades += planetas[i] + ": " + (velocidadeMediaPlanetas[i] / (double) listaDados.size()) + "\n";

		}

		e.escreverDados("C:/Users/enzov/Downloads/Dados/dadosFinais.txt",
				"1)Nome do campeão de vendas e sua matrícula : " + nomeCampeãoDeVendas + "|" + matrículaCampeã
						+ "\n2)Planeta que mais faleceu: " + planetaAmaldiçoado
						+ "\n3)Planeta que mais teve o dom da vida: " + planetas[indiceMaiorValor - 14]
						+ "\n4)Quadrante que os bugs mais se encontram: " + (encontrarMaiorValor(devsTotais) + 1)+ "° Quadrante" 
						+ "\n5)Quadrante que os devs mais se encontram: " + (encontrarMaiorValor(bugsTotais) + 1) + "° Quadrante"
						+ "\n6)Total de instantes analisados: " + listaDados.size()
						+ "\n7)Média de velocidade dos planetas: \n" + mediaDeVelocidades
						+ "8)Quantidade de Bugs fuleras: " + Arrays.stream(bugsTotais).sum()
						+ "\n9)Quantidade de Devs gente finas: " + Arrays.stream(devsTotais).sum()
						+ "\n10)Quantidade de horas totais: " + horasTotais + "\n11)Quantidade de anos totais: "
						+ anosTotais);
	}

	private static int contarRepetidos(String nome, ArrayList<DadosRelatório> listaDados) {
		int contagem = 0;
		for (DadosRelatório elemento : listaDados) {
			if (nome.equals(elemento.getNome())) {
				contagem++;
			}
		}
		return contagem;
	}

	private static int encontrarMaiorValor(int[] x) {
		int indiceMaiorValor = 0;
		int maiorValor = x[0];

		for (int i = 1; i < x.length; i++) {
			if (x[i] > maiorValor) {
				maiorValor = x[i];
				indiceMaiorValor = i;
			}
		}

		return indiceMaiorValor;
	}

}
