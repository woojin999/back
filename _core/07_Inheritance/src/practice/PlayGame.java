package practice;

import java.util.Scanner;

public class PlayGame {
	private Character character; // 캐릭터 추상 
	private int menu; // 메뉴 번호
	private boolean flag; // 종료 조건
	
	public boolean isFlag() { // 종료조건 전달 메서드
		return this.flag;
	}

	public PlayGame(Character ch) { // 게임시작 후 캐릭터 세팅
		this.character = ch;
	}
	
	public void printMenu(Scanner sc) {
		// 캐릭터 플레이 메뉴
		System.out.println("1.EAT 2.SLEEP 3.PLAY 4.TRAIN 0.EXIT");
		menu = sc.nextInt();
		playCharacter(); // 캐릭터 플레이 메서드
	}

	private void playCharacter() { // 캐릭터 추상 클래스에서 확인바람
		switch (menu) {
		case 1:
			character.eat(); 	
			flag = true;
			break;
		case 2:
			character.sleep();	
			flag = true;
			break;
		case 3:
			character.play();	
			flag = true;
			break;
		case 4:
			character.train();	
			flag = true;
			break;
		case 0:
			flag = false;
			break;
	
		default:
			flag = true;
			break;
		}
		character.printStatus(); // 캐릭터 상태 출력 in 캐릭터 추상 클래스
	}
}
