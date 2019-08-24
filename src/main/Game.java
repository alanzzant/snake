package main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import shared.Shared;

public class Game extends Canvas {
	private static final long serialVersionUID = 1L;
	private boolean running = true;
	
	public Game() {
		setIgnoreRepaint(true);
		addKeyListener(Shared.keyboard);
		setPreferredSize(new Dimension(Shared.WIDTH, Shared.HEIGHT));
		setFocusable(true);
		requestFocus();
		
		new Window(Shared.WIDTH, Shared.HEIGHT, this);
		
		setup();
	}
	
	private void setup() {
		loop();
	}
	
	private void loop() {
		long lastTime = System.nanoTime();
        double amountOfTicks = 15.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1) {
                update();
                delta--;
            }
            
            if(running) {
            	draw();
            	frames++;            	
            }
            
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
	}
	
	private void update() {
		Shared.stateManager.update();
		Shared.stateManager.actualState.update();
	}
	
	private void draw() {
		BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }
        
        Graphics2D g = (Graphics2D) bs.getDrawGraphics();
        
        Shared.stateManager.actualState.draw(g);
        
        g.dispose();
        bs.show();
	}
}
