<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="title" value="New Attraction" scope="page"/>
<elem:head/>
<body>
<mod:menu/>
<div class="main">
    <div class="main-container">
        <div class="main-container-content">
            <c:if test="${not empty validationErrors}">
                <mod:errors validationErrors="${validationErrors}"/>
            </c:if>
            <form action="/news/add" class="form-horizontal" method="post" enctype="multipart/form-data">
                <fieldset>
                    <legend>New Article</legend>

                    <div class="form-group">
                        <label for="inputTitle" class="col-lg-4 control-label">Title</label>

                        <div class="col-lg-8">
                            <input type="text" class="form-control" id="inputTitle" placeholder="Title"
                                   value="${invalidNewsBean.title}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputDesc" class="col-lg-4 control-label">Description</label>

                        <div class="col-lg-8">
                            <input type="text" class="form-control" id="inputDesc" placeholder="Description"
                                   value="${invalidNewsBean.description}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputImg" class="col-lg-4 control-label">Article image</label>

                        <div class="col-lg-8">
                            <input type="file" class="form-control" id="inputImg">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <button type="submit" class="btn btn-primary">Add</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>