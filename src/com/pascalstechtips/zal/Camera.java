/**
 * 
 */
package com.pascalstechtips.zal;

import com.pascalstechtips.zal.core.CoreObject;
import com.pascalstechtips.zal.entity.Player;
import com.pascalstechtips.zal.enums.GameState;
import com.pascalstechtips.zal.libs.Identities;


public class Camera {
	private float x, y;
	private  Player player;
	
	public Camera(float x, float y){
		this.x = x;
		this.y = y;
		for(CoreObject obj:Game.getInstance().getController().getObjects())
			if(obj.getId() == Identities.PLAYER)
				player = (Player)obj;
	}
	
	public void tick(){
		if (Game.state == GameState.GAME)
			x += ((-player.getX() + Game.WIDTH / 2) - x) * 0.045f;
		
		else
			x = 0;
	}
	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	
	
	
}
