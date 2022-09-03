package domain;


public class producttVO {
	private int pno;
	private String pname;
	private double price;
	private String regdate;
	private String madeby;
	
	// insert
	public producttVO(String pname, double price, String madeby) {
		super();
		this.pname = pname;
		this.price = price;
		this.madeby = madeby;
	}

	// selectlist
	public producttVO(int pno, String pname, String regdate) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.regdate = regdate;
	}
	// update
	public producttVO(int pno, String pname, double price, String madeby) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.madeby = madeby;
	}
	// select One delete

	public producttVO(int pno, String pname, double price, String regdate, String madeby) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.regdate = regdate;
		this.madeby = madeby;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getMadeby() {
		return madeby;
	}

	public void setMadeby(String madeby) {
		this.madeby = madeby;
	}
	
	
	
	
}
