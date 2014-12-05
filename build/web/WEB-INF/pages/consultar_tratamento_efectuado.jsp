<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<script type="text/javascript">
    function delete_tratamento(id)
    {
        var x=confirm("Tem a certeza que quer eliminar o tratamento?");
        if (x==true)
        {
            window.location.href="eliminar_tratamento?"+id;
        }
        else
        {      
        }
            
    }
</script>

<div class="form_settings" style="float: right; width: 400px">
    <form action="<c:url value='searchTratamentoEfectuado'/>" method="post" class="form-horizontal" data-validate="parsley" style="margin: 0 0 0 0;">
        <input type="text" name="search" data-trigger="change" placeholder="Procurar" value="${search}" style="width: 150px"/>
        <select name="searchType" style="width: 141px">
            <c:choose>
                <c:when test="${idSEARCH == 1}">
                    <option value ="1" selected>Tanque</option>
                    <option value ="2">Agente</option>
                    <option value ="3">Tipo Tratamento</option>
                </c:when>
                <c:when test="${idSEARCH == 2}">
                    <option value ="1">Tanque</option>
                    <option value ="2" selected>Agente</option>
                    <option value ="3">Tipo Tratamento</option>
                </c:when>
                <c:when test="${idSEARCH == 3}">
                    <option value ="1">Tanque</option>
                    <option value ="2">Agente</option>
                    <option value ="3" selected>Tipo Tratamento</option>
                </c:when>
                <c:otherwise>
                    <option value ="1">Tanque</option>
                    <option value ="2">Agente</option>
                    <option value ="3">Tipo Tratamento</option>
                </c:otherwise>
            </c:choose>
        </select>     
        <button type="submit" class="submit" style="margin: 0 0 0 0; background-image: url('images/search.png'); background-repeat: no-repeat; width: 40px; background-position: center;"></button>
    </form>
    <form action="<c:url value='consultar_tratamento_efectuado'/>" method="get" class="form-horizontal" data-validate="parsley">
        <button type="submit" class="submit" style="margin: 10px 0 0 315px; width: 60px;">Limpar</button>
    </form>
</div>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/tratamento.png" alt="tratamento" /><h1 style="margin: 15px 0 0 0;">Lista dos tratamentos existentes</h1>

<br> <br>

<table style="border-spacing:0;">
    <tr>
        <th>Referência</th>
        <th>Tanque</th>
        <th>Agente</th>
        <th>Temperatura (Graus ºC)</th>
        <th>Tipo de tratamento</th>
        <th>Duração (Minutos)</th>
        <th>Dose (Kg ou Litros)</th>
        <th>Data</th>
        <th>Editar</th>
        <th>Apagar</th>
    </tr>
    <c:forEach var="columnName" items="${tratamento}">
        <tr>
            <td> <c:out value="${columnName.referencia}"/> </td>
            <td> <c:out value="${columnName.idTanque}"/> </td>
            <td> <c:out value="${columnName.agente}"/> </td>
            <td> <c:out value="${columnName.temperatura}"/> </td>
            <td> <c:out value="${columnName.tipo}"/> </td>
            <td> <c:out value="${columnName.duracao}"/> min</td>
            <td> <c:out value="${columnName.dose}"/> Kg/L</td>
            <td> <c:out value="${columnName.data}"/> </td>
            <td>
                <a href="editar_tratamento_efectuado?${columnName.referencia}" title="Editar">
                <img src="images/edit.png" width="25" height="25">
                </a>
            </td>       
            <td>
                <a onclick="delete_tratamento('${columnName.referencia}')" title="Eliminar">
                    <img src="images/delete.png" width="25" height="25">
                </a>
            </td>
        </tr>
    </c:forEach>
</table>


<%
    if (request.getAttribute("TratamentoALTERADO") == "1") {
%>
<script>

    alert("Tratamento alterado com sucesso!");

</script>
<%                                }
%>

