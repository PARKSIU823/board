package com.board.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * @description TB_BOARD entity 클래스
 * @author PARKSIU
 */

@Getter
@Setter
public class BoardDTO {

	/**
	 *  글번호
	 */
	private int boardIdx;
	
	/**
	 *  제목
	 */
	private String title;
	
	/**
	 *  내용
	 */
	private String content;
	
	/**
	 *  조회수
	 */
	private int viewCount;
	
	/**
	 *  작성자
	 */
	private String memId;
	
	/**
	 *  수정자
	 */
	private String uptMemId;
	
	/**
	 *  삭제자
	 */
	private String delMemId;
	
	/**
	 *  등록일
	 */
	private LocalDateTime insertTime;
	
	/**
	 *  수정일
	 */
	private LocalDateTime updateTime;
	
	/**
	 *  삭제일
	 */
	private LocalDateTime deleteTime;
	
	/**
	 *  공지여부
	 */
	private String noticeYn;
	
	/**
	 *  비밀글
	 */
	private String secretYn;
	
	/**
	 *  삭제여부
	 */
	private String deleteYn;
}
