package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpgradeProperty implements ActionListener {
	protected board.PropertySquare square;
	public UpgradeProperty(board.PropertySquare sq) {
		square = sq;
	}
	public void actionPerformed(ActionEvent e) {
		square.upgrades++;
		//TODO implement correctly
		//max 4 upgrades, and must have sufficient funds to upgrade
	}
}
