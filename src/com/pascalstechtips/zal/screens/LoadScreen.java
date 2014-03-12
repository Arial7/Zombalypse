/**
 * 
 */
package com.pascalstechtips.zal.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.pascalstechtips.zal.Game;
import com.pascalstechtips.zal.libs.Images;




public class LoadScreen {
	private static int width = 540;
	private static int numResources = 8;
	private static int loadAdd = width / numResources;
	private static int loadStatus = 0;
	
	private static String msg = "Loading resources...";
	
	public static void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.splashscreen,120,0,null);
		g.setColor(Color.RED);
		g.drawRect(49,199,width + 1,51);
		g.setFont(new Font("Arial", Font.PLAIN,18));
		g.drawString(msg, 51, 195);
		g.setColor(Color.WHITE);
		g.fillRect(50, 200, loadStatus, 50);
		
	}
	
	public static void loadMore(){
		loadStatus += loadAdd;
	}
	
	public static void setMessage(String msg){
		LoadScreen.msg = msg;
	}
	
	
}
