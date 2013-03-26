// (c) 2013 Marian Longa

package TicTacToe;

import java.awt.*;

public class Board {
	
	Graphics g;
	
	private Field[][] fields = {
			{ new Field(10, 50), new Field(50, 50), new Field(90, 50) },
			{ new Field(10, 90), new Field(50, 90), new Field(90, 90) },
			{ new Field(10, 130), new Field(50, 130), new Field(90, 130) }
	};
	
	public Board(Graphics g) {
		this.g = g;
	}
	
	public Board() {}
	
	public void draw() { // draw to screen
		for (Field[] row : this.fields) {
			for (Field f : row) {
				f.draw(g);
			}
		}
	}
	
	public boolean setField(int x, int y, int player) { // set clicked field
		for (Field[] row : this.fields) {
			for (Field f : row) {
				if (f.isInside(x, y) == true) {
					if (f.getPlayer() == 0)	{
						f.setPlayer(player);
						return true;
					}
				} 
			}
		}
		return false;
	}
	
	public boolean isEnd(int player) { // if the game is over (staci kontrolovat len playera, ktory bol prave na tahu)
		if (
				(fields[0][0].getPlayer() == player &&
				 fields[1][0].getPlayer() == player &&
				 fields[2][0].getPlayer() == player)
				||
				(fields[0][1].getPlayer() == player &&
				 fields[1][1].getPlayer() == player &&
				 fields[2][1].getPlayer() == player)
				||
				(fields[0][2].getPlayer() == player &&
				 fields[1][2].getPlayer() == player &&
				 fields[2][2].getPlayer() == player)
				||
				(fields[0][0].getPlayer() == player &&
				 fields[0][1].getPlayer() == player &&
				 fields[0][2].getPlayer() == player)
				||
				(fields[1][0].getPlayer() == player &&
				 fields[1][1].getPlayer() == player &&
				 fields[1][2].getPlayer() == player)
				||
				(fields[2][0].getPlayer() == player &&
				 fields[2][1].getPlayer() == player &&
				 fields[2][2].getPlayer() == player)
				||
				(fields[0][0].getPlayer() == player &&
				 fields[1][1].getPlayer() == player &&
				 fields[2][2].getPlayer() == player)
				||
				(fields[0][0].getPlayer() == player &&
				 fields[1][1].getPlayer() == player &&
				 fields[2][2].getPlayer() == player)
				||
				(fields[2][0].getPlayer() == player &&
				 fields[1][1].getPlayer() == player &&
				 fields[0][2].getPlayer() == player)
				
		) return true;
		return false;
	}
	
}
