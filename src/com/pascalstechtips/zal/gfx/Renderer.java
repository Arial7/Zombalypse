/**
 * 
 */
package com.pascalstechtips.zal.gfx;

import java.awt.Color;
import java.awt.Graphics;

import com.pascalstechtips.zal.Game;


public class Renderer {

	//private static Game game = Game.getInstance();
	
	
	
	public void renderBackground(Graphics g){
		switch(Game.state){
		case GAME:
			break;
		case MENU:
			Game.getInstance().getMenu().render(g);
			break;
		case PAUSE:
			break;
		case OPTIONS:
			break;
		case GAMEOVER:		
			break;
		default:
			g.setColor(Color.RED);
			g.drawString("UNKNOWN GAMESTATE",150,150 );
			break;
		
		}
		
	}
	
	public void renderForeground(Graphics g){
		
		switch(Game.state){
		case GAME:
			Game.getInstance().getController().render(g);
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		case GAMEOVER:
			Game.getInstance().getGameOver().render(g);
			/*g.setColor(Color.GREEN);
			g.fillRect(10, 10, 9000, Game.HEIGHT -50);
			g.setColor(Color.RED);
			Font lostFont = new Font("Baby Kruffy", Font.PLAIN, 40 );
			g.setFont(lostFont);
			g.drawString("YOU LOST!",(int)Reference.PlayerX - 100, Reference.CENTER_Y);
			*/break;
		default:
			g.setColor(Color.RED);
			g.drawString("UNKNOWN GAMESTATE",150,150 );
			break;
		
		}
	}

}
