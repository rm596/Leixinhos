<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<div class="form_settings" style="float: right; width: 400px">
    <form action="<c:url value='searchLote'/>" method="post" class="form-horizontal" data-validate="parsley" style="margin: 0 0 0 0;">
        <input type="text" name="search" data-trigger="change" placeholder="Procurar" value="${search}" style="width: 150px"/>
        <select name="searchType" style="width: 141px">
            <c:choose>
                <c:when test="${idSEARCH == 1}">
                    <option value ="1" selected>Especie</option>
                    <option value= "6">Sala</option>
                    <option value ="2">Origem</option>
                    <option value ="3">Titular</option>
                    <option value ="4">Grupo de investigação</option>
                    <option value ="5">Tipo contentor</option>
                </c:when>
                <c:when test="${idSEARCH == 2}">
                    <option value ="1">Especie</option>
                    <option value= "6">Sala</option>
                    <option value ="2" selected>Origem</option>
                    <option value ="3">Titular</option>
                    <option value ="4">Grupo de investigação</option>
                    <option value ="5">Tipo contentor</option>
                </c:when>
                <c:when test="${idSEARCH == 3}">
                    <option value ="1">Especie</option>
                    <option value= "6">Sala</option>
                    <option value ="2">Origem</option>
                    <option value ="3" selected>Titular</option>
                    <option value ="4">Grupo de investigação</option>
                    <option value ="5">Tipo contentor</option>
                </c:when>
                <c:when test="${idSEARCH == 4}">
                    <option value ="1">Especie</option>
                    <option value= "6">Sala</option>
                    <option value ="2">Origem</option>
                    <option value ="3">Titular</option>
                    <option value ="4" selected>Grupo de investigação</option>
                    <option value ="5">Tipo contentor</option>
                </c:when>
                <c:when test="${idSEARCH == 5}">
                    <option value ="1">Especie</option>
                    <option value= "6">Sala</option>
                    <option value ="2">Origem</option>
                    <option value ="3">Titular</option>
                    <option value ="4">Grupo de investigação</option>
                    <option value ="5" selected>Tipo contentor</option>
                </c:when>
                <c:when test="${idSEARCH == 6}">
                    <option value ="1">Especie</option>
                    <option value= "6" selected>Sala</option>
                    <option value ="2">Origem</option>
                    <option value ="3">Titular</option>
                    <option value ="4">Grupo de investigação</option>
                    <option value ="5">Tipo contentor</option>
                </c:when>
                <c:otherwise>
                    <option value ="1">Especie</option>
                    <option value= "6">Sala</option>
                    <option value ="2">Origem</option>
                    <option value ="3">Titular</option>
                    <option value ="4">Grupo de investigação</option>
                    <option value ="5">Tipo contentor</option>
                </c:otherwise>
            </c:choose>
        </select>     
        <button type="submit" class="submit" style="margin: 0 0 0 0; background-image: url('images/search.png'); background-repeat: no-repeat; width: 40px; background-position: center;"></button>
    </form>
    <form action="<c:url value='consultar_lote'/>" method="get" class="form-horizontal" data-validate="parsley">
        <button type="submit" class="submit" style="margin: 10px 0 0 315px; width: 60px;">Limpar</button>
    </form>
</div>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/lote.png" alt="lotes" /><h1 style="margin: 15px 0 0 0;">Lista de lotes existentes</h1>

<br> <br>

<div style="white-space:pre;overflow:auto;width:950px;">
    <table style="border-spacing:0;">
        <tr>
            <th>Id</th>
            <th>Data de introdução</th>
            <th>Id do tanque</th>
            <th>Sala</th>
            <th>Espécie</th>
            <th>Nº Vulgar</th>
            <th>Grupo Zoológico</th>
            <th>Família</th>
            <th>Origem</th>
            <th>Fornecedor</th>
            <th>Titular</th>
            <th>Grupo de investigação</th>
            <th>Referência FCT</th>
            <th>Nº Exemplares</th>
            <th>Peso médio (Kg)</th>
            <th>Comprimento médio (Metros)</th>
            <th>Nº Machos à Chegada</th>
            <th>Nº Fêmeas à Chegada</th>
            <th>Tipo contentor</th>
            <th>Percentagem Oxigénio (%)</th>
            <th>Projecto</th>
            <th>Editar</th>
        </tr>
        <c:forEach var="columnName" items="${cons_lote}">
            <tr>

                <td> <c:out value="${columnName.id}"/> </td>
                <td> <c:out value="${columnName.data}"/> </td>
                <td> <c:out value="${columnName.idTanque}"/> </td>
                <td> <c:out value="${columnName.sala}"/> </td>
                <td> <c:out value="${columnName.especie}"/> </td>
                <td> <c:out value="${columnName.NVulgar}"/> </td> 
                <td> <c:out value="${columnName.grupoZoologico}"/> </td> 
                <td> <c:out value="${columnName.familia}"/> </td> 
                <td> <c:out value="${columnName.origem}"/> </td> 
                <td> <c:out value="${columnName.fornecedor}"/> </td> 
                <td> <c:out value="${columnName.titular}"/> </td> 
                <td> <c:out value="${columnName.grupoInvestigacao}"/> </td> 
                <td> <c:out value="${columnName.referenciaFct}"/> </td> 
                <td> <c:out value="${columnName.NExemplares}"/> </td>
                <td> <c:out value="${columnName.pesosMedio}"/> Kg</td>
                <td> <c:out value="${columnName.comprimentoMedio}"/> m</td><%-- --%>
                <td> <c:out value="${columnName.NMachos}"/> </td>
                <td> <c:out value="${columnName.NFemeas}"/> </td>
                <td> <c:out value="${columnName.tipoContentor}"/> </td>
                <td> <c:out value="${columnName.percentagemO2}"/> %</td>
                <td> <c:out value="${columnName.projecto}"/> </td>
                <td><a href="editar_lote?${columnName.id}" title="Editar"><img src="images/edit.png" width="25" height="25"></a></td> 
            </tr>

        </c:forEach>
    </table>
</div>

<%
    if (request.getAttribute("LoteALTERADO") == "1") {
%>
<script>

    alert("Lote alterado com sucesso!");

</script>
<%                                }
%>