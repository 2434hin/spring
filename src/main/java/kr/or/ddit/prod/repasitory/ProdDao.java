package kr.or.ddit.prod.repasitory;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.prod.model.ProdVo;

@Repository
public class ProdDao implements IProdDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/**
	 *
	 * Method : getProdList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param lprodGu
	 * @return
	 * Method 설명 : lprodGu를 갖는 prod정보 조회
	 */
	@Override
	public List<ProdVo> getProdList(String lprodGu) {

		return sqlSession.selectList("prod.getProdList", lprodGu);
	}

}
