<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


		<!-- 파일업로드 폼태그의 enctype을 nultipart/form-data으로 반드시 설정 -->
		
		<form action="upload_ok" method="post" enctype="multipart/form-data">
			파일선택:<input type="file" name="file"><br/>
			<input type="submit" value="확인">
		</form>
		
		<hr>
		
		
		<!-- 여러파일 업로드: multifile옵션 사용 -->
		<form action="upload_ok2" method="post" enctype="multipart/form-data">
			다중파일선택: <input type="file" name="files" multiple="multiple"><br/>
			<input type="submit" value="확인">
		</form>
		
		
		<hr>
		
		<!-- 여러파일 업로드: 복수태그선택 방법 -->
		<form action="upload_ok3" method="post" enctype="multipart/form-data">
			파일선택:<input type="file" name="file"><br/>
			파일선택:<input type="file" name="file"><br/>
			파일선택:<input type="file" name="file"><br/>
			<input type="submit" value="확인">
		</form>
		
		<hr>
		
		<!-- 가변적인 form일 경우 -->
		<form action="upload_ok4" method="post" enctype="multipart/form-data">
			<!-- 이름에 미리 순서를 지정 -->
			<input type="text" name="list[0].name">
			파일선택:<input type="file" name="list[0].file"><br/>
			<input type="text" name="list[1].name">
			파일선택:<input type="file" name="list[1].file"><br/>
			<input type="text" name="list[2].name">
			파일선택:<input type="file" name="list[2].file"><br/>
			<input type="submit" value="확인">
		</form>
		
		
</body>
</html>











