package gui.actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ChangeIcon implements ActionListener {
	public final input.Player usr;
	private final JComboBox<File> selector = new JComboBox<>();
	private final JFrame window = new JFrame();
	private final JLabel message;
	private final JButton select = new JButton("Select Image");
	public static final ArrayList<File> fileNames = new ArrayList<>();
	public ChangeIcon(input.Player player) {
		usr = player;
		message = new JLabel("Choose the icon for " + usr.name);
		if (fileNames.size() == 0) {
			genFiles(new File("img/piece"));
		}
		window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
		window.add(message);
		window.add(selector);
		window.add(select);
		window.setTitle("Select icon");
		window.setResizable(false);
		select.addActionListener(this);
		selector.setMaximumSize(new Dimension(600, 50));
	}
	public void actionPerformed(ActionEvent e) {
		if (window.isAncestorOf((JButton)e.getSource())) {
			changeTo((File)selector.getSelectedItem());
			window.setVisible(false);
			return;
		}
		selector.removeAllItems();
		for (File f : fileNames) {
			selector.addItem(f);
		}
		window.setSize(600, 150);
		window.setVisible(true);
	}
	public void changeTo(File img) {
		try {
			usr.guiDisp.img = ImageIO.read(img);
			usr.guiDisp.imgDisplay.setIcon(new ImageIcon(usr.guiDisp.img));
			gui.LogPanel.write("Changed the icon for " + usr.name + " to \'" + img + '\'');
		}
		catch (Exception e) {
			gui.LogPanel.write("Could not change the icon for " + usr.name + " to \'" + img + "\' as an error occured");
		}
		usr.icon.reloadIcon();
	}
	public static void genFiles(File parentDir) {
		if (!parentDir.exists() || !parentDir.isDirectory()) {
			String msg = "The folder \'" + parentDir.getAbsolutePath() + "\' does not exist";
			JOptionPane.showMessageDialog(null, msg, "Error opening images", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		for (File path : parentDir.listFiles()) {
			String fname = path.getName();
			if (path.isDirectory() || !fname.substring(fname.lastIndexOf('.') + 1).equals("png")) {
				continue;
			}
			fileNames.add(path);
		}
	}
}
