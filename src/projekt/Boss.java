package projekt;

import java.util.ArrayList;

import org.newdawn.slick.Animation;

public class Boss extends Entity {
	private int currentAttack = 0;
	private ArrayList<Ability> attackList = new ArrayList<Ability>();
	private ArrayList<Integer> delay = new ArrayList<Integer>();
	private ArrayList<Projectile> projectiles;
	private Player player;
    private String attackSound;


	
	public Boss(Vector2d pos, Animation[] image, Player player){
		super(pos, image);
		this.player = player;
	}
	public Boss(int x, int y, Animation[] image, Player player){
		super(x, y, image);
		this.player = player;
	}

    public void setAttackSound(String attackSound){
        this.attackSound = attackSound;
    }
    public String getAttackSound(){
        return this.attackSound;
    }
	public void setProjectileList(ArrayList<Projectile> proj){
		projectiles = proj;
	}
	
	public void addAttack(Ability a, int delay){
		attackList.add(a);
		this.delay.add(delay);
	}
	@Override
	public void update(long delta, SoundModule sound){
		super.update(delta);
		this.time += delta;
		if(this.time >= delay.get(currentAttack)){
			attackList.get(currentAttack).trigger(projectiles,this.pos.getX()+this.getWidth()/2, this.pos.getY()+this.getHeight()/2);
			this.time = 0;
			this.currentAttack++;

			if(currentAttack >= attackList.size()){
				currentAttack = 0;
			}
		}
	}
	
}
