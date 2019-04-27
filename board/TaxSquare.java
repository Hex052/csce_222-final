package board;

import javax.swing.JOptionPane;

public class TaxSquare extends Square {
	private int taxrate;
	public TaxSquare(String name, Square n, Square p, int rate) {
		super(name, n, p);
		taxrate = rate;
	}
	public void pass(input.Player usr) {
		//Nothing happens.
		return;
	}
	public final void land(input.Player usr) {
		usr.updateDisplayedPos();
		int amount = usr.charge(taxrate);
		String log = "Charged " + usr.name + " $" + amount;
		if (amount < taxrate) {
			log = log + " of total due ($" + taxrate + ", insufficient funds)";
		}
		JOptionPane.showMessageDialog(gui.MainFrame.frame, log, "Landed on " + name, JOptionPane.INFORMATION_MESSAGE);
		gui.LogPanel.write(log + " for landing on " + name);
	}
	public String toString() {
		return "Tax \'" + name + "\' costing $" + taxrate;
	}
}
