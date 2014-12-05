<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/lote.png" alt="lotes" /><h1 style="margin: 15px 0 0 0;">Editar informação do lote <c:out value="${lote.id}"/> </h1>

<br> <br>

<form id="checkoutForm" action="<c:url value='editar_lote'/>" method="post" data-validate="parsley">
    <div class="form_settings">

        <input type="hidden" name="id" value="${lote.id}">

        <p><span>Tanque:</span>
        
        <select name="idTanque" style="width: 430px" >
                <c:forEach var="columnName" items="${tanque}">
                    <c:choose>
                        <c:when test="${lote.idTanque.getId() == columnName.id}">
                            <option value="${columnName.id}" selected> ID do tanque: <c:out value="${columnName.id}"/>, Volume usado: <c:out value="${columnName.volumeUsado}"/>L, Estado: <c:out value="${columnName.estadoTanque}"/>
                        </c:when>
                        <c:otherwise>
                            <option value="${columnName.id}"> ID do tanque: <c:out value="${columnName.id}"/>, Volume usado: <c:out value="${columnName.volumeUsado}"/>L, Estado: <c:out value="${columnName.estadoTanque}"/>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>                
            </select>
        </p>
        
        <p>
            <span>Sala:</span>
            <input type="double" name="sala" data-required="true" value="${lote.sala}" data-trigger="change" data-type="number">
        </p>
        <p>
            <span>Espécie:</span>
            <input type="text" name="especie" data-required="true" value="${lote.especie}" data-trigger="change" data-rangelength="[1,20]">
        </p>
        <p>
            <span>Número vulgar:</span>
            <input type="number" name="nvulgar" data-rangelength="[1,11]" value="${lote.NVulgar}" data-trigger="change" data-type="number">
        </p>
        <p>
            <span>Grupo zoológico:</span>
            <input type="text" name="grupoZoologico" data-required="true" value="${lote.grupoZoologico}" data-trigger="change" data-rangelength="[1,20]">
        </p>
        <p>
            <span>Família:</span>
            <input type="text" name="familia" data-required="true" value="${lote.familia}" data-trigger="change" data-rangelength="[1,20]">
        </p>
        <p>
            <span>Origem:</span>
            <input type="text" name="origem" data-required="true"  value="${lote.origem}" data-trigger="change" data-rangelength="[1,20]">
        </p>
        <p>
            <span>Fornecedor:</span>
            <input type="text" name="fornecedor" data-trigger="change" value="${lote.fornecedor}" data-rangelength="[0,20]">
        </p>
        <p>
            <span>Titular:</span>
            <input type="text" name="titular" data-required="true" value="${lote.titular}" data-trigger="change" data-rangelength="[1,20]">
        </p>
        <p>
            <span>Grupo de investigação:</span>
            <input type="text" name="grupoInvestigacao" value="${lote.grupoInvestigacao}" data-required="true" data-trigger="change" data-rangelength="[1,20]">
        </p>
        <p>
            <span>Referência FCT:</span>
            <input type="number" name="referenciaFct" value="${lote.referenciaFct}" data-rangelength="[1,11]" data-trigger="change" data-type="number">
        </p>
        <p>
            <span>Número de exemplares:</span>
            <input type="number" name="NExemplares" value="${lote.NExemplares}" data-rangelength="[1,11]" data-required="true" data-trigger="change" data-type="number">
        </p>
        <p>
            <span>Peso médio: (Kg)</span>
            <input type="double" name="pesosMedio" value="${lote.pesosMedio}" data-trigger="change" data-type="number">
        </p>
        <p>
            <span>Comprimento médio: (m)</span>
            <input type="double" name="comprimentoMedio" value="${lote.comprimentoMedio}" data-trigger="change" data-type="number">
        </p>
        <p>
            <span>Número de machos à chegada:</span>
            <input type="number" name="NMachos" value="${lote.NMachos}" data-rangelength="[1,11]"  data-trigger="change" data-type="number">
        </p>
        <p>
            <span>Número de fêmeas à chegada:</span>
            <input type="number" name="NFemeas" value="${lote.NFemeas}" data-rangelength="[1,11]" data-trigger="change" data-type="number">
        </p>
        <p>
            <span>Tipo de contentor:</span>
            <input type="text" name="tipoContentor" value="${lote.tipoContentor}" data-trigger="change" data-rangelength="[1,20]">
        </p>
        <p>
            <span>Percentagem oxigénio: (%)</span>
            <input type="double" name="percentagemO2" value="${lote.percentagemO2}" data-required="true" data-trigger="change" data-type="number">
        </p>
        <p>
            <span>Projecto:</span>
            <input type="text" name="projecto" value="${lote.projecto}" data-trigger="change" data-rangelength="[1,50]">
        </p>
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="editar" value="Editar" />
        </p>
    </div>
</form>