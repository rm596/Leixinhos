<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/plano.png" alt="planos_alimentares" /><h1 style="margin: 15px 0 0 0;">Editar informação do plano alimentar <c:out value="${plano.id}"/></h1>

<br> <br>

<form id="checkoutForm" action="<c:url value='editar_plano_alimentar'/>" method="post" data-validate="parsley">
    <div class="form_settings">
        <p><span>Tanque:</span>
        <input type="hidden" name="id" value="${plano.id}">
        <select name="tanque" style="width: 370px" >
            <c:forEach var="columnName" items="${tanque}">
            <c:choose>
                <c:when test="${plano.idTanque.getId() == columnName.id}">
                    <option value="${columnName.id}" selected> Id: <c:out value="${columnName.id}"/>, Estado: <c:out value="${columnName.estadoTanque}"/> 
                </c:when>
                <c:otherwise>
                    <option value="${columnName.id}"> Id: <c:out value="${columnName.id}"/>, Estado: <c:out value="${columnName.estadoTanque}"/> 
                </c:otherwise>
              </c:choose>
            </c:forEach>
        </select>
        
        </p>
        <p>
            <span>Tipo de alimentação</span>
            <input type="text" name="tipo_alimentacao" value="${plano.tipoAlimentacao}" data-required="true" data-trigger="change" data-rangelength="[1,20]">
        </p>
        <br>
        <p>
            <span>Quantidade: (medidas)</span>
            <input type="double" name="quantidade" data-required="true" value="${plano.quantidade}" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Forma de distribuição:</span>
            <textarea rows="5" cols="50" name="distribuicao" data-required="true" value="${plano.formaDistribuicao}" data-trigger="change" data-rangelength="[1,50]" style="width:350px; max-width: 590px; height:150px; max-height: 250px"><c:out value="${plano.formaDistribuicao}"/></textarea>
        </p>
        <p>
            <span>Número de vezes ao dia:</span>
            <input type="number" name="NVezesDia" data-rangelength="[1,11]" value="${plano.NVezesDia}" data-required="true" data-trigger="change" data-type="number">
        </p>
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="editar" value="Editar" />
        </p>
    </div>
</form>

