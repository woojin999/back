package quiz;

import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		System.out.println("별의 갯수 입력 >");
		star();
	}

	private static void star() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print("*");
			}System.out.println();
		}
		
	}

	
	

}
