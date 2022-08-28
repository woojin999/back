package construtor;


import java.util.Date;
public class Bank {

	public static void main(String[] args) {
		String owner = "wee";
		int accNum = 1234;
		double deposit = 0.0;
		BankAccount myBA = new BankAccount(owner, accNum, deposit);
		System.out.println(myBA.getOwner() + myBA.getAccNum() + myBA.getDeposit());
		
		BankAccount anonyBA = new BankAccount(1233, 10000);
		System.out.println(anonyBA.getAccNum());
		Date today = new Date();
		System.out.println(today);

		
	}

}
