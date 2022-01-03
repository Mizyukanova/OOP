package mypackage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class Main {

	public static void main(String[] args) {
		
		// Создание основного окна ввода
		JFrame frame = new JFrame("Registration");
		frame.setSize(800, 150);
		frame.setLocation(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
			
		// Создание флажка
		final JCheckBox tempCheckBox = new JCheckBox("No use personal data");
		
		// Создание контейнера
		JPanel panel = new JPanel();
		
		// Создание текстовых полей
		final JTextField name = new JTextField("name"); 
		name.setPreferredSize(new Dimension(150, 25));
		final JTextField surname = new JTextField("surname"); 
		surname.setPreferredSize(new Dimension(150, 25));
		final JTextField greeting = new JTextField("Welсome, " + name.getText() +" " + surname.getText() + "!" ); 
		greeting.setPreferredSize(new Dimension(250, 25));
		JTextArea tempTextArea = new JTextArea();
		tempTextArea.setPreferredSize(new Dimension(200, 25));
		tempTextArea.setText("Visit cost:");
		tempTextArea.setEditable(false);
		
		// Создание группы
		ButtonGroup group = new ButtonGroup();
		JRadioButton email = new JRadioButton("Email");
		JRadioButton phone = new JRadioButton("Phone number");
		
		// Создание выпадающего списка
		final JComboBox<String> tempComboBox = new JComboBox<String>(EntryPassInformation.PASS);
		
		// Слушатели
		CheckBoxListener checkListener = new CheckBoxListener();
		ComboBoxListener comboListener = new ComboBoxListener(tempComboBox, tempTextArea);
		
		checkListener.components.add(name);
		checkListener.components.add(surname);
		checkListener.components.add(email);
		checkListener.components.add(phone);
		checkListener.components.add(greeting);
		tempCheckBox.addActionListener(checkListener);
		tempComboBox.addActionListener(comboListener);
		
		name.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent arg0) {
				
				greeting.setText("Welсome, " + name.getText() +" " + surname.getText() + "!");
			}
		});
		
		surname.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent arg0) {
				
				greeting.setText("Welсome, " + name.getText() +" " + surname.getText() + "!");
			}
		});
		
		frame.add(tempCheckBox);
		group.add(email);
		group.add(phone);
		frame.add(panel);
		panel.add(name);
		panel.add(surname);
		panel.add(email);
		panel.add(phone);
		frame.add(greeting);
		frame.add(tempComboBox);
		frame.add(tempTextArea);

		frame.setVisible(true);
	}

}
