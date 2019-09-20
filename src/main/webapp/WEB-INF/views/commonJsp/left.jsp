<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<ul class="nav nav-sidebar">
	<!-- a tag : get method -->
	<li class="active"><a href="<%=request.getContextPath() %>/user/userList"><span class="glyphicon glyphicon-music"></span> 사용자리스트 <span class="sr-only">(current)</span></a></li>
	<li class="active"><a href="<%=request.getContextPath() %>/user/userListOnlyHalf">사용자리스트(onlyHalf) <span class="sr-only">(current)</span></a></li>
	<li class="active"><a href="<%=request.getContextPath() %>/user/userPagingListAjaxView">사용자 페이징 리스트 <span class="sr-only">(current)</span></a></li>

	<li class="active"><a href="<%=request.getContextPath() %>/lprod/lprodList">제품그룹리스트</a></li>
	<li class="active"><a href="<%=request.getContextPath() %>/lprod/lprodPagingList">제품그룹 페이징 리스트</a></li>
</ul>