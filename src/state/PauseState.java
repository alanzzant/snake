package state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import shared.Shared;

public class PauseState implements State {
	private final String[] options;
	private int actualOption = 0;
	private final int initialY = 300;
	private final int initialX = 250;
	
	public PauseState() {
		options = new String[]{
			"Continue",
			"Restart",
			"Exit"
		};
	}
	
	@Override
	public void update() {
		if(Shared.keyboard.isActive()) {
			switch(Shared.keyboard.activeKey) {
				case KeyEvent.VK_UP:
				case KeyEvent.VK_W:
					actualOption--;
					if(actualOption == -1)
						actualOption = options.length - 1;
					break;
				case KeyEvent.VK_DOWN:
				case KeyEvent.VK_S:
					actualOption++;
					if(actualOption == options.length)
						actualOption = 0;
					break;
			}
			
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Shared.bgColor);
        g.fillRect(0, 0, Shared.WIDTH, Shared.HEIGHT);
        
        g.setColor(Shared.alternativeColor);
        g.setFont(Shared.titleFont);
        g.drawString("SNAKE!", 130, 200);
		
		for(int i = 0; i < options.length; i++) {
			if(i == actualOption) {
				g.setColor(Shared.alternativeColor);
				g.setFont(Shared.boldFont);
				g.fillRect(initialX - 20, initialY - 15 + (50 * i), 10, 10);
			} else {
				g.setColor(Shared.commonColor);
				g.setFont(Shared.commonFont);
			}
			
			g.drawString(options[i], initialX, initialY + (50 * i));
		}
		
		if(Shared.keyboard.isActive()) {
			if(Shared.keyboard.activeKey == KeyEvent.VK_ENTER) {
				switch(actualOption) {
					case 0:
						Shared.stateManager.actualState = Shared.stateManager.states[0];
						break;
					case 1:
						Shared.stateManager.actualState = Shared.stateManager.states[0];
						Shared.restartValues();
						break;
					case 2:
						System.exit(0);
						break;
				}
			}
		}
	}
}
