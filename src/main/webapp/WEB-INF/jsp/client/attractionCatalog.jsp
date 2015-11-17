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
				<span id="add"> <c:if test="${userRole == 'admin' }">
						<div onclick="window.location.href='#add_form'"
							class="addSettingAttraction">
							<span>Добавить аттракцион</span> <img width="30" height="30"
								align="absmiddle" src="image/setting.png" />
						</div>
					</c:if>
				</span> <a href="#x" class="overlay" id="add_form"></a>
				<div class="popup">
					<p id="title">Добавление аттракциона</p>
					<hr />
					<form action="controller" method="post" name="attraction"
						enctype="multipart/form-data">
						<input type="hidden" name="command" value="addAttraction" />

						<table class="addAttraction">
							<c:if test="${not empty addErrorMessage}">
								<tr>
									<td colspan="2" id="error"><img src="image/alert.png"
										align="absmiddle" />&nbsp;&nbsp;${addErrorMessage}</td>
								</tr>
							</c:if>
							<tr>
								<td>Название:&nbsp;</td>
								<td><input class="field" id="attrAdd" type="text"
									name="title" /></td>
							</tr>
							<tr>
								<td>Минимальный рост&nbsp;(см):&nbsp;</td>
								<td><input class="field" id="attrAdd" type="number"
									min="50" max="250" value="50" name="height" /></td>
							</tr>
							<tr>
								<td>Цена взрослый:&nbsp;</td>
								<td><input class="field" id="attrAdd" type="number"
									name="adult_price" /></td>
							</tr>
							<tr>
								<td>Цена детский:&nbsp;</td>
								<td><input class="field" id="attrAdd" type="number"
									name="child_price" /></td>
							</tr>
							<tr>
								<td>Описание:&nbsp;</td>
								<td><textarea rows="10" cols="35" name="desc"></textarea></td>
							</tr>
							<tr>
								<td>Фото:&nbsp;</td>
								<td><input type="file" class="btn" id="attrAdd"
									name="image" /></td>
							</tr>
							<tr>
								<td colspan="2"><input class="btn" id="all" type="submit"
									value="Добавить" /></td>
							</tr>
						</table>

					</form>
					<a class="close" href="#close"></a>
				</div>

				<p id="title">Аттракционы</p>
				<hr />
				<c:forEach items="${attractions }" var="item">
					<div class="attraction">
						<div class="attrDesc" id="attrDescTop">
							<h2>${item.title}</h2>
						</div>
						<img
							src="controller?command=imageGenerator&imgpath=${item.image }" />
						<div class="img">
							<a href="controller?command=orderTicketPage&id=${item.id }">
							</a>
						</div>
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