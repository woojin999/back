package practice_case2;

public class Kobbugi extends Character {

	public Kobbugi() {  
		hp = 100; 
		mp = 50; 
		System.out.println("꼬부기 생성~");
		printStatus(); 
	}

	@Override
	public void eat() { 
		mp += 5;
	}

	@Override
	public void sleep() {
		mp += 15;
	}

	@Override
	public void play() {
		mp -= 10;
		hp += 15;
	}

	@Override
	public boolean train() {
		mp -= 5;
		hp += 15;
		levelUp();
		return checkMp();
	}

	@Override
	public void levelUp() {
		if(hp >= 40) {
			hp -= 40;
			level++;
		}
	
		
	}

	

}
