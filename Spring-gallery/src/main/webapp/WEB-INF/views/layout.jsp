<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include-head.jsp"%>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jsp"%>
	<section>
		<c:if test="${BODY == 'GALLERY_LIST'}">
			<%@ include file="/WEB-INF/views/gallery/list.jsp"%>
		</c:if>
		<c:if test="${BODY == 'GALLERY_INSERT' }">
			<%@ include file="/WEB-INF/views/gallery/insert.jsp"%>
		</c:if>
	</section>
</body>
</html>
