//package control;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//import model.Planeta;
//import model.Plano;
//import view.PainelBotões;
//import view.PainelJavaLar;
//
//
//public class ActionController implements ActionListener{
//	
//	private Plano plano;
//	private PainelBotões painelBotões;
//	private PainelJavaLar painelJavaLar;
//	private List<Planeta> planetas;
//	
//	
//	public ActionController(Plano plano, PainelBotões painelBotões) {
//		this.plano=plano;
//		this.painelBotões= painelBotões;
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource()== painelBotões.getBotãoInstante()) {
//			processarPróximoInstante();
//		}
//	}
//	
//	
//	private void processarPróximoInstante() {
//		for(Planeta planeta: planetas) {
//			int movimento = planeta.getMovimento();
//			planeta.mover( movimento);
//		}
//		 painelJavaLar.getPlano().atualizarPlano(planetas, painelJavaLar.getListaCélulas());
//		 painelJavaLar.revalidate();
//		 painelJavaLar.repaint();
//		}
//	}
//	

