/**
 * 
 */
package com.pascalstechtips.zal;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.pascalstechtips.zal.libs.Reference;

/**
 * @author Pascal
 * 
 */
public class Window {
	private static JFrame frame;
	

	public static void initWindow(String title) {
		frame = new JFrame(title);

	}

	public static void addGame(Game game){
		frame.add(game);
	}
	public static void createWindow() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image icon = toolkit.getImage(Reference.RESOURCE_LOCATION + "icon.png");
		Image cursor = toolkit.getImage(Reference.RESOURCE_LOCATION+ "cursor.gif");
		frame.setIconImage(icon);
		frame.setCursor(toolkit.createCustomCursor(cursor,new Point(frame.getX(), frame.getY()), "cursor"));
		frame.setSize(Game.WIDTH, Game.HEIGHT);
		frame.addWindowListener(
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						Game.exit();
					}
				}
				);
		
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
	}
	public static void setTitle (String title){
		frame.setTitle(title);
	}
}
