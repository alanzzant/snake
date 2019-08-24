package controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	private boolean active;
	public int activeKey;
	
	public Keyboard() {
		active = false;
	}

	@Override
	public void keyPressed(KeyEvent ev) {
		active = true;
		this.activeKey = ev.getKeyCode();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		active = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	public boolean isActive() {
		return active;
	}
}
