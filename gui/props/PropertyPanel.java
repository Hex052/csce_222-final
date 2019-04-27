package gui.props;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

//My naming isn't good...
public abstract class PropertyPanel extends JPanel {
	private static final long serialVersionUID = 42l;
	public board.BuyableSquare pos;
	protected Dimension minsize;
	protected JLabel rent, name;

	public PropertyPanel(board.BuyableSquare sq) {
		setLayout(new GridBagLayout());
		minsize = new Dimension(300, 100);
		setMinimumSize(minsize);
		pos = sq;
		rent = new JLabel();
		name = new JLabel(sq.name);
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridx = 1;
		c.gridy = 0;
		add(name, c);
	}
	public abstract void refresh();
}
