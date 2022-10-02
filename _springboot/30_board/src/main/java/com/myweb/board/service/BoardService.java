package com.myweb.board.service;

import java.util.List;

import com.myweb.board.domain.entity.Board;
import com.myweb.board.domain.entity.dto.BoardDTO;

public interface BoardService {
	void register(Board board);
	List<Board> getList();
	Board getDetail(int bno);
	void modify(BoardDTO bdto);
	void remove(int bno);
}
