<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<script type="text/javascript">
    function delete_dados_ambientais(id)
    {
        var x=confirm("Tem a certeza que quer eliminar o dado ambiental?");
        if (x==true)
        {
            window.location.href="eliminar_dados_ambientais?"+id;
        }
        else
        {      
        }
            
    }
</script>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/ambientais.png" alt="dados" /><h1 style="margin: 15px 0 0 0;">Lista dos dado ambientais existentes</h1>

<br> <br>

<table style="border-spacing:0;">
    <tr>
        <th>Id</th>
        <th>Id do Tanque</th>
        <th>Temperatura (Graus ºC)</th>
        <th>Salinidade da água</th>
        <th>Oxigénio (%)</th>
        <th>Data de recolha</th>
        <th>Editar</th>
        <th>Apagar</th>
    </tr>
    <c:forEach var="columnName" items="${dados_ambientais}">
        <tr>
            <td> <c:out value="${columnName.id}"/> </td>
            <td> <c:out value="${columnName.idTanque}"/> </td>
            <td> <c:out value="${columnName.temperatura}"/> ºC</td>
            <td> <c:out value="${columnName.salinidadeAgua}"/> </td>
            <td> <c:out value="${columnName.oxigenio}"/> %</td>
            <td> <c:out value="${columnName.data}"/> </td>
            <td>
                <a href="editar_dados_ambientais?${columnName.id}" title="Editar">
                    <img src="images/edit.png" width="25" height="25"></td>
                </a>
            <td>
                <a onclick="delete_dados_ambientais('${columnName.id}')" title="Eliminar">
                    <img src="images/delete.png" width="25" height="25">
                </a>
            </td>
        </tr>
    </c:forEach>
</table>


    <%
    if (request.getAttribute("DadosAmbientaisALTERADO") == "1") {
%>
<script>

    alert("Dado ambiental alterado com sucesso!");

</script>
<%                                }
%>
  