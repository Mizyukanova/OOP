package mypackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComponent;

public class CheckBoxListener implements ActionListener {

	public ArrayList<JComponent> components = new ArrayList<JComponent>();
	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (JComponent comp : components) {
			comp.setEnabled(!comp.isEnabled());
		}
		
	}
}