package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChangeIcon implements ActionListener {
	public final input.Player usr;
	public static final ArrayList<File> fileNames = new ArrayList<>();
	public ChangeIcon(input.Player player) {
		usr = player;
		if (fileNames.size() == 0) {
			genFiles(new File("img/piece"));
		}
	}
	public void actionPerformed(ActionEvent e) {


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
			if (fname.isDirectory() || !fname.substring(fname.lastIndexOf('.') + 1).equals("png")) {
				continue;
			}
			fileNames.add(path);
		}
	}
}
