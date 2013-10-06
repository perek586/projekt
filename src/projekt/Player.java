package projekt;
import org.newdawn.slick.Animation;

public class Player extends Entity{
	      //per älskar kakor
	private Vector2d dir = new Vector2d(0, -1);
	private Entity boss;
	
	private boolean hasAttacked = false;
	
	private int maxCD = 300;
	private int curCD = 0;
	
	// CONSTRUCTORS
	public Player(Vector2d pos){
		super(pos);
		this.speed = 0.15f;
	}
	public Player(Vector2d pos, Animation[] image){
		super(pos, image);
		this.speed = 0.15f;
	}
	public Player(int x, int y, Animation[] image){
		super(x, y, image);
		this.speed = 0.15f;
	}
	////////////////////////////////////
	
	// ANIMATION
	@Override
	public void draw(int xOffset, int yOffset){
		this.currentAnim.draw(xOffset/2, yOffset/2);
	}
	
	////////////////////////////////////
	
	// TARGETING
	public Vector2d getDir(){
		return this.dir;
	}
	public void setDir(float x, float y){
		this.dir.setCoord(x, y);
	}
	////////////////////////////////////
	
	// BATTLE RELATED THINGS
	public void setCurrentBoss(Entity e){
		this.boss = e;
	}
	public boolean canAttack(){
		return !hasAttacked;
	}
	public void attack(){
		if(this.boss.getPos().getDistanceTo(this.pos.add(dir))<this.currentAnim.getWidth()){			
			this.boss.setDamage(20);
			hasAttacked = true;
			curCD = maxCD;
		}
	}
	////////////////////////////////////
	
	public void logic(){
		
		if(curCD == 0 && hasAttacked == true){
			hasAttacked = false;
		}else{
			curCD--;
		}
	}
}
