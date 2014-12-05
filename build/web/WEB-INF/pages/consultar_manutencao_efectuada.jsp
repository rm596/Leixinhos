
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<script type="text/javascript">
    function delete_man_efect(id)
    {
        var x=confirm("Tem a certeza que quer eliminar a manutencao efectuada?");
        if (x==true)
        {
            window.location.href="eliminar_man_efect?"+id;
        }
        else
        {      
        }
            
    }
</script>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/manutencao.png" alt="manutenção" /><h1 style="margin: 15px 0 0 0;">Lista de manutenções efectuadas existentes</h1>

<br> <br>



<table style="border-spacing:0;">
    <tr>
        <th>Id</th>
        <th>Id do tanque</th>
        <th>Id e Nome do tipo de manutenção</th>
        <th>Data</th>
        <th>Observações</th>
        <th>Editar</th>
        <th>Apagar</th>
    </tr>
    <c:forEach var="columnName" items="${cons_man_efectuada}">
        <tr>
            <td> <c:out value="${columnName.id}"/> </td>    
            <td> <c:out value="${columnName.idTanque}"/> </td> 
            <td> <c:out value="${columnName.tipoManutencao}"/> </td>
            <td> <c:out value="${columnName.data}"/> </td>
            <td> <c:out value="${columnName.observacoes}"/> </td>
            <td>
                <a href="edit_man_efect?${columnName.id}" title="Editar">
                    <img src="images/edit.png" width="25" height="25">
                </a>
            </td>
            <td>
                <a onclick="delete_man_efect('${columnName.id}')" title="Eliminar">
                    <img src="images/delete.png" width="25" height="25">
                </a>  <%-- --%>
            </td>
        </tr>
    </c:forEach>
</table>

<%
    if (request.getAttribute("ManutencaoEfectuadaALTERADO") == "1") {
%>
<script>

    alert("Manutenção efectuada alterada com sucesso!");

</script>
<%                                }
%>