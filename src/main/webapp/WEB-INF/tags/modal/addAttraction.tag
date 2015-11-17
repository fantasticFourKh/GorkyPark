<%--<link rel="stylesheet" href="style/modal.css" type="text/css">--%>
<%@ tag trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>

<a href="#x" class="overlay" id="add_form"></a>

<div class="popup">
    <form action="controller" method="post" name="attraction"
          enctype="multipart/form-data">
        <input type="hidden" name="command" value="addAttraction"/>

        <h2>Новый аттракцион</h2>

        <div>
            <label>Название</label> <input type="text"
                                           placeholder="Название" name="title"/>
        </div>
        <div>
            <label>Количество мест</label> <input type="number"
                                                  placeholder="Мест" name="places"/>
        </div>
        <div>
            <label>Страна производитель</label> <input type="text"
                                                       placeholder="Производитель" name="country"/>
        </div>
        <div>
            <label>Цена взрослый</label> <input type="number"
                                                placeholder="Взрослый" name="adult_price"/>
        </div>
        <div>
            <label>Цена детский</label> <input type="number"
                                               placeholder="Детский" name="child_price"/>
        </div>
        <div>
            <label>Описание</label>
            <textarea rows="4" placeholder="Описание" name="desc"></textarea>
        </div>
        <div>
            <label>Фото</label> <input type="file" name="image"/>
        </div>
        <input type="submit" value="Добавить"/> <a class="close"
                                                   href="#close"></a>
    </form>
</div>