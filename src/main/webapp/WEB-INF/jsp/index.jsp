<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="title" value="Главная" scope="page"/>
<elem:head/>
<body>
<mod:menu/>
<div class=main>
    <div class="main-container">
        <div class="settings">
            <b>Поиск:</b>

            <form class="none" action="controller" method="get">
                <input type="hidden" name="command" value="search"/>

                <c:choose>
                    <c:when test="${not empty searchQuery}">
                        <input class="field" id="min-err" type="text" name="query"
                               value="${searchQuery}" placeholder="поисковый запрос..."/>
                    </c:when>
                    <c:otherwise>
                        <input class="field" id="min" type="text" name="query"
                               placeholder="поисковый запрос..."/>
                    </c:otherwise>
                </c:choose>
                <input class="search" type="submit" value=""></input>
            </form>
            <a id="nondecoration" href="controller?command=sort&sortType=1"><span
                    id="brd">Комментарии&nbsp;&nbsp;<img align="absmiddle"
                                                         src="resources/image/sort.png"/></span></a><a id="nondecoration"
                                                                                                       href="controller?command=sort&sortType=2"><span>Дата
						добавления&nbsp;&nbsp;<img align="absmiddle" src="resources/image/sort.png"/>
				</span></a>
            <c:if test="${userRole.name == 'admin'}">
                <div class="addNews"><a href="/news/page">+</a></div>
            </c:if>
        </div>
        <c:choose>
            <c:when test="${not empty queryerror}">
                <div class="main-container-content" id="queryerror">
                    ${queryerror} <br/>
                    <hr/>
                    <a href="/home" class="button">Назад</a>
                </div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${news}" var="n">
                    <div class="main-container-content">
                        <a href="/news/${n.id}">
                            <div class="comments">
                                Комментарии
                                <div class="comCount">${n.commentCount}</div>
                            </div>
                        </a>
							<span class="author">${n.user.lastName}
								${n.user.firstName}&nbsp;&nbsp;|&nbsp;&nbsp;<fmt:formatDate
                                        var="pdate" value="${n.postDate}" type="BOTH" dateStyle="long"
                                        timeStyle="Medium"/> ${pdate}
							</span>

                        <a href="/news/${n.id}">
                            <p id="title">${n.title}</p>
                        </a>
                        <hr/>

                        <c:if test="${not empty n.newsPicture }">
                            <img class="newsImage"
                                 src="/image?imgPath=${n.newsPicture }"/>
                            <br/>
                        </c:if>
                        ${n.body} <br/>
                        <c:if
                                test="${userRole.name == 'admin'}">
                            <a href="/news/delete?articleId=${n.id}">
                                <div class="deleteNews">x
                                </div>
                            </a>
                        </c:if>
                        <a href="/news/${n.id}">
                            <div class="next">Далее →</div>
                        </a>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
    <mod:right/>
</div>

</body>
</html>