<%@ tag trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<div class="header">
    <nav>
        <ul>
            <li><a
                    href="/home">ГЛАВНАЯ</a></li>
            <li><a href="/attraction/view">АТТРАКЦИОНЫ</a></li>
            <c:if test="${userRole.name == 'admin' }">
                <li onclick="window.location.href='controller?command=profile'"><a
                        href="controller?command=profile">АДМИН МЕНЮ</a>
                    <ul>
                        <li><a href="/admin/user/view">ПОЛЬЗОВАТЕЛИ</a></li>
                    </ul>
                </li>
            </c:if>
            <c:if test="${user != null }">
                <li><a href="/user/profile">ЛИЧНЫЙ КАБИНЕТ</a></li>
            </c:if>

            <li><a href="#">КОНТАКТЫ</a></li>
        </ul>
    </nav>
</div>