package com.board.controller;

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@GetMapping("/getBoard.do")
	public ModelAndView getBoard(@RequestParam(value = "boardIdx", required = false) int boardIdx) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/getBoard");
		
		BoardDTO board = boardService.getBoard(boardIdx);
		modelAndView.addObject("board", board);
		
		return modelAndView;
	}
	
	@GetMapping("/goModify.do")
	public ModelAndView goModify(@RequestParam(value = "boardIdx", required = false) int boardIdx) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/modify");
		
		BoardDTO board = boardService.getBoard(boardIdx);
		modelAndView.addObject("board",board);
		
		return modelAndView;
	}
	
}
