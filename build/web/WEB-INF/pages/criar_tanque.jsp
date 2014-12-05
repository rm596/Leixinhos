<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/tanque2.png" alt="tanque" /><h1 style="margin: 15px 0 0 0;">Inserir novo tanque</h1>

<br> <br>

<form id="checkoutForm" action="<c:url value='criar_tanque'/>" method="post" data-validate="parsley">
    <div class="form_settings">
        <p><span>Tipo de tanque:</span>

        <select name="tipo_tanque" style="width: 440px" >
            <c:forEach var="columnName" items="${tipo_tanque}">
                <option value="${columnName.id}"> Numero do tipo tanque: <c:out value="${columnName.id}"/>, Nome: <c:out value="${columnName.nome}"/>, Volume total: <c:out value="${columnName.volumeTotal}"/> Litros
            </c:forEach>
        </select>
        </p><br>

        <p>
            <span>Volume usado: (Litros)</span>
            <input type="double" name="volumeusado" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p><span>Localização física:</span><input type="text" name="localizacao" data-required="true" data-trigger="change" data-rangelength="[1,50]"></p>
        <br>
        <p><span>Estado do tanque:</span>
            <input class="radio" type="radio" name="estado" value="Usado" data-group="mygroup" data-required="true"> Usado

            <input class="radio" type="radio" name="estado" value="Livre" data-group="mygroup" > Livre

            <input class="radio" type="radio" name="estado" value="Quarentena" data-group="mygroup" > Quarentena
        </p>
        <br>
        <p><span>Caracterização:</span><input type="text" name="caracterizacao" data-required="true" data-trigger="change" data-rangelength="[1,50]"></p>
            <%-- --%>      
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="criar" value="Criar" />
        </p>

    </div>
</form>

<%
    if (request.getAttribute("TanqueINSERIDO") == "1") {
%>
<script>

    alert("Tanque inserido com sucesso!");

</script>
<%                                }
%>