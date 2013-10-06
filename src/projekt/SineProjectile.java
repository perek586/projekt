package projekt;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SineProjectile extends Projectile{

	public SineProjectile(Vector2d pos, Vector2d destination, float damage, float speed, Image image, Entity owner)throws SlickException{
		super(destination, damage, speed, image, owner);
	}
	public SineProjectile(int posX, int posY, int destX, int destY, float damage, float speed, Image image, Entity owner)throws SlickException{
		super(destX, destY, damage, speed, image, owner);
	}
	@Override
	public void update(int delta){
		this.time+=delta;
		Vector2d normalized = this.destination.getDifference(this.pos).getNormalized();
		normalized.multiply(speed*delta);
		
		double xIncrement = normalized.getX() + 0.2f*Math.sin((time/1000)*Math.PI);
		double yIncrement = normalized.getY() - 0.2f*Math.sin((time/1000)*Math.PI);
		
		this.pos.setCoord(this.pos.getX() + (float)xIncrement, this.pos.getY() + (float)yIncrement);
		
		this.image.rotate(-(float)rotation);
		rotation = Math.toDegrees(Math.atan2(-xIncrement, yIncrement));
		this.image.rotate((float)rotation);
	}
}
