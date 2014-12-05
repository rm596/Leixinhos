<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/utilizador.png" alt="utilizador" /><h1 style="margin: 15px 0 0 0;">Editar informação de perfil do utilizador <c:out value="${user.nome}"/></h1>

<br> <br>

<h2>Editar Perfil:</h2>
<div class="form_settings">
    <form action="<c:url value='admin_edit_users'/>" method="post" class="form-horizontal" data-validate="parsley">
        <p> <span>Nome:</span>
            <input type="text" name="nome" data-required="true" data-trigger="change" value="${user.nome}" placeholder="Nome" data-rangelength="[5,30]"/>
        </p>

        <p> <span>Tipo Utilizador:</span>
            <select name="tipo">
                <c:forEach var="columnName" items="${userType}">
                    <c:choose>
                        <c:when test="${user.tipoUtilizador == columnName.nome}">
                            <option value ="${columnName.id}" selected><c:out value="${columnName.nome}"/></option>
                        </c:when>

                        <c:otherwise>
                            <option value ="${columnName.id}" ><c:out value="${columnName.nome}"/></option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </p>

        <p> <span>Email:</span>
            <input type="text" name="email" data-type="email" data-required="true" data-trigger="change" value="${user.email}" placeholder="Email" data-rangelength="[5,30]"/>
        </p>

        <p> <span>Morada:</span>
            <input type="text" name="morada" data-trigger="change" value="${user.morada}" placeholder="Morada" data-rangelength="[6,40]"/>
        </p>

        <p> <span>Telemovel:</span>
            <input type="text" name="phone" data-type="digits" data-rangelength="[9,9]" data-trigger="change" placeholder="Telemovel" value="${user.telemovel}" data-type="digits"/>
        </p>

        <p> <span>Username:</span>
            <input type="text" name="username" data-required="true" data-trigger="change" placeholder="Username" value="${user.username}" data-rangelength="[5,10]"  data-type="alphanum"/>
        </p>

        <p> <span>Grupo:</span>
            <input type="text" name="grupoPRO" data-required="true" data-trigger="change" placeholder="Grupo" value="${user.grupoPro}" data-rangelength="[4,30]" data-type="alphanum"/>
        </p>
        <p style="padding-top: 15px; position: relative; left: 20px;">
            <span></span>
            <button type="submit" class="submit">Editar Perfil</button>
        </p>
        <input type="hidden" name="id" value="${user.id}"/>
    </form>
</div>

<%
    if (request.getAttribute("isUsernameRepited") == "1" && request.getAttribute("isEmailRepited") == "0") {
%>
<script>

    alert("Username já Usado, por favor outro!");

</script>
<%                                } else if (request.getAttribute("isUsernameRepited") == "0" && request.getAttribute("isEmailRepited") == "1") {
%>
<script>

    alert("Email já Registado, por favor outro!");

</script>
<%                                } else if (request.getAttribute("isUsernameRepited") == "1" && request.getAttribute("isEmailRepited") == "1") {
%>
<script>

    alert("Username e Email já Registado, por favor outro!");

</script>
<%                                }
%>
