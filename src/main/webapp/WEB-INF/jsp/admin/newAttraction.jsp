<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="title" value="New Attraction" scope="page"/>
<elem:head/>
<body>
<mod:menu/>
<div class="main">
    <div class="main-container">
        <div class="main-container-content">
            <c:if test="${validationErrors}">
                <mod:errors validationErrors="${validationErrors}"/>
            </c:if>
            <form action="/attraction/add" method="post" name="attraction"
                  enctype="multipart/form-data" class="form-horizontal">
                <fieldset>
                    <legend>Attraction</legend>
                    <div class="form-group">
                        <label for="inputTitle" class="col-lg-4 control-label">Title</label>

                        <div class="col-lg-8">
                            <input type="text" class="form-control" id="inputTitle" placeholder="Title"
                                   value="${invalidAttractionBean.title}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDesc" class="col-lg-4 control-label">Description</label>

                        <div class="col-lg-8">
                            <input type="text" class="form-control" id="inputDesc" placeholder="Description"
                                   value="${invalidAttractionBean.description}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputHeight" class="col-lg-4 control-label">Min height</label>

                        <div class="col-lg-8">
                            <input type="text" class="form-control" id="inputHeight" placeholder="Height"
                                   value="${invalidAttractionBean.height}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputAdultPrice" class="col-lg-4 control-label">Adult price</label>

                        <div class="col-lg-8">
                            <input type="text" class="form-control" id="inputAdultPrice" placeholder="Adult price"
                                   value="${invalidAttractionBean.adultPrice}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputChildPrice" class="col-lg-4 control-label">Child price</label>

                        <div class="col-lg-8">
                            <input type="text" class="form-control" id="inputChildPrice" placeholder="Child price"
                                   value="${invalidAttractionBean.childPrice}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputImage" class="col-lg-4 control-label">Attraction image</label>

                        <div class="col-lg-8">
                            <input type="file" class="form-control" id="inputImage">
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
        <mod:right/>
    </div>
</div>
</html>