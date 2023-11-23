//package control;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import model.Bugs;
//import model.Célula;
//import model.Devs;
//import model.Planeta;
//import model.Plano;
//
//public class Controlador {
//
//	public ArrayList<Célula> listaCélulas;
//	public Plano plano;
//	public List<Planeta> planetas = new ArrayList<>();
//	public List<Bugs> listaBugs = new ArrayList<>();
//	public List<Bugs> bugsRemovidos = new ArrayList<>();
//	public List<Devs> listaDevs = new ArrayList<>();
//
//	public Controlador(Plano plano) {
//
//		this.plano = plano;
//	}
//
//	public void verificarColisãoBugs() {
//
//		for (Planeta planeta : planetas) {
//			for (Bugs bug : listaBugs) {
//				if (planeta.getX() == bug.getPosicaoX() && planeta.getY() == bug.getPosicaoY()) {
//					planeta.diminuirMovimento();
//					planeta.aumentarBugs();
//					listaBugs.remove(bug);
//					System.out.println("O planeta " + planeta.getNome() + " encontrou um bug na posição ("
//							+ planeta.getX() + "," + planeta.getY() + ")!");
//					for(Célula célula : listaCélulas) {
//						if(célula.bugs ==bug) {
//							célula.bugs = null;
//							célula.label.setIcon(null);
//						}
//					}
//				}
//			}
//		}
//	}
//}
