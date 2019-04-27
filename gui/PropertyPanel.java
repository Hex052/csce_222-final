package gui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PropertyPanel extends JPanel {
	private static final long serialVersionUID = 42l;
	public board.BuyableSquare pos;

	public PropertyPanel(board.BuyableSquare sq) {
		pos = sq;
		//TODO fill with something useful
		add(new JButton(pos.name));
	}
}
