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
				gui.LogPanel.write(usr.name + " sent to " + toSquareName + " by Chance card");
				do {
					usr.pos = usr.pos.next;
					usr.pos.pass(usr);
				} while (!usr.pos.name.equals(toSquareName));
				usr.pos.land(usr);
				break;
			case 2:
				if (money < 0) {
					gui.LogPanel.write(usr.name + " charged $" + (-money) + " by Chance card");
					usr.charge(-money);
				}
				else {
					gui.LogPanel.write(usr.name + " received $" + money + " from Chance card");
					usr.deposit(money);
				}
				break;
			case 3:
				gui.LogPanel.write(usr.name + " sent to next utility by Chance card");
				do {
					usr.pos = usr.pos.next;
					usr.pos.pass(usr);
				} while (!(usr.pos instanceof board.UtilitySquare));
				usr.pos.land(usr);
				break;
			case 4:
				gui.LogPanel.write(usr.name + " sent to next railroad by Chance card");
				do {
					usr.pos = usr.pos.next;
					usr.pos.pass(usr);
				} while (!(usr.pos instanceof board.RailroadSquare));
				usr.pos.land(usr);
				break;
			case 5:
				gui.LogPanel.write(usr.name + " sent back 3 spaces by Chance card");
				for (int i = 0; i < 3; i++) {
					usr.pos = usr.pos.prev;
				}
				usr.pos.land(usr);
				break;
		}
	}
}
