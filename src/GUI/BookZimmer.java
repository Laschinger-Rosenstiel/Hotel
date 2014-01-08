package GUI;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import Control.BHBookZimmer;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class BookZimmer extends Coordinates{
	
	BHBookZimmer ButtonHandler = new BHBookZimmer(this);
	
	//first Frame
	public JFrame jf1;
	private JPanel contentpane1;
	private JButton jb1, jb2, jb3;
	public JTextField jtfVorname, jtfName, jtfGeb; 
	private JLabel labeltable1, labeltable2, labeljtfVorname, labeljtfName, labeljtfGeb; 
	public JDateChooser geb;
	
	//card Layout
	public CardLayout cardLayout;
	public JPanel card = new JPanel();
	
	//second Frame
	public JFrame jf2;
	private JPanel contentpane2;
	public JTextField jtfVorname2, jtfName2, jtfGeb2, jtfStr2, jtfHn2, jtfPlz2, jtfOrt2, jtfTel2_1, jtfTel2_2, jtfTel2_3;
	private JLabel labeltable3, labeljtfVorname2, labeljtfName2, labeljtfGeb2, labeljtfStr2, labeljtfPlz2, labeljtfOrt2, labeljtfTel2;
	private JButton weiter;
	public JDateChooser geb2;
	Date now = new Date();
	Calendar calendar = new GregorianCalendar();
	
	//third Frame
	public JFrame jf3;
	public JPanel contentpane3 = null;
	public JLabel labeltable4, labeltable5, labeltable6, labeljtfVon, labeljtfBis;
	private JTextField labelVor3, labelName3, labelStr3, labelPlz3, labelOrt3;

	public JTextField labelTel3;

	private JTextField labelGeb3;
	public JTextField labelVor3_2, labelName3_2, labelStr3_2, labelPlz3_2, labelOrt3_2, labelTel3_2, labelGeb3_2;
	private JButton checkAvailability, bookZimmer, back;
	public JDateChooser pickerVon, pickerBis;
	
	
	public BookZimmer() {
	
	}
	
	public JPanel launchFirstJFrame() {
		//Objekte erzeugen
		//jf1 = new JFrame ("GUI 1 ButtonHandler");
		contentpane1 = new JPanel();
	//	jf1.setContentPane(contentpane1);
		contentpane1.setLayout(null);

		jtfVorname = new JTextField(20);
		jtfName = new JTextField(30);
		geb = new JDateChooser();
		labeltable1 = new JLabel("Gastsuche: ");
		labeltable2 = new JLabel("Suchergebnisse: ");
		labeljtfVorname = new JLabel("Vorname: ", JLabel.LEFT);
		labeljtfName = new JLabel("Name: ", JLabel.LEFT);
		labeljtfGeb = new JLabel("Geburtsdatum: ", JLabel.LEFT);
		
		
		jb1 = new JButton("Neuer Gast...");
		jb1.setActionCommand("NewBooking");
		jb1.addActionListener(ButtonHandler);
		
		jb2 = new JButton("Auf ausgewählten Gast buchen");
		jb2.setActionCommand("ExistingBooking");
		
		jb3 = new JButton("Suche");
		jb3.setActionCommand("SEARCH");
		jb3.addActionListener(new BHBookZimmer(this));
		
		//Bounds setzen und zur Contentpane hinzufügen
		labeltable1.setBounds(x_column1, y_line2, x_width, y_height);
		contentpane1.add(labeltable1);
		jb1.setBounds(x_column1, y_line1, x_width, y_height);
		contentpane1.add(jb1);
		labeljtfVorname.setBounds(x_column1, y_line3, x_width, y_height);
		contentpane1.add(labeljtfVorname);
		labeljtfName.setBounds(x_column1, y_line4, x_width, y_height);
		contentpane1.add(labeljtfName);
		labeljtfGeb.setBounds(x_column1, y_line5, x_width, y_height);
		contentpane1.add(labeljtfGeb);
		labeltable2.setBounds(x_column1, y_line7, x_width, y_height);
		contentpane1.add(labeltable2);
		
		jtfVorname.setBounds(x_column3, y_line3, x_width, y_height);
		contentpane1.add(jtfVorname);
		jtfName.setBounds(x_column3, y_line4, x_width, y_height);
		contentpane1.add(jtfName);
		geb.setBounds(x_column3, y_line5, x_width, y_height);
		contentpane1.add(geb);
		
		jb3.setBounds(x_column1, y_line6, x_width, y_height);
		contentpane1.add(jb3);
		/*jf1.setLocation(100,100);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setVisible(true);
		jf1.setExtendedState(jf1.getExtendedState() | jf1.MAXIMIZED_BOTH);*/
		return contentpane1;
	}

	public void launchSecondJFrame() {
			
		jf2 = new JFrame("GUI 2 ButtonHandler");
		
		JPanel contentPane = (JPanel)jf2.getContentPane();
		card.setLayout(cardLayout = new CardLayout());
		contentpane3 = new JPanel();
		contentpane3.setVisible(false);		
		contentpane2 = new JPanel();
		contentpane2.setLayout(null);
		
		labeltable3 = new JLabel("Neuen Gast anlegen: ");
		labeljtfVorname2 = new JLabel("Vorname: ", JLabel.LEFT);
		labeljtfName2 = new JLabel("Name: ", JLabel.LEFT);
		labeljtfGeb2 = new JLabel("Geburtsdatum: ", JLabel.LEFT);
		labeljtfStr2 = new JLabel("Straße & Hausnummer: ", JLabel.LEFT);
		labeljtfPlz2 = new JLabel("Postleitzahl: ", JLabel.LEFT);
		labeljtfOrt2 = new JLabel("Ort: ", JLabel.LEFT);
		labeljtfTel2 = new JLabel("Telefonnummer: ", JLabel.LEFT);
		
		jtfVorname2 = new JTextField(20);
		jtfName2 = new JTextField(30);
		geb2 = new JDateChooser();
		jtfStr2 = new JTextField(30);
		jtfHn2 = new JTextField(8);
		jtfPlz2 = new JTextField(10);
		jtfOrt2 = new JTextField(10);
		jtfTel2_1 = new JTextField(6);
		jtfTel2_1.setText("+49");
		jtfTel2_2 = new JTextField(8);
		jtfTel2_3 = new JTextField(12);
		
		//Bounds setzen und zur Contentpane hinzufügen		
		labeltable3.setBounds(x_column1, y_line1, x_width, y_height);
		contentpane2.add(labeltable3);
		labeljtfVorname2.setBounds(x_column1, y_line2, x_width, y_height);
		contentpane2.add(labeljtfVorname2);
		labeljtfName2.setBounds(x_column1, y_line3, x_width, y_height);
		contentpane2.add(labeljtfName2);
		labeljtfGeb2.setBounds(x_column1, y_line4, x_width, y_height);
		contentpane2.add(labeljtfGeb2);
		labeljtfStr2.setBounds(x_column1, y_line5, x_width, y_height);
		contentpane2.add(labeljtfStr2);
		labeljtfPlz2.setBounds(x_column1, y_line6, x_width, y_height);
		contentpane2.add(labeljtfPlz2);
		labeljtfOrt2.setBounds(x_column1, y_line7, x_width, y_height);
		contentpane2.add(labeljtfOrt2);
		labeljtfTel2.setBounds(x_column1, y_line8, x_width, y_height);
		contentpane2.add(labeljtfTel2);
		
		jtfVorname2.setBounds(x_column3, y_line2, x_width, y_height);
		contentpane2.add(jtfVorname2);
		jtfName2.setBounds(x_column3, y_line3, x_width, y_height);
		contentpane2.add(jtfName2);
		
		calendar.setTime(now);
		calendar.add(Calendar.YEAR, -120);
		Date past = calendar.getTime();
		geb2.setSelectableDateRange(past, now);
		geb2.setBounds(x_column3, y_line4, x_width, y_height);
		contentpane2.add(geb2);
		
		jtfStr2.setBounds(x_column3, y_line5, x_width, y_height);
		contentpane2.add(jtfStr2);
		jtfHn2.setBounds(x_column4, y_line5, 40, y_height);
		contentpane2.add(jtfHn2);
		jtfPlz2.setBounds(x_column3, y_line6, x_width, y_height);
		contentpane2.add(jtfPlz2);
		jtfOrt2.setBounds(x_column3, y_line7, x_width, y_height);
		contentpane2.add(jtfOrt2);
		jtfTel2_1.setBounds(x_column3, y_line8, 30, y_height);
		contentpane2.add(jtfTel2_1);
		jtfTel2_2.setBounds(180, y_line8, 50, y_height);
		contentpane2.add(jtfTel2_2);
		jtfTel2_3.setBounds(230, y_line8, 90, y_height);
		contentpane2.add(jtfTel2_3);
		
		weiter = new JButton("Weiter...");
		weiter.setBounds(x_column1, y_line9, x_width, y_height);
		weiter.setActionCommand("NEXT");
		weiter.addActionListener(new BHBookZimmer(this));
		contentpane2.add(weiter);
		
		card.add("Card1", contentpane2);
		//JPanel contentpane3 = launchThirdJFrame();
		//card.add("Card2", contentpane3);
		contentPane.add(card);
		
		jf2.setVisible(true);
		jf2.setResizable(true);
		jf2.setSize(500,500);
		jf2.setLocation(100,100);
		jf2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public JPanel launchThirdJFrame() {
		//Objekte erzeugen
		contentpane2.setVisible(false);
		contentpane3 = new JPanel();
		contentpane3.setLayout(null);
					
		labelVor3 = new JTextField("Vorname: ");
		setTfForm(labelVor3);
		labelName3 = new JTextField("Nachname: ");
		setTfForm(labelName3);
		labelStr3 = new JTextField("Straße: ");
		setTfForm(labelStr3);
		labelPlz3 = new JTextField("Postleitzahl: ");
		setTfForm(labelPlz3);
		labelOrt3 = new JTextField("Ort: ");
		setTfForm(labelOrt3);
		labelTel3 = new JTextField("Telefon: ");
		setTfForm(labelTel3);
		labelGeb3 = new JTextField("Geburtsdatum: ");
		setTfForm(labelGeb3);
		
		labelVor3_2 = new JTextField();
		setTfForm(labelVor3_2);
		labelName3_2 = new JTextField();
		setTfForm(labelName3_2);
		labelStr3_2 = new JTextField();
		setTfForm(labelStr3_2);
		labelPlz3_2 = new JTextField();
		setTfForm(labelPlz3_2);
		labelOrt3_2 = new JTextField();
		setTfForm(labelOrt3_2);
		labelTel3_2 = new JTextField();
		setTfForm(labelTel3_2);
		labelGeb3_2 = new JTextField();
		setTfForm(labelGeb3_2);
		
		labeltable4 = new JLabel("Gaststammdaten:");
		labeltable5 = new JLabel("Datum auswählen:");
		labeltable6 = new JLabel("Zimmer auswählen:");
		labeljtfVon = new JLabel("Von:");
		labeljtfBis = new JLabel("Bis:");
		
		pickerVon = new JDateChooser();
		pickerBis = new JDateChooser();
		
		
		
		//Bounds setzen und zur Contentpane hinzufügen
		labeltable4.setBounds(x_column1, y_line1, x_width, y_height);
		contentpane3.add(labeltable4);
		
		labelVor3.setBounds(x_column1, y_line2, 100, y_height);
		contentpane3.add(labelVor3);
		labelName3.setBounds(x_column1, y_line3, 100, y_height);
		contentpane3.add(labelName3);
		labelStr3.setBounds(x_column1, y_line4, 100, y_height);
		contentpane3.add(labelStr3);
		labelPlz3.setBounds(x_column1, y_line5, 100, y_height);
		contentpane3.add(labelPlz3);
		labelOrt3.setBounds(x_column4, y_line2, 100, y_height);
		contentpane3.add(labelOrt3);
		labelGeb3.setBounds(x_column4, y_line3, 100, y_height);
		contentpane3.add(labelGeb3);
		labelTel3.setBounds(x_column4, y_line4, 100, y_height);
		contentpane3.add(labelTel3);
		
		labelVor3_2.setBounds(x_column3, y_line2, x_width, y_height);
		contentpane3.add(labelVor3_2);
		labelName3_2.setBounds(x_column3, y_line3, x_width, y_height);
		contentpane3.add(labelName3_2);
		labelStr3_2.setBounds(x_column3, y_line4, x_width, y_height);
		contentpane3.add(labelStr3_2);
		labelPlz3_2.setBounds(x_column3, y_line5, x_width, y_height);
		contentpane3.add(labelPlz3_2);
		labelOrt3_2.setBounds(x_column5, y_line2, x_width, y_height);
		contentpane3.add(labelOrt3_2);
		labelTel3_2.setBounds(x_column5, y_line4, x_width, y_height);
		contentpane3.add(labelTel3_2);
		labelGeb3_2.setBounds(x_column5, y_line3, x_width, y_height);
		contentpane3.add(labelGeb3_2);
		
		labeltable5.setBounds(x_column1, y_line6, x_width, y_height);
		contentpane3.add(labeltable5);
		
		labeltable6.setBounds(x_column4, y_line6, x_width, y_height);
		contentpane3.add(labeltable6);
		
		labeljtfVon.setBounds(x_column1, y_line7, 40, y_height);
		contentpane3.add(labeljtfVon);	
		
		labeljtfBis.setBounds(x_column1, y_line8, 40, y_height);
		contentpane3.add(labeljtfBis);
		

		
		pickerVon.setSelectableDateRange(new Date(), null);
		pickerVon.setBounds(x_column2, y_line7, 100, y_height);
		contentpane3.add(pickerVon);
		pickerBis.setSelectableDateRange(new Date(), null);
		pickerBis.setBounds(x_column2, y_line8, 100, y_height);
		contentpane3.add(pickerBis);
		
		checkAvailability = new JButton("Verügbare Zimmer anzeigen...");
		checkAvailability.setBounds(x_column1, y_line9, x_width, y_height);
		contentpane3.add(checkAvailability);
		
		bookZimmer = new JButton("Zimmer buchen");
		bookZimmer.setBounds(x_column4, y_line10, x_width, y_height);
		bookZimmer.setActionCommand("BOOK?");
		bookZimmer.addActionListener(new BHBookZimmer(this));
		contentpane3.add(bookZimmer);
		
		back = new JButton("Zurück");
		back.setBounds(x_column1, y_line10, x_width, y_height);
		back.setActionCommand("BACK");
		back.addActionListener(new BHBookZimmer(this));
		contentpane3.add(back);
		
		return contentpane3;
	}
	
	/*public static void main (String[] args) {
		BookZimmer guiBZ = new BookZimmer();
		guiBZ.launchFirstJFrame();
	}*/
	
	private JTextField setTfForm (JTextField tf){
		Font fontTf=new Font(tf.getFont().getName(),Font.BOLD,tf.getFont().getSize());
		tf.setEditable(false);
		tf.setBorder(null);
		tf.setFont(fontTf);
		return tf;
	}
}
