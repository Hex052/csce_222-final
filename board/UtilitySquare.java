package board;

import javax.swing.JOptionPane;

public class UtilitySquare extends BuyableSquare {
	public int multiplier;
	public UtilitySquare(String name, Square n, Square p, int cost, int multi) {
		super(name, n, p, cost);
		multiplier = multi;
		disp = new gui.props.UtilityPanel(this);
	}

	public void land(input.Player usr) {
		usr.updateDisplayedPos();
		if (owner == null) {
			purchase(usr);
		}
		else if (!owner.equals(usr)) {
			int dieresult = input.Player.rollDice(1);
			charge(usr, dieresult * multiplier);
		}
	}

	public String toString() {
		return "Utility \'" + name + "\' costing $" + cost + " and with a multiplier of " + multiplier;
	}
	// public void pass(input.Player usr)
	// marked final in BuyableSquare
}
