<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="title" value="Register user" scope="page"/>
<elem:head/>
<body>
<mod:menu/>
<div class="main">
    <div class="main-container">
        <c:if test="${validationErrors}">
            <mod:errors validationErrors="${validationErrors}"/>
        </c:if>
        <form class="form-control" action="/admin/user/add" method="post">
            <fieldset>
                <legend>New user</legend>
                <user:registerForm/>
                <div class="form-group">
                    <label for="inputRole" class="col-lg-4 control-label">Role</label>

                    <div class="col-lg-8">
                        <select class="form-control" id="inputRole" name="selectRole">
                            <c:forEach items="${roles}" var="role">
                                <option value="${role.name}">${role.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button type="submit" class="btn btn-primary">Register</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>