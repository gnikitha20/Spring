package test;
public class Triangle implements Shape{
	
	private Point pointA;
	private Point pointB;
	private Point pointC;

public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

public void myInit(){
	System.out.println("My Init Method");
}
public void cleanUp(){
	System.out.println("Clean Up");
}
public void destroy() throws Exception {
	// TODO Auto-generated method stub
	System.out.println("Disposable bean");
}

public void afterPropertiesSet() throws Exception {
	// TODO Auto-generated method stub
	System.out.println("Intializing bean");
}

public void draw() {
	// TODO Auto-generated method stub
	 System.out.println("point A : "+getPointA().getX()+" "+getPointA().getY());
	 System.out.println("point B : "+getPointB().getX()+" "+getPointB().getY());
	 System.out.println("point C : "+getPointC().getX()+" "+getPointC().getY());
}
}
