package gui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.JLabel;

public class PlayerIcon extends JLabel {
	private static final long serialVersionUID = 42l;

	private Image icon;
	public input.Player usr;

	public PlayerIcon(input.Player p) {
		usr = p;
		setSize(25,25);
		reloadIcon();
		reposition();
	}
	public void reloadIcon() {
		icon = usr.guiDisp.img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(icon));
	}
	public void reposition() {
		int squareNum = usr.pos.squareNum;
		switch (squareNum / 10) {
			case 0: //Bottom
				setLocation(542 - (50 * (squareNum % 10)) , 581);
				break;
			case 1: //Left
				setLocation(usr.jailed ? 50 : 2, 542 - (50 * (squareNum % 10))); //Special case for being in jail
				break;
			case 2: //Top
				setLocation(50 + (50 * (squareNum % 10)) , 10);
				break;
			case 3: //Right
				setLocation(581, 50 + (50 * (squareNum % 10)));
				break;
		}
	}
}
