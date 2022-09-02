package hotel;

import java.util.Scanner;

public class HotelMgr {
	// 과제 - 호텔예약 프로그램 만들기
	// 제출처 : miaseye@naver.com
	// 제출기한 : 2022-05-16 14:00 이전
	// 제출파일명 : java_1st_work_이우진_20220516.zip
	// 완성 못했습니다
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("호텔의 층 수를 입력 > ");
		int floorCount = sc.nextInt();
		System.out.println("층 당 방 개수를 입력 > ");
		int roomCount = sc.nextInt();
		Hotel hotel = new Hotel();
		hotel.goFrontDest();
	}
}
