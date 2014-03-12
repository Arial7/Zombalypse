/**
 * 
 */
package com.pascalstechtips.zal.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.pascalstechtips.zal.Game;
import com.pascalstechtips.zal.entity.Player;
import com.pascalstechtips.zal.enums.GameState;
import com.pascalstechtips.zal.libs.Identities;

/**
 * @author Pascal
 * 
 */
public class KeyInput extends KeyAdapter {

	private Player player;
	private boolean[] keyDown = new boolean[2];

	public KeyInput() {
		for (int k = 0; k < Game.getInstance().getController().getObjects()
				.size(); k++) {
			if (Game.getInstance().getController().getObjects().get(k).getId() == Identities.PLAYER) {
				player = (Player) Game.getInstance().getController()
						.getObjects().get(k);
			}

		}

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (Game.state) {
		case GAME:
			if (key == KeyEvent.VK_W && !player.isJumping()) {

				player.setVely(-16);
				player.setJumping(true);
			}
			// if(key == KeyEvent.VK_S)
			// player.setVely(5);
			if (key == KeyEvent.VK_A) {

				player.setVelx(-5);
				keyDown[0] = true;
				//player.moving = true;

			}
			if (key == KeyEvent.VK_D) {

				player.setVelx(5);
				keyDown[1] = true;
				//player.moving = true;
			} 
			if (key == KeyEvent.VK_ESCAPE && !player.isJumping()) {
				if (Game.state == GameState.GAME) {

				}
				Game.state = GameState.MENU;
			}
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		switch (Game.state) {
		case GAME:
			if (key == KeyEvent.VK_W)
				player.setVely(0);
			// if(key == KeyEvent.VK_S)
			// player.setVely(0);
			if (key == KeyEvent.VK_A) {
				keyDown[0] = false;
				//player.moving = false;
			}
			if (key == KeyEvent.VK_D) {
				keyDown[1] = false;
				//player.moving = false;

			}

			if (keyDown[0] && !keyDown[1])
				player.setVelx(-5);
			if (!keyDown[0] && keyDown[1])
				player.setVelx(5);
			if (!keyDown[0] && !keyDown[1])
				player.setVelx(0);

			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			break;

		}
	}

}
