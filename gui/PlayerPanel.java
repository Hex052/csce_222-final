package gui;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel {
	private static final long serialVersionUID = 42l;

	public PlayerPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		for (input.Player usr : start.Startup.players) {
			add(usr.guiDisp);
		}
		// setSize(new Dimension(450,650));
		//TODO
	}
}
