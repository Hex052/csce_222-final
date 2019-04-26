package board;

import javax.swing.JOptionPane;

public abstract class BuyableSquare extends Square {
	protected int cost;
	public input.Player owner = null;

	public BuyableSquare(String name, Square n, Square p, int c) {
		super(name, n, p);
		cost = c;
	}

	public int getCost() {
		return cost;
	}
	public abstract void land(input.Player usr);
	public final void pass(input.Player usr) {
		return;
	}
	public void purchase(input.Player usr) {
		if (usr.getFunds() < cost) {
			JOptionPane.showMessageDialog(null, "Unaffordable", "You are unable to purcase " + name + " for " + cost + "since you do not have enough funds.", JOptionPane.WARNING_MESSAGE);
			return;
		}
		int choice = JOptionPane.showConfirmDialog(null, "Purchase " + name, "Do you want to purchase " + name + " for " + cost + "?", JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			gui.LogPanel.write(usr.name + " purchased " + name + " for $" + cost);
			usr.charge(cost);
			owner = usr;
		}
	}
}
