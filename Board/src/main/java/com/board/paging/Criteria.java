package com.board.paging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {
	
	/**
	 * 현재 페이지 번호
	 */
	private int currentPageNo;
	
	/**
	 * 한 페이지당 출력되는 글 개수
	 */
	private int recordsPerPage;
	
	/**
	 * 페이지 번호 출력 범위
	 */
	private int pageSize;
	
	/**
	 * 검색 키워드
	 */
	private String keyword;
	
	/**
	 * 검색 타입
	 */
	private String searchType;
	
	public Criteria() {
		this.currentPageNo = 1;
		this.recordsPerPage = 20;
		this.pageSize = 10;
	}
	
	public int getStartPage() {
		return (currentPageNo - 1) * recordsPerPage;
	}

}
