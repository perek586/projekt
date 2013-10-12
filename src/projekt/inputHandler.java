package projekt;

import org.newdawn.slick.Input;

public final class inputHandler {
	
	private inputHandler(){}
	
	public static Vector2d playerInput(Player player, Input input, int delta, SoundModule sound){
		float newX = player.getX();
		float newY = player.getY();
		
		if(input.isKeyDown(Input.KEY_UP)){
			newY -= delta*player.speed;
			player.setAnim(player.moveUp);
			player.update(delta);
			
		}else if (input.isKeyDown(Input.KEY_DOWN)){
			newY += delta*player.speed;
			player.setAnim(player.moveDown);
			player.update(delta);
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			newX -= delta*player.speed;
			player.setAnim(player.moveLeft);
			player.update(delta);
		}else if(input.isKeyDown(Input.KEY_RIGHT)){
			newX += delta*player.speed;
			player.setAnim(player.moveRight);
			player.update(delta);
		}
		if(input.isKeyDown(Input.KEY_SPACE)){
			if(player.canAttack()){
				player.attack(sound);
			}
		}
		
		return new Vector2d(newX, newY);
		
		
	}
}
