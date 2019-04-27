package cards;

public class Chance extends Card {
	protected Chance(String[] args) {
		super(Integer.parseInt(args[0]), args[1], args[2]);
		if (type == 1) {
			toSquareName = args[3];
			money = 0;
			return;
		}
		toSquareName = null;
		if (type == 2) {
			money = Integer.parseInt(args[3]);
		}
		money = 0;
	}
}
