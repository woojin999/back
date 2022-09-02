package address;

public class Address {
	private String name;
	private String tel;
	private int age;
	public Address() {}
	public Address(String name, String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return "hotel [roomnum = 101, name=" + "Lee" + ", tel=" + "1234"  + ", age=" + "23, " + "gen=f, check_in_time = 2022-06-11 17:55:10" +"]"+ "\n"
				+ "hotel [roomnum = 103, name=" + "Kim" + ", tel=" + "5678"  + ", age=" + "10, " + "gen=m, check_in_time = 2022-06-11 17:59:45" + "]";
	}
}
