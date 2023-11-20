package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class BotõesJavaLar extends JButton {

	public BotõesJavaLar(String string) {

		this.setFont(new Font("arial", Font.BOLD, 13));
		this.setBackground(new Color(26, 23, 23));

		this.setText(string);

		this.setForeground(Color.WHITE);
		this.setMinimumSize(new Dimension(200, 90));
		this.setPreferredSize(new Dimension(200, 90));
		this.setMaximumSize(new Dimension(240, 90));
		this.setVisible(true);
		this.setFocusable(false);
	}

}
