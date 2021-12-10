package com.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.domain.BoardDTO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	/**
	 * 게시판 리스트 페이지
	 * @return
	 */
	@GetMapping("/list.do")
	public ModelAndView getBoardList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/list");
		
		List<BoardDTO> boardList = boardService.getBoardList();
		modelAndView.addObject("boardList", boardList);
		
		int totalCount = boardService.getBoardTotalCount();
		modelAndView.addObject("totalCount", totalCount);
		
		return modelAndView;
	}
	
	/**
	 * 게시글 단건 조회
	 * @param boardIdx
	 * @return
	 */
	@GetMapping("/getBoard.do")
	public ModelAndView getBoard(@RequestParam(value = "boardIdx", required = false) int boardIdx) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/read");
		
		BoardDTO board = boardService.getBoard(boardIdx);
		modelAndView.addObject("board", board);
		
		return modelAndView;
	}
	
	/**
	 * 게시글 작성 페이지 이동
	 * @return
	 */
	@GetMapping("/goWrite.do")
	public String goWrite() {
		return "board/write";
	}
	
	/**
	 * 게시글 insert
	 * @param request
	 * @param board
	 * @return
	 */
	@PostMapping("/insertBoard.do")
	public String insertBoard(HttpServletRequest request,BoardDTO board) {
		
		ModelAndView modelAndView = new ModelAndView();
		board.setMemId("parksiu823");
		boolean result = boardService.insertBoard(board);
		

		if(!result) {
			System.out.println("insertBoard Error ========================");
			return "redirect:/board/goWrite.do";
		}else {
			modelAndView.setViewName("board/list");
			return "redirect:/board/list.do";
		}
		
	}
	
	@GetMapping("/goModify.do")
	public ModelAndView goModify(@RequestParam(value = "boardIdx", required = false) int boardIdx) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/modify");
		
		BoardDTO board = boardService.getBoard(boardIdx);
		modelAndView.addObject("board",board);
		
		return modelAndView;
	}
	
	@PostMapping("/updateBoard.do")
	public String updateBoard(HttpServletRequest request, BoardDTO board, Model model) {
		board.setUptMemId(board.getMemId());
		boolean result = boardService.updateBoard(board);
		
		if(!result) {
			System.out.println("updateBoard Error ========================");
			return "redirect:/board/list.do";
		} else {
			BoardDTO modBoard = boardService.getBoard(board.getBoardIdx());
			model.addAttribute("board", modBoard);
			return "redirect:/board/getBoard.do?boardIdx="+modBoard.getBoardIdx();
		}
		
	}
	
	@GetMapping("deleteBoard.do")
	public String deleteBoard(HttpServletRequest request, BoardDTO board) {
		board.setDelMemId(board.getMemId());
		boolean result = boardService.deleteBoard(board);
		
		if(!result) {
			System.out.println("deleteBoard Error ========================");
			return "redirect:/board/getBoard.do?boardIdx="+board.getBoardIdx();
		} else {
			System.out.println("deleteBoard Success ========================");
			return "redirect:/board/list.do";
		}
	}
	
}
