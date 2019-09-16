package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.model.LprodVo;

@Service
public class LprodService implements ILprodService{

	@Resource(name = "lprodDao")
	private ILprodDao lprodDao;

	public LprodService() {}
	
	public LprodService(ILprodDao lprodDao) {
		this.lprodDao = lprodDao;
	}

	@Override
	public List<LprodVo> getLprodList() {
		
		return lprodDao.getLprodList();
	}

	@Override
	public Map<String, Object> getLprodPagingList(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();


		List<LprodVo> lprodList = lprodDao.getLprodPagingList(page);
		int totalCnt = lprodDao.getLprodTotalCnt();

		map.put("lprodList", lprodList);
		map.put("paginationSize", (int)Math.ceil((double)totalCnt / page.getPagesize()));

		return map;
	}


}
