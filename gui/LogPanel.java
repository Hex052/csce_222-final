package gui;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// public class LogPanel extends JPanel {
public class LogPanel extends JScrollPane {
	private static final long serialVersionUID = 42l;
	public static JTextArea text = new JTextArea();
	public LogPanel() {
		text.setEditable(false);
		Dimension size = new Dimension(450, 650);
		setViewportView(text);
		text.setFont(new Font("Monospaced", Font.PLAIN, 12));
		write("Welcome to Monopoly!");
		setBackground(java.awt.Color.BLUE);
		setSize(size);
		text.setSize(size);
	}

	public static void write(String str) {
		if (str.length() > 0 && str.charAt(str.length() - 1) == '\n')
			text.append(str);
		else
			text.append(str + '\n');
	}
}
