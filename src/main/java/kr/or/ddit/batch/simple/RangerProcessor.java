package kr.or.ddit.batch.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

// reader로 부터 들어오는 타입
// processor에서 처리하여 writer 넘기는 타입
public class RangerProcessor implements ItemProcessor<String, String>{

	private static final Logger logger = LoggerFactory.getLogger(RangerProcessor.class);
	
	// 메소드 인자 item : reader를 통해 받은 배치 대상
	// 리턴 : processor에서 처리한 값(writer로 넘길 값)
	@Override
	public String process(String item) throws Exception {
		
		String itemProcessed = item + "_modified";
		
		logger.debug("itemProcessed : {}", itemProcessed);
		
		return itemProcessed;
	}

}
