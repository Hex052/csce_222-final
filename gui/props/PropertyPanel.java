package gui.props;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

//My naming isn't good...
public abstract class PropertyPanel extends JPanel {
	private static final long serialVersionUID = 42l;
	public board.BuyableSquare pos;
	protected Dimension minsize, maxsize;
	protected JLabel rent, name;
	protected JPanel subpanel;

	public PropertyPanel(board.BuyableSquare sq) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		minsize = new Dimension(300, 100);
		maxsize = new Dimension(1000, 120);
		setMinimumSize(minsize);
		setMaximumSize(maxsize);
		pos = sq;
		subpanel = new JPanel();
		rent = new JLabel("rent");
		name = new JLabel(sq.name, JLabel.CENTER);
		add(name);
		add(subpanel);
	}
	public abstract void refresh();
}
