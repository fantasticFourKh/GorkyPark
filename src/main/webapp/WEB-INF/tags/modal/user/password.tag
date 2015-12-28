<%@ tag trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<div class="form-group">
    <label for="inputPassword" class="col-lg-4 control-label">Password</label>

    <div class="col-lg-8">
        <input type="password"  class="form-control" id="inputPassword" name="inputPassword" placeholder="Password" maxlength="16">
    </div>
</div>
<div class="form-group">
    <label for="inputRepeatPassword" class="col-lg-4 control-label">Repeat password</label>

    <div class="col-lg-8">
        <input type="password" class="form-control" id="inputRepeatPassword" name="inputRepeatPassword" placeholder="Repeat password" maxlength="16">
    </div>
</div>