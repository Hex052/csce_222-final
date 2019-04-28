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
				gui.LogPanel.write(usr.name + " sent to jail by Community Chest card");
				usr.gotoJail();
				break;
			case 4:
				input.Player otherUsr = usr.next;
				int bal = 0;
				do {
					bal += otherUsr.charge(-money);
				} while (usr != otherUsr);
				usr.deposit(bal);
				gui.LogPanel.write("All other players paid $" + bal + " to " + usr.name + " ($" + (-money) + " each) because of Community Chest card");
				break;
			case 5:
				int houses = 0;
				for (board.BuyableSquare sq : usr.propertyList) {
					if (sq instanceof board.PropertySquare) {
						houses += ((board.PropertySquare)sq).upgrades;
					}
				}
				gui.LogPanel.write(usr.name + " charged $" + usr.charge((-money) * houses) + " for " + houses + " houses ($" + (-money) + "each) by Community Chest card");
				usr.charge((-money) * houses);
				break;
		}
	}
}
