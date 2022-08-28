package practice;

public class PyLee extends Character {

	public PyLee() { 
		hp = 100; 
		mp = 50; 
		System.out.println("파이리~ 생성");
		printStatus(); 
	}
	
	@Override
	public void eat() { 
		mp += 15;
	}

	@Override
	public void sleep() {
		mp += 30;
	}

	@Override
	public void play() {
		mp -= 25;
		hp += 10;
	}

	@Override
	public boolean train() {
		mp -= 5;
		hp += 5;
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
