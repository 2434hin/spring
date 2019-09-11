package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public interface IUserService {
	
	/**
	 * 
	 * Method : getUserList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 전체 리스트 조회
	 */
	List<User> getUserList();

	/**
	 *
	 * Method : getUser
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 상세조회
	 */
	User getUser(String userId);

	/**
	 *
	 * Method : getUserListOnlyHalf
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 50명 조회
	 */
	List<User> getUserListOnlyHalf();

	/**
	 *
	 * Method : getUserPagingList
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param page
	 * @return
	 * Method 설명 : 사용자 페이징 리스트 조회
	 */
	Map<String, Object> getUserPagingList(Page page);

	/**
	 *
	 * Method : insertUser
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param user
	 * Method 설명 : 사용자 등록
	 */
	int insertUser(User user);

	/**
	 *
	 * Method : deleteUser
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param userId
	 * Method 설명 : 사용자 삭제
	 */
	int deleteUser(String userId);

	/**
	 *
	 * Method : updateUser
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param user
	 * @return
	 * Method 설명 : 사용자 수정
	 */
	int updateUser(User user);
}
