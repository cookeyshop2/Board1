<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  	<fieldset>
  	  <form action="/delete" method="post">
  	  	 비밀번호 : <input type="password" name="userpw">
  	  	 <input type="submit" value="회원탈퇴">
  	  </form>  	
  	</fieldset>
  	
  	

</body>
</html>
<%@ include file="../include/footer.jsp" %>