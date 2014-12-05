<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/lote.png" alt="lotes" /><h1 style="margin: 15px 0 0 0;">Inserir novo lote</h1>

<br> <br>


<form id="checkoutForm" action="<c:url value='criar_lote'/>" method="post" data-validate="parsley">
    <div class="form_settings">
        <p><span>Tanque:</span>
            
            <select name="idTanque" style="width: 430px" >
                <c:forEach var="columnName" items="${tanque}">
                    <option value="${columnName.id}"> ID do tanque: <c:out value="${columnName.id}"/>, Volume usado: <c:out value="${columnName.volumeUsado}"/>L, Estado: <c:out value="${columnName.estadoTanque}"/>
                </c:forEach>
            </select>    
        
        </p>
        <p>
            <span>N�mero de Sala:</span>
            <input type="double" name="sala" data-required="true" data-trigger="change" data-type="number">
        </p>
        <p>
            <span>Esp�cie:</span>
            <input type="text" name="especie" data-required="true" data-trigger="change" data-rangelength="[1,20]">
        </p>
        <p>
            <span>N�mero vulgar:</span>
            <input type="number" name="nvulgar" data-rangelength="[1,11]"  data-trigger="change" data-type="number">
        </p>
        <p>
            <span>Grupo zool�gico:</span>
            <input type="text" name="grupoZoologico" data-required="true" data-trigger="change" data-rangelength="[1,20]">
        </p>
        <p>
            <span>Fam�lia:</span>
            <input type="text" name="familia" data-required="true" data-trigger="change" data-rangelength="[1,20]">
        </p>
        <p>
            <span>Origem:</span>
            <input type="text" name="origem" data-required="true" data-trigger="change" data-rangelength="[1,20]">
        </p>
        <p>
            <span>Fornecedor:</span>
            <input type="text" name="fornecedor" data-trigger="change" data-rangelength="[0,20]">
        </p>
        <p>
            <span>Titular:</span>
            <input type="text" name="titular" data-required="true" data-trigger="change" data-rangelength="[1,20]">
        </p>
        <p>
            <span>Grupo de investiga��o:</span>
            <input type="text" name="grupoInvestigacao" data-required="true" data-trigger="change" data-rangelength="[1,20]">
        </p>
        <p>
            <span>Refer�ncia FCT:</span>
            <input type="number" name="referenciaFct" data-rangelength="[1,11]" data-trigger="change" data-type="number">
        </p>
        <p>
            <span>N�mero de exemplares:</span>
            <input type="number" name="NExemplares" data-rangelength="[1,11]" data-required="true" data-trigger="change" data-type="number">
        </p>
        <p>
            <span>Peso m�dio: (Kg)</span>
            <input type="double" name="pesosMedio" data-trigger="change" data-type="number">
        </p>
        <p>
            <span>Comprimento m�dio: (Metros)</span>
            <input type="double" name="comprimentoMedio" data-trigger="change" data-type="number">
        </p>
        <p>
            <span>N�mero de machos � chegada:</span>
            <input type="number" name="NMachos" data-rangelength="[1,11]"  data-trigger="change" data-type="number">
        </p>
         <p>
            <span>N�mero de f�meas � chegada:</span>
            <input type="number" name="NFemeas" data-rangelength="[1,11]" data-trigger="change" data-type="number">
        </p>
         <p>
            <span>Tipo de contentor:</span>
            <input type="text" name="tipoContentor" data-trigger="change" data-rangelength="[1,20]">
        </p>
         <p>
            <span>Percentagem oxig�nio: (%)</span>
            <input type="double" name="percentagemO2" data-required="true" data-trigger="change" data-type="number">
        </p>
        <p>
            <span>Projecto:</span>
            <input type="text" name="projecto" data-trigger="change" data-rangelength="[1,50]">
        </p>
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="criar" value="Criar" />
        </p>
    </div>
</form>

<%
    if (request.getAttribute("LoteINSERIDO") == "1") {
%>
<script>

    alert("Lote inserido com sucesso!");

</script>
<%                                }
%>