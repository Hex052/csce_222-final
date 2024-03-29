package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PlayerContainer extends JPanel {
	private static final long serialVersionUID = 42l;
	public static BufferedImage beginImg = null;
	// public JTextField name;
	public input.Player usr;
	public JLabel funds;
	public BufferedImage img;
	public JLabel imgDisplay;
	public JTextArea name, pos;
	public JPanel top = new JPanel(), topRight = new JPanel();
	public Dimension maxTop = new Dimension(450, 160);
	public JButton changeName, changeImg, manageProp;

	public PlayerContainer(input.Player player) {
		usr = player;
		funds = new JLabel("$" + usr.getFunds());
		name = new JTextArea(usr.name);
		name.setEditable(false);
		name.setLineWrap(true);
		name.setWrapStyleWord(true);

		if (beginImg == null) {
			setInitialImage(new File("img/piece/car.png"));
		}
		img = beginImg;
		changeName = new JButton("Change Name");
		changeName.setName(usr.name);
		changeName.addActionListener(new gui.actions.ChangeName());
		changeImg = new JButton("Change Icon");
		changeImg.setName(usr.name);
		changeImg.addActionListener(new gui.actions.ChangeIcon(usr));
		imgDisplay = new JLabel(new ImageIcon(img));
		manageProp = new JButton("Properties");
		manageProp.setName(usr.name);
		manageProp.addActionListener(new gui.actions.ManageProperties(usr));
		pos = new JTextArea("On " + usr.pos.name);
		pos.setEditable(false);
		pos.setLineWrap(true);
		pos.setWrapStyleWord(true);

		top.setMaximumSize(maxTop);
		top.add(imgDisplay);
		top.add(topRight);
		topRight.setLayout(new GridLayout(0,2));
		topRight.add(name);
		topRight.add(changeName);
		topRight.add(funds);
		topRight.add(changeImg);
		topRight.add(pos);
		topRight.add(manageProp);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(top); //below would go the properties owned


	}

	public void updateFunds() {
		funds.setText("$" + usr.getFunds());
	}

	/// Set the image used by default for new players
	public static void setInitialImage(File img_file) {
		if (img_file.exists() && !img_file.isDirectory()) {
			try {
				beginImg = ImageIO.read(img_file);
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

	// public void repaint() {
	// 	removeAll();
	// 	add(top);
	// }
}
