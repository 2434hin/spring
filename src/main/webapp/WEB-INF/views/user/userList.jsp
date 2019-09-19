<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-basicLib</title>

<%@ include file="/WEB-INF/views/commonJsp/basicLib.jsp"%>

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

</head>

<body>

	<form id="frm" action="${cp }/user/user" method="get">
		<input type="hidden" id="userId" name="userId"/>
	</form>

	<!-- header -->
	<%@ include file="/WEB-INF/views/commonJsp/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@ include file="/WEB-INF/views/commonJsp/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


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

								<%-- for(User user : userList) --%>
								<c:forEach items="${userList}" var="user">
									<tr class="userTr" data-userId="${user.userId}">
										<input type="hidden" value="${user.userId}"/>
										<td>${user.userId}</td>
										<td>${user.userNm}</td>
										<td>${user.alias}</td>
										<td><fmt:formatDate value="${user.reg_dt }" pattern="yyyy-MM-dd"/></td>
<%-- 										<td>${user.reg_dt_fmt}</td> --%>
									</tr>
								</c:forEach>

							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>