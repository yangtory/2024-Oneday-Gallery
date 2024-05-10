<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<div class="btn_box">
	<a href="${rootPath }/insert">이미지 업로드</a>
</div>
<div class="gallery">
	<c:forEach items="${LIST }" var="L">
	<div>
		<img src="${rootPath }/upload/${L.g_up_image }" width="200px">
	</div>
	</c:forEach>
</div>
