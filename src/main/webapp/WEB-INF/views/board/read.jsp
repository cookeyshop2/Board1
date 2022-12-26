<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp" %>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">스프링 게시판 내용</h3>
				</div>
				<!-- /.box-header -->
					<form action="" role="form">
						<input type="hidden" name="bno" value="${vo.bno }">	
					</form>					
					
					<%-- ${sessionScope.upFlag } --%>

					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">글 번호</label>
							<input type="text" class="form-control" id="exampleInputEmail1"
							    name ="bno" value="${vo.bno }" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">조회수</label>
							<input type="text" class="form-control" id="exampleInputEmail1"
							    name ="viewcnt" value="${vo.viewcnt }" readonly="readonly">
						</div>
					
						<div class="form-group">
							<label for="exampleInputEmail1">글 제목</label>
							<input type="text" class="form-control" id="exampleInputEmail1"
							    name ="title" value="${vo.title }" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">글쓴이</label>
							<input type="text" class="form-control" id="exampleInputPassword1"
								name="writer" value="${vo.writer }" readonly="readonly">
						</div>
						
						<div class="form-group">
							<label>글 내용</label>
							<textarea class="form-control"  name="content"
							rows="3" readonly="readonly">${vo.content }</textarea>
						</div>
						
						
					</div>

					<div class="box-footer">
						<button type="submit" class="btn btn-primary">수정</button>
						<button type="submit" class="btn btn-danger">삭제</button>
						<button type="submit" class="btn bg-purple">목록</button>
					</div>


<!-- 댓글 -->
<ul>
	<c:forEach items="${reply}" var="reply">
		<li>
			<div>
			<p>${reply.writer} / <fmt:formatDate value="${reply.regdate}" pattern="yyyy-MM-dd" /></p>
			<p>${reply.content }</p>
			</div>
		</li>	
	</c:forEach>
</ul>
<!-- 댓글 -->

<div>

    <form method="post" action="/reply/write">
    
        <p>
            <label>댓글 작성자</label> <input type="text" name="writer">
        </p>
        <p>
            <textarea rows="5" cols="50" name="content"></textarea>
        </p>
        <p>
        	<input type="hidden" name="bno" value="${vo.bno}">
            <button type="submit">댓글 작성</button>
        </p>
    </form>
    
</div>


			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script type="text/javascript">
	$(document).ready(function(){
		// 목록 버튼 클릭시
		$('.bg-purple').click(function(){
			alert(' 목록 버튼 클릭! ');
			location.href='/board/listAll';
		});
		
		// 폼태그(객체) 정보
		var formObj = $('form[role="form"]');
		//alert(formObj);
		console.log(formObj);
		
		
		// 수정 버튼 클릭시 => 폼태그(bno) 사용해서 페이지 이동
		$('.btn-primary').click(function(){
			alert(' 수정 버튼 클릭 ! ');
			
			// 폼태그 정보 => submit()
			// 주소 (/board/modify)
			formObj.attr("action","/board/modify");
			// GET방식
			//formObj.attr("method","get");
			
			formObj.submit();			
		});
		/////////////////////////////////////////////////////////////////////
		
		// 삭제 버튼 클릭
		// /board/remove - POST 방식 
		$(".btn-danger").click(function(){
			alert(" 삭제 버튼 클릭 ");
			
			// 폼태그 action 정보 변경
			formObj.attr("action","/board/remove");
			// 폼태그 method 정보 변경
			formObj.attr("method","POST");
			
			// 페이지 이동		
			formObj.submit();
		});
		
		
		
		
	});// JQuery
	
	//$('.btn-primary').click(function(){});(x)
	
	
	
	
</script>





<%@ include file="../include/footer.jsp" %>
