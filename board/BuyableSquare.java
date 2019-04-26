package board;

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
}
