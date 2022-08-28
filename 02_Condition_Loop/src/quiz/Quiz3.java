package quiz;

import java.util.Iterator;

public class Quiz3 {

	public static void main(String[] args) {
		//Q3. 아래와 같은 출력문을 만들어보세요
		//ABCDEFGHIJKLMNOPQRSTUVWX
		//ABCDEFGHIJKLMNOPQRSTUVW
		//ABCDEFGHIJKLMNOPQRSTUV
		//ABCDEFGHIJKLMNOPQRSTU
		//ABCDEFGHIJKLMNOPQRST
		//ABCDEFGHIJKLMNOPQRS
		//....
		//...
		//..
		//A
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = str.length(); i >0 ; i--) {
			System.out.println(str.substring(0,i));
		}


		
	}

}
