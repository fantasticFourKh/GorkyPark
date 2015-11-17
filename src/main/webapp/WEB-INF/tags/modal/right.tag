<%@ tag trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<div class="right">

    <c:choose>
        <c:when test="${empty registerCommand}">
            <c:choose>
                <c:when test="${not empty user.login}">
                    <div id="login">
                        <span id="login">Вы вошли как:&nbsp;&nbsp;</span>${user.login}
                        <hr />
                        <a href="controller?command=profile"><img width="30"
                                                                  align="absmiddle" height="30" src="image/account2.png" /></a>&nbsp;
                        <a href="controller?command=logout"><img width="30"
                                                                 align="absmiddle" height="30" src="image/exit.png" /></a>
                        <c:if test="${userRole == 'admin'}">
                            &nbsp;<a href="controller?command=registerPage"><img
                                width="30" align="absmiddle" height="30"
                                src="image/register.png" /></a>
                        </c:if>
                        <br />
                    </div>
                </c:when>
                <c:otherwise>
                    <div>
                        <p id="title">Вход в систему</p>
                        <hr />
                        <c:if test="${not empty rightErrorMessage}">
                            <div id="error">
                                <img src="image/error.png" align="absmiddle" />&nbsp;&nbsp;${rightErrorMessage}
                            </div>
                        </c:if>
                        <form action="controller" method="post">
                            <input type="hidden" name="command" value="login" /> <input
                                class="field" name="login" maxlength="16" type="text"
                                placeholder="login..." /> <br /> <input class="field"
                                                                        name="password" maxlength="16" type="password"
                                                                        placeholder="password..." /> <br /> <input class="btn"
                                                                                                                   type="submit" value="Вход" />
                        </form>
                        <br />
                        <form action="controller" method="post">
                            <input type="hidden" name="command" value="registerPage" /> <input
                                class="btn" type="submit" value="Регистрация" />
                        </form>

                    </div>

                </c:otherwise>
            </c:choose>
        </c:when>
        <c:otherwise>
            <div>
                <p id="title">Регистрация</p>
                <hr />
                &nbsp;
                <form class="login" action="controller" method="post">
                    <input type="hidden" name="command" value="register" />
                    <c:if test="${not empty rightErrorMessage}">
                        <div id="error">
                            <img src="image/error.png" align="absmiddle" />&nbsp;&nbsp;${rightErrorMessage}
                        </div>
                    </c:if>
                    <table class="register">

                        <c:if test="${userRole == 'admin'}">
                            <tr>
                                <td>Роль:&nbsp;</td>
                                <td><select class="field" id="dropDown" name="roleName">
                                    <c:forEach var="role" items="${role}">
                                        <option>${role.name}</option>
                                    </c:forEach>
                                </select></td>
                            </tr>
                            <tr>
                                <td colspan="2" class="help">Выберите роль пользователя в
                                    системе</td>
                            </tr>
                        </c:if>

                        <tr>
                            <td>Логин:&nbsp;</td>
                            <td><input class="field" id="reg" type="text" maxlength="16"
                                       value="${regUser.login}" name="login" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="help">Минимальная длина логина = 3,
                                максимальная = 16. Допустимые символы: a-z, A-Z, 0-9, _, -</td>
                        </tr>
                        <tr>
                            <td>Пароль:&nbsp;</td>
                            <td><input class="field" id="reg" type="password"
                                       maxlength="16" value="${regUser.password}" name="password" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="help">Минимальная длина пароля = 3,
                                максимальная = 16. Допустимые символы: a-z, A-Z, 0-9, _, -</td>
                        </tr>
                        <tr>
                            <td>Имя:&nbsp;</td>
                            <td><input class="field" id="reg" type="text" maxlength="48"
                                       value="${regUser.firstName}" name="firstName" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="help">Введите имя</td>
                        </tr>
                        <tr>
                            <td>Фамилия:&nbsp;</td>
                            <td><input class="field" id="reg" type="text" maxlength="48"
                                       value="${regUser.lastName}" name="lastName" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="help">Введите фамилию</td>
                        </tr>
                        <tr>
                            <td>Email:&nbsp;</td>
                            <td><input class="field" id="reg" type="text" maxlength="48"
                                       value="${regUser.email}" name="email" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="help">Введите один адрес электронной
                                почты, который вы используете</td>
                        </tr>
                        <tr>
                            <td>Номер телефона:&nbsp;</td>
                            <td><input class="field" id="reg" type="text" maxlength="16"
                                       value="${regUser.phone}" name="phone" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="help">Формат ввода: 0XXYYYYYYY, или
                                +380XXYYYYYYY, где XX - это код мобильного оператора, а YYYYYYY
                                - номер вашего телефона.</td>
                        </tr>
                        <tr>
                            <td>Дата рождения:&nbsp;</td>
                            <td><input type="date" name="dob" class="field" id="reg"
                                       max="1996-01-01" min="1935-01-01" value="${regUser.dob}"></input></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="help">Введите дату рождения</td>
                        </tr>
                        <tr>
                            <td colspan="2"><input class="btn" id="all" type="submit"
                                                   value="Регистрация" /></td>
                        </tr>
                    </table>
                    <br />
                </form>
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="main" /> <input
                        class="btn" type="submit" value="Назад" />
                </form>
            </div>
        </c:otherwise>
    </c:choose>
    <div>
        <p id="title">Календарь</p>
        <hr />
    </div>
</div>
<c:remove var="rightErrorMessage" scope="session" />
<c:remove var="registerCommand" scope="session" />