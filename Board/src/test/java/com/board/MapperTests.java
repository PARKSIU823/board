package com.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;

@SpringBootTest
public class MapperTests {

	@Autowired
	BoardMapper boardMapper;
	
	/**
	 * 글 등록 테스트
	 */
	@Test
	public void insertBoardTests() {
		BoardDTO board = new BoardDTO();
		board.setTitle("글제목 01");
		board.setContent("내용 01");
		board.setMemId("parksiu823");
		board.setNoticeYn("N");
		board.setSecretYn("N");
		
		int result = boardMapper.insertBoard(board);
		if(result == 1) {
			System.out.println("게시글 등록");
		}else {
			System.out.println("등록 오류");
			System.out.println("result : " + result);
		}
	}
	
	/**
	 * 게시글 다량 등록
	 */
	@Test
	public void multipleInsertTests() {
		for (int i = 2; i < 200; i++) {
			BoardDTO board = new BoardDTO();
			board.setTitle("글제목 " + i);
			board.setContent("내용 " + i);
			board.setNoticeYn("N");
			board.setSecretYn("N");
			board.setMemId("parksiu823");
			boardMapper.insertBoard(board);
		}
	}
	/**
	 * 게시글 목록 조회 테스트
	 */
	@Test
	public void getBoardListTests() {
		int boardTotalCount = boardMapper.getBoardTotalCount();
		if(boardTotalCount > 0) {
			List<BoardDTO> boardList = boardMapper.getBoardList();
			for(BoardDTO board : boardList) {
				System.out.println("======================");
				System.out.println(board.getBoardIdx());
				System.out.println(board.getTitle());
				System.out.println(board.getContent());
				System.out.println(board.getMemId());
				System.out.println(board.getViewCount());
				System.out.println("======================");
			}
			System.out.println("총 게시글 수 : " + boardTotalCount);
		}else {
			System.out.println("등록된 글 없음");
		}
	}
	
	/**
	 * 게시글 조회 테스트
	 */
	@Test
	public void getBoard() {
		BoardDTO board = new BoardDTO();
		board.setBoardIdx(1);
		board = boardMapper.getBoard(board.getBoardIdx());
		if(board != null) {
			System.out.println("======================");
			System.out.println(board.getBoardIdx());
			System.out.println(board.getTitle());
			System.out.println(board.getContent());
			System.out.println(board.getMemId());
			System.out.println(board.getViewCount());
			System.out.println("======================");			
		}else {
			System.out.println("등록된 글 없음");
		}
	}
	
	/**
	 * 게시글 수정 테스트
	 */
	@Test
	public void updateBoardTests() {
		BoardDTO board = boardMapper.getBoard(1);
		board.setTitle("수정 제목 01");
		board.setContent("수정 내용 01");
		board.setUptMemId("parksiu823");
		board.setNoticeYn("Y");
		board.setSecretYn("Y");
		
		int result = boardMapper.updateBoard(board);
		if(result == 1) {
			System.out.println("게시글 수정 성공");
		}else {
			System.out.println("게시글 수정 오류");
		}
	}
	
	/**
	 * 게시글 삭제 테스트
	 */
	@Test
	public void deleteBoardTests() {
		BoardDTO board = boardMapper.getBoard(150);
		board.setDelMemId("parksiu823");
		board.setDeleteYn("Y");
		
		int result = boardMapper.deleteBoard(board);
		if(result == 1) {
			System.out.println("게시글 삭제 성공");
		}else {
			System.out.println("게시글 삭제 오류");
		}
	}
	
}
