// (c) 2013 Marian Longa

package TicTacToe;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Main 
	extends Applet 
	implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	
	int width, height, // applet size
		player; // player id
	Board board;
	boolean theEnd;
	
	// Initialization
	public void init() {
		// Initial settings
		width = getSize().width;
		height = getSize().height;
		setBackground(Color.white);
		
		// Mouse listeners
		addMouseListener(this);
		addMouseMotionListener(this);
		
		System.out.println("Welcome!");
		
		theEnd = false;
		player = 1;
		
		// Generate a board
		board = new Board();
	
	}
	
	// "Game"
	public void paint(Graphics g) {
		// Frame
		//g.setColor(Color.gray);
		//g.drawRect(0, 0, width, height);
		
		// Title
		g.setColor(Color.black);
		g.drawString("Tic Tac Toe! v.1", 20, 20);
		g.setColor(Color.gray);
		g.drawString("by Marian Longa", 10, 35);
		
		// Draw board
		board.g = g;
		board.draw();
		
		if (theEnd == true) {
			g.setColor(new Color(0, 180, 0));
			g.drawRect(20, 175, 94, 20);
			if (player == 1) g.setColor(Color.blue);
			if (player == 2) g.setColor(Color.red);
			g.drawString("Player " + player + " won!", 25, 190);
		}
		
	}
	
	public void win(int player, Graphics g) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {	
		// Setting the field and game over control
		if (board.setField(e.getX(), e.getY(), player) == true && theEnd == false) {
			if (board.isEnd(player) == true) {
				theEnd = true;
			} else {
				player = 3 - player; // toggle players
			}
		}
		
		repaint();
		e.consume();
		
		// Restart (user clicked the "you win" rectangle)
		// x=20, y=175, w=94, h=20
		if (e.getX() >= 20 && 
			e.getX() <= 20+94 && 
			e.getY() >= 175 && 
			e.getY() <= 175+20) this.init();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
