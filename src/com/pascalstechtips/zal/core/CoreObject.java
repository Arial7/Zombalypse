/**
 * 
 */
package com.pascalstechtips.zal.core;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;



import com.pascalstechtips.zal.gfx.Textures;

public abstract class CoreObject {

	protected float x;
	public float y;
	protected float velX;
	protected float velY;
	protected int id;

	protected Textures tex;
	protected BufferedImage image;
	
	protected int width;
	protected int height;

	public CoreObject(float x, float y, int id, Textures tex) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;

	}

	
	public CoreObject(float x, float y, int id, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.id = id;
		

	}
	
	
	public abstract void tick();

	public abstract void render(Graphics g);

	public Rectangle getTopBounds() {
		return new Rectangle((int)x,(int) y, width, 12);
	}

	public Rectangle getBottomBounds() {
		return new Rectangle((int)x, (int)y + (height - 6), 32, 12);
	}

	public Rectangle getRightBounds() {
		return new Rectangle((int)x + (int)(width - 6), (int) y, 6, height);
	}

	public Rectangle getLeftBounds() {
		return new Rectangle((int)x, (int)y, 6, height);
	}

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param velx
	 *            the velx to set
	 */
	public void setVelx(float velx) {
		this.velX = velx;
	}

	/**
	 * @param vely
	 *            the vely to set
	 */
	public void setVely(float vely) {
		this.velY = vely;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	public void setSize(int width, int height){
		this.width = width;
		this.height = height;
	}
}
