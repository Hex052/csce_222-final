package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ChangeName implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String oldName = ((JButton)e.getSource()).getName();
		String newName = JOptionPane.showInputDialog(gui.MainFrame.frame, "What is the new name for " + oldName + "?", "Changing name of " + oldName, JOptionPane.QUESTION_MESSAGE);
		if (newName == null)
			return;
		input.Player usr = start.Startup.findPlayer(oldName);

		while (start.Startup.findPlayer(newName) != null) {
			newName = JOptionPane.showInputDialog(gui.MainFrame.frame, "That name is already in use. Choose a new name for " + oldName + ".", "Changing name of " + oldName, JOptionPane.QUESTION_MESSAGE);
			if (newName == null)
				return;
		}
		usr.name = newName;
		usr.guiDisp.name.setText(newName);
		usr.guiDisp.changeName.setName(newName);
		usr.guiDisp.changeImg.setName(newName);
		usr.guiDisp.manageProp.setName(newName);
		gui.LogPanel.write("Player renamed from " + oldName + " to " + newName);
	}
}
