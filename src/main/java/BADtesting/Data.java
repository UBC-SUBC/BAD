package BAD;

public class Data {
	public double theta, deltaT, acceleration;
	public double depth;

	public Data(double theta, double deltaT, double acceleration, double depth){
		super();
		this.theta = theta;
		this.deltaT = deltaT;
		this.acceleration = acceleration;
		this.depth = depth;
	}

	public double getTheta(){
		return theta;
	}

	public double getDeltaT(){
		return deltaT;
	}

	public double getAcceleration(){
		return acceleration;
	}

	public double getDepth(){
		return depth;
	}

	@Override
	public String toString(){
		return "Data:{" + "theta:" + theta + ", deltaT:" + deltaT + ", acceleration" + acceleration + ", depth" + depth + '}';
	}
}
