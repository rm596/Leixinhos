<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/ambientais.png" alt="dados" /><h1 style="margin: 15px 0 0 0;">Inserir dado ambiental</h1>

<br> <br>


<form id="checkoutForm" action="<c:url value='criar_dados_ambientais'/>" method="post" data-validate="parsley">
    <div class="form_settings">
        <p><span>Tanque:</span>
            <select name="idtanque" style="width: 200px" >
                <c:forEach var="columnName" items="${tanque}">
                    <option value="${columnName.id}"> Id: <c:out value="${columnName.id}"/>, Estado: <c:out value="${columnName.estadoTanque}"/>               
                </c:forEach>
            </select>
        </p>
        <p>
            <span>Temperatura: (graus ºC)</span>
            <input type="double" name="temperatura" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Salinidade da água:</span>
            <input type="double" name="salinidadeAgua" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Oxigénio: (%)</span>
            <input type="double" name="oxigenio" data-required="true" data-trigger="change" data-type="number">
        </p>
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="criar" value="Criar" />
        </p>
    </div>
</form>

<%
    if (request.getAttribute("DadosAmbientaisINSERIDO") == "1") {
%>
<script>

    alert("Dados ambientais inseridos com sucesso!");

</script>
<%                                }
%>

