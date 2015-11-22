<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="title" value="Главная" scope="page" />
<elem:head/>
<body>
	<mod:menu/>
	<div class=all>
		<div class="newsContainer">
			<div class="settings">
				<b>Поиск:</b>

				<form class="none" action="controller" method="get">
					<input type="hidden" name="command" value="search" />

					<c:choose>
						<c:when test="${not empty searchQuery}">
							<input class="field" id="min-err" type="text" name="query"
								value="${searchQuery}" placeholder="поисковый запрос..." />
						</c:when>
						<c:otherwise>
							<input class="field" id="min" type="text" name="query"
								placeholder="поисковый запрос..." />
						</c:otherwise>
					</c:choose>
					<input class="search" type="submit" value=""></input>
				</form>
				<a id="nondecoration" href="controller?command=sort&sortType=1"><span
					id="brd">Комментарии&nbsp;&nbsp;<img align="absmiddle"
						src="resources/image/sort.png" /></span></a><a id="nondecoration"
					href="controller?command=sort&sortType=2"><span>Дата
						добавления&nbsp;&nbsp;<img align="absmiddle" src="resources/image/sort.png" />
				</span></a>
				<c:if test="${userRole.name == 'admin'}">
					<div class="addNews" onclick="window.location.href='#add_news'">+</div>

					<a href="#x" class="overlay" id="add_news"></a>
					<div class="popup">
						<p id="title">Добавление новости</p>
						<hr />
						<form action="controller" method="post"
							enctype="multipart/form-data">
							<input type="hidden" name="command" value="addNews" />

							<table class="addAttraction">
								<c:if test="${not empty addErrorMessage}">
									<tr>
										<td colspan="2" id="error"><img src="image/error.png"
											align="absmiddle" />&nbsp;&nbsp;${addErrorMessage}</td>
									</tr>
								</c:if>
								<tr>
									<td>Заголовок:&nbsp;</td>
									<td><input class="field" id="attrAdd" type="text"
										name="title" /></td>
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
										value="Добавить новость" /></td>
								</tr>
							</table>

						</form>
						<a class="close" href="#close"></a>
					</div>
				</c:if>
			</div>
			<c:choose>
				<c:when test="${not empty queryerror}">
					<div class="news" id="queryerror">
						${queryerror} <br />
						<hr />
						<a href="index.html" class="button">Назад</a>
					</div>
				</c:when>
				<c:otherwise>
					<c:forEach items="${news}" var="n">
						<div class="news">
							<div class="comments"
								onclick="window.location.href='controller?command=oneNewsComment&id_news=${n.id}'">
								Комментарии
								<div class="comCount">${n.commentCount}</div>
							</div>
							<span class="author">${n.user.lastName}
								${n.user.firstName}&nbsp;&nbsp;|&nbsp;&nbsp;<fmt:formatDate
									var="pdate" value="${n.postDate}" type="BOTH" dateStyle="long"
									timeStyle="Medium" /> ${pdate}
							</span>
							<p id="title"
								onclick="window.location.href='controller?command=oneNewsComment&id_news=${n.id}'">${n.title}</p>
							<hr />

							<c:if test="${not empty n.newsPicture }">
								<img class="newsImage"
									src="controller?command=imageGenerator&imgpath=${n.newsPicture }" />
								<br/>
							</c:if>
							${n.body} <br />
							<c:choose>
								<c:when
									test="${userRole.name == 'admin'}">
									<div
										onclick="window.location.href='controller?command=deleteNews&id_news=${n.id}'"
										class="deleteNews">x</div>
									<div
										onclick="window.location.href='controller?command=oneNewsComment&id_news=${n.id}'"
										class="next">Далее →</div>
								</c:when>
								<c:otherwise>
									<div
										onclick="window.location.href='controller?command=oneNewsComment&id_news=${n.id}'"
										class="next">Далее →</div>
								</c:otherwise>
							</c:choose>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<c:remove var="addErrorMessage" scope="session" />
		<c:remove var="searchQuery" scope="session" />
		<mod:right/>
	</div>

</body>
</html>