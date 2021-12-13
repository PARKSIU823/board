package com.board.service;

import java.util.List;

import com.board.domain.BoardDTO;
import com.board.paging.Criteria;

public interface BoardService {

	public boolean insertBoard(BoardDTO board);
	
	public List<BoardDTO> getBoardList(Criteria criteria);
	
	public BoardDTO getBoard(int boardIdx);
	
	public int getBoardTotalCount(Criteria criteria);
	
	public boolean updateBoard(BoardDTO board);
	
	public boolean deleteBoard(BoardDTO board);
	
	public void updateViewCount(int boardIdx);
}
