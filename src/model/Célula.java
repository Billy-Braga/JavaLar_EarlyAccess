package model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Célula {
	public int posiçãoX;
	public int posiçãoY;
	public ImageIcon icon;
	public JLabel label;

	public Célula(int x,int y, JLabel label){
		this.posiçãoX=x;
		this.posiçãoY=y;
		this.label=label;
	}

	public int getPosiçãoX() {
		return posiçãoX;
	}

	public int getPosiçãoY() {
		return posiçãoY;
	}

	
}
