package quiz;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		System.out.println("확인하고 싶은 수열의 자리수 입력 > ");
		int num = sc.nextInt();
		
		for (int i = 0; i < num; i++) {
			System.out.print(fibo(i) + " ");
		}
	}

	private static int fibo(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}else {
			return fibo(n-2) + fibo(n-1);
		}

	}

}
