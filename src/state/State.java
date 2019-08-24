package state;

import java.awt.Graphics;

public interface State {
	public void update();
	public void draw(Graphics g);
}
