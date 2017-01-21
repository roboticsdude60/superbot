package helperCode;

public class Position {
	private double x,y;
	
	public Position (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Position (Position posi, Vector toNewPos) {
		this.x = posi.getX() + toNewPos.getX();
		this.y = posi.getY() + toNewPos.getY();
	}
	
	public void move(double x, double y) {
		this.x += x;
		this.y += y;
	}
	public void move(Vector toNewPos) {
		this.x +=  toNewPos.getX();
		this.y +=  toNewPos.getY();
	}
	
	public double distanceTo(Position otherPlace) {
		Vector vect = new Vector(this, otherPlace);
		return vect.getDistance();
	}
	public double angleTo(Position otherPlace) {
		Vector vect = new Vector(this, otherPlace);
		return vect.getHeading();
	}
	
	
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	private double degreeToRad(double degree) {
		return degree * Math.PI / 180;
	}

}
