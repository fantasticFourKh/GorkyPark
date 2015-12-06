<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="title" value="Аттракционы" scope="page"/>
<elem:head/>

<body>
<mod:menu/>
<div class="main">
    <div class="main-container">
        <div class="main-container-content">
            <div onclick="window.location.href='/home'" class="next">Назад</div>
            <p id="title">${news.title }</p>
            <hr/>
            <c:if test="${not empty news.newsPicture }">
                <img class="newsImageInfo" align="left"
                     src="/image?imgPath=${news.newsPicture }"/>
            </c:if>
            ${news.body } <br/> <br/>
        </div>

        <c:if test="${not empty user.login}">
            <div class="main-container-content">
                <p id="title">Новый комментарий</p>
                <hr/>

                <c:if test="${not empty errorMessageComment}">
                    <div id="error">
                        <img src="resources/image/alert.png" align="absmiddle"/>&nbsp;&nbsp;${errorMessageComment}
                    </div>
                    <br/>
                </c:if>

                <form action="/comment/add" method="post">
                    <input type="hidden" name="id_news" value="${news.id}"/>

                    <div class="otziv">
							<textarea class="comment" name="commentBody"
                                      placeholder="Оставить отзыв..."></textarea>
                        <input class="btn-right" type="submit" value="+"/>
                    </div>
                </form>
            </div>
        </c:if>

        <c:if test="${not empty comments}">
            <div class="main-container-content">
                <p id="title">${news.commentCount} комментариев</p>
                <hr/>
                <c:forEach items="${comments}" var="c">
                    <div class="oneComment">
                        <div class="commentInfo" id="commentName">${c.user.firstName}&nbsp;${c.user.lastName}</div>
                        <div class="commentInfo" id="commentData">

                            <fmt:formatDate var="cdate" value="${c.wroteDate}" type="BOTH"
                                            dateStyle="long" timeStyle="Medium"/>
                            ${cdate}

                        </div>
                        <div class="body">&mdash; ${c.body }</div>
                        <c:if
                                test="${(loggedUser.login == c.user.login) || (loggedUser.login == 'admin')}">
                            <ul class="commentModify">
                                <li><a href="/comment/delete?commentId=${c.id}"> <img
                                        src="resources/image/commentDel.png"/></a></li>
                            </ul>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>
    <mod:right/>
</div>
</body>
</html>