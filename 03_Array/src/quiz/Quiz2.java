package quiz;

import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		// 테스트에 참여할 인원수를 입력하세요 > 3
		// 1번째 사람의 이름을 입력하세요 >
		// 1번째 사람의 국어 점수 입력 >
		// 1번째 사람의 영어 점수 입력 >
		// 1번째 사람의 수학 점수 입력 >
		//...
		// 3번째 사람의 수학 점수 입력 >
		
		// 이름 국어 영어 수함 총점 평균
		// aaa  88  99  87  ?   ?
		// ....
		Scanner sc = new Scanner(System.in);
		System.out.println("테스트에 참여할 인원수를 입력하세요 >");
		int num = sc.nextInt();
		String[] name = new String[num];
		int score1[] = new int[num];
		int score2[] = new int[num];
		int score3[] = new int[num];
		
		for (int i = 0; i < num; i++) {					
			System.out.println((i+1) + "번째 사람의 이름을 입력하세요 >");
			name[i] = sc.next();
			System.out.println((i+1) +"번째 사람의 국어 점수 입력 >");
			score1[i] = sc.nextInt();
			System.out.println((i+1) +"번째 사람의 영어 점수 입력 >");
			score2[i] = sc.nextInt();
			System.out.println((i+1) +"번째 사람의 수학 점수 입력 >");
			score3[i] = sc.nextInt();			
		}		
		for (int i = 0; i < num; i++) {
			System.out.println("이름 국어 영어 수학 총점 평균");
			int total = score1[i]+score2[i]+score3[i];
			System.out.print(name[i] + " " + score1[i] + "  " + score2[i] + "  " + score3[i] + "  " 
					+ total + "  " +(total/3));
			System.out.println();
		}		
		System.out.println("프로그램 종료");
	}
}
