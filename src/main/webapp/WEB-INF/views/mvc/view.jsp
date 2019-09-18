<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${cp }/js/jquery-3.4.1.min.js"></script>

<script>
	$(document).ready(function () {
		// pathBtn이 클릭 될때 이벤트 핸들러
		$('#pathBtn').on('click', function () {
			var subpath = $('input[name=path]:checked').val();
			
			$('#frm').attr('action', '${cp}/mvc/path/' + subpath);
			$('#frm').submit();
		})
	})
</script>
</head>
<body>
	<h2>mvc/view.jsp</h2>
	
	<h3>redirect Attribute</h3>
	<form action="${cp }/mvc/redirect">
		<input type="text" name="userId" value="brown"/> <br>
		<input type="submit" value="전송"/>
	</form>
	
	<h3>requestParam</h3>
	<form action="${cp }/mvc/requestParam" method="post">
		userId : <input type="text" name="userId" value="sally"/><br>
		<input type="submit" value="전송"/>
	</form>
	
	<h3>pathVariable</h3>
	<form id="frm">
		brown <input type="radio" name="path" value="brown" checked/><br>
		sally <input type="radio" name="path" value="sally"/><br>
		<input type="button" id="pathBtn" value="전송"/>
	</form>
	
	<h3>requestPart</h3>
	<form id="frmPart" action="${cp }/mvc/upload" 
		  enctype="multipart/form-data" method="post">
		<input type="text" name="userId" value="brown"/> <br>
		<input type="file" name="picture"/> <br> 
		<input type="submit" value="전송"/>
	</form>
	
	<h3>multi parameter</h3>
	<form action="${cp }/mvc/multiParameter" method="post">
		<input type="text" name="userId" value="brown"/> <br>
		<input type="text" name="userId" value="sally"/> <br>
		<input type="text" name="addr.addr1" value="대전시 중구 중앙로 76"/> <br>
		<input type="text" name="addr.addr2" value="DDIT"/> <br>
		
		<input type="text" name="addrList[0].addr1" value="대전시 중구 중앙로 76 list1"/> <br>
		<input type="text" name="addrList[0].addr2" value="DDIT list1"/> <br>
		
		<input type="text" name="addrList[1].addr1" value="대전시 중구 중앙로 76 list2"/> <br>
		<input type="text" name="addrList[1].addr2" value="DDIT list2"/> <br>
		
		<input type="submit" value="전송"/>
	</form>
</body>
</html>