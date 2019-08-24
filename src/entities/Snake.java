package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import shared.Shared;

public class Snake {
	private List<Integer[]> body = new ArrayList<Integer[]>();
	private int v = 1;
	private int dx = 0;
	private int dy = v;
	private final int GRID_SIZE = Shared.GRID_SIZE;
	private final Color color;
	private Rectangle headArea;
	public boolean headCollidedBody = false;
	
	public Snake(int x, int y, Color color) {
		body.add(new Integer[]{x, y});
		this.color = color;
		headArea = new Rectangle(x, y, GRID_SIZE, GRID_SIZE);
	}
	
	public void update() {
		for(int i = body.size() - 1; i > 0; i--) {
			body.get(i)[0] = body.get(i - 1)[0];
			body.get(i)[1] = body.get(i - 1)[1];
		}
		
		body.get(0)[0] += dx * GRID_SIZE;
		body.get(0)[1] += dy * GRID_SIZE;
		
		headArea = new Rectangle(body.get(0)[0], body.get(0)[1], GRID_SIZE, GRID_SIZE);
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		
		body.forEach(piece -> {
			g.fillRect(piece[0], piece[1], GRID_SIZE, GRID_SIZE);			
		});
	}
	
	public void handleKeyboard(int key) {
		switch(key) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_W:
				dx = 0;
				dy = -v;
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_S:
				dx = 0;
				dy = v;
				break;
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_D:
				dx = v;
				dy = 0;
				break;
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_A:
				dx = -v;
				dy = 0;
				break;
		}
	}
	
	public void growUp() {
		int previousPieceX = body.get(body.size() - 1)[0];
		int previousPieceY = body.get(body.size() - 1)[1];
		body.add(new Integer[]{previousPieceX, previousPieceY});
	}
	
	public boolean headCollidedBody() {
		boolean collision = false;
		
		if(body.size() > 1) {
			for(int i = 1; i < body.size(); i++) {
				if(body.get(0)[0] + dx * GRID_SIZE == body.get(i)[0]) {
					if(body.get(0)[1] + dy * GRID_SIZE == body.get(i)[1]) {
						collision = true;
					}
				}
			}			
		}
		
		return collision;
	}
	
	public boolean collidedWith(Rectangle r) {
		boolean collision = false;
		
		if(headArea.intersects(r)) {
			collision = true;
		}
		
		return collision;
	}
}
