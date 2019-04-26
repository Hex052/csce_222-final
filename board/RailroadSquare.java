package board;

import javax.swing.JOptionPane;

public class RailroadSquare extends BuyableSquare {
	public int rent;
	public RailroadSquare(String name, Square n, Square p, int cost, int rent) {
		super(name, n, p, cost);
		this.rent = rent;
	}
	public void land(input.Player usr) {
		if (owner == null) {
			purchase(usr);
		}
		else if (!owner.equals(usr)) {
			int owed = 25*(1<<(owner.railroadsOwned - 1));
			charge(usr, owed);
		}
	}
	public String toString() {
		return "RR \'" + name + "\' costing $" + cost + " and with a base rent of $" + rent;
	}
}
