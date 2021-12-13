package com.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;
import com.board.paging.Criteria;
import com.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public boolean insertBoard(BoardDTO board) {
		int result = boardMapper.insertBoard(board);
		return (result == 1) ? true : false;
	}

	@Override
	public List<BoardDTO> getBoardList(Criteria criteria) {
		List<BoardDTO> boardList = boardMapper.getBoardList(criteria);
		return boardList;
	}

	@Override
	public BoardDTO getBoard(int boardIdx) {
		BoardDTO board = boardMapper.getBoard(boardIdx);
		return board;
	}

	@Override
	public int getBoardTotalCount(Criteria criteria) {
		int totalCount = boardMapper.getBoardTotalCount(criteria);
		return totalCount;
	}
	
	@Override
	public boolean updateBoard(BoardDTO board) {
		int result = boardMapper.updateBoard(board);
		return (result == 1) ? true : false;
	}

	@Override
	public boolean deleteBoard(BoardDTO board) {
		int result = boardMapper.deleteBoard(board);
		return (result == 1 ) ? true : false;
	}

	@Override
	public void updateViewCount(int boardIdx) {
		boardMapper.updateViewCount(boardIdx);		
	}


}
