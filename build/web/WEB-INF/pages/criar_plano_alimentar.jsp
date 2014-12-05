<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/plano.png" alt="alimentação" /><h1 style="margin: 15px 0 0 0;">Criar plano alimentar</h1>

<br> <br>


<form id="checkoutForm" action="<c:url value='criar_plano_alimentar'/>" method="post" data-validate="parsley">
    <div class="form_settings">
        <p><span>Tanque:</span>
        
            <select name="tanque" style="width: 400px" >
            <c:forEach var="columnName" items="${tanque}">
                <option value="${columnName.id}"> ID do tanque: <c:out value="${columnName.id}"/>, Volume usado: <c:out value="${columnName.volumeUsado}"/>L, Estado: <c:out value="${columnName.estadoTanque}"/>
            </c:forEach>
        </select>
        </p>
        
        <p>
            <span>Tipo de alimentação:</span>
            <input type="text" name="tipo_alimentacao" data-required="true" data-trigger="change" data-rangelength="[1,20]">
        </p>
        <br>
        <p>
            <span>Quantidade: (medidas)</span>
            <input type="double" name="quantidade" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Forma de distribuição:</span>
            <textarea rows="5" cols="50" name="distribuicao" data-required="true" data-trigger="change" data-rangelength="[1,50]" style="width:350px; max-width: 590px; height:150px; max-height: 250px"></textarea>
        </p>
        <p>
            <span>Número de vezes ao dia:</span>
            <input type="number" name="NVezesDia" data-rangelength="[1,11]" data-required="true" data-trigger="change" data-type="number">
        </p>
         <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="criar" value="Criar" />
        </p>
    </div>
</form>

<%
    if (request.getAttribute("PlanoAlimentarINSERIDO") == "1") {
%>
<script>

    alert("Plano alimentar inserido com sucesso!");

</script>
<%                                }
%>
