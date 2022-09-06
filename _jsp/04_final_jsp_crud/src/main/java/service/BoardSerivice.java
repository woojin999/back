package service;

import java.util.List;

import domain.BoardVO;

public interface BoardSerivice {
	public int register(BoardVO bvo);
	public List<BoardVO> getList();
	public BoardVO getDetail(long bno);
	public int modify(BoardVO bvo);
	public int remove(long bno);
}
