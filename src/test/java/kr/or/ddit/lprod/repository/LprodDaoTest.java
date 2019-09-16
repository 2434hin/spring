package kr.or.ddit.lprod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.model.LprodVo;

public class LprodDaoTest extends RootTestConfig{

	@Resource(name = "lprodDao")
	private ILprodDao lprodDao;

	/**
	 *
	 * Method : getLprodListTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : getLprodList 테스트
	 */
	@Test
	public void getLprodListTest() {

		/***Given***/

		/***When***/
		List<LprodVo> lprodList = lprodDao.getLprodList();

		/***Then***/
		assertEquals(10, lprodList.size());

	}

	/**
	 *
	 * Method : getLprodPagingList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : 제품그룹 페이징 리스트 조회
	 */
	@Test
	public void getLprodPagingList() {
		/***Given***/
		Page page = new Page();
		page.setPage(1);
		page.setPagesize(5);

		/***When***/
		List<LprodVo> lprodList = lprodDao.getLprodPagingList(page);

		/***Then***/
		assertEquals(5, lprodList.size());
	}

	@Test
	public void getLprodTotalCnt() {
		/***Given***/

		/***When***/
		int totalCnt = lprodDao.getLprodTotalCnt();

		/***Then***/
		assertEquals(10, totalCnt);
	}
}
