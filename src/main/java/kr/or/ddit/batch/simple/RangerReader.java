package kr.or.ddit.batch.simple;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class RangerReader implements ItemReader<String>{
	
	private static final Logger logger = LoggerFactory.getLogger(RangerReader.class);

	private List<String> rangers;
	private int index = 0;
	
	public RangerReader() {
		rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		rangers.add("moon");
		rangers.add("james");
	}
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		if(index < rangers.size()) {
			String ranger = rangers.get(index++); 
			logger.debug("ranger : {}", ranger);
			return ranger;
		} else {
			index = 0;		// 반복적으로 실행할 수 있도록(처음부터 읽을 수 있도록 인덱스 초기화)
			return null;	// 더이상 처리할 데이터가 없을떄
		}
	}
	
}
