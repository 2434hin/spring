package kr.or.ddit.batch.simple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class RangerWriter implements ItemWriter<String>{

	private static final Logger logger = LoggerFactory.getLogger(RangerWriter.class);
	
	// 배치에서는 chunk 단위 설정 시 한번에 여러건의 데이터를 처리할 수 있게끔 설정 가능
	@Override
	public void write(List<? extends String> items) throws Exception {
		
		for(String item : items) {
			logger.debug("itemProcessor : {}", item);
		}
		
	}
	
}
