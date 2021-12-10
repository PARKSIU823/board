package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.BoardDTO;

@Mapper
public interface BoardMapper {
	
	/**
	 * 글 등록
	 * @param board
	 * @return
	 */
	public int insertBoard(BoardDTO board);
	

	/**
	 * 글 목록 리스트
	 * @return
	 */
	public List<BoardDTO> getBoardList();
	
	/**
	 * 게시글 상세 조회
	 * @param boardIdx 글번호
	 * @return
	 */
	public BoardDTO getBoard(int boardIdx);
	
	/**
	 * 게시글 등록 수 조회
	 * @return
	 */
	public int getBoardTotalCount();
	
	/**
	 * 게시글 수정
	 * @param board
	 * @return
	 */
	public int updateBoard(BoardDTO board);
	
	/**
	 * 게시글 삭제
	 * @param board
	 * @return
	 */
	public int deleteBoard(BoardDTO board);
	
	/**
	 * 게시글 조회 수 증가
	 * @param viewCount
	 * @return
	 */
	public int updateViewCount(int boardIdx);
}
