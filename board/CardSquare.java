package board;

import java.util.ArrayList;

public class CardSquare extends Square {
	public static ArrayList<cards.CommunityChest> chestDeck; //TODO init
	public static ArrayList<cards.Chance> chanceDeck; //TODO init
	public static enum Type {CHEST, CHANCE};

	public Type type;
	public CardSquare(String name, Square n, Square p) {
		super(name, n, p);
		if (name.equals("Chance")) {
			type = Type.CHANCE;
		}
		else {
			type = Type.CHEST;
		}
	}
	public void land(input.Player usr) {
		usr.updateDisplayedPos();
		//TODO draw cards
	}
	public void pass(input.Player usr) {
		return;
	}
	public String toString() {
		return "Card \'" + name + "\' of type " + type; 
	}
}
