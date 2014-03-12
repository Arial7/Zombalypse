/**
 * 
 */
package com.pascalstechtips.zal;

import java.awt.Graphics;
import java.util.ArrayList;

import com.pascalstechtips.zal.core.CoreObject;


public class Controller {

	private ArrayList<CoreObject> objects = new ArrayList<CoreObject>();
	
	
	public void tick(){
		for(CoreObject obj : objects){
			obj.tick();
		}
	}
	
	public void render(Graphics g){
		for(CoreObject obj : objects){
			obj.render(g);
		}
	}
	
	public  void addObject(CoreObject instance){
		objects.add(instance);
		
	}
	public  void removeObject(CoreObject instance){
		objects.remove(instance);
	}
	public  ArrayList<CoreObject> getObjects(){
		return objects;
	}
}
