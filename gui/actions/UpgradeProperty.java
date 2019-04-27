package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class UpgradeProperty implements ActionListener {
	protected board.PropertySquare square;
	private static final int HOUSE_COST = 50;
	public UpgradeProperty(board.PropertySquare sq) {
		square = sq;
	}
	public void actionPerformed(ActionEvent e) {
		if (square.owner.getFunds() < HOUSE_COST) {
			JOptionPane.showMessageDialog(square.disp, "Houses cost $" + HOUSE_COST, "Insufficent funds", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (square.upgrades == 4) {
			//I have no idea how the button was clicked, but this should fix it
			square.disp.refresh();
			return;
		}
		int choice = JOptionPane.showConfirmDialog(square.disp, "Do you want to spend $" + HOUSE_COST + " for a house to be added to " + square.name, "Confirm purchase", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (choice == JOptionPane.YES_OPTION) {
			square.upgrades++;
			square.owner.charge(HOUSE_COST);
			square.disp.refresh();
		}
	}
}
