package conditions;

import java.util.Scanner;

public class IfElse {

	public static void main(String[] args) {
		// 현재시간(24시간 기준)을 입력받아
		// 9시 이전이면 굿모닝 출력
		// 14시 이전이면 굿에프터눈
		// 22시 이전이면 굿나잇
		
		Scanner sc = new Scanner(System.in);
		System.out.println("시간을 입력하세요 >");
		int num = sc.nextInt();
		if(num < 9) {
			System.out.println("굿모닝");
		} else if(num < 14) {
			System.out.println("굿에프터눈");
		} else if(num < 22) {
			System.out.println("굿나잇");
		
		}
		
	}
}
