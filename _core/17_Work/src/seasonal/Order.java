package seasonal;

public class Order {

	public void game() {
		String[] seasonal = { 
				"입춘", "우수", "경칩", "춘분",
				"청명", "곡우", "입하",
				"소만", "망종", "하지", "소서", "대서",
				"입추", "처서", "백로", "추분",
				"한로", "상강", "입동",
				"소설", "대설", "동지", "소한", "대한" };
		
		int order = (int)(Math.floor(Math.random() * 24));
	}
	
}
