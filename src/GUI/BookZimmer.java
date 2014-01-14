package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import Control.BHBook;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class BookZimmer extends GUIHelp{
	
	BHBook ButtonHandler = new BHBook(this);
	
	//Startpanel
	private JPanel contentpane1;
	private JButton jb1, jb2, jb3;
	public JTextField jtfVorname, jtfName, jtfGeb; 
	private JLabel labeltable1, labeltable2, labeljtfVorname, labeljtfName, labeljtfGeb; 
	public JDateChooser geb;
	
	//card Layout
	public CardLayout cardLayout;
	public JPanel card = new JPanel();
	
	//Frame
	public JFrame jf;
	private JPanel contentpane2;
	public JTextField jtfVorname2, jtfName2, jtfGeb2, jtfStr2, jtfHn2, jtfPlz2, jtfOrt2, jtfLand2, jtfTel2_1, jtfTel2_2, jtfTel2_3;
	private JLabel labeltable3, labeljtfVorname2, labeljtfName2, labeljtfGeb2, labeljtfStr2, labeljtfPlz2, labeljtfOrt2, labeljtfLand2, labeljtfTel2;
	private JButton weiter;
	public JDateChooser geb2;
	Date now = new Date();
	Calendar calendar = new GregorianCalendar();
	
	//Frame 2nd Card
	public JPanel contentpane3 = null;
	public JLabel labeltable4, labeltable5, labeltable6, labeljtfVon, labeljtfBis;
	private JTextField labelVor3, labelName3, labelStr3, labelPlz3, labelOrt3, labelLand3;

	public JTextField labelTel3;

	private JTextField labelGeb3;
	public JTextField labelVor3_2, labelName3_2, labelStr3_2, labelPlz3_2, labelOrt3_2, labelLand3_2, labelTel3_2, labelGeb3_2;
	private JButton checkAvailability, bookZimmer, back;
	public JDateChooser pickerVon, pickerBis;
	
	
	public BookZimmer() {
	
	}
	
	public JPanel launchStartPanel() {
		//Objekte erzeugen
		contentpane1 = new JPanel();
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
		jb2.setActionCommand("ExistBooking");
		jb2.addActionListener(new BHBook(this));
		
		jb3 = new JButton("Suche");
		jb3.setActionCommand("SEARCH");
		jb3.addActionListener(new BHBook(this));
		
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
		
		jb2.setBounds(x_column1, y_line12, x_width, y_height);
		contentpane1.add(jb2);
		jb3.setBounds(x_column1, y_line6, x_width, y_height);
		contentpane1.add(jb3);
		
		//Color
		contentpane1.setOpaque(true);
		contentpane1.setBackground(new Color(209,218,248));
	
		return contentpane1;
	}

	public void launchJFrame() {
			
		jf = new JFrame("Zimmerbuchung");		
		contentpane2 = new JPanel();
		contentpane2.setLayout(null);
		
		JPanel contentPane = (JPanel)jf.getContentPane();
		card.setLayout(cardLayout = new CardLayout());
		
		if (contentpane3 != null) {
		contentpane3.setVisible(false);
		}
		
		labeltable3 = new JLabel("Neuen Gast anlegen: ");
		labeljtfVorname2 = new JLabel("Vorname: ", JLabel.LEFT);
		labeljtfName2 = new JLabel("Name: ", JLabel.LEFT);
		labeljtfGeb2 = new JLabel("Geburtsdatum: ", JLabel.LEFT);
		labeljtfStr2 = new JLabel("Straße & Hausnummer: ", JLabel.LEFT);
		labeljtfPlz2 = new JLabel("Postleitzahl: ", JLabel.LEFT);
		labeljtfOrt2 = new JLabel("Ort: ", JLabel.LEFT);
		labeljtfLand2 = new JLabel("Land: ", JLabel.LEFT);
		labeljtfTel2 = new JLabel("Telefonnummer: ", JLabel.LEFT);
		
		jtfVorname2 = new JTextField(20);
		jtfName2 = new JTextField(30);
		geb2 = new JDateChooser();
		jtfStr2 = new JTextField(30);
		jtfHn2 = new JTextField(8);
		jtfPlz2 = new JTextField(10);
		jtfOrt2 = new JTextField(10);
		jtfLand2 = new JTextField(10);
		jtfTel2_1 = new JTextField(6);
		jtfTel2_1.setText("+49");
		jtfTel2_2 = new JTextField(8);
		jtfTel2_3 = new JTextField(12);
		
		weiter = new JButton("Weiter...");
		
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
		labeljtfLand2.setBounds(x_column1, y_line8, x_width, y_height);
		contentpane2.add(labeljtfLand2);
		labeljtfTel2.setBounds(x_column1, y_line9, x_width, y_height);
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
		jtfLand2.setBounds(x_column3, y_line8, x_width, y_height);
		jtfLand2.setText("Deutschland");
		contentpane2.add(jtfLand2);
		jtfTel2_1.setBounds(x_column3, y_line9, 30, y_height);
		contentpane2.add(jtfTel2_1);
		jtfTel2_2.setBounds(180, y_line9, 50, y_height);
		contentpane2.add(jtfTel2_2);
		jtfTel2_3.setBounds(230, y_line9, 90, y_height);
		contentpane2.add(jtfTel2_3);
		
		weiter.setBounds(x_column1, y_line10, x_width, y_height);
		weiter.setActionCommand("NEXT");
		weiter.addActionListener(new BHBook(this));
		contentpane2.add(weiter);
		//Color
		contentpane2.setOpaque(true);
		contentpane2.setBackground(new Color(209,218,248));
		
		card.add("Card1", contentpane2);
		contentPane.add(card);
		
		jf.setVisible(true);
		jf.setResizable(true);
		jf.setSize(600,500);
		jf.setLocation(300,50);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
			
	}

	public JPanel launchSecond() {
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
		labelLand3 = new JTextField("Land: ");
		setTfForm(labelLand3);
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
		labelLand3_2 = new JTextField();
		setTfForm(labelLand3_2);
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
		labelLand3.setBounds(x_column4, y_line3, 100, y_height);
		contentpane3.add(labelLand3);
		labelGeb3.setBounds(x_column4, y_line4, 100, y_height);
		contentpane3.add(labelGeb3);
		labelTel3.setBounds(x_column4, y_line5, 100, y_height);
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
		labelLand3_2.setBounds(x_column5, y_line3, x_width, y_height);
		contentpane3.add(labelLand3_2);
		labelTel3_2.setBounds(x_column5, y_line4, x_width, y_height);
		contentpane3.add(labelTel3_2);
		labelGeb3_2.setBounds(x_column5, y_line5, x_width, y_height);
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
		bookZimmer.addActionListener(new BHBook(this));
		contentpane3.add(bookZimmer);
		
		back = new JButton("Zurück");
		back.setBounds(x_column1, y_line10, x_width, y_height);
		back.setActionCommand("BACK");
		back.addActionListener(new BHBook(this));
		contentpane3.add(back);
		//Color
		contentpane3.setOpaque(true);
		contentpane3.setBackground(new Color(209,218,248));
		
		return contentpane3;
	}
	
	
}
