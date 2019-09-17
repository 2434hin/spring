package kr.or.ddit.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;

public class ContextPathInitListener implements ServletContextListener{

	private static final Logger logger = LoggerFactory.getLogger(ContextPathInitListener.class);

	// application객체가 생성될 때 호출
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		sc.setAttribute("cp", sc.getContextPath());

		sc.setAttribute("S_USERVO_LIST", new ArrayList<User>());
		logger.debug("cp : {}", sc.getAttribute("cp"));
	}

	// application객체가 삭제될 떄 호출
	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
