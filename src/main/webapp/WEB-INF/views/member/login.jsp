<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="../include/header.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/memberPage.css" >

</head>
<body>
	<div class="header-form">
		<h1>로그인 후 입장가능</h1>
	</div>			
	<div class="login-form">
		<form action="/login" method="post">
			<input type="text" name="id" class="text-field" placeholder="아이디"><br>
			<input type="password" name="pw" class="text-field" placeholder="비밀번호"><br>
			<input type="submit" value="로그인" class="submit-btn">
			<input type="button" value="회원가입" class="submit-btn" onclick=" location.href='/insert';">
		</form>
	</div>
</body>
</html>
<%-- <%@ include file="../include/footer.jsp" %> --%>