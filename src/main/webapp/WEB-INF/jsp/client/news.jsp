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
				<div onclick="window.location.href='index.html'" class="next">Назад</div>
				<p id="title">${news.title }</p>
				<hr />
				<c:if test="${not empty news.image }">
					<img class="newsImageInfo" align="left"
						src="controller?command=imageGenerator&imgpath=${news.image }" />
				</c:if>
				${news.body } <br /> <br />
			</div>

			<c:if test="${not empty user.login}">
				<div class="news">
					<p id="title">Новый комментарий</p>
					<hr />

					<c:if test="${not empty errorMessageComment}">
						<div id="error">
							<img src="image/alert.png" align="absmiddle" />&nbsp;&nbsp;${errorMessageComment}
						</div>
						<br />
					</c:if>

					<form action="controller" method="post">
						<input type="hidden" name="command" value="newComment" />
						<input type="hidden" name="id_news" value="${news.id}" />

						<div class="otziv">
							<textarea class="comment" name="comment"
								placeholder="Оставить отзыв..."></textarea>
							<input class="btn-right" type="submit" value="+" />
						</div>
					</form>
				</div>
			</c:if>

			<c:if test="${not empty comment}">
				<div class="news">
					<p id="title" name="COMM">${count} комментариев</p>
					<hr />
					<c:forEach items="${comment}" var="c">
						<div class="oneComment">
							<div class="commentInfo" id="commentName">${c.name}&nbsp;${c.surname}</div>
							<div class="commentInfo" id="commentData">

								<fmt:formatDate var="cdate" value="${c.postDate}" type="BOTH"
									dateStyle="long" timeStyle="Medium" />
								${cdate}

							</div>
							<div class="body">&mdash; ${c.body }</div>
							<c:if
								test="${(user.login == c.login) || (user.login == 'admin')}">
								<ul class="commentModify">
									<li><img
										onclick="window.location.href='controller?command=deleteComment&idComment=${c.id}'"
										src="image/commentDel.png" /></li>
								</ul>
							</c:if>
						</div>
					</c:forEach>
				</div>
			</c:if>
		</div>
		<c:remove var="errorMessageComment" scope="session" />
		<mod:right/>
	</div>
</body>
</html>