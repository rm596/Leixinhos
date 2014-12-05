<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/tanque2.png" alt="manutenção" /><h1 style="margin: 15px 0 0 0;">Inserir novo tipo de tanque</h1>

<br> <br>

<form id="checkoutForm" action="<c:url value='criar_tipo_tanque'/>" method="post" data-validate="parsley">
    <div class="form_settings">
        <p><span>Nome:</span><input type="text" name="nome" data-required="true" data-trigger="change" data-rangelength="[1,5]"></p>
        <br>
        <p><span>Classe do tanque:</span>
        <select name="idClasse" style="width: 150px" >
            <c:forEach var="columnName" items="${classe_tanque}">
                <option value="${columnName.id}"> Id: <c:out value="${columnName.id}"/>, Nome: <c:out value="${columnName.nome}"/>
            </c:forEach>
        </select>
        </p>
        <br>
        <p>
            <span>Volume total: (Litros)</span>
            <input type="double" name="volumetotal" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Altura da água: (Litros)</span>
            <input type="double" name="alturaagua" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Taxa exterior: (&euro;)</span>
            <input type="double" name="taxaexterior" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Taxa interior: (&euro;)</span>
            <input type="double" name="taxainterior" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Taxa interior com exclusividade: (&euro;)</span>
            <input type="double" name="taxainteriorexc" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Taxa exterior com exclusividade: (&euro;)</span>
            <input type="double" name="taxaexteriorexc" data-required="true" data-trigger="change" data-type="number">
        </p>
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="criar" value="Criar" />
        </p>
    </div>
</form>

<%
    if (request.getAttribute("TipoTanqueINSERIDO") == "1") {
%>
<script>

    alert("Tipo de tanque inserido com sucesso!");

</script>
<%                                }
%>

