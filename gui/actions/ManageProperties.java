package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ManageProperties implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (!start.Startup.passingTurn) {
			JOptionPane.showMessageDialog(gui.MainFrame.frame, "Properties may only be managed between turns, not during", "Cannot manage properties now", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		String usrName = ((JButton)e.getSource()).getName();
		if (!usrName.equals(start.Startup.currentPlayer.name)) {
			JOptionPane.showMessageDialog(gui.MainFrame.frame, "Properties may only be managed before your turn, not at other times", "Cannot manage properties now", JOptionPane.INFORMATION_MESSAGE);
			//TODO double-check this is actually a rule
			return;
		}
		//TODO implement via panel, which adds several boxes for each property in a JScrollPane
	}
}
