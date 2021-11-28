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
		// �������� ����
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		// �������� ���� ��� ������
		JFrame errorFrame = new JFrame("������");
		errorFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
		errorFrame.setSize(300, 100);
		errorFrame.setLocation(600, 300);
		errorFrame.add(new JLabel("��������� ������������ ��������� ������!"));
		
		// �������� ������
		JButton button = new JButton("����������");
		button.setPreferredSize(new Dimension(150, 25));
		
		final JLabel profitField = new JLabel("0,00");
		
		// �������� ��������� �����
		final JTextField amountField = new JTextField(""); // ����� ������
		amountField.setPreferredSize(new Dimension(150, 25));
		final JTextField percentageField = new JTextField(""); // ������� �� ������
		percentageField.setPreferredSize(new Dimension(75, 25));
		final JTextField countField = new JTextField(""); // ���� �� ������
		countField.setPreferredSize(new Dimension(75, 25));
		
		// �������� ������
		final JCheckBox �ompoundInterestCheckBox = new JCheckBox("������� �������");
		�ompoundInterestCheckBox.requestFocusInWindow();
		
		// �������� ����������� ������
		final JComboBox<String> termComboBox = new JComboBox<String>(new String[] {"�������", "���"});
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					errorFrame.setVisible(false);
					float amount = Float.parseFloat(amountField.getText());
					float percentage = Float.parseFloat(percentageField.getText());
					float term = Float.parseFloat(countField.getText());
					float profit = 0;
				
					if (termComboBox.getSelectedItem().equals("�������")) {
						if (�ompoundInterestCheckBox.isSelected()) {
							profit = ((float)Math.pow((1+percentage/(100*12)), term)-1)*amount;
						}
						else {
							profit = amount*percentage*(term*30)/(365*100);
						}
					}
					if (termComboBox.getSelectedItem().equals("���")) {
						if (�ompoundInterestCheckBox.isSelected()) {
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

        frame.add(new JLabel("����� ������"));
        frame.add(amountField);
        frame.add(new JLabel("���."));
        frame.add(new JLabel("�������"));
		frame.add(percentageField);
		frame.add(new JLabel("%"));
		frame.add(�ompoundInterestCheckBox);
		frame.add(new JLabel("����"));
		frame.add(countField);
		frame.add(termComboBox);
		frame.add(button);
		frame.add(new JLabel("�����:"));
		frame.add(profitField);
		frame.add(new JLabel("���."));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 100);
		frame.setLocation(200, 300);
		frame.setTitle("������ ������ �� ������");
		frame.setVisible(true);
		
	}
}
