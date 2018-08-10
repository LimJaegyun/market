<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>키워드로 조회하고 있어요</title>
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
	<form action="main/keyword" method="POST">
		검색어 : ${keyword}<br>
		검색어 해당 목록
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
							<font color="#FFFFFF">태그</font>
						</th>
						<th style="width: 40px; text-align: center;">
							<font color="#FFFFFF">가격</font>
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
								<c:out value="${ item.name }" />
							</td>
							<td style="text-align: center;">
								<c:out value="${ item.image }" />
							</td>
							<td style="text-align: center;">
								<c:out value="${ item.tag }" />
							</td>
							<td style="text-align: center;">
								<c:out value="${ item.price }원" />
							</td>
						</tr>
						<br>
					</c:forEach>
				</c:if>
			</table>
		</div>
		<input type="button" onclick="javascript:postSend('/main')" value="목록">
	</form>
</body>
</html>