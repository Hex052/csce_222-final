package gui.props;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;

//My naming isn't good...
public class ColoredPropertyPanel extends PropertyPanel {
	private static final long serialVersionUID = 42l;
	protected JButton upgrade;
	protected JLabel remaining, applied;
	public ColoredPropertyPanel(board.PropertySquare sq) {
		super(sq);
		name.setBackground(sq.color);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		add(rent, c);
		c.gridwidth = GridBagConstraints.REMAINDER;
		applied = new JLabel("Upgrades Applied");
		add(applied, c);
		c.gridwidth = 1;
		remaining = new JLabel("Upgrades Remain");
		add(remaining, c);
		c.gridwidth = GridBagConstraints.REMAINDER;
		upgrade = new JButton("Upgrade");
		add(upgrade,c);
	}
	public void refresh() {
		//TODO something useful on refresh
	}
}
