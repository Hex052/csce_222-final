package gui.props;

import javax.swing.JButton;
import javax.swing.JLabel;

//My naming isn't good...
public class UtilityPanel extends PropertyPanel {
	private static final long serialVersionUID = 42l;
	public UtilityPanel(board.UtilitySquare sq) {
		super(sq);
		name.setForeground(java.awt.Color.WHITE);
		setBackground(java.awt.Color.BLACK);
		rent.setText(sq.multiplier + "x the roll of a die");
		subpanel.add(rent);
	}
	public void refresh() {
		return;
	}
}
