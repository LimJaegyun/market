<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
	.main_profile_image{
	border-radius:70px;
    border: 1px solid red;
    width: 92px;
    height: 92px;
}
	.main_profile_title{
	border: 1px solid pink;
    width: 92px;
    height: 26px;
}

/* 	.main_info{
    width: 306px;
    height: 30px;
} */

	.main_profile{
    /* background-color: yellow;*/
    border: 1px solid blue;
    float: left; width:33%; padding-left:60px; padding-right:60px;
    width: 95px;
    height: 122px;
}

	.main_item_image{
    border: 1px solid red;
    width: 152px;
    height: 92px;
}
	.main_item_title{
	border: 1px solid pink;
    width: 152px;
    height: 26px;
}

 	.main_item_price{
 	border: 1px solid black;
    width: 152px;
    height: 30px;
}

	.main_item_info{
 	border: 1px solid green;
    width: 152px;
    height: 20px;
}

	.main_item{
    /* background-color: yellow;*/
    border: 1px solid blue;
    float: left; width:33%; padding-left:30px; padding-right:30px;
    width: 155px;
    height: 175px;
}
   
/* .main_common{
    display: inline-block;
    float: left;
    width: 100px;
    height: 100px;
    border: 1px solid blue;
} */
</style>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
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
	         }, 
	         error: function (data) {
	              var show = "<thead><tr><th>번호</th><th>전화번호</th><th>닉네임</th><th>가입날짜</th><th>상세보기</th></tr></thead>";
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
		<a href="<c:url value="/main/view/${sessionNo}"/>">
			<input type="button" value="마이페이지">
		</a>
		<a href="<c:url value="/main/logout"/>">
			<input type="button" value="로그아웃">
		</a>
		<br>
		<!-- 검색 <input type="text" id="keyword" /> -->
		<br><br>
		실시간 인기 키워드 <br><br>
		<div style="text-align: center;">
			<c:if test="${ !empty keywordList}">
				<c:forEach items="${ keywordList }" var="keyword" varStatus="status">
					<tr>
						<td style="text-align: center;">
							<a href="<c:url value="/main/keyword/${keyword.keywordSeq}" /> ">
								<c:out value="${ keyword.keyword }" />
							</a>
							&nbsp;&nbsp;
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</div>
		인기 판매자 <br>
		<div style="text-align: center;">
			<table style="width: 100%;" id="tables">
				<c:if test="${ !empty memberList}">
					
					<c:forEach items="${ memberList }" var="member" end="4" varStatus="status">
							<div class="main_profile">
								<a href="<c:url value="/main/view/${member.memberSeq}" /> ">
									<div class="main_profile_image"><img style="border-radius: 70px;" src="../upload/${ profileList[status.index].randomName }" width="92" height="92"></div>
									<div class="main_profile_title"><c:out value="${ member.nick }" /></div>
								</a>
							</div>
					</c:forEach>
				</c:if>
			</table>
		</div>
		<br><br>
		판매중인 상품<br>
		<div style="text-align: center;">
			<table style="width: 100%;" id="tables">
				<c:if test="${ !empty itemList}">
					<c:forEach items="${ itemList }" var="item" varStatus="status">
						<div class="main_item">
							<a href="<c:url value="/main/item/${item.itemSeq}" /> ">
								<div class="main_item_image"><img src="../upload/${ imageList[status.index].randomName }" width="92" height="92"></div>
								<div class="main_item_title"><c:out value="${ item.name }" /></div>
								<c:forEach items="${ memberList }" var="member" varStatus="status">
									<c:if test="${item.memberSeq eq member.memberSeq}">
										<div class="main_item_price"><c:out value="${ item.price }원" /></div>
										<div class="main_item_info"><c:out value="${ member.nick}" /></div>
									</c:if>
								</c:forEach>
							</a>
						</div>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</form>
</body>
</html>