package board;

import javax.swing.JOptionPane;

public class UtilitySquare extends BuyableSquare {
	public int multiplier;
	public UtilitySquare(String name, Square n, Square p, int cost, int multi) {
		super(name, n, p, cost);
		multiplier = multi;
	}

	public void land(input.Player usr) {
		if (owner == null) {
			purchase(usr);
		}
		else if (!owner.equals(usr)) {
			int dieresult = input.Player.rollDice(1);
			input.Log.write("Charged " + usr.name + " $" + (dieresult*multiplier) + " for landing on " + name + ". Deposited in the account of " + owner.name + "\n");
			owner.deposit(usr.charge(dieresult * multiplier));
		}
	}

	public String toString() {
		return "Utility \'" + name + "\' costing $" + cost + " and with a multiplier of " + multiplier; 
	}
	// public void pass(input.Player usr)
	// marked final in BuyableSquare
}
