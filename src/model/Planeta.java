package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import view.PainelJavaLar;

public abstract class Planeta {
	protected String nome;
	protected int x;
	protected int y;
	protected double rotação;
	protected int movimento;
	protected int anoJavaLar;
	protected int anoPorRodada;
	protected double tempoDesdeUltimoInstante = 0;
	protected double tempoRodado;
	protected int unidadesPercorridas;
	protected int totalInstantes;
	private int bugsColididos;
	private int devsColididos;
	protected int instantes;
	private ImageIcon imageIcon;
	private PainelJavaLar painelJavaLar;
	private Plano plano;
	private int movimentomax;
	private ImageIcon imagem;

	public Planeta(String nome, int x, int y, int movimento, double rotação, String caminhoImagem) {
		this.nome = nome;
		this.x = x;
		this.y = y;
		this.imagem = new ImageIcon(getClass().getResource(caminhoImagem));
		this.rotação = rotação;
		this.movimento = movimento;
		this.anoJavaLar = 0;
		this.anoPorRodada = 0;
		this.tempoRodado = 0;
		this.instantes = 0;
		this.painelJavaLar = painelJavaLar;
		this.plano = plano;
		bugsColididos = 0;
		devsColididos = 0;
	}

	public static List<Planeta> criarPlanetas() {
		List<Planeta> planetas = new ArrayList<>();
		planetas.add(new Java("Java", 8, 8, 1, 0, "/icons/java.png"));
		planetas.add(new Python("Python", 8, 7, 4, 24, "/icons/python.png"));
		planetas.add(new JavaScript("JavaScript", 8, 6, 3, 10, "/icons/javascript.png"));
		planetas.add(new RubyonRails("RubyOnRails", 8, 5, 2, 48, "/icons/ruby.png"));
		planetas.add(new PHP("PHP", 8, 4, 2, 60, "/icons/php.png"));
		planetas.add(new Csharp("Csharp", 8, 3, 1, 4, "/icons/csharp.png"));
		planetas.add(new Cplusplus("Cplusplus", 8, 2, 2, 0.5, "/icons/Cplusplus.png"));
		planetas.add(new C("C", 8, 1, 10, 0.1, "/icons/C.png"));
		return planetas;
	}

	public String getNome() {
		return nome;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getInstantes() {
		return instantes;
	}

	public void setInstantes(int instantes) {
		this.instantes = instantes;
	}

	public void zerarAnoPorRodada() {
		anoPorRodada = 0;
	}

	public int getAnoPorRodada() {
		return anoPorRodada;
	}

	public double getRotação() {
		return rotação;
	}

	public int getMovimento() {
		return movimento;
	}

	public void setMovimento(int movimento) {
		this.movimento = movimento;
	}

	public int getAnos() {
		return anoJavaLar;
	}

	public void setAnos(int anoJavaLar) {
		this.anoJavaLar = anoJavaLar;
	}

	public ImageIcon getImagem() {
		return imagem;
	}

	public double getTempoDesdeUltimoInstante() {
		return tempoDesdeUltimoInstante;
	}

	public void setTempoDesdeUltimoInstante(double tempoDesdeUltimoInstante) {
		this.tempoDesdeUltimoInstante = tempoDesdeUltimoInstante;
	}

	public void zerarTempoDesdeUltimoInstante() {
		this.tempoDesdeUltimoInstante = 0;
	}

	public double getTempoRodado() {
		return tempoRodado;
	}

	public void setTempoRodado(int tempoRodado) {
		this.tempoRodado = tempoRodado;
	}

	public int getBugsColididos() {
		return bugsColididos;
	}

	public void aumentarBugs() {
		bugsColididos++;
	}

	public int getDevsColididos() {
		return devsColididos;
	}

	public void aumentarDevs() {
		devsColididos++;
	}

	public void aumentarMovimento() {
		this.movimento++;
	}

	public void diminuirMovimento() {
		this.movimento--;
	}

	public void aumentarAnoPorRodada() {
		this.anoPorRodada++;

	}

	public void aumentarAnosTotais() {
		this.anoJavaLar++;
	}

	public abstract void mover();

	public abstract void rotacionar();

	protected boolean passouPelaCoordenada(int CoordX, int CoordY) {
		if (x == CoordX && y == CoordY) {
			return true;
		} else {
			return false;
		}
	}

}
