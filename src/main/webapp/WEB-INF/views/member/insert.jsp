<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="../include/header.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function check(){
		alert("유효성 체크 완료");
	}

</script>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/memberPage.css" >
</head>
<body>
	<div class="header-form">
    	<h1>회원가입</h1>
    </div>
	<div class="login-form">
    	<form action="/insert" method="post" onsubmit="check();">
			<input type="text" name="id" class="text-field" placeholder="아이디"><br>
			<input type="password" name="pw" class="text-field" placeholder="비밀번호"><br>
			<input type="text" name="name" class="text-field" placeholder="이름"><br>
			<input type="submit" value="회원가입" class="submit-btn">
		</form>
	</div>
    <%--     	<form action="${pageContext.request.contextPath }/insert" method="post" onsubmit="check();"> --%>
<!--     	    아이디 : <input type ="text" name="id"><br> -->
<!--     	    비밀번호 : <input type ="password" name="pw"><br> -->
<!--     	    이름 : <input type="text" name="name"><br> -->
<!--     	    <input type="submit" value="회원가입하기" > -->
<!--     	</form>     -->
    
</body>
</html>
<%-- <%@ include file="../include/footer.jsp" %> --%>