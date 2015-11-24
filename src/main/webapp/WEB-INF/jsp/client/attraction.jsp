<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:set var="title" value="Аттракцион" scope="page" />
<elem:head/>
<body>
	<mod:menu/>
	<div class="all">
		<div class="newsContainer">
			<div class="attraction">
				<p id="title">Аттракцион: ${attraction.title }</p>
				<hr />
				<img src="/image?imgPath=${attraction.image }" alt="picture" />
				<br/>
				<p>
					<strong>Описание</strong>: ${attraction.description }
				</p>
				<p>
					<strong>Сделано в</strong>: ${attraction.countryProd }
				</p>
				<p>
					<strong>Мест в аттракционе</strong>: ${attraction.places }
				</p>
				<p>Цена</p>
				<ul> 
					<li><strong>Взрослый</strong>: ${attraction.adultPrice }</li>
					<li><strong>Десткий</strong>: ${attraction.childPrice }</li>
				</ul>
			</div>
		</div>
		<mod:right/>
	</div>
</body>
</html>