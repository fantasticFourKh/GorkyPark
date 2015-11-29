<%@include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<%@ tag language="java" trimDirectiveWhitespaces="true"%>
<%@ attribute name="validationErrors" required="true" type="java.util.Map"%>

<div class="alert alert-dismissible alert-warning">
    <button type="button" class="close" data-dismiss="alert">&close;</button>
    <h4>Warning! Mistakes found</h4>
    <c:forEach var="entry" items="${validationErrors}">
        <p>${entry.key} - ${entry.value}</p>
    </c:forEach>
</div>