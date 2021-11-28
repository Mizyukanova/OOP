package classes;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainClass {

	public static void main(String[] args) {
		// Создание окна
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		// Создание окна для ошибок
		JFrame errorFrame = new JFrame("Ошибка");
		errorFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
		errorFrame.setSize(300, 100);
		errorFrame.setLocation(600, 300);
		errorFrame.add(new JLabel("Проверьте корректность введенных данных!"));
		
		// Создание кнопки
		JButton button = new JButton("Рассчитать");
		button.setPreferredSize(new Dimension(150, 25));
		
		final JLabel profitField = new JLabel("0,00");
		
		// Создание текстовых полей
		final JTextField amountField = new JTextField(""); // сумма вклада
		amountField.setPreferredSize(new Dimension(150, 25));
		final JTextField percentageField = new JTextField(""); // процент по вкладу
		percentageField.setPreferredSize(new Dimension(75, 25));
		final JTextField countField = new JTextField(""); // срок по вкладу
		countField.setPreferredSize(new Dimension(75, 25));
		
		// Создание флажка
		final JCheckBox сompoundInterestCheckBox = new JCheckBox("Сложный процент");
		сompoundInterestCheckBox.requestFocusInWindow();
		
		// Создание выпадающего списка
		final JComboBox<String> termComboBox = new JComboBox<String>(new String[] {"месяцев", "лет"});
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					errorFrame.setVisible(false);
					float amount = Float.parseFloat(amountField.getText());
					float percentage = Float.parseFloat(percentageField.getText());
					float term = Float.parseFloat(countField.getText());
					float profit = 0;
				
					if (termComboBox.getSelectedItem().equals("месяцев")) {
						if (сompoundInterestCheckBox.isSelected()) {
							profit = ((float)Math.pow((1+percentage/(100*12)), term)-1)*amount;
						}
						else {
							profit = amount*percentage*(term*30)/(365*100);
						}
					}
					if (termComboBox.getSelectedItem().equals("лет")) {
						if (сompoundInterestCheckBox.isSelected()) {
							profit = ((float)Math.pow((1+percentage/(100*12)), (term*12))-1)*amount;
						}
						else {
							profit = amount*percentage*(term*12*30)/(365*100);
						}
					}	
					profitField.setText(String.format("%.2f", profit));
				} catch (Exception er) {
					errorFrame.setVisible(true);
				}
			}
		});

        frame.add(new JLabel("Сумма вклада"));
        frame.add(amountField);
        frame.add(new JLabel("руб."));
        frame.add(new JLabel("Процент"));
		frame.add(percentageField);
		frame.add(new JLabel("%"));
		frame.add(сompoundInterestCheckBox);
		frame.add(new JLabel("Срок"));
		frame.add(countField);
		frame.add(termComboBox);
		frame.add(button);
		frame.add(new JLabel("Доход:"));
		frame.add(profitField);
		frame.add(new JLabel("руб."));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 100);
		frame.setLocation(200, 300);
		frame.setTitle("Расчет дохода по вкладу");
		frame.setVisible(true);
		
	}
}
