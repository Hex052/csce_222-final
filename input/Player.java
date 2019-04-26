package input;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Player {
	public static int numplayers = 0;
	public Player next, prev;
	public String name = "Player ";
	protected int funds;
	public int railroadsOwned;
	public boolean jailed = false;
	public board.Square pos = null;
	public ArrayList<board.BuyableSquare> propertyList = new ArrayList<>();
	public BufferedImage icon = null;
	public gui.PlayerContainer guiDisp;
	private static java.util.Random singleDie = new java.util.Random();


	public Player(board.Square go, Player n, Player p) {
		numplayers++;
		pos = go;
		next = n;
		prev = p;
		name = name + numplayers;
		funds = 1500;
		guiDisp = new gui.PlayerContainer(this);
	}

	//! returns the amount that was able to be deducted from the user.
	public int charge(int cost) {
		if (funds >= cost) {
			funds -= cost;
			guiDisp.updateFunds();
			return cost;
		}
		else {
			int oldfunds = funds;
			funds = 0;
			//TODO Case where unable to cover amount
			guiDisp.updateFunds();
			return oldfunds;
		}
	}
	public void deposit(int val) {
		funds += val;
		guiDisp.updateFunds();
	}
	public int getFunds() {
		return funds;
	}
	//! Adds a property to the arraylist of properites
	public void addProperty(board.BuyableSquare sq) {
		propertyList.add(sq);
	}

	//! Displays a new window with the result of the die roll(s).
	//! num must be positive.
	public static int rollDice(int num) {
		//TODO
		int roll, tot = 0;
		int[] list = new int[num];
		for (int i = 0; i < num; i++) {
			roll = rollSingleDie();
			tot += roll;
			list[i] = roll;
		}
		String rolls = "";
		for (int i : list) {
			rolls = rolls + " " + i;
		}
		JOptionPane.showMessageDialog(gui.MainFrame.frame, "Rolling " + num + "D6:\n" + rolls + "\nTotalling " + tot, "Roll " + num + "D6", JOptionPane.INFORMATION_MESSAGE);
		return tot;
	}
	private static int rollSingleDie() {
		return (java.lang.Math.abs((singleDie.nextInt() % 6)) + 1);
	}
	public String toString() {
		return "Player \'" + name + "\' on square \'" + pos.name + "\' with $" + funds;
	}
}
