package kr.or.ddit.batch.user;

import org.springframework.batch.item.ItemProcessor;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.User;

public class UpdatePassBatchProcessor implements ItemProcessor<User, User>{

	@Override
	public User process(User item) throws Exception {
		item.setPass(KISA_SHA256.encrypt(item.getPass()));
		return item;
	}

}
