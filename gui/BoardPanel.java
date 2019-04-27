package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	private static final long serialVersionUID = 42l;
	public static Image img = null;
	public static JButton roll = new JButton("Begin Turn");
	public static JLabel currTurn = new JLabel("", JLabel.CENTER);
	public BoardPanel() {
		// setBackground(java.awt.Color.RED);
		if (img == null) {
			readImage(new File("img/Map.jpg"));
		}

		setLayout(null);
		roll.setSize(150, 30);
		roll.setLocation(325,140);
		roll.addActionListener(new gui.actions.BeginTurn());
		add(roll);
		setNextLabel(start.Startup.currentPlayer.name);
		currTurn.setSize(200, 50);
		currTurn.setLocation(300, 90);
		add(currTurn);

		for (input.Player usr : start.Startup.players) {
			usr.icon = new PlayerIcon(usr);
			add(usr.icon);
		}
	}

	public static void readImage(File img_file) {
		if (img_file.exists() && !img_file.isDirectory()) {
			try {
				img = ImageIO.read(img_file);
			}
			catch (Exception e) {
				System.err.println("Error reading image \'" + img_file.getAbsolutePath() + "\'");
				JOptionPane.showMessageDialog(null, "Error reading image","An error occoured  importing game board image from path \'" + img_file.getAbsolutePath() + "\'. The program will now terminate.", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
		}
		else {
			System.err.println("Image file \'" + img_file.getAbsolutePath() + "\' does not exist");
			JOptionPane.showMessageDialog(null, "Image does not exist","The image at path \'" + img_file.getAbsolutePath() + "\' does not exist. The program will now terminate.", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}
	public static void setNextLabel(String name) {
		currTurn.setText("Next Player: " + name);
	}
}
