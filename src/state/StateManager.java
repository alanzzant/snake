package state;

import java.awt.event.KeyEvent;

import shared.Shared;

public class StateManager {
	public State[] states = new State[] {
		new GameState(),
		new PauseState()
	};
	public State actualState;
	
	public StateManager(int initialState) {
		actualState = states[initialState];
	}
	
	public void update() {
		if(Shared.keyboard.isActive()) {
			if(Shared.keyboard.activeKey == KeyEvent.VK_ESCAPE) {
				actualState = states[1];
			}
		}
	}
}
