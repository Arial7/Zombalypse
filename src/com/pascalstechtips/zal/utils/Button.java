/**
 * 
 */
package com.pascalstechtips.zal.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.pascalstechtips.zal.input.MouseInput;


@SuppressWarnings("serial")
public class Button extends Rectangle {
 
    private String text;
    
	
	

	/**
	 * @param width
	 * @param height
	 */
	public Button(int width, int height) {
		super(width, height);
		
	}

	
	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	public Button setText(String text){
		this.text = text;
		return this;
	}
	public void drawButton(Graphics g, int offset){
		int xx = x + offset;
		int yy = y + 38;
		
		if(MouseInput.MOUSE.intersects(this) && MouseInput.MOUSE != null){
			g.setColor(Color.ORANGE);
		}else
			g.setColor(Color.WHITE);
		
		if(!MouseInput.pressed && MouseInput.MOUSE.intersects(this)){
			g.drawRect(x, y, width, height);
		}else if(MouseInput.pressed && MouseInput.MOUSE.intersects(this)){
			g.fillRect(x, y, width, height);
		}
		
		g.setColor(Color.RED);
		g.drawString(text, xx, yy);
	}
}
