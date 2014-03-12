/**
 * 
 */
package com.pascalstechtips.zal.world;

import java.awt.image.BufferedImage;

import com.pascalstechtips.zal.Controller;
import com.pascalstechtips.zal.Game;
import com.pascalstechtips.zal.gfx.Textures;
import com.pascalstechtips.zal.libs.Identities;
import com.pascalstechtips.zal.libs.Images;
import com.pascalstechtips.zal.objects.Block;


public class Level {

	private BufferedImage image;
	private Controller controller = Game.getInstance().getController();
	private Textures tex = Game.getInstance().getTextureHandler();
	
	
	public Level(int levelNumber){
		switch (levelNumber) {
		case 1:
			image = Images.level1_1;
			break;

		default:
			image = Images.level1_1;
			break;
		}
	}
	
	
	public void loadLevel(){
		
		
		int w = image.getWidth();
		int h = image.getHeight();
		
		for(int x = 0; x < w; x++){
			for(int y = 0; y < h; y++){
				int pixel = image.getRGB(x, y);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 255 && green == 255 && blue == 255)
					controller.addObject(new Block(x *32, y*32, Identities.BLOCK_DIRT, tex.blockDirt));
				else{
					if(red == 255)
						controller.addObject(new Block(x *32, y*32, Identities.BLOCK_GRASS, tex.blockGrass));
					if(red == 200)
						controller.addObject(new Block(x * 32, y *32, Identities.BLOCK_Barrier, tex.blockBarrier));
					if(red == 100)
						controller.addObject(new Block(x * 32, y *32, Identities.BLOCK_WOOD_RIGHTOPEN, tex.blockWoodRightOpen));
					if(red == 101)
						controller.addObject(new Block(x * 32, y *32, Identities.BLOCK_WOOD_OPEN, tex.blockWoodOpen));
					if(red == 102)
						controller.addObject(new Block(x * 32, y *32, Identities.BLOCK_WOOD_LEFTOPEN, tex.blockWoodLeftOpen));
				}
			}
		}
		
	}
}
