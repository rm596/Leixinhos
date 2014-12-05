<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/tanque2.png" alt="manutenção" /><h1 style="margin: 15px 0 0 0;">Editar informação do tipo de tanque  <c:out value="${tipo_tanques.id}"/></h1>

<br> <br>

<form id="checkoutForm" action="<c:url value='editar_tipo_tanques'/>" method="post" data-validate="parsley">
    <div class="form_settings">

        <input type="hidden" name="id" value="${tipo_tanques.id}">

        <p><span>Nome:</span><input type="text" name="nome" value="${tipo_tanques.nome}" data-required="true" data-trigger="change" data-rangelength="[1,5]"></p>
        <br>
        <p><span>Classe do tanque:</span>
        
            <select name="idClasse" style="width: 170px" >
                <c:forEach var="columnName" items="${classe_tanque}">
                    <c:choose>
                        <c:when test="${tipo_tanques.getIdClasse().getId() == columnName.id}">
                            <option value="${columnName.id}" selected > Id: <c:out value="${columnName.id}"/>, Nome: <c:out value="${columnName.nome}"/>
                        </c:when>
                        <c:otherwise>
                            <option value="${columnName.id}"> Id: <c:out value="${columnName.id}"/>, Nome: <c:out value="${columnName.nome}"/>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>                
            </select>
            
        <p>
            <span>Volume total: (Litros)</span>
            <input type="double" name="volumetotal" value="${tipo_tanques.volumeTotal}" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Altura da água: (Litros)</span>
            <input type="double" name="alturaagua" value="${tipo_tanques.alturaAgua}" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Taxa exterior: (&euro;)</span>
            <input type="double" name="taxaexterior" value="${tipo_tanques.taxaExterior}" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Taxa interior: (&euro;)</span>
            <input type="double" name="taxainterior" value="${tipo_tanques.taxaInterior}" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Taxa interior com exclusividade: (&euro;)</span>
            <input type="double" name="taxainteriorexc" value="${tipo_tanques.taxaIntExc}" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Taxa exterior com exclusividade: (&euro;)</span>
            <input type="double" name="taxaexteriorexc" value="${tipo_tanques.taxaIntSExc}" data-required="true" data-trigger="change" data-type="number">
        </p>
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="editar" value="Editar" />
        </p>
    </div>
</form>
