package quiz.bank;

import java.util.Scanner;

public class Banker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("고객의 수 입력 > ");
		int limit = sc.nextInt();
		Bank bank = new Bank(limit);
		
//		User me = null;
//		User you = null;		
		User an = null;
		
//		BankAccount ba = null;
		
		
		int menu = 0;
		boolean flag = true;
		int money = 0;
		int regCount = 0;
		int userIdx = 0;
		
		while (flag) {
			System.out.println("\n==============뱅킹 시스템============");
			System.out.println("1.계좌개설 / 2.입금 / 3.출금 / 4. 무기명계좌 개설 / 5.이체 etc.종료");
			menu = sc.nextInt();
			System.out.println("---------------------------------------");
			
			switch (menu) {
			case 1:
				if(regCount < limit) {
					
				System.out.println("고객명 입력 > ");
				String userName = sc.next();
				System.out.println("최초 입금액 > ");
				int initBalance = sc.nextInt();
				bank.getUsers()[regCount]
						= new User(userName, initBalance, new BankAccount());
				regCount++;
				}else {
					System.out.println("고객 수 초과");
				}
//				ba = new BankAccount();
//				me =  new User("Lee", 10000, new BankAccount());
//				you =  new User("Woo", 50000, new BankAccount());
//				me.setAccount(new BankAccount());
//				System.out.println("계좌 개설 완료");
//				System.out.println(me.toString());
//				System.out.println(me.getAccount().toString());
				break;
				
//				ba = new BankAccount();
//				you =  new User("you", 50000);
//				you.setAccount(ba);
//				System.out.println("계좌 개설 완료");
//				System.out.println(you.toString());
//				System.out.println(you.getAccount().toString());
			case 2:
				System.out.println("고객 번호 입력(0 ~ limit - 1) >");
				userIdx = sc.nextInt();
				if (userIdx < limit) {
					if(bank.getUsers()[userIdx] != null) {
						System.out.println("입금할 금액 > ");
						money = sc.nextInt();
						bank.saving(money, bank.getUsers()[userIdx]);
					}else {
						System.out.println("미개설 계좌입니다");
					}
				}else {
					System.out.println("없는 고객 번호 입니다");
				}
//				limit = bank.getUsers().length
				
				
				break;
			case 3:
				System.out.println("고객 번호 입력");
				userIdx = sc.nextInt();
				if (userIdx < limit) {
					if (bank.getUsers()[userIdx] != null) {
						System.out.println("출금할 금액 > ");
						money = sc.nextInt();
						bank.withdraw(money, bank.getUsers()[userIdx]);
					}else {
						System.out.println("미개설 개좌입니다");
					}
				}else {
					System.out.println("없는 고객 번호 입니다");
				}
				break;
			case 4 :
				an = new User();
				break;
			case 5 :
				System.out.println("고객 번호 입력");
				int from = sc.nextInt();
				
				if (from < limit && bank.getUsers()[from] != null) {
						User me = bank.getUsers()[from];
						System.out.println("이체할 고객 번호 입력");
						int to = sc.nextInt();
						
						if (to < limit && bank.getUsers()[to] != null) {
							User you = bank.getUsers()[to];
							System.out.println("이체할 금액 > ");
							money = sc.nextInt();
							bank.transfer(money, me, you);
							
						}else {
							System.out.println("없는 고객 번호이거나 미개설 계좌");
						}
					
				}else {
					System.out.println("없는 고객 번호이거나 미개설 계좌");
				}
				break;
			default:
				flag = false;
				System.out.println("==========뱅킹시스템 종료========");
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

}
