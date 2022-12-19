<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>게시판 목록</h1>
<%-- ${boardList } --%>

<div class="box">
	<div class="box-header with-border">
		<h3 class="box-title">Bordered Table</h3>
	</div>

	<div class="box-body">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th style="width: 10px">번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th style="width: 40px">조회수</th>
				</tr>
				<c:forEach var="vo"  items="${boardList }">
					<tr>
						<td>${vo.bno }</td>
						<td>
							<a href="/board/read?bno=${vo.bno }">${vo.title }</a>
						</td>
						<td>${vo.writer }</td>
						<td>
						 <%-- <fmt:formatDate value="${vo.regdate }" type="both"/> --%>
						 <fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td><span class="badge bg-red">${vo.viewcnt }</span></td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>

	<div class="box-footer clearfix">
		<ul class="pagination pagination-sm no-margin pull-right">
		    <c:if test="${pageMaker.prev}">
		    	<li><a href="listAll${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
		    </c:if> 
		
		    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
		    	<li><a href="listAll${pageMaker.makeQuery(idx)}">${idx}</a></li>
		    </c:forEach>
		
		    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		    	<li><a href="listAll${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
		    </c:if> 
		</ul>
	</div>
</div>


<script type="text/javascript">
//    alert('${result}');
//    alert('${boardList[0].title}');
//    $(document).ready(function(){
// 	   $('body').append('${boardList[0].title}');
//    });

	var result = '${result}';
	
	if(result == "REGOK"){
		alert('글쓰기 완료!');
	}
	
	if(result == "MODOK"){
		alert(" 글 수정 완료! ");
	}
	
	if(result == "DELOK"){
		alert(" 글 삭제 완료! ");
	}



</script>


<%@ include file="../include/footer.jsp"%>
