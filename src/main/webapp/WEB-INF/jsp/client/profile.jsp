<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="title" value="My profile" scope="page"/>
<elem:head/>
<body>
<mod:menu/>
<div class="main">
    <div class="main-container">
        <div class="main-container-content">
            <p id="title">${loggedUser.lastName} ${loggedUser.firstName }</p>
            <hr/>
            <div class="personal">
                <div class="personalData">
                    <p>
                        <strong>Логин</strong>: ${loggedUser.login }
                    </p>

                    <p>
                        <strong>Дата рождения</strong>: ${loggedUser.dob }
                    </p>

                    <p>
                        <strong>Электронный адрес</strong>: ${loggedUser.email }
                    </p>

                    <p>
                        <strong>Номер телефона</strong>: ${loggedUser.phone }
                    </p>

                    <p>
                        <strong>Дата регистрации</strong>: ${loggedUser.regDate }
                    </p>

                    <p>
                        <strong>Статус (Заблокирован/Незаблокирован)</strong>:
                        ${loggedUser.statusBanned }
                    </p>
                </div>
                <div class="dataButton">
                    <div><a href="/attraction/view">
                        <span>Каталог</span><span><img width="35" height="35"
                                                       align="absmiddle" src="resources/image/icon/catalog.png"/></span></a>
                    </div>
                    <div><a href="/home">
                        <span>Новости</span><span><img width="35" height="35"
                                                       align="absmiddle" src="resources/image/icon/news.png"/></span></a>
                    </div>
                </div>
            </div>
        </div>

        <div class="main-container-content">
            <p id="title">Изменить пароль</p>
            <hr/>
            <form action="controller" method="get">
                <input type="hidden" name="command" value="changeUserPassword"/>


                <table class="pass">
                    <c:if test="${not empty message_1}">
                        <tr>
                            <td colspan="2" id="ok"><img src="resources/image/ok.png"
                                                         align="absmiddle"/>&nbsp;&nbsp;${message_1}
                            </td>
                        </tr>
                    </c:if>
                    <c:if test="${not empty errorMessage_1}">
                        <tr>
                            <td colspan="2" id="error"><img src="resources/image/alert.png"
                                                            align="absmiddle"/>&nbsp;&nbsp;${errorMessage_1}
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <td>Текущий пароль:</td>
                        <td><input class="field" id="attrAdd" type="password"
                                   maxlength="16" name="curPass"/></td>

                    </tr>
                    <tr>
                        <td>Новый пароль:</td>
                        <td><input class="field" id="attrAdd" type="password"
                                   maxlength="16" name="newPass"/></td>
                    </tr>
                    <tr>
                        <td>Повторите пароль:</td>
                        <td><input class="field" id="attrAdd" type="password"
                                   maxlength="16" name="newPass2"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input class="btn" id="all" type="submit"
                                               value="Изменить"/></td>
                    </tr>
                </table>

            </form>
        </div>
    </div>
    <mod:right/>
</div>
</body>
</html>