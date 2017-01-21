package helperCode;


public class Vector {
	
	private final double heading, inches;//heading in degrees 0 = west 90= north.
	
	public Vector(double heading, double inches) {
		this.heading = heading;
		this.inches = inches;
	}
	
	
	public Vector(Position a, Position b) {
		double x = b.getX() - a.getX();
		double y = b.getY() - a.getY();
		
		this.inches = Math.sqrt( x*x + y*y );
		this.heading =  Math.toDegrees( Math.atan( y / x) );
	}
	
	
	
	public double getX() {
		return  inches * Math.cos( Math.toRadians(heading) );
	}
	
	public double getY() {
		return inches * Math.sin( Math.toRadians(heading) );
	}

	public double getHeading() {
		return heading;
	}
	
	public double getDistance() {
		return inches;
	}
	

	

}
