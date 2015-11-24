<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="title" value="Аттракционы" scope="page" />
<elem:head/>

<body>
	<mod:menu/>
	<div class="all">
		<div class="newsContainer">
			<div class="news">
				<span id="add"> <c:if test="${userRole.name == 'admin' }">
						<div onclick="window.location.href='#add_form'"
							class="addSettingAttraction">
							<span>Добавить аттракцион</span> <img width="30" height="30"
								align="absmiddle" src="image/setting.png" />
						</div>
					</c:if>
				</span>
				<mod:addAttraction/>

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
		<c:remove var="addErrorMessage" scope="session" />
		<mod:right/>
	</div>
</body>
</html>