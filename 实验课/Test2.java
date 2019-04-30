class Triangle{
	double bottom;
	double high;
	
	//初始化高
	Triangle(double h){
		this.high = h;
	}
	
	//初始化底
	Triangle(float b){
		this.bottom = b;
	}
	
	//初始化高和底
	Triangle(double h,double b){
		this.high = h;
		this.bottom = b;
	}
	
	public double area() {
		return 0.5*high*bottom;
	}
	
}


public class Test2 {

	public static void main(String[] args) {
		//初始化高
		Triangle t1 = new Triangle(1.0);
		double area = t1.area();
		System.out.println("t1的面积：" + area);
		
		//初始化底
		Triangle t2 = new Triangle(1.0f);
		area = t2.area();
		System.out.println("t2的面积："+ area);
		
		Triangle t3 = new Triangle(1.0,1.0);
		area = t3.area();
		System.out.println("t3的面积：" + area);
	}

}
