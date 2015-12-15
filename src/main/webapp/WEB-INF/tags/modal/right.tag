<%@ tag trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<div class="right">
<c:choose>
    <c:when test="${not empty loggedUser}">
        <div id="login">
            <span id="login">Вы вошли как:&nbsp;&nbsp;</span>${loggedUser.login}
            <hr/>
            <a href="controller?command=profile"><img width="30"
                                                      align="absmiddle" height="30" src="resources/image/account2.png"/></a>&nbsp;
            <a href="/logout"><img width="30"
                                   align="absmiddle" height="30" src="resources/image/exit.png"/></a>
            <c:if test="${userRole.name == 'admin'}">
                &nbsp;<a href="/admin/user/page"><img width="30" align="absmiddle" height="30"
                src="resources/image/register.png" /></a>
            </c:if>
            <br/>
        </div>
    </c:when>
    <c:otherwise>
        <div>
            <p id="title">Вход в систему</p>
            <hr/>
            <c:if test="${not empty rightErrorMessage}">
                <div id="error">
                    <img src="resources/image/error.png" align="absmiddle"/>&nbsp;&nbsp;${rightErrorMessage}
                </div>
            </c:if>
            <form action="/login" method="post"><input
                    class="field" name="inputLogin" maxlength="16" type="text"
                    placeholder="Login..."/> <br/> <input class="field"
                                                          name="inputPassword" maxlength="16" type="password"
                                                          placeholder="Password..."/> <br/> <input class="btn"
                                                                                                   type="submit"
                                                                                                   value="Sign in"/>
            </form>
            <br/>
            <a href="/user/page" class="btn btn-success">Registration</a>
        </div>

        <div>
            <p id="title">Календарь</p>
            <hr/>
        </div>
        </div>
    </c:otherwise>
</c:choose>