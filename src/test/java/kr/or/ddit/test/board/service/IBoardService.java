package kr.or.ddit.test.board.service;

import kr.or.ddit.test.board.dao.IBoardDao;

public interface IBoardService {

	void setBoardDao(IBoardDao boardDao);
	
	void setBoardNm(String boardNm);
	
	/**
	 * 
	 * Method : getBosrdList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 게시판 리스트를 조회한다
	 */
	void getBosrdList();
	
}
