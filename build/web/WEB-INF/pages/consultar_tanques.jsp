<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<div class="form_settings" style="float: right; width: 400px">
    <form action="<c:url value='searchTanques'/>" method="post" class="form-horizontal" data-validate="parsley" style="margin: 0 0 0 0;">
        <input type="text" name="search" data-trigger="change" placeholder="Procurar" value="${search}" style="width: 150px"/>
        <select name="searchType" style="width: 141px">
            <c:choose>
                <c:when test="${idSEARCH == 1}">
                    <option value ="1" selected>Localização</option>
                    <option value ="2">Estado</option>
                </c:when>
                <c:when test="${idSEARCH == 2}">
                    <option value ="1">Localização</option>
                    <option value ="2" selected>Estado</option>
                </c:when>
                <c:otherwise>
                    <option value ="1">Localização</option>
                    <option value ="2">Estado</option>
                </c:otherwise>
            </c:choose>
        </select>     
        <button type="submit" class="submit" style="margin: 0 0 0 0; background-image: url('images/search.png'); background-repeat: no-repeat; width: 40px; background-position: center;"></button>
    </form>
    <form action="<c:url value='consultar_tanques'/>" method="get" class="form-horizontal" data-validate="parsley">
        <button type="submit" class="submit" style="margin: 10px 0 0 315px; width: 60px;">Limpar</button>
    </form>
</div>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/tanque2.png" alt="tanques" /><h1 style="margin: 15px 0 0 0;">Lista dos tanques existentes:</h1>

<br> <br>
<!--
<h4></h4>-->
<table style="border-spacing:0;">
    <tr>
        <th>Id</th>
        <th>Id Tipo</th>
        <th>Volume usado (L)</th>
        <th>Localização Fisica</th>
        <th>Data aquisição</th>
        <th>Estado do tanque</th>
        <th>Caracterização</th>
        <th>Editar tanque</th>
    </tr>
    <c:forEach var="columnName" items="${tanques}">
        <tr>
            <td> <c:out value="${columnName.id}"/> </td>
            <td> <c:out value="${columnName.idTipo}"/> </td>
            <td> <c:out value="${columnName.volumeUsado}"/> L </td>
            <td> <c:out value="${columnName.localizacaoFisica}"/> </td>
            <td> <c:out value="${columnName.dataAquisicao}"/> </td>
            <td> <c:out value="${columnName.estadoTanque}"/> </td>
            <td> <c:out value="${columnName.caracterizacao}"/> </td>
            <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="editar_tanque?${columnName.id}" title="Editar">
                    <img src="images/edit.png" width="25" height="25">
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<%
    if (request.getAttribute("TanqueALTERADO") == "1") {
%>
<script>

    alert("Tanque alterado com sucesso!");

</script>
<%                                }
%>