/**
 * 
 */
package com.pascalstechtips.zal.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;


import com.pascalstechtips.zal.Game;
import com.pascalstechtips.zal.libs.Images;
import com.pascalstechtips.zal.libs.Reference;
import com.pascalstechtips.zal.utils.Button;


public class Menu {
    
	public  Button play, options, quit;
	
	
	
	
	public Menu(){
		int fillerY = 150;
		
		play = new Button(Reference.CENTER_X -100, fillerY, 200, 50).setText("Play");
		options = new Button(Reference.CENTER_X -100, fillerY += 60, 200, 50).setText("Options");
		quit = new Button(Reference.CENTER_X -100, fillerY += 60, 200, 50).setText("Quit");
		
	
		
	}
	public void drawButton(Graphics g, Rectangle rect, String text, int offsetX){
		Font menuFont = new Font("Baby Kruffy", Font.PLAIN, 40 );
		g.setFont(menuFont);
		
		g.drawRect(rect.x, rect.y, rect.width, rect.height);
		g.drawString(text, rect.x + offsetX, rect.y + 40);
	}
	
	
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.title, 60, 0, null);
		
		Font menuFont = new Font("Baby Kruffy", Font.PLAIN, 40 );
		g.setFont(menuFont);
		
		play.drawButton(g,  65);
		options.drawButton(g, 25);
		quit.drawButton(g, 65);
		
		
	}
	

}
