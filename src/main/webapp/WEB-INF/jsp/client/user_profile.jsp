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
			<div>
				<p id="title">${user.login }</p>
				<hr />
				<p>
					<strong>Имя</strong>: ${user.firstName }
				</p>
				<p>
					<strong>Фамилия</strong>: ${user.lastName }
				</p>
				<p>
					<strong>Дата рождения</strong>: ${user.dob }
				</p>
				<p>
					<strong>Электронный адрес</strong>: ${user.email }
				</p>
				<p>
					<strong>Дата регистрации</strong>: ${user.regDate }
				</p>
			</div>
		</div>
		<mod:right/>
	</div>
</body>
</html>