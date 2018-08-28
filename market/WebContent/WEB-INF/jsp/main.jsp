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

	.wrapper{
	display: grid;
	grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
	}
	
</style>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/style.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
var bDisplay = true;
function doDisplay(){
    var con = document.getElementById("myDIV");
    if(con.style.display=='none'){
        con.style.display = 'block';
    }else{
        con.style.display = 'none';
    }
}


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
		
		인기 판매자 <br>
		<div style="text-align: center;">
			<c:set var="i" value="0" />
			<c:set var="j" value="5" />
			<table style="width: 100%;" id="tables">
				<c:if test="${ !empty memberList}">
				<div class="wrapper">
					<c:forEach items="${ memberList }" var="member" end="4" varStatus="status">
							<c:if test="${i%j == 0}">
								<tr>
							</c:if>
								<th>
									<div class="main_profile">
										<a href="<c:url value="/main/view/${member.memberSeq}" /> ">
											<div class="main_profile_image"><img style="border-radius: 70px;" src="../upload/${ profileList[status.index].randomName }" width="92" height="92"></div>
											<div class="main_profile_title"><c:out value="${ member.nick }" /></div>
										</a>
									</div>	
								</th>
							<c:if test="${i%j == j-1}">
								</tr>
							</c:if>
							<c:set var="i" value="${i+1}" />
						</c:forEach>
					</div>
				</c:if>
			</table>
		</div>
		<a onclick="this.nextSibling.style.display=(this.nextSibling.style.display=='none')?'block':'none';" href="javascript:void(0)"> 
		제목(이걸 누11르면 열기,닫기가 됩니다.)
		</a><div style="DISPLAY: none">
		<div style="text-align: center;">
			<table style="width: 100%;" id="tables">
				<c:if test="${ !empty memberList}">
					<c:forEach items="${ memberList }" var="member"  varStatus="status">
							<c:if test="${status.count > 5}">
							<c:if test="${i%j == 0}">
								<tr>
							</c:if>
							<th>
								<div class="main_profile">
									<a href="<c:url value="/main/view/${member.memberSeq}" /> ">
										<div class="main_profile_image"><img style="border-radius: 70px;" src="../upload/${ profileList[status.index].randomName }" width="92" height="92"></div>
										<div class="main_profile_title"><c:out value="${ member.nick }" /></div>
									</a>
								</div>	
							</th>
							<c:if test="${i%j == j-1}">
								</tr>
							</c:if>
							<c:set var="i" value="${i+1}" />
							</c:if>
					</c:forEach>
				</c:if>
			</table>
		</div>
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