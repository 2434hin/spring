package kr.or.ddit.test.board.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.test.board.dao.IBoardDao;

public class BoardService implements IBoardService{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);

	// boardDao 구현체를 설정할 수 있는 방법
	// 1. 직접 만들기(생성자에서 new BoardDao())
	// 2. 외부에서 주입
	//		.setter(setBoardDao(IBoardDao boardDao)
	//		.consturctor(public BoardService((IBoardDao boardDao))
	private IBoardDao boardDao;
	private String boardNm;
	
	public BoardService() {}
	
	public BoardService(IBoardDao boardDao, String boardNm) {
		this.boardDao = boardDao;
		this.boardNm = boardNm;
	}

	public IBoardDao getBoardDao() {
		return boardDao;
	}

	public void setBoardDao(IBoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public String getBoardNm() {
		return boardNm;
	}

	public void setBoardNm(String boardNm) {
		this.boardNm = boardNm;
	}

	/**
	 * 
	 * Method : getBosrdList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 게시판 리스트를 조회한다
	 */
	@Override
	public void getBosrdList() {
		
		logger.debug("boardNm : {}", boardNm);
		
		boardDao.getBosrdList();
	}

}
