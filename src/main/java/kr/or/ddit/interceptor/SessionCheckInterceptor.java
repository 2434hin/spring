package kr.or.ddit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.ddit.user.model.User;

public class SessionCheckInterceptor extends HandlerInterceptorAdapter{

	// @Resource()
	
	// 메뉴 - 관리자(left, header), 일반사용(left, header)
	// 세션에 저장된 사용자 정보 - 권한 체크 - 그 사람이 현재 메뉴에서 볼 수 있는 메뉴들
	// application ->
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("S_USERVO");
		
		// session이 없으면 login화면으로 이동
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		
		// session이 존재하면 통과
		return true;
	}
}
