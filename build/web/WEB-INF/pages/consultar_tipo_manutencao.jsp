<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/manutencao.png" alt="manutenção" /><h1 style="margin: 15px 0 0 0;">Lista de tipos de manutenção existentes</h1>

<br> <br>

<table style="border-spacing:0;">
    <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Nível</th>
        <th>Frequência</th>
        <th>Descrição</th>
        <th>Editar</th>
    </tr>
    <c:forEach var="columnName" items="${cons_tipo_manutencao}">
        <tr>
            <td> <c:out value="${columnName.id}"/> </td>
            <td> <c:out value="${columnName.nome}"/> </td>
            <td> <c:out value="${columnName.nivel}"/> </td>
            <td> <c:out value="${columnName.frequencia}"/> </td><%----%>
            <td> <c:out value="${columnName.descricao}"/> </td>
            <td>
                <a href="editar_tipo_man?${columnName.id}" title="Editar">
                    <img src="images/edit.png" width="25" height="25">
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<%
    if (request.getAttribute("TipoManALTERADO") == "1") {
%>
<script>

    alert("Tipo de manutenção alterado com sucesso!");

</script>
<%                                }
%>