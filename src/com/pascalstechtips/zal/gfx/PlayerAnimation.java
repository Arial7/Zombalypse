/**
 * 
 */
package com.pascalstechtips.zal.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PlayerAnimation {

	private int count = 0;
	private int index = 0;
	private int speed;
	private int frames;
	
	int k = 0;

	private BufferedImage currentImage;
	private BufferedImage anime[];

	public PlayerAnimation(int speed, BufferedImage anime[]) {
		this.speed = speed;
		this.anime = anime;
		this.frames = anime.length;

	}

	public void runAnimation() {
		index++;
		if (index > speed) {
			index = 0;
			nextFrame2();
		}
	}

	public void nextFrame() {
		for (int k = 0; k < frames; k++) {
			if (count == k)
				currentImage = anime[k];
			count++;
			if (count > frames)
				count = 0;
		}
	}
	
	
	
	public void nextFrame2() {
		k++;
		if (k < 2)
			currentImage = anime[0];
		if (k >= 2){
			currentImage = anime[1];
			k = 0;
		}
		
		/*
		for (int k = 0; k < frames; k++) {
			if (count == k)
				currentImage = anime[k];
			count++;
			if (count > frames)
				count = 0;
				
		}
		
		*/
	}

	public void drawAnimation(Graphics g, float x, float y){
		g.drawImage(currentImage, (int) x, (int)y,null);
	}
	
	
	}
	
