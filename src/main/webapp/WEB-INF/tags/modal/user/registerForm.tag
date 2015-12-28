<%@ tag trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<div class="form-group">
    <label for="inputLogin" class="col-lg-4 control-label">Login</label>

    <div class="col-lg-8">
        <input type="text"  class="form-control" id="inputLogin" name="inputLogin" placeholder="Login" value="${invalidUserBean.login}">
    </div>
</div>
<div class="form-group">
    <label for="inputFName" class="col-lg-4 control-label">First name</label>

    <div class="col-lg-8">
        <input type="text"  class="form-control" id="inputFName" name="inputFName" placeholder="First name" value="${invalidUserBean.firstName}">
    </div>
</div>
<div class="form-group">
    <label for="inputLName" class="col-lg-4 control-label">Last name</label>

    <div class="col-lg-8">
        <input type="text"  class="form-control" id="inputLName" name="inputLName" placeholder="Last name" value="${invalidUserBean.lastName}">
    </div>
</div>
<user:password/>
<div class="form-group">
    <label for="inputEmail" class="col-lg-4 control-label">Email</label>

    <div class="col-lg-8">
        <input type="text"  class="form-control" id="inputEmail" name="inputEmail" placeholder="Email" value="${invalidUserBean.email}">
    </div>
</div>
<div class="form-group">
    <label for="inputPhone" class="col-lg-4 control-label">Phone number</label>

    <div class="col-lg-8">
        <input type="text"  class="form-control" id="inputPhone" name="inputPhone" placeholder="Phone number" value="${invalidUserBean.phone}">
    </div>
</div>
<div class="form-group">
    <label for="inputDob" class="col-lg-4 control-label">Date of birth</label>

    <div class="col-lg-8">
        <input type="date"  class="form-control" id="inputDob" name="inputDob" placeholder="Birth date" min="1935-01-01">
    </div>
</div>