package gui.props;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;

public class RailroadPanel extends PropertyPanel {
	private static final long serialVersionUID = 42l;
	protected JLabel railroadsOwned = new JLabel();
	public RailroadPanel(board.RailroadSquare sq) {
		super(sq);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		add(railroadsOwned, c);
		c.gridwidth = GridBagConstraints.REMAINDER;
		add(rent, c);
		//Can't set anything with a call to refresh() since doesn't have owner yet
	}
	public void refresh() {
		railroadsOwned.setText(pos.owner.railroadsOwned + " railroads owned");
		rent.setText("Rent: $" + ((board.RailroadSquare)pos).rent*(1<<(pos.owner.railroadsOwned - 1)));
	}
}
