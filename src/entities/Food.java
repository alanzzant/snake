package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import shared.Shared;

public class Food {
	private Random random = new Random();
	private int x, y;
	private int previousX, previousY;
	private final int GRID_SIZE = Shared.GRID_SIZE;
	private final int WINDOW_WIDTH = Shared.WIDTH;
	private final int WINDOW_HEIGHT = Shared.HEIGHT;
	private final Color color;
	private Rectangle area;
	
	public Food(Color color) {
		this.color = color;
		
		generate();
	}
	
	public void generate() {
		previousX = x;
		previousY = y;
		
		x = random.nextInt(WINDOW_WIDTH / GRID_SIZE) * GRID_SIZE;
		y = random.nextInt(WINDOW_HEIGHT / GRID_SIZE) * GRID_SIZE;
		
		while(x == previousX && y == previousY) {
			x = random.nextInt(WINDOW_WIDTH / GRID_SIZE) * GRID_SIZE;
			y = random.nextInt(WINDOW_HEIGHT / GRID_SIZE) * GRID_SIZE;
		}
		
		if(x > WINDOW_WIDTH)
			x = WINDOW_WIDTH - GRID_SIZE;
		if(y > WINDOW_HEIGHT)
			y = WINDOW_HEIGHT - WINDOW_HEIGHT;
		
		area = new Rectangle(x, y, GRID_SIZE, GRID_SIZE);
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, GRID_SIZE, GRID_SIZE);
	}
	
	public Rectangle getArea() {
		return area;
	}
}
