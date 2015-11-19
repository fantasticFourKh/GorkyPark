<%@ tag trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<div class="header">
    <nav>
        <ul>
            <li onclick="window.location.href='index.html'"><a
                    href="index.html">ГЛАВНАЯ</a></li>
            <li
                    onclick="window.location.href='controller?command=attractionCatalog'"><a
                    href="controller?command=attractionCatalog">АТТРАКЦИОНЫ</a></li>
            <c:choose>
                <c:when test="${userRole.name == 'admin' }">
                    <li onclick="window.location.href='controller?command=profile'"><a
                            href="controller?command=profile">АДМИН МЕНЮ</a>
                        <ul>
                            <li onclick="window.location.href='controller?command=profile'"><a
                                    href="controller?command=profile">ПРОФИЛЬ</a></li>
                            <li onclick="window.location.href='controller?command=allUsers'"><a
                                    href="controller?command=allUsers">ПОЛЬЗОВАТЕЛИ</a></li>
                        </ul>
                    </li>
                </c:when>
                <c:otherwise>
                    <c:if test="${user != null }">
                        <li onclick="window.location.href='controller?command=profile'"><a
                                href="controller?command=profile">ЛИЧНЫЙ КАБИНЕТ</a></li>
                    </c:if>
                </c:otherwise>
            </c:choose>

            <li onclick="window.location.href='index.html'"><a href="#">КОНТАКТЫ</a></li>
        </ul>
    </nav>
</div>