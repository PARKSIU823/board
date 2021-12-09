package com.board.service;

import java.util.List;

import com.board.domain.BoardDTO;

public interface BoardService {

	public boolean insertBoard(BoardDTO board);
	
	public List<BoardDTO> getBoardList();
	
	public BoardDTO getBoard(int boardIdx);
	
	public int getBoardTotalCount();
	
	public boolean updateBoard(BoardDTO board);
	
	public boolean deleteBoard(BoardDTO board);
}
