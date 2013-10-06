package projekt;

public class Vector2d {
	private float x;
	private float y;
	
	public Vector2d(){
		this(0, 0);
	}
	public Vector2d(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public float getX(){
		return this.x;
	}
	public void setX(float newX){
		this.x = newX;
	}
	public float getY(){
		return this.y;
	}
	public void setY(float newY){
		this.y = newY;
	}
	public void setCoord(float newX, float newY){
		this.x = newX;
		this.y = newY;
	}
	public void add(float x){
		this.x += x;
		this.y += x;
	}
	public void multiply(float scalar){
		this.x *= scalar;
		this.y *= scalar;
	}
	public float getMagnitude(){
		return (float) Math.sqrt(this.x*this.x + this.y*this.y);
	}
	public Vector2d getNormalized(){
		return new Vector2d(this.x/this.getMagnitude(), this.y/this.getMagnitude());
	}
	public Vector2d add(Vector2d v){
		return new Vector2d (this.x + v.getX(),this.y + v.getY());
	}
	public Vector2d getDifference(Vector2d v){
		return new Vector2d(this.x - v.getX(), this.y-v.getY());
	}
	public float getDistanceTo(Vector2d target){
		return (this.getDifference(target).getMagnitude());
	}
	public boolean equals(Vector2d v){
		return this.x==v.x && this.y == v.y;
	}
	public float getDotProd(Vector2d v){
		return this.x*v.x+this.y*v.y;
	}
	
}
