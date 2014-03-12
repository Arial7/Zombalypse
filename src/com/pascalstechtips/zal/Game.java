/** Copyright 2014 PascalsTechTips (Pascal Riesinger)
 * 
 */
package com.pascalstechtips.zal;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import org.lwjgl.openal.AL;

import com.pascalstechtips.zal.entity.Player;
import com.pascalstechtips.zal.enums.GameState;
import com.pascalstechtips.zal.gfx.Renderer;
import com.pascalstechtips.zal.gfx.Textures;
import com.pascalstechtips.zal.input.KeyInput;
import com.pascalstechtips.zal.input.MouseInput;
import com.pascalstechtips.zal.libs.Identities;
import com.pascalstechtips.zal.screens.GameOver;
import com.pascalstechtips.zal.screens.LoadScreen;
import com.pascalstechtips.zal.screens.Menu;
import com.pascalstechtips.zal.utils.Audio;
import com.pascalstechtips.zal.utils.AudioPlayer;
import com.pascalstechtips.zal.utils.ResourceLoader;
import com.pascalstechtips.zal.utils.files.TextFile;
import com.pascalstechtips.zal.world.Level;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = -5632632721679479906L;

	
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 4 * 3;
	public static final String TITLE = "Zobalypse";
	private static Game game = new Game();
	public static GameState state = GameState.LOADING;

	private boolean running = false;
	private Thread thread;
	private Renderer gfx;
	public Camera camera;
	private Menu menu;
	private GameOver gameOver;

	public Controller controller = new Controller();
	public Textures tex;
	
	public Level level1_1;
	
	private int time = 75;
	private int counter = 0;

	public static Game getInstance() {
		return game;
	}

	public Menu getMenu() {
		return menu;
	}
	
	public GameOver getGameOver(){
		return gameOver;
	}

	public Controller getController() {
		return controller;

	}
	
	public Camera getCamera(){
		return camera;
	}
	
	public Textures getTextureHandler(){
		return tex;
	}
	

	public void init() {
		ResourceLoader.preLoad();
		TextFile.writeFile("./version.txt", "0.0.0.1");
		System.out.println("Zombalypse - Version:  " + TextFile.readFile("./version.txt"));
	}
	
	private void load(){
		switch(counter){
			case 0:
				ResourceLoader.loadImages();
				counter ++;
				LoadScreen.loadMore();
				return;
			case 1:
				ResourceLoader.loadFonts();
				counter ++;
				LoadScreen.loadMore();
				return;
			case 2:
				ResourceLoader.loadSounds();
				counter ++;
				LoadScreen.loadMore();
				return;
			case 3:
				tex = new Textures();
				counter ++;
				LoadScreen.loadMore();
				return;
			case 4:
				menu = new Menu();
				gameOver = new GameOver();
				counter ++;
				LoadScreen.loadMore();
				return;
			case 5:
				gfx = new Renderer();
				counter ++;
				LoadScreen.loadMore();
				return;
			case 6:
				MouseInput mouse = new MouseInput();
				this.addMouseListener(mouse);
				this.addMouseMotionListener(mouse);
				
				level1_1 = new Level(1);
				counter ++;
				LoadScreen.loadMore();
				return;
			case 7:
				controller.addObject(new Player(448, Game.HEIGHT - 220, Identities.PLAYER, tex));
				initCamera();
				this.addKeyListener(new KeyInput());
				counter ++;
				LoadScreen.loadMore();
				return;
			case 8:
				counter ++;
				LoadScreen.loadMore();
				state = GameState.MENU;
				AudioPlayer.playMusic(Audio.MUSIC_BACKGROUND1);
				return;
				
		}
		

	}
	public void initCamera(){
		camera = new Camera(0,0);
	}

	public static void checkGameover(float y){
		if(y > Game.HEIGHT){
			state = GameState.GAMEOVER;
			Camera camera = Game.getInstance().getCamera();
			camera.tick();
		}
	}
	public void tick() {
		if(state == GameState.LOADING){
			time --;
			if(time <= 0){
				load();
				time = 25;
			}
		}
		if (state == GameState.GAME) {
			
			controller.tick();
			camera.tick();
		}
		
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(new Color(20, 20, 20));
		g.fillRect(0, 0, WIDTH, HEIGHT);

		
		//////
		
		if(state == GameState.LOADING){
			LoadScreen.render(g);
		}
		else{
		gfx.renderBackground(g);
		g2d.translate(camera.getX(), camera.getY());
		gfx.renderForeground(g);
		g2d.translate(-camera.getX(), -camera.getY());
		}
		
		//////
		
		
		g.dispose();
		bs.show();
	}

	private synchronized void start() {
		if (running)
			return;
		else
			running = true;
		thread = new Thread(this);
		thread.start();
	}

	private synchronized void stop() {
		if (!running)
			return;
		else
			running = false;
		
		cleanup();
		System.exit(1);
	}

	private void cleanup(){
		AL.destroy();
	}
	
	public static void exit(){
		game.stop();
	}
	
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000 / numTicks;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();

		while (running) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;

			if (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(ticks + " Ticks, FPS: " + frames);
				
				ticks = 0;
				frames = 0;

			}
		}
		stop();
	}

	public static void main(String args[]) {
		Window.initWindow(TITLE);
		Window.addGame(game);
		Window.createWindow();
		game.start();

	}

}
