package board;

import javax.swing.JOptionPane;

public abstract class BuyableSquare extends Square {
	protected int cost;
	public input.Player owner = null;
	public gui.props.PropertyPanel disp = null;

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
	public boolean purchase(input.Player usr) {
		if (usr.getFunds() < cost) {
			JOptionPane.showMessageDialog(null, "You are unable to purcase " + name + " for " + cost + "since you do not have enough funds.", "Unaffordable", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		int choice = JOptionPane.showConfirmDialog(gui.MainFrame.frame, "Purchase " + name, "Do you want to purchase " + name + " for " + cost + "?", JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			gui.LogPanel.write(usr.name + " purchased " + name + " for $" + cost);
			usr.charge(cost);
			setOwner(usr);
			return true;
		}
		return false;
	}
	public void charge(input.Player usr, int amount) {
		int charged = usr.charge(amount);
		owner.deposit(charged);
		gui.LogPanel.write("Charged " + usr.name + " $" + charged + " for landing on " + name + " owned by " + owner.name + "\n");
		if (amount != charged) {
			gui.LogPanel.write("Unable to charge the full amount of $" + amount);
		}
	}
	public void setOwner(input.Player usr) {
		if (owner != null) {
			owner.propertyList.remove(this);
		}
		owner = usr;
		usr.propertyList.add(this);
	}
}
