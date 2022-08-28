package quiz;

import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {	
		String item = "";
		int qty = 0;
		double price =0;
		compute(item, qty, price);
		
		
		
	}

	private static void compute(String item, int qty, double price) {
		Scanner sc = new Scanner(System.in);
		System.out.println("품명을 입력하세요");
		String tem = sc.next();
		System.out.println("수량을 입력하세요");
		int qt = sc.nextInt();
		System.out.println("단가를 입력하세요");
		double pric = sc.nextInt();
		
		System.out.println("품명 : " + tem);
		System.out.println("금액 : " + (double)(qt*pric));
	}

}
