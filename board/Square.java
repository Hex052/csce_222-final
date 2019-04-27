package board;

import javax.swing.JOptionPane;

public class Square {
	public Square next, prev;
	public String name;
	public int on_land, on_pass;
	public Boolean is_gotojail = null; //true if gotojail, false if jail, null otherwise
	public Square(String name, Square n, Square p) {
		this.name = name;
		next = n;
		prev = p;
	}
	public Square(String name, Square n, Square p, int onland, int onpass) {
		this.name = name;
		next = n;
		prev = p;
		on_land = onland;
		on_pass = onpass;
	}
	public Square(String name, Square n, Square p, boolean is_gotojail) {
		this.name = name;
		next = n;
		prev = p;
		this.is_gotojail = is_gotojail;
	}
	public void land(input.Player usr) {
		usr.updateDisplayedPos();
		if (is_gotojail != null && is_gotojail) {
			JOptionPane.showMessageDialog(gui.MainFrame.frame, "Go Directly to Jail. Do not pass GO. Do not collect $200.", "Go To Jail", JOptionPane.INFORMATION_MESSAGE);
			gui.LogPanel.write(usr.name + " was sent to Jail.");
			for (int i = 0; i < 20; i++) /*Move 20 squares to jail without passing any*/ {
				usr.pos = usr.pos.next;
			}
			usr.jailed = true;
			usr.updateDisplayedPos(); //Again after being moved to jail
		}
		else if (on_land > 0)
			usr.deposit(on_land);
		else if (on_land < 0)
			usr.charge(-on_land);
	}
	//! Pass should be called before land
	public void pass(input.Player usr) {
		if (on_pass > 0)
			usr.deposit(on_pass);
		else if (on_pass < 0)
			usr.charge(-on_pass);
	}
	public String toString() {
		return "Square \'" + name + "\' is_gotojail=" + is_gotojail + " on_land=" + on_land + " on_pass=" + on_pass;
	}
}
