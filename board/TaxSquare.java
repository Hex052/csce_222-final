package board;

public class TaxSquare extends Square {
	private int taxrate;
	public TaxSquare(String name, Square n, Square p, int rate) {
		super(name, n, p);
		//TODO
	}
	public void pass(input.Player usr) {
		//Nothing happens.
		return;
	}
	public final void land(input.Player usr) {
		//TODO
	}
	public String toString() {
		return "Tax \'" + name + "\' costing $" + taxrate; 
	}
}
