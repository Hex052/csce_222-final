package board;

import java.util.ArrayList;

public class CardSquare extends Square {
	public CardSquare(String name, Square n, Square p) {
		super(name, n, p);
	}
	public void land(input.Player usr) {
		usr.updateDisplayedPos();
		cards.Card drawn;
		if (name.equals("Chance")) {
			drawn = cards.CardDeck.drawChance();
		}
		else {
			drawn = cards.CardDeck.drawCommunityChest();
		}
		drawn.action(usr);
		cards.CardDeck.discard(drawn);
	}
	public void pass(input.Player usr) {
		return;
	}
	public String toString() {
		return "Card \'" + name + "\'";
	}
}
