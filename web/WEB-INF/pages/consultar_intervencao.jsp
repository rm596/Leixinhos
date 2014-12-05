<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<script type="text/javascript">
    function delete_intervencao(id)
    {
        var x=confirm("Tem a certeza que quer eliminar a intervencao?");
        if (x==true)
        {
            window.location.href="eliminar_intervencao?"+id;
        }
        else
        {      
        }
            
    }
</script>

<div class="form_settings" style="float: right; width: 400px">
    <form action="<c:url value='searchIntervencao'/>" method="post" class="form-horizontal" data-validate="parsley" style="margin: 0 0 0 0;">
        <input type="text" name="search" data-trigger="change" placeholder="Procurar" value="${search}" style="width: 150px"/>
        <select name="searchType" style="width: 141px">
            <c:choose>
                <c:when test="${idSEARCH == 1}">
                    <option value ="1" selected>Lote</option>
                    <option value ="2">Tipo</option>
                    <option value ="3">Especie</option>
                    <option value ="4">Utilizador</option>
                </c:when>
                <c:when test="${idSEARCH == 2}">
                    <option value ="1">Lote</option>
                    <option value ="2" selected>Tipo</option>
                    <option value ="3">Especie</option>
                    <option value ="4">Utilizador</option>
                </c:when>
                <c:when test="${idSEARCH == 3}">
                    <option value ="1">Lote</option>
                    <option value ="2">Tipo</option>
                    <option value ="3" selected>Especie</option>
                    <option value ="4">Utilizador</option>
                </c:when>
                <c:when test="${idSEARCH == 4}">
                    <option value ="1">Lote</option>
                    <option value ="2">Tipo</option>
                    <option value ="3">Especie</option>
                    <option value ="4" selected>Utilizador</option>
                </c:when>
                <c:otherwise>
                    <option value ="1">Lote</option>
                    <option value ="2">Tipo</option>
                    <option value ="3">Especie</option>
                    <option value ="4">Utilizador</option>
                </c:otherwise>
            </c:choose>
        </select>     
        <button type="submit" class="submit" style="margin: 0 0 0 0; background-image: url('images/search.png'); background-repeat: no-repeat; width: 40px; background-position: center;"></button>
    </form>
    <form action="<c:url value='consultar_intervencao'/>" method="get" class="form-horizontal" data-validate="parsley">
        <button type="submit" class="submit" style="margin: 10px 0 0 315px; width: 60px;">Limpar</button>
    </form>
</div>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/intervencao.png" alt="intervencao" /><h1 style="margin: 15px 0 0 0;">Lista de intervenções existentes</h1>

<br> <br>
<table style="border-spacing:0;">
    <tr>
        <th>Número</th>
        <th>Lote</th>
        <th>Nome</th>
        <th>Descrição</th>
        <th>Tipo</th>
        <th>Data</th>
        <th>Espécie</th>
        <th>Quantidade</th>
        <th>Utilizador responsável</th>
        <th>Editar</th>
        <th>Apagar</th>
    </tr>
    <c:forEach var="columnName" items="${cons_intervencao}">
        <tr>
            <td> <c:out value="${columnName.id}"/> </td>
            <td>  <c:out value="${columnName.idLote}"/> </td>
            <td> <c:out value="${columnName.nome}"/> </td>
            <td> <c:out value="${columnName.descricao}"/> </td>
            <td> <c:out value="${columnName.tipo}"/> </td>
            <td>  <c:out value="${columnName.data}"/> </td>
            <td> <c:out value="${columnName.especie}"/> </td>
            <td> <c:out value="${columnName.quantidade}"/> </td>  
            <td> <c:out value="${columnName.idUtilizador}"/> </td><%-- --%>
            <td>
                <a href="editar_intervencao?${columnName.id}" title="Editar">
                    <img src="images/edit.png" width="25" height="25">
                </a>
            </td>
            <td>
                <a onclick="delete_intervencao('${columnName.id}')" title="Eliminar">
                    <img src="images/delete.png" width="25" height="25">
                </a>
            </td>
        </tr>
    </c:forEach>
</table>


<%
    if (request.getAttribute("IntervencaoALTERADO") == "1") {
%>
<script>

    alert("Intervenção alterada com sucesso!");

</script>
<%                                }
%>