package com.myweb.www.domain;

import lombok.Data;

@Data // 불필요한 기능까지 선언하므로 추천하지 않는다.
public class CommentVO {
	private long cno;
	private long pno;
	private String writer;
	private String content;
	private String regAt;
	private String modAt;
	
	public CommentVO() {}
	// insert : pno, writer, content
	// list : cno, pno, writer, content, modAt
	// modify : cno, content
	// remove : cno

	public CommentVO(long pno, String writer, String content) {
		this.pno = pno;
		this.writer = writer;
		this.content = content;
	}
	public CommentVO(long cno, long pno, String writer, String content, String regAt, String modAt) {
		this.cno = cno;
		this.pno = pno;
		this.writer = writer;
		this.content = content;
		this.regAt = regAt;
		this.modAt = modAt;
	}
	public CommentVO(long cno, String content) {
		this.cno = cno;
		this.content = content;
	}
	

	public long getCno() {
		return cno;
	}

	public void setCno(long cno) {
		this.cno = cno;
	}

	public long getPno() {
		return pno;
	}

	public void setPno(long pno) {
		this.pno = pno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegAt() {
		return regAt;
	}

	public void setRegAt(String regAt) {
		this.regAt = regAt;
	}

	public String getModAt() {
		return modAt;
	}

	public void setModAt(String modAt) {
		this.modAt = modAt;
	}

	@Override
	public String toString() {
		return "CommentVO [cno=" + cno + ", pno=" + pno + ", writer=" + writer + ", content=" + content + ", regAt="
				+ regAt + ", modAt=" + modAt + "]";
	}
}
