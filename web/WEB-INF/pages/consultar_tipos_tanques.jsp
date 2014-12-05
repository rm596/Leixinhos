<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/tanque2.png" alt="tanques" /><h1 style="margin: 15px 0 0 0;">Lista dos tipos de tanques existentes</h1>

<br> <br>

<!--<h4></h4>-->
<table style="border-spacing:0;">
    <tr>
        <th>Id</th>
        <th>Nome do tipo</th>
        <th>Classe do tanque</th>
        <th>Volume total do tanque (L)</th>
        <th>Altura da água (L)</th>
        <th>Valor da taxa exterior (&euro;)</th>
        <th>Valor da taxa interior (&euro;)</th>
        <th>Valor da taxa interior exclusiva (&euro;)</th>
        <th>Valor da taxa exterior exclusiva (&euro;)</th>
        <th>Editar tipo</th>
    </tr>
    <c:forEach var="columnName" items="${tipos_tanques}">
        <tr>
            <td> <c:out value="${columnName.id}"/> </td>
           
            <td> <c:out value="${columnName.nome}"/> </td>
            <td> <c:out value="${columnName.idClasse}"/></td>
            <td> <c:out value="${columnName.volumeTotal}"/> L</td>
            <td> <c:out value="${columnName.alturaAgua}"/> L</td>
            <td> <c:out value="${columnName.taxaExterior}"/> &euro;</td>
            <td> <c:out value="${columnName.taxaInterior}"/> &euro;</td>
            <td> <c:out value="${columnName.taxaIntExc}"/> &euro;</td>
            <td> <c:out value="${columnName.taxaIntSExc}"/> &euro;</td>
            <td>
                &nbsp;
                <a href="editar_tipo_tanques?${columnName.id}" title="Editar">
                    <img src="images/edit.png" width="25" height="25">
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<%
    if (request.getAttribute("TipoTanqueALTERADO") == "1") {
%>
<script>

    alert("Tipo de tanque alterado com sucesso!");

</script>
<%                                }
%>
