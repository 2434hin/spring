<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	$(document).ready(function () {

		$(".lprodTr").on('click', function () {

			var dataValue = $(this).data("lprodgu");

			$('#lprod_Gu').val(dataValue);

			$('#frm').submit();
		});
	})
</script>

</head>

<body>

	<form id="frm" action="${cp }/prodList" method="get">
		<input type="hidden" id="lprod_Gu" name="lprod_Gu"/>
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
						<h2 class="sub-header">제품그룹리스트</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>lprod_id</th>
									<th>lprod_gu</th>
									<th>lprod_nm</th>
								</tr>

								<c:forEach items="${lprodList}" var="lprod">
									<tr class="lprodTr" data-lprodGu="${lprod.lprod_gu}">
										<td>${lprod.lprod_id}</td>
										<td>${lprod.lprod_gu}</td>
										<td>${lprod.lprod_nm}</td>
									</tr>
								</c:forEach>

							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>