<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script>

	$(document).ready(function () {

		   //사용자 등록 버튼 클릭 이벤트 핸드러
		   $("#regBtn").on("click", function(){
// 		      var userIdValidationChk = /^([a-zA-Z\d\.@]){5,20}$/.test($("#userId").val())
// 		      if(userIdValidationChk == false){
// 		         alert("사용자 아이디 유효하지 않음");
// 		         $("#userId").focus();
// 		         return false;
// 		      }

		      //submit;
		      $("#frm").submit();

		   })

		// 우편번호 건색 버튼 클릭 이벤트 핸들러
		$('#zipcodeBtn').on('click', function () {
		    new daum.Postcode({
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		            // 김혜인바보
		            console.log(data);
		            $('#addr1').val(data.roadAddress);	// 도로주소(addr1)
		            $('#zipcode').val(data.zonecode);		// 우편번호(zipcode)
		        }
		    }).open();
		})
	})

	function setTestData() {
		$('#userId').val("brownTest");
		$('#userNm').val("브라운테스트");
		$('#alias').val("곰테스트");
		$('#reg_dt').val("2019-08-08");
		$('#addr1').val("대전광역시 중구 중앙로 76");
		$('#addr2').val("영민빌딩 2층 DDIT");
		$('#zipcode').val("34940");
		$('#pass').val("brownTest1234");
	}
</script>

</head>

<body>

	<!-- header -->
	<%@ include file="/WEB-INF/views/commonJsp/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@ include file="/WEB-INF/views/commonJsp/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<%-- 파일전송은 post메소드만 가능 --%>
				<form id="frm" class="form-horizontal" role="form"
					  action="${cp }/user/userForm" method="post"
					  enctype="multipart/form-data">

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<input type="file" class="form-control" id="picture" name="picture"
								placeholder="사용자 사진">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" name="userId"
								placeholder="사용자 아이디" value="${param.userId }">
							<font color="red"><form:errors path="user.userId"/></font>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userNm" name="userNm"
								placeholder="사용자 이름" value="${param.userNm }">
						</div>
					</div>

					<div class="form-group">
						<label for="alias" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="alias" name="alias"
								placeholder="별명" value="${param.alias }">
						</div>
					</div>

					<div class="form-group">
						<label for="reg_dt" class="col-sm-2 control-label">생일</label>
						<div class="col-sm-10">
							<input type="date" class="form-control" id="reg_dt" name="reg_dt"
								placeholder="생일" value="${param.reg_dt }">
						</div>
					</div>

					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소1</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="addr1" name="addr1"
								placeholder="주소1" value="${param.addr1 }" readonly>
						</div>
						<div class="col-sm-2">
							<button type="button" id="zipcodeBtn" class="btn btn-default">우편번호</button>
						</div>
					</div>

					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">주소2</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr2" name="addr2"
								placeholder="주소2" value="${param.addr2 }">
						</div>
					</div>

					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="zipcode" name="zipcode"
								placeholder="우편번호" value="${param.zipcode }" readonly>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass" name="pass"
								placeholder="비밀번호">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" id="regBtn" class="btn btn-default">사용자 등록</button>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
</body>
</html>