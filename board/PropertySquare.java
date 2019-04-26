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
			purchase(usr);
		}
		else if (!owner.equals(usr)) {
			charge(usr, rents[upgrades]);
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
