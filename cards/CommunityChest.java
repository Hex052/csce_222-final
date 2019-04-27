package cards;

public class CommunityChest extends Card {
	protected CommunityChest(String[] args) {
		super(Integer.parseInt(args[0]), args[1], args[2]);
		if (type == 1) {
			toSquareName = args[3];
			money = 0;
			return;
		}
		if (type == 3) {
			toSquareName = "Jail/Just Visiting";
			money = 0;
			return;
		}
		toSquareName = null;
		money = Integer.parseInt(args[3]);
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
				usr.gotoJail();
				break;
			case 4:
				input.Player otherUsr = usr.next;
				do {
					usr.deposit(otherUsr.charge(-money));
				} while (usr != otherUsr);
				break;
			case 5:
				int houses = 0;
				for (board.BuyableSquare sq : usr.propertyList) {
					if (sq instanceof board.PropertySquare) {
						houses += ((board.PropertySquare)sq).upgrades;
					}
				}
				usr.charge((-money) * houses);
				break;
		}
	}
}
