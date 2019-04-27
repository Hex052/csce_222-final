package gui.props;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

//My naming isn't good...
public class ColoredPropertyPanel extends PropertyPanel {
	private static final long serialVersionUID = 42l;
	protected JButton upgrade;
	protected JLabel remaining, applied;
	public ColoredPropertyPanel(board.PropertySquare sq) {
		super(sq);
		setBackground(sq.color);
		subpanel.setLayout(new GridLayout(0,2));
		subpanel.add(rent);
		applied = new JLabel("Upgrades Applied");
		subpanel.add(applied);
		remaining = new JLabel("Upgrades Remain");
		subpanel.add(remaining);
		upgrade = new JButton("Upgrade");
		upgrade.addActionListener(new gui.actions.UpgradeProperty((board.PropertySquare)pos));
		subpanel.add(upgrade);
	}
	public void refresh() {
		board.PropertySquare sq = (board.PropertySquare)pos;
		rent.setText("Rent: $" + sq.rents[sq.upgrades]);
		upgrade.setText((sq.upgrades < 4) ? "Upgrade" : "No more houses");
		upgrade.setEnabled(sq.upgrades < 4);
		remaining.setText((4-sq.upgrades) + " houses left");
		applied.setText(sq.upgrades + " houses built");
	}
}
