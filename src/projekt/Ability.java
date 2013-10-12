package projekt;

import java.util.ArrayList;

public class Ability {
	private ArrayList<Projectile> pattern = new ArrayList<Projectile>();
	
	
	public Ability(){}
	public void trigger(ArrayList<Projectile> projectiles, float x, float y){
		Projectile proj;
		for(int i = 0; i < pattern.size(); i++){
			try{
				proj = pattern.get(i).Clone();
				proj.create(x-proj.getWidth()/2, y-proj.getHeight()/2);
				projectiles.add(proj);
			}catch(CloneNotSupportedException e){
				e.printStackTrace();
			}
		}
	}
	
	public void addProjectile(Projectile proj){
		pattern.add(proj);
	}

}
