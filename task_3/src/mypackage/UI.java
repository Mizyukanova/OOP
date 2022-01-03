package mypackage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.Vector;

public class UI {

	public static void main(String[] args) {
		
		// Создание массива операций
		IOperation[] operations = {
				new Div(), new Mod(),
				new Lcm(), new Gcd()
		};
		
		// Создание основного окна ввода
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		// Создание окна ошибок
		JFrame errorFrame = new JFrame("Ошибка");
		errorFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
		errorFrame.setSize(300, 100);
		errorFrame.setLocation(600, 300);
		errorFrame.add(new JLabel("Проверьте корректность введенных данных!"));
		
		// Создание текстовых полей
		final JTextField firstOperand = new JTextField(""); // операнд 1
		firstOperand.setPreferredSize(new Dimension(150, 25));
		final JTextField secondOperand = new JTextField(""); // операнд 2
		secondOperand.setPreferredSize(new Dimension(150, 25));
		
		final JLabel result = new JLabel(); // результат операции
		
		// Создание массива наименований операций для выпадающего списка
		Vector<String> operationNames = new Vector<String>();
		for (IOperation op : operations) {
			operationNames.add(op.getName());
		}
				
		// Создание выпадающего списка
		final JComboBox<String> termComboBox = new JComboBox<String>(operationNames);
		
		// Создание кнопки
		JButton button = new JButton(" = ");
		button.setPreferredSize(new Dimension(150, 25));
				
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					errorFrame.setVisible(false);
					int firstOperandValue = Integer.parseInt(firstOperand.getText());
					int secondOperandValue = Integer.parseInt(secondOperand.getText());
					int resultValue = 0;
			
					int index = termComboBox.getSelectedIndex();
					IOperation selectedOperation = operations[index];
			
					resultValue = selectedOperation.estimate(firstOperandValue, secondOperandValue);
					result.setText(String.format("%d", resultValue));
				} catch (Exception er) {
					errorFrame.setVisible(true);
				}
			}
		});

		frame.add(new JLabel("Операнд 1"));
	    frame.add(firstOperand);
		frame.add(termComboBox);
        frame.add(new JLabel("Операнд 2"));
		frame.add(secondOperand);
		frame.add(button);
		frame.add(result);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 100);
		frame.setLocation(200, 300);
		frame.setTitle("Целочисленные бинарные операции");
		frame.setVisible(true);
	}

}
