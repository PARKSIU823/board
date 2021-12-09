package com.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.domain.BoardDTO;
import com.board.service.BoardService;

@SpringBootTest
public class ServiceTests {

	@Autowired
	BoardService boardService;
	
	@Test
	public void insertBoardTests() {
		BoardDTO board = BoardDTO.builder()
				.title("Service Test 글제목 01")
				.content("Service Test 내용 01")
				.memId("parksiu823")
				.noticeYn("N")
				.secretYn("N")
				.build();
		boolean result = boardService.insertBoard(board);
		System.out.println("result =========== " + result);
	}
	
	@Test
	public void getBoardListTests() {
		List<BoardDTO> boardList = boardService.getBoardList();
		int totalCount = boardService.getBoardTotalCount();
		for(BoardDTO board : boardList) {
			System.out.println("=========================================");
			System.out.println(board.getBoardIdx()+" "+board.getTitle()+" "+board.getContent()+" "+board.getMemId());
			System.out.println("=========================================");
		}
		System.out.println("게시글 총 개수 : " + totalCount);
	}
	
	@Test
	public void updateBoardTests() {
		BoardDTO board = BoardDTO.builder()
				.title("Service Test 수정 글제목 01")
				.content("Service Test 수정 글제목 01")
				.uptMemId("parksiu823")
				.noticeYn("N")
				.secretYn("Y")
				.boardIdx(200)
				.build();
		boolean result = boardService.updateBoard(board);
		System.out.println("result =========== " + result);
	}
	
	@Test
	public void deleteBoardTests() {
		BoardDTO board = BoardDTO.builder()
				.deleteYn("Y")
				.delMemId("parksiu823")
				.boardIdx(200)
				.build();
		boolean result = boardService.deleteBoard(board);
		System.out.println("result =========== " + result);
	}
}
