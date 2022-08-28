package quiz;


public class Quiz3 {
	double base = 5.0;
	double height = 3.5;
	
	double getArea() {
		return (base * height * 0.5);
	}
	
	double getHypotemuse() {
		return (Math.sqrt(base*base + height*height));
	}
	
	double getPerimeter() {
		return base + height + getHypotemuse();
	}
	public static void main(String[] args) {
		Quiz3 Quiz3 = new Quiz3();
		System.out.println("넓이 : " + Quiz3.getArea());
		System.out.println("빗변길이 : " + Quiz3.getHypotemuse());
		System.out.println("둘레길이 : " + Quiz3.getPerimeter());
		

		
	}

	
	
}


