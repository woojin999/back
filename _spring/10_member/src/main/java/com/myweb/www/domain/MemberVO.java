package com.myweb.www.domain;

public class MemberVO {
	private String email;
	private String pwd;
	private String nickName;
	private String regAt;
	private String lastLogin;
	private int grade;
	
	public MemberVO() {}

	public MemberVO(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
	}

	public MemberVO(String email, String pwd, String nickName) {
		this(email, pwd);
		this.nickName = nickName;
	}
	
	public MemberVO(String email, String pwd, String nickName, int grade) {
		this(email, pwd, nickName);
		this.grade = grade;
	}

	public MemberVO(String email, String nickName, String regAt, String lastLogin, int grade) {
		this.email = email;
		this.nickName = nickName;
		this.regAt = regAt;
		this.lastLogin = lastLogin;
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRegAt() {
		return regAt;
	}

	public void setRegAt(String regAt) {
		this.regAt = regAt;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "MemberVO [email=" + email + ", pwd=" + pwd + ", nickName=" + nickName + ", regAt=" + regAt
				+ ", lastLogin=" + lastLogin + ", grade=" + grade + "]";
	}
}
