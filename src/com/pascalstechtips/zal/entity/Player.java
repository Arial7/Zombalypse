/**
 * 
 */
package com.pascalstechtips.zal.entity;

import java.awt.Graphics;
import java.util.ArrayList;

import com.pascalstechtips.zal.Game;
import com.pascalstechtips.zal.core.CoreObject;
import com.pascalstechtips.zal.gfx.PlayerAnimation;
import com.pascalstechtips.zal.gfx.Textures;
import com.pascalstechtips.zal.libs.Images;
import com.pascalstechtips.zal.libs.Reference;
import com.pascalstechtips.zal.objects.Block;

/**
 * @author Pascal
 * 
 */
public class Player extends CoreObject {

	private static ArrayList<CoreObject> gameObjects = Game.getInstance()
			.getController().getObjects();

	

	private float gravity = 1;
	private boolean falling = true;
	private boolean jumping = false;
	public boolean moving = false;
	public boolean right = true;

	private PlayerAnimation animeRight;
	private PlayerAnimation animeLeft;

	public Player(float x, float y, int id, Textures tex) {
		super(x, y, id, tex);
		this.setSize(32, 70);
		animeRight = new PlayerAnimation(5, Textures.playerRight);
		animeLeft = new PlayerAnimation(5, Textures.playerLeft);

	}

	@Override
	public void tick() {

		if (velX != 0)
			moving = true;
		else
			moving = false;

		if (velX > 0)
			right = true;
		
		if (velX < 0)
			right = false;
		
		

		x += velX;
		y += velY;

		fall();
		checkCollision();

		if (moving && right)
			animeRight.runAnimation();

		if (moving && !right)
			animeLeft.runAnimation();

		Reference.PlayerX = x;
		Reference.PlayerY = y;
	}

	@Override
	public void render(Graphics g) {

		if (!moving) {
			if (right) {
				try {
					g.drawImage(Images.characterRightStanding, (int) x, (int) y, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					g.drawImage(Images.characterLeftStanding, (int) x, (int) y, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			if (right)
				animeRight.drawAnimation(g, x, y);
			else
				animeLeft.drawAnimation(g, x, y);

		}

		Game.checkGameover(y);
			
		
		

	}

	private void checkCollision() {
		for (CoreObject obj : gameObjects) {
			if (obj instanceof Block) {

				if (getBottomBounds().intersects(obj.getTopBounds())) {
					velY = 0;
					y = obj.getY() - height;
					jumping = false;
				}
				if (getTopBounds().intersects(obj.getBottomBounds())) {
					fall();
					y = obj.getY() + obj.getHeight();
				}
				if (getRightBounds().intersects(obj.getLeftBounds())) {
					velX = 0;
					x = obj.getX() - width;

				}
				if (getLeftBounds().intersects(obj.getRightBounds())) {
					velX = 0;
					x = obj.getX() + obj.getWidth();

				}
			}
		}
	}

	public void fall() {
		if (falling)
			velY += gravity;
	}

	/**
	 * @return the jumping
	 */
	public boolean isJumping() {
		return jumping;
	}

	/**
	 * @param jumping
	 *            the jumping to set
	 */
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	/**
	 * @return the moving
	 */
	public boolean isMoving() {
		return moving;
	}

	/**
	 * @param moving
	 *            the moving to set
	 */
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
}
