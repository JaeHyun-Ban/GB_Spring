<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>권한이 있어야 접근 가능한 MYPAGE</h2>
	
	전송내용 확인
	${sessionScope.user_id }<br/>
	${sessionScope.user_name }<br/>
	
	마이페이지.........................<br/>
	<a href="logout">로그아웃</a>
	
</body>
</html>