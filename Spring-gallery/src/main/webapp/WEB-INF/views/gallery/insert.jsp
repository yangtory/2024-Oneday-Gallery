<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<h1>이미지 업로드</h1>
<f:form enctype="multipart/form-data">
	<input type="text" placeholder="제목" name="g_subject">
	<textarea rows="10" placeholder="내용" name="g_content"></textarea>
	<div>
		<input type="file" name="file" accept="image/*" > 
		<input type="file" name="multi" accept="image/*" multiple>
	</div>
	<div>
		<img class="image" width="200px">
	</div>
	<div class="image"></div>
	<div class="image multi"></div>
	<input type="text" placeholder="Email" name="g_author">
	<input type="password" name="g_password">
	<input type="submit" value="저장">
</f:form>