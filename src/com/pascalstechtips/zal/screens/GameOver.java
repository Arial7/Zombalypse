/**
 * 
 */
package com.pascalstechtips.zal.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.pascalstechtips.zal.Game;
import com.pascalstechtips.zal.utils.Button;

public class GameOver {

	public Button retry, quit;

	public GameOver() {
		

		retry = new Button(0, 350, 200, 50).setText("Retry");

		quit = new Button(0, 350, 200, 50).setText("Quit");

	}

	public void drawButton(Graphics g, Rectangle rect, String text, int offsetX) {
		Font gameOverFont = new Font("Baby Kruffy", Font.PLAIN, 40);
		g.setFont(gameOverFont);

		g.drawRect(rect.x, rect.y, rect.width, rect.height);
		g.drawString(text, rect.x + offsetX, rect.y + 40);
	}

	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, Game.WIDTH , Game.HEIGHT);

		Font gameOverFont = new Font("Baby Kruffy", Font.PLAIN, 40);
		g.setFont(gameOverFont);
		
		g.setColor(Color.RED);
		g.drawString("You failed",220, 150);
		
		retry.x = 50;
		quit.x  = 400;
		
		retry.drawButton(g, 40);

		quit.drawButton(g, 65);

	}

}
