// (c) 2013 Marian Longa

package TicTacToe;

import java.awt.*;

public class Field {
	
	private int x, y, width, height, player;
	private Color color;
	
	public Field(int x, int y, int width, int height) {
		player = 0; // empty field
		color = Color.gray;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Field(int x, int y) {
		player = 0; // empty field
		color = Color.gray;
		this.x = x;
		this.y = y;
		this.width = 30;
		this.height = 30;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawRect(x, y, width, height);
		if (this.player == 1) {
			g.setColor(new Color(150, 150, 255));
			g.fillOval(x+4, y+4, width-8, height-8);
		}
		if (this.player == 2) {
			g.setColor(new Color(255, 150, 150));
			g.fillOval(x+4, y+4, width-8, height-8);
		}
	}
	
	public void setPlayer(int player) {
		this.player = player;
	}
	
	public int getPlayer() {
		return this.player;
	}
	
	public boolean isInside(int x, int y) {
		if (
				x >= this.x &&
				x <= this.x + this.width &&
				y >= this.y &&
				y <= this.y + this.height
			) return true;
		return false;
	}

}
