package start;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Startup {
	public static board.Square go = null;
	public static input.Player[] players = new input.Player[4];
	public static input.Player currentPlayer = null;
	public static boolean passingTurn = true;

	public static void main(String[] args) {
		/*Init colormap from String to Color*/
		Colormap.init();
		/*Load squares from file*/
		processSquaresFile("squares.txt");
		board.Square curr = go;
		/*Load cards from file*/
		//TODO
		/*Init players*/
		input.Player lastPlayer = new input.Player(go, null, null);
		players[0] = lastPlayer;
		for (int i = 1; i < players.length; i++) {
			players[i] = new input.Player(go, null, lastPlayer);
			lastPlayer.next = players[i];
			lastPlayer = players[i];
		}
		players[3].next = players[0];
		players[0].prev = players[3];
		currentPlayer = players[0];
		/*Set up game board*/
		new gui.MainFrame();
		/*Debug*/
		gui.MainFrame.frame.setVisible(true);
		// for (int i = 0; i < 42; i++) {
		// 	System.out.println(curr.toString());
		// 	curr = curr.next;
		// }
		// for (input.Player p : players) {
		// 	System.out.println(p.toString());
		// }

	}

	public static void nextTurn() {
		currentPlayer = currentPlayer.next;
		gui.LogPanel.write("Passing turn to " + currentPlayer.name);
		gui.BoardPanel.setNextLabel(currentPlayer.name);
		start.Startup.passingTurn = true;
	}

	public static void processSquaresFile(String filename) {
		board.Square last = null;
		Scanner squaresfile = null;
		try {
			squaresfile = new Scanner(new File(filename));
		}
		catch (Exception e) {
			System.err.println("File \'" + filename + "\' not found.");
			System.exit(1);
		}
		while (squaresfile.hasNextLine()) {
			String [] line = squaresfile.nextLine().split(",");
			if (line.length < 2) {
				continue;
			}
			switch ((int)Double.parseDouble(line[0])) {
				case 1:
					if (go == null) {
						go = new board.Square(line[1], null, null, 0, 200);
						last = go;
						continue;
					}
					else if (line[1].equals("Community Chest") || line[1].equals("Chance")) {
						last.next = new board.CardSquare(line[1], null, last);
					}
					else if (line[1].equals("Free Parking")) {
						last.next = new board.Square(line[1], null, last, 20, 0);
					}
					else /*Jail or Got To Jail*/ {
						last.next = new board.Square(line[1], null, last, line[1].equals("Go to Jail"));
					}
					break;
				case 2:
					last.next = new board.PropertySquare(line[1], null, last, (int)Double.parseDouble(line[3]), new int[] {(int)Double.parseDouble(line[4]), (int)Double.parseDouble(line[5]), (int)Double.parseDouble(line[6]), (int)Double.parseDouble(line[7]), (int)Double.parseDouble(line[8])}, line[2]);
					break;
				case 3:
					//Tax
					last.next = new board.TaxSquare(line[1], null, last, (int)Double.parseDouble(line[2]));
					break;
				case 4:
					//Railroad
					last.next = new board.RailroadSquare(line[1], null, last, (int)Double.parseDouble(line[2]), (int)Double.parseDouble(line[3]));
					break;
				case 5:
					//Utility
					last.next = new board.UtilitySquare(line[1], null, last, (int)Double.parseDouble(line[2]), (int)Double.parseDouble(line[3]));
					break;
				default:
					System.err.println("Malformed file \'" + filename + "\'");
					JOptionPane.showMessageDialog(null, "Error parsing file", "An error occured regarding the file \'" + filename + "\' being malformed. The program will now terminate.", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
			}
			last = last.next;
		}
		last.next = go;
		go.prev = last;
	}
	public static input.Player findPlayer(String name) {
		for (input.Player p : players) {
			if (p.name.equals(name))
				return p;
		}
		return null;
	}
}
