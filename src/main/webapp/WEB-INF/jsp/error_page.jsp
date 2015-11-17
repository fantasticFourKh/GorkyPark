<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="title" value="ОШИБКА" scope="page" />
<elem:head/>

<body>

	<div class="middle_4">
		<div id="p">
			<h2 class="error">The following error occurred</h2>

			<c:set var="code"
				value="${requestScope['javax.servlet.error.status_code']}" />

			<c:set var="message"
				value="${requestScope['javax.servlet.error.message']}" />

			<c:if test="${not empty code}">
				<p id="p_info_red">
					Error code:
					<c:out value="${code}" />
				</p>
			</c:if>

			<c:if test="${not empty message}">
				<p id="p_info_red">
					<c:out value="${message}" />
				</p>
			</c:if>

			<c:if test="${not empty errorMessage}">
				<p id="p_info_red">
					<font id="log"><b><c:out value="${errormessage}" /></b></font>
				</p>
			</c:if>
		</div>
	</div>
</body>
</html>