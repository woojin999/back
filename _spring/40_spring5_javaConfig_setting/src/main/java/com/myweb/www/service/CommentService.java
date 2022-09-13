package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.CommentVO;

public interface CommentService {
	int post(CommentVO cvo);
	List<CommentVO> spread(long pno);
	int modify(CommentVO cvo);
	int remove(long cno);
}
