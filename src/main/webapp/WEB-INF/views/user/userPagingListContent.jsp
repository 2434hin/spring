<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
	// 문서 로딩이 완료되고 나서
	$(document).ready(function () {

		// 사용자 정보 클릭시 이벤트 핸들러
		$(".userTr").on('click', function () {
			console.log("userTr click");

			// 클릭된 tr 태그의 자식태그(td)중 첫번째 자식의 텍스트 문자열
			// :) 사용자 아이디를 확인할 수 있는 방법
/* 			<tr class="userTr">
				<input type="hidden" value="${user.userId}"/>
				<td>${user.userId}</td>
				<td>${user.userNm}</td>
				<td>${user.alias}</td>
				<td>${user.reg_dt_fmt}</td>
			</tr> */

			// td태그의 택스트 가져오기(첫번째 자식)
			//var tdText = $(this).children().first().text();

			// td태그의 택스트 가져오기(두번째 자식)
			var tdText = $($(this).children()[1]).text();
			console.log("tdText : " + tdText);

			// input태긍 저장된 값 확인
			var inputValue = $(this).find("input").val();
			console.log("inputValue : " + inputValue);

			// data속성으로 값 가져오기
			// data속성명은 소문자로 치환된다!!!
			// data-userId --> $(this).data("userid");
			// 대소문자 주의!!!!!!!
			var dataValue = $(this).data("userid");
			console.log("dataValue : " + dataValue);

			// input 태그에 값 설정
			$('#userId').val(dataValue);

			// form 태그 이용 전송
			console.log("serialize : " + $('#frm').serialize());

			$('#frm').submit();
		});
	})
</script>


<form id="frm" action="${cp }/user/user" method="get">
	<input type="hidden" id="userId" name="userId"/>
</form>

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>

				<c:forEach items="${userList}" var="user">
					<tr class="userTr" data-userId="${user.userId}">
						<td>${user.userId} <input type="hidden" value="${user.userId}"/></td>
						<td>${user.userNm}</td>
						<td>${user.alias}</td>
						<td><fmt:formatDate value="${user.reg_dt }" pattern="yyyy/MM/dd"/></td>
					</tr>
				</c:forEach>

			</table>
		</div>

		<a href="${cp }/user/userForm" class="btn btn-default pull-right">사용자 등록<%=request.getParameter("page") %> / ${param.page }</a>

		<div class="text-center">
			<ul class="pagination">

				<%-- 이전 페이지 가기 : 지금 있는 페이지에서 한페이지 전으로
					  단 1페이지인 경우는 li 태그에 class="disabled"를 추가하고 이동 경로는 차단
				 --%>
				<c:choose>
					<c:when test="${pageVo.page == 1 }">
						<li class="disabled">
					      <a href="#" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					</c:when>
					<c:otherwise>
						<li>
					      <a href="${cp }/user/userPagingList?page=${pageVo.page-1 }" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					</c:otherwise>
				</c:choose>

				<c:forEach begin="1" end="${paginationSize}" var="page">
					<c:choose>
						<c:when test="${page == pageVo.page}">
							<li	class="active"><span>${page }</span></li>
						</c:when>
						<c:otherwise>
							<li><a href="${cp }/user/userPagingList?page=${page }">${page }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:choose>
					<c:when test="${pageVo.page == paginationSize }">
					    <li class="disabled">
					      <a href="#" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					</c:when>
					<c:otherwise>
						<li>
					      <a href="${cp }/user/userPagingList?page=${pageVo.page+1 }" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</div>