package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.MemberDTO;
import com.myweb.www.domain.MemberVO;

public interface MemberService {
	int register(MemberDTO mdto);
	MemberVO login(MemberVO mvo);
	List<MemberVO> getList();
	MemberDTO getDetail(String email);
	int modify(MemberDTO mdto);
	int remove(String email);
	int dupleCheck(String email);
	int removeFile(String uuid);
}
