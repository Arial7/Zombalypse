/**
 * 
 */
package com.pascalstechtips.zal.utils;

import java.io.IOException;

import com.pascalstechtips.zal.libs.Images;


public class ResourceLoader {

	private static BufferedImageLoader imageLoader = new BufferedImageLoader();
	
	public static void preLoad(){
		try{
			Images.splashscreen = imageLoader.loadImage("splashscreen.png");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void loadImages(){
		
		try{
			Images.title = imageLoader.loadImage("title.png");
			
			//Blöcke
			Images.blocksSprite = imageLoader.loadImage("blocks.png");
			//Images.playerSprite = imageLoader.loadImage("character.png");
			
			//Spieler
			Images.characterRightStanding = imageLoader.loadImage("Character/Ritter-rechts-1.png");
			Images.characterRight1 = imageLoader.loadImage("Character/Ritter-rechts-12.png");
			Images.characterRight2= imageLoader.loadImage("Character/Ritter-rechts-13.png");
			
			Images.characterLeftStanding = imageLoader.loadImage("Character/Ritter-links-1.png");
			Images.characterLeft1 = imageLoader.loadImage("Character/Ritter-links-12.png");
			Images.characterLeft2= imageLoader.loadImage("Character/Ritter-links-13.png");
			
			
			
			//Levels 
			Images.level1_1 = imageLoader.loadImage("levels/1-1.png");
			
			
		}catch(IOException e){
			
			e.printStackTrace();
			
		}
	}
	
	public static void loadFonts(){
		Fonts.addFont(new Fonts("font1.ttf"));
	}
	
	public static void loadSounds(){
		AudioPlayer.addSound(Audio.SOUND_SWORDDRAW, "sworddraw.ogg");
		
		AudioPlayer.addMusic(Audio.MUSIC_BACKGROUND1, "background1.ogg");
	}
}
