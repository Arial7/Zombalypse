/**
 * 
 */
package com.pascalstechtips.zal.input;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.pascalstechtips.zal.Controller;
import com.pascalstechtips.zal.Game;
import com.pascalstechtips.zal.entity.Player;
import com.pascalstechtips.zal.enums.GameState;
import com.pascalstechtips.zal.gfx.Textures;
import com.pascalstechtips.zal.libs.Identities;
import com.pascalstechtips.zal.screens.GameOver;
import com.pascalstechtips.zal.screens.Menu;
import com.pascalstechtips.zal.utils.Audio;
import com.pascalstechtips.zal.utils.AudioPlayer;

public class MouseInput extends MouseAdapter {

	public static boolean pressed = false;
	public static int MOUSE_X;
	public static int MOUSE_Y;
    public static Rectangle MOUSE = new Rectangle (1,1,1,1);
    private Menu menu = Game.getInstance().getMenu();
    private GameOver gameOver = Game.getInstance().getGameOver();
    
	@Override
	public void mouseClicked(MouseEvent e) {

		int mouse = e.getButton();
		Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1);
		
		if (mouse == MouseEvent.BUTTON1) {
			switch (Game.state) {
			case GAME:
				break;
			case MENU:
				if (rect.intersects(menu.play)) {
					AudioPlayer.playSound(Audio.SOUND_SWORDDRAW);
					Game.getInstance().level1_1.loadLevel();
					Game.state = GameState.GAME;
				}else if (rect.intersects(menu.options)) {
					AudioPlayer.playSound(Audio.SOUND_SWORDDRAW);
					Game.state = GameState.OPTIONS;
				}
				break;
			case PAUSE:
				break;
			case GAMEOVER:
				if (rect.intersects(gameOver.retry)) {
					AudioPlayer.playSound(Audio.SOUND_SWORDDRAW);
					
					Game.getInstance().level1_1.loadLevel();
					Game game = Game.getInstance();
					Controller controller = Game.getInstance().getController();
					Textures tex = Game.getInstance().getTextureHandler();
					controller.addObject(new Player(448, Game.HEIGHT - 220, Identities.PLAYER, tex));
					game.initCamera();
					Game.state = GameState.GAME;
				}
				break;
			default:
				break;

			}

		}

	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		pressed = true;
		MOUSE = new Rectangle (e.getX(), e.getY(), 1, 1);
		if(Game.state == GameState.MENU || Game.state == GameState.GAMEOVER){
			if(MOUSE.intersects(menu.quit)|| MOUSE.intersects(gameOver.quit)){
				AudioPlayer.playSound(Audio.SOUND_SWORDDRAW);
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		pressed = false;
		
		MOUSE = new Rectangle (e.getX(), e.getY(), 1, 1);
		if(Game.state == GameState.MENU || Game.state == GameState.GAMEOVER){
			if(MOUSE.intersects(menu.quit) || MOUSE.intersects(gameOver.quit)){
				Game.exit();
			}
		}
	}
	
	
	@Override
	public void mouseMoved(MouseEvent e) {
		MOUSE_X = e.getX();
		MOUSE_Y = e.getY();

		MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
		 switch (Game.state) {
         case GAME:
             break;
         case MENU:
             if ((MOUSE.intersects(menu.play)           //Only do this if the mouse is hovering over a button and the sound has not already played
                     || MOUSE.intersects(menu.options)
                     || MOUSE.intersects(menu.quit))
                     && !AudioPlayer.hasPlayedHover) {
                 
                 AudioPlayer.playSound(Audio.SOUND_SWORDDRAW);
                 AudioPlayer.hasPlayedHover = true;  //The sound has played, so lets set it to true
                 
             }else if(!(MOUSE.intersects(menu.play)    //If the mouse is not hovering over a button, then reset the boolean to false
                     || MOUSE.intersects(menu.options)
                     || MOUSE.intersects(menu.quit))
                     && AudioPlayer.hasPlayedHover){
                 
                 AudioPlayer.hasPlayedHover = false;
             }
             break;
         case OPTIONS:
             break;
         case PAUSE:
             break;
         case GAMEOVER:
        	  if ((MOUSE.intersects(gameOver.retry)           //Only do this if the mouse is hovering over a button and the sound has not already played
                      || MOUSE.intersects(gameOver.quit)
                       && !AudioPlayer.hasPlayedHover)) {
                  
                  AudioPlayer.playSound(Audio.SOUND_SWORDDRAW);
                  AudioPlayer.hasPlayedHover = true;  //The sound has played, so lets set it to true
                  
              }else if(!(MOUSE.intersects(gameOver.retry)           //Only do this if the mouse is hovering over a button and the sound has not already played
                      || MOUSE.intersects(gameOver.quit)
                      && AudioPlayer.hasPlayedHover)){
                  
                  AudioPlayer.hasPlayedHover = false;
              }
        	 break;
         default:
             break;

     }
	}
}