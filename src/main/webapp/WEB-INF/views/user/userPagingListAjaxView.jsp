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
	//문서 로딩이 완료되고 나서
	$(document).ready(function(){
	   
		// 문서로딩이 되면 자동으로 1페이지 리스트를 가져온다.
		getUserHtmlList(1,10);
		
	   //사용자 정보 클릭시 이벤트 핸들러
	   $("#userListTbody").on("click", ".userTr", function(){
	      
	      console.log("userTr click");
	      
	      //클릭된 tr 태그의 자식태그(td)중 첫번째 자식의 텍스트 문자열
	                  
	      //td태그의 텍스트 가져오기(두번째 자식)
	      var tdText = $($(this).children()[1]).text();
	      console.log("tdText : " + tdText);
	      
	      //input태그에 저장된 값 확인
	      var inputValue = $(this).find("input").val();
	      console.log("inputValue : " + inputValue);
	      
	      //data속성으로 값 가져오기
	      //data속성명은 소문자로 치환된다!!
	      //data-userId --> $(this).data("userid");
	      //대소문자 주의!!!!!!
	      var dataValue = $(this).data("userid");
	      console.log("dataValue : " + dataValue);
	      
	      //input 태그에 값 설정
	      $("#userId").val(dataValue);
	      
	      //form 태그이용 전송
	      console.log("serialize : "  + $("#frm").serialize());
	      
	      $("#frm").submit();
	   });
	});
	
	// ajax 응답을 html로 받는다.(html javascript로 생성하는 작업을 줄인다)
	function getUserHtmlList(page, pagesize) {
	   $.ajax({
	      url : "${cp}/user/userPagingListHtmlAjax",
	      
	      // 파라미터 -> json
	      data : "page=" + page + "&pagesize=" + pagesize,
	      success : function (data) {
	    	  
	         console.log(data);
	         var html = data.split("#############!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	         
	         $('#userListTbody').html(html[0]);
	         $(".pagination").html(html[1]);
	         
	      }
	   });
	}
	
	//:) 
	function getUserListRequestBody(page, pagesize) {
		var param = {};
		param.page = page;
		param.pagesize = pagesize;
		console.log("param : " + param);
		
	   $.ajax({
	      url : "${cp}/user/userPagingListAjaxRequestBody",
	      contentType : "application/json",
	      method : "post",
	      dataType : "json",
	      data : JSON.stringify(param),
	      success : function (data) {
	         createUserListTbody(data.userList);   //userList html 생성
	         createPagination(data.pageVo, data.paginationSize);   //페이지네이션 html생성
	         
	      }
	   });
	}
	
	//ajax call을 통해 page, pagesize 하는 사용자
	//데이터를 가져온다
	function getUserList(page, pagesize) {
	   $.ajax({
	      url : "${cp}/user/userPagingListAjax",
	      data : "page=" + page + "&pagesize=" + pagesize,
	      success : function (data) {
	         
	         createUserListTbody(data.userList);   //userList html 생성
	         createPagination(data.pageVo, data.paginationSize);   //페이지네이션 html생성
	         
	      }
	   });
	}
	
	function createPagination(pageVo, paginationSize) {
	   var html = "";
	   if(pageVo.page == 1){
	      html += "<li class='disabled'>";
	      html += "   <span aria-hidden='true'>&laquo;</span>";
	      html += "</li>";
	   }else {
	      html += "<li>";
	      html += "   <a href='javascript:getUserList(" + (pageVo.page-1) + "," + pageVo.pagesize + ")' aria-label='Previous'>";
	      html += "      <span aria-hidden='true'>&laquo;</span>";
	      html += "   </a>";
	      html += "</li>";
	   }
	   
	   for(var page = 1; page <= paginationSize; page++){
	      if(page == pageVo.page){
	         html += "<li class='active'><span>" + page + "</span></li>";
	      }else {
	         html += "<li>";
	         html += "   <a href='javascript:getUserList(" + page + "," + pageVo.pagesize + ")'>" + page + "</a>";
	         html += "</li>";
	      }
	   }
	   
	   //:)
	   if(pageVo.page == paginationSize){
	      html += "<li class='disabled'>";
	      html += "   <span aria-hidden='true'>&raquo;</span>";
	      html += "</li>";
	   }else {
	      html += "<li>";
	      html += "   <a href='javascript:getUserList(" + (pageVo.page+1) + "," + pageVo.pagesize + ")' aria-label='Next'>";
	      html += "      <span aria-hidden='true'>&raquo;</span>";
	      html += "   </a>";
	      html += "</li>";
	   }
	
	   $(".pagination").html(html);
	}
	
	function createUserListTbody(userList) {
	   //사용자 데이터 list
	   //기존 데이터 제거
	   $("#userListTbody").empty();
	   var html = "";
	   userList.forEach(function (user, idx) {
	      html += "<tr>";            
	      html += "   <td>" + user.userId + "</td>";            
	      html += "   <td>" + user.userNm + "</td>";            
	      html += "   <td>" + user.alias + "</td>";            
	      html += "   <td>" + user.reg_dt + "</td>";            
	      html += "</tr>";            
	   });
	   //완성된 userList 데이터를 tbody 영역에 추가
	   $("#userListTbody").html(html);
	   
	}
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
								<tbody id="userListTbody">
								
								</tbody>
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
									<%-- 방법1 --%>
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
			</div>
		</div>
	</div>
</body>
</html>