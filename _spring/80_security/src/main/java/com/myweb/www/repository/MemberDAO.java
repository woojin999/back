package com.myweb.www.repository;

import java.util.List;


import com.myweb.www.domain.MemberVO;
import com.myweb.www.security.AuthVO;

import lombok.NonNull;

public interface MemberDAO {
	int insert(MemberVO mvo); // register
	MemberVO selectOne(MemberVO mvo); // login
	List<MemberVO> selectList(); // list
	MemberVO selectDetail(String email); // detail
	int update(MemberVO mvo); // modify
	int delete(String email); // remove
	int selectEmail(String email);
	MemberVO selectAuth(String email);
	List<AuthVO> selectAuthList(String email);
	int insertAuth(@NonNull String email);
	int updateLastLogin(String email);
}
