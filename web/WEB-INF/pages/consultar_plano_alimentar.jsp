<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<script type="text/javascript">
    function delete_plano_alimentar(id)
    {
        var x=confirm("Tem a certeza que quer eliminar o plano alimentar?");
        if (x==true)
        {
            window.location.href="eliminar_plano_alimentar?"+id;
        }
        else
        {      
        }
            
    }
</script>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/plano.png" alt="planos_alimentares" /><h1 style="margin: 15px 0 0 0;">Lista dos planos alimentares existentes</h1>

<br> <br>


<table style="border-spacing:0;">
    <tr>
        <th>Id</th>
        <th>Id do Tanque</th>
        <th>Tipo de alimentação</th>
        <th>Data da criação do plano</th>
        <th>Quantidade de comida (medidas)</th>
        <th>Forma de distribuição</th>
        <th>Número vezes p/ dia</th>
        <th>Editar</th>
        <th>Apagar</th>
    </tr>
    <c:forEach var="columnName" items="${cons_plano_ali}">
        <tr>
            <td > <c:out value="${columnName.id}"/> </td>
            <td> <c:out value="${columnName.idTanque}"/> </td>
            <td> <c:out value="${columnName.tipoAlimentacao}"/> </td>
            <td> <c:out value="${columnName.data}"/> </td>
            <td> <c:out value="${columnName.quantidade}"/> medida(s)</td>
            <td> <c:out value="${columnName.formaDistribuicao}"/> </td> 
            <td> <c:out value="${columnName.NVezesDia}"/></td>
            <td> 
                <a href="editar_plano_alimentar?${columnName.id}" title="Editar">
                    <img src="images/edit.png" width="25" height="25">
                </a> 
            </td>

            <td>
                <a onclick="delete_plano_alimentar('${columnName.id}')" title="Eliminar">
                    <img src="images/delete.png" width="25" height="25">
                </a>  <%-- --%>
            </td> 
        </tr>
    </c:forEach>
</table>


<%
    if (request.getAttribute("PlanoALTERADO") == "1") {
%>
<script>

    alert("Plano alimentar alterado com sucesso!");

</script>
<%                                }
%>