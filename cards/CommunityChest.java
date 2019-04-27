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
}
