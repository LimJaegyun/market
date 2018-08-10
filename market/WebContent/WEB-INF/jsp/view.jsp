<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>중고장터 상세조회</title>
</head>
<script type="text/javascript">
	function postSend(path) {
		method = "post";
		var form = document.createElement("form");
	    form.setAttribute("method", method);
	    form.setAttribute("action", path);
	    
	    var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", "memberSeq");
        hiddenField.setAttribute("value", ${sessionNo});
        form.appendChild(hiddenField);
         
	    document.body.appendChild(form);

	    form.submit();
	}
</script>

<body>
	<form action="/main/view" method="post">
		<input type="hidden" name="memberSeq" value="${member.memberSeq }"/>
		판매자 정보<br>
		<div style="text-align: center;">
			<table style="width: 100%;" border="1" id="tables">
				<thead>
					<tr bgcolor="#4C4639">
						<th style="width: 40px; text-align: center;">
							<font color="#FFFFFF">닉네임</font>
						</th>
						<th style="width: 40px; text-align: center;">
							<font color="#FFFFFF">판매상품</font>
						</th>
						<th style="width: 40px; text-align: center;">
							<font color="#FFFFFF">판매횟수</font>
						</th>
						<th style="width: 40px; text-align: center;">
							<font color="#FFFFFF">방문자수</font>
						</th>
						<th style="width: 40px; text-align: center;">
							<font color="#FFFFFF">상점등록</font>
						</th>
					</tr>
				</thead>
					<tr>
						<td style="text-align: center;">
							<c:out value="${member.nick}" />
						</td>
						<td style="text-align: center;">
							<c:out value="${ member.saleItem }" />
						</td>
						<td style="text-align: center;">
							<c:out value="${ member.saleCount }" />
						</td>
						<td style="text-align: center;">
							<c:out value="${ member.visit }" />
						</td>
						<td style="text-align: center;">
							<c:out value="${ member.store }" />
						</td>
					</tr>
			</table>
		</div>
		판매자 상품
		<div style="text-align: center;">
			<table style="width: 100%;" border="1" id="tables">
				<thead>
					<tr bgcolor="#4C4639">
						<th style="width: 40px; text-align: center;">
							<font color="#FFFFFF">번호</font>
						</th>
						<th style="width: 40px; text-align: center;">
							<font color="#FFFFFF">품명</font>
						</th>
						<th style="width: 40px; text-align: center;">
							<font color="#FFFFFF">이미지</font>
						</th>
						<th style="width: 40px; text-align: center;">
							<font color="#FFFFFF">가격</font>
						</th>
						<th style="width: 40px; text-align: center;">
							<font color="#FFFFFF">삭제</font>
						</th>
					</tr>
				</thead>
				<c:if test="${ !empty itemList}">
					<c:forEach items="${ itemList }" var="item" varStatus="status">
						<tr>
							<td style="text-align: center;">
								<c:out value="${status.count}" />
							</td>
							<td style="text-align: center;">
								<a href="/main/item/${item.itemSeq }"><c:out value="${ item.name }" /></a>
							</td>
							<td style="text-align: center;">
								<c:out value="${ item.image }" />
							</td>
							<td style="text-align: center;">
								<c:out value="${ item.price }원" />
							</td>
							<td style="text-align: center;">
								<a href="/main/item/remove/${item.itemSeq }"><input type="button" value="삭제"/></a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
		
		<c:if test="${sessionNo eq member.memberSeq}">
			<a href="/main/add"><input type="button" value="등록"></a>
		</c:if>
		<input type="button" onclick="javascript:postSend('/main')" value="목록">
	</form>
</body>
</html>