package gui.props;

import java.awt.GridLayout;
import javax.swing.JLabel;

public class RailroadPanel extends PropertyPanel {
	private static final long serialVersionUID = 42l;
	protected JLabel railroadsOwned = new JLabel();
	public RailroadPanel(board.RailroadSquare sq) {
		super(sq);
		name.setForeground(java.awt.Color.WHITE);
		setBackground(java.awt.Color.BLACK);
		subpanel.setLayout(new GridLayout(0,2));
		subpanel.add(railroadsOwned);
		subpanel.add(rent);
	}
	public void refresh() {
		railroadsOwned.setText(pos.owner.railroadsOwned + " railroads owned");
		rent.setText("Rent: $" + ((board.RailroadSquare)pos).rent*(1<<(pos.owner.railroadsOwned - 1)));
	}
}
