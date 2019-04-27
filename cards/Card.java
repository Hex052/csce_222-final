package cards;

public abstract class Card {
	public String name, flavorText, toSquareName;
	public int type, money;
	protected Card(int t, String title, String text) {
		type = t;
		name = title;
		flavorText = text;
	}
	public String toString() {
		return "Card type " + type + " name \'" + name + "\' flavorText \'" + flavorText + "\' toSquareName \'" + toSquareName + "\' money $" + money;
	}
}
