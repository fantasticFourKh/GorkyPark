<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="title" value="Профиль пользователя" scope="page" />
<elem:head/>
<body>
	<mod:menu/>
	<div class="all">
		<div class="newsContainer">
			<div class="news">
				<p id="title">${user.lastName} ${user.firstName }</p>
				<hr />
				<div class="personal">
					<div class="personalData">
						<p>
							<strong>Логин</strong>: ${user.login }
						</p>
						<p>
							<strong>Дата рождения</strong>: ${user.dob }
						</p>
						<p>
							<strong>Электронный адрес</strong>: ${user.email }
						</p>
						<p>
							<strong>Номер телефона</strong>: ${user.phone }
						</p>
						<p>
							<strong>Дата регистрации</strong>: ${user.regDate }
						</p>
						<p>
							<strong>Статус (Заблокирован/Незаблокирован)</strong>:
							${user.statusBanned }
						</p>
					</div>
					<div class="dataButton">
						<div onclick="window.location.href='controller?command=ticketsUser'">
							<span>Мои билеты</span><span><img width="35" height="35"
								align="absmiddle" src="resources/image/icon/ticket.png" /></span>
						</div>
						<c:if test="${cartCount != '0'}">
							<div onclick="window.location.href='controller?command=basket'">
								<span>Корзина</span><span><img width="35" height="35"
									align="absmiddle" src="resources/image/icon/cart.png" /></span>
							</div>
						</c:if>
						<div onclick="window.location.href='controller?command=attractionCatalog'">
							<span>Каталог</span><span><img width="35" height="35"
								align="absmiddle" src="resources/image/icon/catalog.png" /></span>
						</div>
						<div onclick="window.location.href='index.html'">
							<span>Новости</span><span><img width="35" height="35"
								align="absmiddle" src="resources/image/icon/news.png" /></span>
						</div>
					</div>
				</div>
			</div>

			<div class="news">
				<p id="title">Изменить пароль</p>
				<hr />
				<form action="controller" method="get">
					<input type="hidden" name="command" value="changeUserPassword" />


					<table class="pass">
						<c:if test="${not empty message_1}">
							<tr>
								<td colspan="2" id="ok"><img src="resources/image/ok.png"
									align="absmiddle" />&nbsp;&nbsp;${message_1}</td>
							</tr>
						</c:if>
						<c:if test="${not empty errorMessage_1}">
							<tr>
								<td colspan="2" id="error"><img src="resources/image/alert.png"
									align="absmiddle" />&nbsp;&nbsp;${errorMessage_1}</td>
							</tr>
						</c:if>
						<tr>
							<td>Текущий пароль:</td>
							<td><input class="field" id="attrAdd" type="password"
								maxlength="16" name="curPass" /></td>

						</tr>
						<tr>
							<td>Новый пароль:</td>
							<td><input class="field" id="attrAdd" type="password"
								maxlength="16" name="newPass" /></td>
						</tr>
						<tr>
							<td>Повторите пароль:</td>
							<td><input class="field" id="attrAdd" type="password"
								maxlength="16" name="newPass2" /></td>
						</tr>
						<tr>
							<td colspan="2"><input class="btn" id="all" type="submit"
								value="Изменить" /></td>
						</tr>
					</table>

				</form>
			</div>
		</div>
		<c:remove var="message_1" scope="session" />
		<c:remove var="errorMessage_1" scope="session" />
		<mod:right/>
	</div>
</body>
</html>