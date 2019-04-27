package gui.props;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;

//My naming isn't good...
public class UtilityPanel extends PropertyPanel {
	private static final long serialVersionUID = 42l;
	public UtilityPanel(board.UtilitySquare sq) {
		super(sq);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridy = 0;

		rent.setText(sq.multiplier + "x the roll of a die");
		add(rent,c);
	}
	public void refresh() {
		return;
	}
}
