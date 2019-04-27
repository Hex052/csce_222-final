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
	private JFrame window = new JFrame();
	private JScrollPane scroll = new JScrollPane(view);

	public ManageProperties(input.Player p) {
		view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));
		usr = p;
		window.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		window.setContentPane(scroll);
		window.setSize(400,400);
	}
	public void actionPerformed(ActionEvent e) {
		if (!start.Startup.passingTurn) {
			JOptionPane.showMessageDialog(gui.MainFrame.frame, "Properties may only be managed between turns, not during", "Cannot manage properties now", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		for (board.BuyableSquare sq : usr.propertyList) {
			sq.disp.refresh();
			view.add(sq.disp);
		}
		window.setTitle(usr.name + "\'s properties");
		window.setVisible(true);
	}
}
