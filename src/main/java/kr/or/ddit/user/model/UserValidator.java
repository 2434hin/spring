package kr.or.ddit.user.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		// userId 필드는 null일수 없고, 문자열 길이는 4글자 이상이어야한다
		if(user.getUserId() == null || user.getUserId().length() <= 3) {
			errors.rejectValue("userId", "required");	// 필드명, 에러코드(개발자 정의)
		}
	}
	
}
