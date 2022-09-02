package address;

import java.util.List;
import java.util.Scanner;

public class AddressService {
	private Scanner sc = new Scanner(System.in);
	private boolean flag;
	private DataBase dbms;
	
	public AddressService() {
		flag = true;
		dbms = new MySQL();
		printMenu();
	}

	private void printMenu() {
		int menu = 0;
		while (flag) {
			System.out.println("----------------Hotel System------------");
			System.out.println("1:객실 현황 2:입실 3:퇴실 Etc:EXIT");
			menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				
				list();
				break;
			case 2:
				add();
				break;
			case 3:
				remove();
				break;
			case 4:
				edit();
				break;
			case 5:
				remove();
				break;

			default:
				flag = false;
				break;
			}
		}
	}

	private void remove() {
		System.out.println("Name > ");
		String name = sc.next();
		boolean isDel = dbms.delete(name);
		System.out.println("퇴실 " + (isDel ? "완료": "실패"));
	}

	private void edit() {
		System.out.println("Name  > ");
		String name = sc.next();
		System.out.println("Tel > ");
		String tel = sc.next();
		System.out.println("Age > ");
		int age = sc.nextInt();
		boolean isOk = dbms.update(new Address(name, tel, age));
		System.out.println("주소록 수정 " + (isOk ? "성공": "실패"));
	}

	private void detail() {
		System.out.println("Name > ");
		String name = sc.next();
		Address addr = dbms.selectOne(name);
		System.out.println(addr);
	}

	private void list() {
		List<Address> list = dbms.selectList();
		for (Address address : list) {
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
		System.out.println("Gen > ");
		String name2 = sc.next();;
		boolean isOk = dbms.insert(new Address(name, tel, age));
		System.out.println("입실 " + (isOk ? "완료": "실패"));
	}
}
