<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<html>
<c:set var="title" value="ОШИБКА" scope="page" />
<elem:head/>

<body>

	<div class="middle_4">
		<div id="p">
			<h2 class="error">The following error occurred</h2>
			<c:if test="${not empty code}">
				<p id="p_info_red">
					Error code:
					<c:out value="${code}" />
				</p>
			</c:if>

			<c:if test="${not empty errorMessage}">
				<p id="p_info_red">
					<b><c:out value="${errorMessage}" /></b>
				</p>
			</c:if>
		</div>
	</div>
</body>
</html>