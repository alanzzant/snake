package main;

import controls.Keyboard;
import shared.Shared;
import state.StateManager;

public class Main {
	public static void main(String[] args) {
		Shared.keyboard = new Keyboard();
		Shared.stateManager = new StateManager(1);
		new Game();
	}
}
