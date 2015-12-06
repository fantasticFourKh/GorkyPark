<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="title" value="Аттракционы" scope="page" />
<elem:head/> /attraction/view

<body>
	<mod:menu/>
	<div class="main">
		<div class="main-container">
			<div class="main-container-content">
				<span id="add"> <c:if test="${userRole.name == 'admin' }">
						<a href="/attraction/page" class="addSettingAttraction">
							<span>Добавить аттракцион</span> <img width="30" height="30"
								align="absmiddle" src="image/setting.png" />
						</a>
					</c:if>
				</span>
				<p id="title">Аттракционы</p>
				<hr />
				<c:forEach items="${attractions }" var="item">
					<div class="attraction">
						<div class="attrDesc" id="attrDescTop">
							<h2>${item.title}</h2>
						</div>
						<img src="/image?imgPath=${item.image }" />
						<div class="attrDesc" id="attrDescBottom">
							Взрослый:&nbsp;${item.adultPrice}&nbsp;Грн<br />Детский:&nbsp;${item.childPrice}&nbsp;Грн
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<mod:right/>
	</div>
</body>
</html>