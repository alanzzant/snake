package shared;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import controls.Keyboard;
import entities.Food;
import entities.Snake;
import state.StateManager;

public class Shared {
	public static Keyboard keyboard;
	public static StateManager stateManager;
	
	public static Snake snake;
	public static Food food;
	public static boolean snakeDidLose = false;
	
	public final static int GRID_SIZE = 20;
	public final static int WIDTH = 640;
	public final static int HEIGHT = 480;
	public final static Rectangle windowArea = new Rectangle(-GRID_SIZE, 0, WIDTH + 2*GRID_SIZE, HEIGHT + GRID_SIZE);
	
	public final static Color commonColor = new Color(30, 30, 30);
	public final static Color bgColor = new Color(132, 163, 82);
	public final static Color alternativeColor = new Color(20, 20, 20);
	
	public final static Font boldFont = new Font("Arial", Font.BOLD, 30);
	public final static Font commonFont = new Font("Arial", Font.PLAIN, 30);
	public final static Font titleFont = new Font("default", Font.BOLD, 100);
	
	public static void restartValues() {
		snake = new Snake(0, 0, commonColor);
		food = new Food(commonColor);
		snakeDidLose = false;
	}
}
