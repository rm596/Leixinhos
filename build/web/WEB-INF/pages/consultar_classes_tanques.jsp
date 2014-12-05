<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/tanque2.png" alt="tanques" /><h1 style="margin: 15px 0 0 0;">Lista das classes de tanques existentes</h1>

<br> <br>

<!--<h4></h4>-->
<table style="border-spacing:0;">
    <tr>
        <th>Id</th>
        <th>Nome da classe</th>
        <th>Descrição da classe</th>
        <th>Editar classe</th>
    </tr>
    <c:forEach var="columnName" items="${classes_tanques}">
        <tr>
            <td> <c:out value="${columnName.id}"/> </td>
            <td> <c:out value="${columnName.nome}"/> </td>
            <td> <c:out value="${columnName.descricao}"/> </td>
            <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="editar_classe_tanque?${columnName.id}" title="Editar">
                <img src="images/edit.png" width="25" height="25">
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<%
    if (request.getAttribute("ClasseTanqueALTERADO") == "1") {
%>
<script>

    alert("Classe de tanque alterada com sucesso!");

</script>
<%                                }
%>


