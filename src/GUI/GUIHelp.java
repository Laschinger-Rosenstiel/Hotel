package GUI;

import java.awt.Font;

import javax.swing.JTextField;

public class GUIHelp {
	//Y-Koordinaten
	int y_line1 = 40;
	int y_line2 =80;
	int y_line3 =120;
	int y_line4 = 160;
	int y_line5 = 200;
	int y_line6 = 240;
	int y_line7 = 280;
	int y_line8 = 320;
	int y_line9 = 360;
	int y_line10 = 400;
	int y_line11 = 440;
	int y_line12 = 480;
	int y_line13 = 520;
	int y_line14 = 560;
	//X-Koordinaten
	int x_column1 = 10;
	int x_column2 = 40;
	int x_column3 = 150;
	int x_column4 = 300;
	int x_column5= 450;
	//Standardgr��en
	int x_width = 150;
	int y_height = 20;

public JTextField setTfForm (JTextField tf){
	Font fontTf=new Font(tf.getFont().getName(),Font.BOLD,tf.getFont().getSize());
	tf.setEditable(false);
	tf.setBorder(null);
	tf.setFont(fontTf);
	return tf;
}
}