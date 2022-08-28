package practice_case1;

public class LeeSangHae extends Character {

	public LeeSangHae() {  
		hp = 100; 
		mp = 50; 
		System.out.println("이상해씨 생성~");
		printStatus(); 
	}
	
	@Override
	public void eat() { 
		mp += 25;
	}

	@Override
	public void sleep() {
		mp += 5;
	}

	@Override
	public void play() {
		mp -= 25;
		hp += 20;
	}

	@Override
	public boolean train() {
		mp -= 10;
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
