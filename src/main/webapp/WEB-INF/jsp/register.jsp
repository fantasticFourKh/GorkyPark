<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="title" value="Registration" scope="page"/>
<elem:head/>
<body>
<mod:menu/>
<div class=main>
    <div class="main-container">
        <form class="form-horizontal" action="/user/add" method="post">
            <fieldset>
                <legend>Registration</legend>
                <user:registerForm/>
                <div class="form-group">
                    <div class="col-lg-8 col-lg-offset-4">
                        <button type="submit" class="btn btn-primary">Register</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>