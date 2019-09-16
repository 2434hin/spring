package kr.or.ddit.prod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.repasitory.IProdDao;
import kr.or.ddit.prod.repasitory.ProdDao;

public class ProdDaoTest extends RootTestConfig{
	
	@Resource(name = "prodDao")
	private IProdDao prodDao;

	/**
	 *
	 * Method : getProdListTest
	 * 작성자 : PC-11
	 * 변경이력 :
	 * Method 설명 : getProdList 테스트
	 */
	@Test
	public void getProdListTest() {

		/***Given***/
		String lprodGu = "P101";

		/***When***/
		List<ProdVo> prodList = prodDao.getProdList(lprodGu);

		/***Then***/
		assertEquals(6, prodList.size());

	}

}
