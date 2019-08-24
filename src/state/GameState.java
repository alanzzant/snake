package state;

import java.awt.Graphics;

import shared.Shared;

public class GameState implements State {
	public GameState() {
		Shared.restartValues();	
	}
	
	@Override
	public void update() {
		
		Shared.snake.update();
		if(Shared.keyboard.isActive()) {
			Shared.snake.handleKeyboard(Shared.keyboard.activeKey);
		}
		
		if(Shared.snake.collidedWith(Shared.food.getArea())) {
			Shared.food.generate();
			Shared.snake.growUp();
		}
		
		if(Shared.snake.headCollidedBody()) {
			Shared.snakeDidLose = true;
		}
		
		if(!Shared.snake.collidedWith(Shared.windowArea)) {
			Shared.snakeDidLose = true;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Shared.bgColor);
        g.fillRect(0, 0, Shared.WIDTH, Shared.HEIGHT);
		
		Shared.snake.draw(g);
        Shared.food.draw(g);
        
        if(Shared.snakeDidLose) {
            Shared.stateManager.actualState = Shared.stateManager.states[1];
            Shared.restartValues();
        }
	}
}
