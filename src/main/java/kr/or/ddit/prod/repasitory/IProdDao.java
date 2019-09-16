package kr.or.ddit.prod.repasitory;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;

public interface IProdDao {

	List<ProdVo> getProdList(String lprodGu);
}
