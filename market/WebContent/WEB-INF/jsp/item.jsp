<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>제품 상세 정보</title>
</head>
	
<body>
	<form action="edit" method="post">
		<input type="hidden" name="itemSeq" value="${item.itemSeq}">
		이미지 <input type="text" name="image" value="${item.image}"> <br>
		상품명 <input type="text" name="name" value="${item.name}" readonly="readonly"> <br>
		타이틀 <input type="text" name="title" value="${item.title }" readonly="readonly"> <br>
		태그 <input type="text" name="tag" value="${item.tag}" readonly="readonly"> <br>
		가격 <input type="text" name="price" value="${item.price }" readonly="readonly"> <br>
		수량 <input type="text" name="count" value="${item.count}" readonly="readonly"> <br>
		상세설명 <br>
		<textarea rows="10" cols="30" name="detail" readonly="readonly">${item.detail}</textarea>
		<a href="/main"><input type="button" value="메인"/></a>
	</form>
</body>
</html>