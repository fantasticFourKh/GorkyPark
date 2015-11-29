<%--<link rel="stylesheet" href="style/modal.css" type="text/css">--%>
<%@ tag trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>

<a href="#x" class="overlay" id="add_form"></a>

<div class="popup">
    <p id="title">Добавление аттракциона</p>
        <hr />
        <form action="/attraction/add" method="post" name="attraction"
              enctype="multipart/form-data">
        <table class="addAttraction">
            <tr>
                <td>Название:&nbsp;</td>
                <td><input class="field" type="text"
                           name="inputTitle" /></td>
            </tr>
            <tr>
                <td>Минимальный рост&nbsp;(см):&nbsp;</td>
                <td><input class="field" type="number"
                           min="50" max="250" value="50" name="inputHeight" /></td>
            </tr>
            <tr>
                <td>Цена взрослый:&nbsp;</td>
                <td><input class="field" type="number"
                           name="inputAdultPrice" /></td>
            </tr>
            <tr>
                <td>Цена детский:&nbsp;</td>
                <td><input class="field" type="number"
                           name="inputChildPrice" /></td>
            </tr>
            <tr>
                <td>Описание:&nbsp;</td>
                <td><textarea rows="10" cols="35" name="inputDesc"></textarea></td>
            </tr>
            <tr>
                <td>Фото:&nbsp;</td>
                <td><input type="file" class="btn"
                           name="inputImage" /></td>
            </tr>
            <tr>
                <td colspan="2"><input class="btn" id="all" type="submit"
                                       value="Добавить" /></td>
            </tr>
        </table>

    </form>
    <a class="close" href="#close"></a>
</div>