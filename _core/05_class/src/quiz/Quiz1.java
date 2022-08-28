package quiz;



class Pet {
	int age;
	String name;
	String breeds;
	void info(int petAge, String petName, String petbreeds) {
		name = petName;
		age = petAge;
		breeds = petbreeds;
	}
	void sound(String name) {
		
	}
	int getOld() {
		age++;
		return age;
	}
	void info() {
		System.out.println(age);
	}
}
public class Quiz1 {

	public static void main(String[] args) {
		Pet myPet = new Pet();
		myPet.name = "흰둥이"; // Pet이라는 객체에 멍뭉이를 초기화
		myPet.age = 4;
		myPet.breeds = "포메라니안";
		myPet.getOld();
		System.out.println(myPet.name);
		System.out.println(myPet.age);
		System.out.println(myPet.breeds);
	}

}
