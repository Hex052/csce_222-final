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
	public void action(input.Player usr) {
		displayMsg();
		switch (type) {
			case 1:
				do {
					usr.pos = usr.pos.next;
					usr.pos.pass(usr);
				} while (!usr.pos.name.equals(toSquareName));
				usr.pos.land(usr);
				break;
			case 2:
				if (money < 0) {
					usr.charge(-money);
				}
				else {
					usr.deposit(money);
				}
				break;
			case 3:
				do {
					usr.pos = usr.pos.next;
					usr.pos.pass(usr);
				} while (!(usr.pos instanceof board.UtilitySquare));
				usr.pos.land(usr);
				break;
			case 4:
				do {
					usr.pos = usr.pos.next;
					usr.pos.pass(usr);
				} while (!(usr.pos instanceof board.RailroadSquare));
				usr.pos.land(usr);
				break;
			case 5:
				for (int i = 0; i < 3; i++) {
					usr.pos = usr.pos.prev;
				}
				usr.pos.land(usr);
				break;
		}
	}
}
