<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  	<h1> 회원정보 목록 </h1>
  	
  	<table border="1">
  		<tr>
  		   <td>아이디</td>
  		   <td>비밀번호</td>
  		   <td>이름</td>
  		   <td>회원가입일</td>
  		</tr>
  		
  		<c:forEach var="member" items="${memberList }">
	  		<tr>
	  		   <td>${member.userid }</td>
	  		   <td>${member.userpw }</td>
	  		   <td>${member.username }</td>
	  		   <td>${member.regdate }</td>
	  		</tr>
  		</c:forEach>
  		
  	</table>
  	
  	<h2><a href="/member/main">메인페이지</a></h2>
  	

</body>
</html>
<%@ include file="../include/footer.jsp" %>