package hotel;

import java.util.Scanner;
import java.util.Date;

public class Hotel {
	private Room[][] rooms;	
	
	public Hotel(int floorCount, int roomCount) {
		rooms = new Room[floorCount][roomCount];
		
	}
	public Hotel() {
		buildHotel();
	}
	private void buildHotel() {
		Scanner sc = new Scanner(System.in);
		System.out.println("호텔의 층 수를 입력 > ");
		int floorCount = sc.nextInt();
		System.out.println("층 당 방 개수를 입력 > ");
		int roomCount = sc.nextInt();
		rooms = new Room [floorCount][roomCount];
		
	}



	public Room[][] getRooms() {
		return rooms;
	}

	public void setRooms(Room[][] rooms) {
		this.rooms = rooms;
	}

	public void goFrontDest() {
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		boolean flag = true;

		
		while (flag) {
			System.out.println("\n====================== 호텔 관리 메뉴 =====================");
			System.out.println("1:객실현황 2:입실 3:퇴실 4:객실상세조회 5:투숙객조회 Etc:종료");
			System.out.println("-------------------------------------------------------------");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> 메뉴 선택 >>>>>>>>>>>>>>>>>>>>>>>>>>");
			menu = sc.nextInt();
			
			flag = choiceMenu(menu);
		}
		System.out.println("프로그램을 종료합니다");
		
	}

	private boolean choiceMenu(int menu) {
		Scanner sc = new Scanner(System.in);
//		System.out.println("호텔의 층 수를 입력 > ");
//		int floorCount = sc.nextInt();
//		System.out.println("층 당 방 개수를 입력 > ");
//		int roomCount = sc.nextInt();

		
		
//		boolean check = false;
		
		String roomNum = "";
		switch (menu) {
		case 1:
			printRooms();
			break;
		case 2:
			System.out.println("입실 - 방번호 입력 >");
			
			roomNum = sc.next();
			checkIn(roomNum);
			boolean empty = false;
			break;
		case 3:
			System.out.println("퇴실 - 방번호 입력 >");
			roomNum = sc.next();
			checkOut(roomNum);
			break;
		case 4:
			System.out.println("객실 상세조회");
			for (int i = 0; i < rooms.length; i++) {
				for (int j = 0; j < rooms[i].length; j++) {
					System.out.print((i + 1) + (j < 9 ? "0" : "") + (j + 1) + "호:");
					System.out.print(rooms[i][j].toString());
					System.out.print("\t");
				}
				System.out.println();
			}
			break;
		case 5:
			System.out.println("투숙색 상세조회");
			for (int i = 0; i < rooms.length; i++) {
				for (int j = 0; j < rooms[i].length; j++) {
					System.out.print((i + 1) + (j < 9 ? "0" : "") + (j + 1) + "호:");
//					System.out.print(rooms[i][j].getName() + rooms[i][j].getAge() + rooms[i][j].getGen());
					System.out.print("\t");
				}
				System.out.println();
			}
			break;
			
		default:
			break;
		}
		return true;
	}

	private void printRooms() {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				System.out.print((i + 1) + (j < 9 ? "0" : "") + (j + 1) + "호:");
//				System.out.print(rooms[i][j] == 0  ? "입실가능" : "사용중");
				System.out.print("\t");
			}
			System.out.println();
		}
	}

	private void checkOut(String roomNum) {
		int floor = 0, room = 0; 
		
		if (roomNum.length() > 3) { 
			floor = Integer.parseInt(roomNum.substring(0, 2)) - 1;
			room = Integer.parseInt(roomNum.substring(2)) - 1;
		} else { 
			floor = Integer.parseInt(roomNum.substring(0, 1)) - 1;
			room = Integer.parseInt(roomNum.substring(1)) - 1;
		}
		if (rooms[floor][room] != null) {
			rooms[floor][room] = null;
			Date checkOutTime = new Date();
			
			
			
			System.out.println(roomNum + "호 퇴실완료");
		} else {
			System.out.println(roomNum + "호 빈 방 > 다른방을 선택 !");
		}
	}

	private void checkIn(String roomNum) {
		int floor = 0, room = 0; 
		boolean empty = true;
		if (roomNum.length() > 3) { 
			floor = Integer.parseInt(roomNum.substring(0, 2)) - 1;
			room = Integer.parseInt(roomNum.substring(2)) - 1;
		} else { 
			floor = Integer.parseInt(roomNum.substring(0, 1)) - 1;
			room = Integer.parseInt(roomNum.substring(1)) - 1;
		}
		if (empty = true) {
			System.out.println("성함을 입력하세요");
			Scanner sc = new Scanner(System.in);
			String name = sc.next();
			System.out.println("나이를 입력하세요");
			int age = sc.nextInt();
			System.out.println("성별(F/M)을 입력하세요");
			
			char gen = 'F';
			User roomNum2 = new User(name, age,gen);
			
			Date checkInTime = new Date();
			
			
			System.out.println(roomNum + "호 입실완료");
		} else {
			System.out.println(roomNum + "호 사용중 > 다른방을 선택!");
		}
	}

}
