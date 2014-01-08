package GUI;

import javax.swing.*;

import Control.BHBookZimmer;

import java.awt.*;
import java.awt.event.*;

public class CLTest implements ActionListener{
	
	public static CardLayout cardLayout;
	public static JPanel card = new JPanel();
	static JButton weiter = new JButton("Weiter...");
	static JButton abbrechen = new JButton("Abbrechen");
	static JButton back = new JButton("Zurück");
	public JFrame jf2;
	static JPanel contentpane2;
	static JTextField jtfVorname2, jtfName2, jtfGeb2, jtfStr2, jtfHn2, jtfPlz2, jtfOrt2, jtfTel2;
	static JLabel labeltable3, labeljtfVorname2, labeljtfName2, labeljtfGeb2, labeljtfStr2,labeljtfHn2, labeljtfPlz2, labeljtfOrt2, labeljtfTel2;
	//static JButton jb4;
	
	static int y_north = 20; 
	static int y_center=80;
	static int y_center2=120;
	static int y_south = 160;
	static int y_south2 = 200;
	static int y_south3 = 240;
	static int y_south4 = 280;
	static int y_south5 = 320;
	static int y_south6 = 360;
	
	static int x_left = 10;
	static int x_center = 150;
	static int x_center2 = 300;
	static int x_right = 300;
	static int x_width = 150;
	static int y_height = 20;
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("NEXT")) {
			cardLayout.show(card, "Card N");
		}
	}
	
	public static void main(String[] args) {
		BookZimmer abc = new BookZimmer();
		
	}

}
