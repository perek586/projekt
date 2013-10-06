package projekt;
import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Rectangle;

public class Entity {
	
	
	protected float health = 100f;
	protected float maxHealth = health;
	protected float speed = 0.2f;
	protected long time;
	
	
	protected Vector2d pos;
	
	protected Rectangle hitBox;
	
	protected Animation currentAnim;
	protected Animation moveUp;
	protected Animation moveDown;
	protected Animation moveLeft;
	protected Animation moveRight;
	
	// CONSRUCTORS
	public Entity(Vector2d pos){
		this.pos = pos;
	}
	public Entity(Vector2d pos, Animation[] image){
		this.pos = pos;
		moveUp = image[0];
		moveDown = image[1];
		moveLeft = image[2];
		moveRight = image[3];
		currentAnim = moveDown;
		this.hitBox = new Rectangle(this.getX(), this.getY(), 32, 32);
	}
	public Entity(int x, int y, Animation[] image){
		this(new Vector2d(x, y), image);
	}
	///////////////////////
	
	
	// IMAGES / ANIMATION
	public Animation getTexture(){
		return this.currentAnim;
	}
	public void update(long delta){
		this.currentAnim.update(delta);
		this.hitBox.setLocation(this.getX(), this.getY());
	}
	public void setAnim(Animation image){
		this.currentAnim = image;
	}
	public void draw(int xOffset, int yOffset){
		this.currentAnim.draw(this.pos.getX()+xOffset, this.pos.getY()+yOffset);
	}
	public Rectangle getHitBox(){
		return this.hitBox;
	}
	public int getHeight(){
		return this.currentAnim.getHeight();
	}
	public int getWidth(){
		return this.currentAnim.getWidth();
	}
	///////////////////////
	
	
	// POSITIONAL THINGS
	public Vector2d getPos(){
		return this.pos;
	}
	public float getX(){
		return this.pos.getX();
	}
	public float getY(){
		return this.pos.getY();
	}
	public void setCoord(float newX, float newY){
		this.pos.setCoord(newX, newY);
		this.updateHitbox(newX, newY);
	}
	public void updateHitbox(float newX, float newY){
		this.hitBox.setLocation(newX, newY);
	}
	public void setCoord(Vector2d newV){
		this.pos = newV;
	}
	/////////////////////
	
	
	// HEALTHBASED THINGS
	public float getHealth(){
		return this.health;
	}
	public float getMaxHealth(){
		return this.maxHealth;
	}
	public void setDamage(float dmg){
		this.health -= dmg;
	}
	public void setDamage(int dmg){
		this.health -= dmg;
	}
	/////////////////////
	
}
