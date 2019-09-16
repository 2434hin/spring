package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.user.model.User;

public interface ILprodDao {

	/**
	 *
	 * Method : getLprodList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 제품 그룹 리스트 조회
	 */
	public List<LprodVo> getLprodList();

	/**
	 *
	 * Method : getLprodPagingList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @param page
	 * @return
	 * Method 설명 : 제품 그룹 페이징 리스트 조회
	 */
	public List<LprodVo> getLprodPagingList(Page page);

	/**
	 *
	 * Method : getLprodTotalCnt
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 전체 제품 그룹 건수 조회
	 */
	public int getLprodTotalCnt();


}
