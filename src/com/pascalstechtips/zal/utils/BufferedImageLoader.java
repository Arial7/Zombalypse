/**
 * 
 */
package com.pascalstechtips.zal.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.pascalstechtips.zal.libs.Reference;
import com.pascalstechtips.zal.screens.LoadScreen;


public class BufferedImageLoader {
  
	private BufferedImage image;
	
	public BufferedImage loadImage(String imagePath) throws IOException{
		LoadScreen.setMessage("Loading textures from:  " + Reference.SPRITE_LOCATION);
		image = ImageIO.read(new File(Reference.SPRITE_LOCATION + imagePath));
		return image;
	}
}
