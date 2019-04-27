package cards;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CardDeck {
	protected static ArrayList<Chance> chanceDrawPile = new ArrayList<>(), chanceDiscardPile = new ArrayList<>();
	protected static ArrayList<CommunityChest> chestDrawPile = new ArrayList<>(), chestDiscardPile = new ArrayList<>();


	public static void init(File chestpath, File chancepath) {
		if (!chestpath.exists() || chestpath.isDirectory()) {
			JOptionPane.showMessageDialog(null, "Could not find Community Chest csv file at path " + chestpath.getAbsolutePath(), "Error opening file", JOptionPane.ERROR_MESSAGE);
		}
		if (!chancepath.exists() || chancepath.isDirectory()) {
			JOptionPane.showMessageDialog(null, "Could not find Chance csv file at path " + chancepath.getAbsolutePath(), "Error opening file", JOptionPane.ERROR_MESSAGE);
		}
		try { // This shouldn't all be in a try-catch block, but none of these errors are correctable anyway.
			Scanner reader = new Scanner(chancepath);
			while (reader.hasNextLine()) {
				chanceDrawPile.add(new Chance(reader.nextLine().split(",")));
			}
			reader = new Scanner(chestpath);
			while (reader.hasNextLine()) {
				chestDrawPile.add(new CommunityChest(reader.nextLine().split(",")));
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Exception occured while reading cards. Message: \n" + e.getMessage(), "Could not read cards", JOptionPane.ERROR_MESSAGE);
			System.err.println(e.getStackTrace());
		}
	
		Collections.shuffle(chanceDrawPile);
		Collections.shuffle(chestDrawPile);
	}

	//Only avaliable to cards
	protected static void discard(Card card) {

	}
}
