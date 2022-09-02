package hoteldb;

import java.util.List;
import java.util.Scanner;

public class HotelFront {
	private Scanner sc = new Scanner(System.in);
	private boolean flag;
	private DataBase dbms;
	
	public HotelFront() {
		flag = true;
		dbms = new MySQL();
		printMenu();
	}

	private void printMenu() {
		int menu = 0;
		while (flag) {
			System.out.println("------------------Hotel System--------------");
			System.out.println("1:객실 조회 2:입실 3:퇴실 4:손님 정보 Etc:EXIT");
			menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				list();
				break;
			case 2:
				add();
				break;
			case 3:
				edit();
				break;
			case 4:
				detail();
				break;
			
			default:
				flag = false;
				break;
			}
		}
	}


	private void edit() {
		System.out.println("Name  > ");
		String name = sc.next();
		System.out.println("Tel > ");
		String tel = sc.next();
		System.out.println("Age > ");
		int age = sc.nextInt();
		boolean isOk = dbms.update(new Hotel(name, tel, age));
		System.out.println("주소록 수정 " + (isOk ? "성공": "실패"));
	}

	private void detail() {
		System.out.println("Name > ");
		String name = sc.next();
		Hotel addr = dbms.selectOne(name);
		System.out.println(addr);
	}

	private void list() {
		List<Hotel> list = dbms.selectList();
		for (Hotel address : list) {
			System.out.println(address);
		}
	}

	private void add() {
		System.out.println("Name  > ");
		String name = sc.next();
		System.out.println("Tel > ");
		String tel = sc.next();
		System.out.println("Age > ");
		int age = sc.nextInt();
		boolean isOk = dbms.insert(new Hotel(name, tel, age));
		System.out.println("주소록 입력 " + (isOk ? "성공": "실패"));
	}
}
