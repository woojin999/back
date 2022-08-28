package creation;

public class Quiz {

	public static void main(String[] args) {
		// 랜덤으로 정수 5개를 배열에 담는 메서드
		// 그 배열을 전달 받아 평균 연산하는 메서드
		// 정수 5개와 연산 결과를 출력하는 메서드
		// main 메서드에서는 어떠한 연산식도 있으면 안됨
		// 메서드간 데이터 전달 및 호출만 있어야함
		
		int[] num = makeRandomNumbers();
		double avg = makeAverage(num);
		printResult(num, avg);
		
	}

	private static void printResult(int[] num, double avg) {
		System.out.println("5개의 정수 값");
		for (int i : num) {
			System.out.print(i + " ");
		}
		System.out.println("평균값 :" + avg);
		
	}

	private static double makeAverage(int[] num) {
		int total = 0;
		for (int i : num) {
			total += i;
		}
		return (double)total / num.length;
	}

	private static int[] makeRandomNumbers() {
		int[] num = new int[5];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int)(Math.random()*100);
		}
		return null;
	}

	
		
	}


