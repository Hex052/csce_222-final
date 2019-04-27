package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ManageProperties implements ActionListener {
	protected input.Player usr;
	protected JPanel view = new JPanel();
	public void actionPerformed(ActionEvent e) {
		if (!start.Startup.passingTurn) {
			JOptionPane.showMessageDialog(gui.MainFrame.frame, "Properties may only be managed between turns, not during", "Cannot manage properties now", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));

		usr = start.Startup.findPlayer(((JButton)e.getSource()).getName());

		for (board.BuyableSquare sq : usr.propertyList) {
			if (sq.disp == null) {
				sq.disp = new gui.PropertyPanel(sq);
			}
			view.add(sq.disp);
			//TODO implement via panel, which adds several boxes for each property in a JScrollPane
		}

		JScrollPane scroll = new JScrollPane(view);
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		// window.getContentPane().add(view);
		window.setContentPane(view);
		window.setSize(400,400);
		window.setVisible(true);
	}
}
