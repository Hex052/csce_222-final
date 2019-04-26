package gui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 42l;
	public static BoardPanel board = new BoardPanel();
	public static LogPanel log = new LogPanel();
	public static PlayerPanel players = new PlayerPanel();
	public static JPanel right = new JPanel();
	public static MainFrame frame = null;
	public static JFrame logFrame = new JFrame();

	public MainFrame() {
		frame = this;
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		// right.setLayout(new BoxLayout(right, BoxLayout.X_AXIS));

		board.setMinimumSize(new java.awt.Dimension(650,650));
		getContentPane().add(board);
		// getContentPane().add(right);
		// right.add(log);
		// right.add(players);
		logFrame.getContentPane().add(log);
		logFrame.setTitle("Monopoly - Log");
		logFrame.setVisible(true);
		logFrame.setSize(300,600);
		logFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE); //To ensure it isn't closed accidentally
		getContentPane().add(players);

		setSize(1240, 650);
		setTitle("Monopoly");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		// setResizable(false);
	}

	public void setVisible(boolean b) {
		super.setVisible(b);
		logFrame.setVisible(b);
	}

}
