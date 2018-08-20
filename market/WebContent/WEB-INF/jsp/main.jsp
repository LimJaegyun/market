<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	   $("#keyword").keyup(function(){
		   
	      var input = $("#keyword").val();
	      $.ajax({
	         url:"main",
	         data:{input : input},
	         type:"post",
	         datatype: 'json',
	         contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	         success:function(data) {
	        	 var show;
	        	 $.each(data, function(idx, val) {
	                 show+= "<td><a href=/main/keyword/" + val.keywordSeq +  ">" + val.keyword + "</a></td>";
	              });
	        	 $("#keywordsss").html(show);
	         }, 
	         error: function (data) {
	        	 var show;
	        	 <c:forEach items="${ keywordList }" var="keyword" varStatus="status">
	              	show+= "<td><a href='<c:url value='/main/keyword/${keyword.keywordSeq}'/> '>" + '${keyword.keyword}' + "</a></td>";
	              </c:forEach>
	        	 $("#keywordsss").html(show);
	           }
	      });
	   });
	});
</script>

<head>

<meta charset="UTF-8">
<title>중고장터</title>
</head>
<body>
	<form action="/main" method="post">
		<a href="<c:url value="/main/view/${sessionNo}"/>"> <input
			type="button" value="마이페이지">
		</a> <a href="<c:url value="/main/logout"/>"> <input type="button"
			value="로그아웃">
		</a> 
		<br><br> 
		검색 <input type="text" id="keyword" />
		<input type="text" id="search" />
		<br><br>
		실시간 인기 키워드 <br><br>
		<div style="text-align: center;">
			<table id="keywordsss">
					<c:if test="${ !empty keywordList}">
						<c:forEach items="${ keywordList }" var="keyword" varStatus="status">
								<td style="text-align: center;">
									<a href="<c:url value="/main/keyword/${keyword.keywordSeq}" /> ">
										<c:out value="${ keyword.keyword }" />
									</a>
									&nbsp;&nbsp;
								</td>
						</c:forEach>
					</c:if>
			</table>
		</div>
		인기 판매자 <br>
		<div style="text-align: center;">
			<table style="width: 100%;" id="tables">
				<tr>
					<c:if test="${ !empty memberList}">
						<c:forEach items="${ memberList }" var="member" end="4" varStatus="status">
							<td>
								<a href="<c:url value="/main/view/${member.memberSeq}" /> ">
									<img style="border-radius: 70px;" src="../upload/${ profileList[status.index].randomName }" width="92" height="92">
									<c:out value="${ member.nick }" />
								</a>
							<td>
						</c:forEach>
					</c:if>
				<tr>
			</table>
		</div>
		<br><br>
		판매중인 상품<br>
		<div style="text-align: center;">
			<table style="width: 100%;" id="tables">
				<tr>
					<c:if test="${ !empty itemList}">
						<c:forEach items="${ itemList }" var="item" varStatus="status">
							<td>
								<a href="<c:url value="/main/item/${item.itemSeq}" /> ">
									<img src="../upload/${ imageList[status.index].randomName }" width="92" height="92">
									<c:out value="${ item.name }" />
									<c:forEach items="${ memberList }" var="member" varStatus="status">
										<c:if test="${item.memberSeq eq member.memberSeq}">
											<c:out value="${ item.price }원" />
											<c:out value="${ member.nick}" />
										</c:if>
									</c:forEach>
								</a>
							</td>
						</c:forEach>
					</c:if>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>