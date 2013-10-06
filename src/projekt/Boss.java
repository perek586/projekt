package projekt;

import java.util.ArrayList;

import org.newdawn.slick.Animation;

public class Boss extends Entity {
	private int currentAttack = 0;
	private ArrayList<Ability> attackList = new ArrayList<Ability>();
	private ArrayList<Integer> delay = new ArrayList<Integer>();
	private ArrayList<Projectile> projectiles;
	
	public Boss(Vector2d pos, Animation[] image){
		super(pos, image);
	}
	public Boss(int x, int y, Animation[] image){
		super(x, y, image);
	}
	
	public void setProjectileList(ArrayList<Projectile> proj){
		projectiles = proj;
	}
	
	public void addAttack(Ability a, int delay){
		attackList.add(a);
		this.delay.add(delay);
	}
	@Override
	public void update(long delta){
		super.update(delta);
		this.time += delta;
		if(this.time >= delay.get(currentAttack)){
			System.out.println(this.time);
			attackList.get(currentAttack).trigger(projectiles,this.pos.getX()+this.getWidth()/2, this.pos.getY()+this.getHeight()/2);
			this.time = 0;
			this.currentAttack++;
			if(currentAttack >= attackList.size()){
				currentAttack = 0;
			}
		}
	}
	
}