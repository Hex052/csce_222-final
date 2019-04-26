package board;

import java.awt.Color;
import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

public class PropertySquare extends BuyableSquare {
	public int upgrades = 0;
	public int[] rents;
	private String colorstr;
	public Color color;

	public PropertySquare(String name, Square n, Square p, int cost, int[] rent, String colorname) {
		super(name, n, p, cost);
		rents = rent;
		colorstr = colorname;
		this.color = start.Colormap.map.get(colorname);

	}
	public void land(input.Player usr) {
		if (owner == null) {
			if (usr.getFunds() < cost) {
				JOptionPane.showMessageDialog(null, "Unaffordable", "You are unable to purcase " + name + " for " + cost + "since you do not have enough funds.", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int choice = JOptionPane.showConfirmDialog(null, "Purchase " + name, "Do you want to purchase " + name + " for " + cost + "?", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				usr.charge(cost);
				owner = usr;
			}
		}
		else if (!owner.equals(usr)) {
			input.Log.write("Charged " + usr.name + " $" + rents[upgrades] + " for landing on " + name + ". Deposited in the account of " + owner.name + "\n");
			owner.deposit(usr.charge(rents[upgrades]));
		}
	}
	public String toString() {
		String str = "Property \'" + name + "\' colored \'" + colorstr + "\' costing $" + cost + " with rents of ";
		for (int i : rents) {
			str = str + i + ' ';
		}
		return str.substring(0, str.length() - 1);
	}
	// public void pass(input.Player usr)
	// marked final in BuyableSquare
}
