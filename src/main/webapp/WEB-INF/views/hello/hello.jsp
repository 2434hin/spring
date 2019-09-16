<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>hello.jsp</h2>
	<%-- model 객체에 추가한 속성 두가지 noeDt, msg --%>
	<%=request.getAttribute("nowDt") %> <br>
	<%=request.getAttribute("msg") %> <br><br>
	${nowDt } <br>
	${msg } <br>
</body>
</html>