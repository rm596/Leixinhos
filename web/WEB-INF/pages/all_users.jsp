<script type="text/javascript">
    function delete_user(id) {
        var x = confirm("Tem a certeza que pretende eliminar este utilizador?");
        if (x == true) {
            window.location.href = "delete_user?" + id;
        } else {
            ;
        }
    }
</script>

<%@page import="entity.TipoUtilizador"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>



<div class="form_settings" style="float: right; width: 400px">
    <form action="<c:url value='searchUsers'/>" method="post" class="form-horizontal" data-validate="parsley" style="margin: 0 0 0 0;">
        <input type="text" name="search" data-trigger="change" placeholder="Procurar" value="${search}" style="width: 150px"/>
        <select name="tipoUser" style="width: 141px">
            <c:choose>
                <c:when test="${idTIPO == 1}">
                    <option value ="1" selected>Tipo Utilizador</option>
                    <option value ="2">Nome Utilizador</option>
                    <option value ="3">Email</option>
                    <option value ="4">Username</option>
                </c:when>
                <c:when test="${idTIPO == 2}">
                    <option value ="1">Tipo Utilizador</option>
                    <option value ="2" selected>Nome Utilizador</option>
                    <option value ="3">Email</option>
                    <option value ="4">Username</option>
                </c:when>
                <c:when test="${idTIPO == 3}">
                    <option value ="1">Tipo Utilizador</option>
                    <option value ="2">Nome Utilizador</option>
                    <option value ="3" selected>Email</option>
                    <option value ="4">Username</option>
                </c:when>
                <c:when test="${idTIPO == 4}">
                    <option value ="1">Tipo Utilizador</option>
                    <option value ="2">Nome Utilizador</option>
                    <option value ="3">Email</option>
                    <option value ="4" selected>Username</option>
                </c:when>
                <c:otherwise>
                    <option value ="1">Tipo Utilizador</option>
                    <option value ="2">Nome Utilizador</option>
                    <option value ="3">Email</option>
                    <option value ="4">Username</option>
                </c:otherwise>
            </c:choose>
        </select>     
        <button type="submit" class="submit" style="margin: 0 0 0 0; background-image: url('images/search.png'); background-repeat: no-repeat; width: 40px; background-position: center;"></button>
    </form>
    <form action="<c:url value='all_users'/>" method="get" class="form-horizontal" data-validate="parsley">
        <button type="submit" class="submit" style="margin: 10px 0 0 315px; width: 60px;">Limpar</button>
    </form>
</div>
        
<img style="float: left; vertical-align: middle; width: 95px; height: 81px;" src="images/utilizador.png" alt="utilizador" /><h1 style="margin: 15px 0 0 0;">Lista dos utilizadores existentes</h1>
<br> <br>

<!-- <h4>Lista dos Utilizadores Sistema:</h4> -->

<table style="border-spacing:0;">
    <tr>
        <th>N.º Utilizador</th>
        <th>Nome</th>
        <th>Tipo Utilizador</th>
        <th>Username</th>
        <th>Email</th>
        <th>Editar</th>
    </tr>
    <c:forEach var="pointer" items="${users}">
        <tr>
            <td> <c:out value="${pointer.id}"/> </td>  
            <td> <c:out value="${pointer.nome}"/> </td>
            <td> <c:out value="${pointer.tipoUtilizador}"/> </td>
            <td> <c:out value="${pointer.username}"/> </td>
            <td> <c:out value="${pointer.email}"/> </td>
            <td>
                <a href="admin_edit_users?${pointer.id}" title="Editar">
                    <img src="images/edit.png" width="25" height="25">
                </a>
            </td>
        </tr>
    </c:forEach>
</table>