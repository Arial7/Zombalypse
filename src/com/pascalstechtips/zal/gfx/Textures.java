/**
 * 
 */
package com.pascalstechtips.zal.gfx;

import java.awt.image.BufferedImage;

import com.pascalstechtips.zal.libs.Images;
import com.pascalstechtips.zal.utils.SpriteSheet;

/**
 * @author Pascal
 * 
 */
public class Textures {

	private SpriteSheet blockSheet;
	
	public BufferedImage playerR = Images.characterRightStanding;
	
	public BufferedImage playerL =Images.characterLeftStanding;
	public static BufferedImage playerRight[] = new BufferedImage[2];
	public static BufferedImage playerLeft[] = new BufferedImage[2];
	
	
	//Blöcke
	public  BufferedImage blockDirt;
	public BufferedImage blockGrass;
	public  BufferedImage blockWater;
	public BufferedImage blockLava;
	public BufferedImage blockWoodRightOpen;
	public BufferedImage blockWoodLeftOpen;
	public BufferedImage blockWoodOpen;
	
	
	public BufferedImage blockBarrier;

	public Textures() {
		blockSheet = new SpriteSheet(Images.blocksSprite, 32);
		
		
		initTextures();
	}

	private void initTextures() {
		
		
		
		//Blöcke
		blockGrass = blockSheet.getSprite(1, 1);
		blockDirt = blockSheet.getSprite(2, 1);
		blockWater = blockSheet.getSprite(3,1);
		blockLava = blockSheet.getSprite(4,1);
		blockWoodRightOpen = blockSheet.getSprite(5,1);
		blockWoodLeftOpen = blockSheet.getSprite(6,1);
		blockWoodOpen = blockSheet.getSprite(7,1);
		
		
		blockBarrier = blockSheet.getSprite(8,8);
		
		
		//Spieler
		playerRight[0] = Images.characterRight1;
		playerRight[1] = Images.characterRight2;
		
		playerLeft[0] = Images.characterLeft1;
		playerLeft[1] = Images.characterLeft2;
		
		
		
		
		
		
		
	}
}
