package gui.actions;

import input.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ActionListener;

public class BeginTurn implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		start.Startup.passingTurn = false;
		//Current player referenced from start.Startup.currentPlayer
		Player usr = start.Startup.currentPlayer;

		if (usr.jailed) {
			gui.LogPanel.write(usr.name + " was in jail. They are now free.\n");
			usr.jailed = false;
		}
		else {
			int roll = input.Player.rollDice(2);
			String toLog = "Moved " + usr.name + " from " + usr.pos.name + " to ";
			for (int i = 0; i < roll; i++) {
				usr.pos = usr.pos.next;
				usr.pos.pass(usr);
			}
			toLog = toLog + usr.pos.name + '\n';

			gui.LogPanel.write(toLog);

			usr.pos.land(usr);
		}

		start.Startup.nextTurn();
	}
}
