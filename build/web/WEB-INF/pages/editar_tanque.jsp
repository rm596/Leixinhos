<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/tanque2.png" alt="tanque" /><h1 style="margin: 15px 0 0 0;">Editar informação do tanque <c:out value="${tanque.id}"/></h1>

<br> <br>

<form id="checkoutForm" action="<c:url value='editar_tanque'/>" method="post" data-validate="parsley">
    <div class="form_settings">

        <input type="hidden" name="id" value="${tanque.id}">

        <p><span>Tipo de tanque:</span>
        <select name="tipo_tanque" style="width: 370px" >
            <c:forEach var="columnName" items="${tipo_tanque}">
            <c:choose>
                <c:when test="${tanque.idTipo.getId() == columnName.id}">
                    <option value="${columnName.id}" selected> ID do tipo tanque: <c:out value="${columnName.id}"/>, Nome: <c:out value="${columnName.nome}"/>L, Volume total: <c:out value="${columnName.volumeTotal}"/>   
                </c:when>
                <c:otherwise>
                    <option value="${columnName.id}" > ID do tipo tanque: <c:out value="${columnName.id}"/>, Nome: <c:out value="${columnName.nome}"/>L, Volume total: <c:out value="${columnName.volumeTotal}"/>   
                </c:otherwise>
              </c:choose>
            </c:forEach>
        </select>
        </p>
        </br>
        
        <p>
            <span>Volume usado: (Litros)</span>
            <input type="double" name="volumeusado" value="${tanque.volumeUsado}" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p><span>Localização física:</span><input type="text" value="${tanque.localizacaoFisica}"  name="localizacao" data-required="true" data-trigger="change" data-rangelength="[1,50]"></p>
        <br>
        <p><span>Estado do tanque:</span>
            <c:choose>
                <c:when test="${tanque.getEstadoTanque() == 'Usado'}">
                    <input class="radio" type="radio" name="estado" checked value="Usado" data-group="mygroup" data-required="true"> Usado
                    <input class="radio" type="radio" name="estado" value="Livre" data-group="mygroup" > Livre
                    <input class="radio" type="radio" name="estado" value="Quarentena" data-group="mygroup" > Quarentena
                </c:when>
                <c:when test="${tanque.getEstadoTanque() == 'Livre'}">
                    <input class="radio" type="radio" name="estado" value="Usado" data-group="mygroup" data-required="true"> Usado
                    <input class="radio" type="radio" name="estado" checked value="Livre" data-group="mygroup" > Livre
                    <input class="radio" type="radio" name="estado" value="Quarentena" data-group="mygroup" > Quarentena
                </c:when>
                <c:otherwise>
                    <input class="radio" type="radio" name="estado" value="Usado" data-group="mygroup" data-required="true"> Usado
                    <input class="radio" type="radio" name="estado" value="Livre" data-group="mygroup" > Livre
                    <input class="radio" type="radio" name="estado" checked value="Quarentena" data-group="mygroup" > Quarentena
                </c:otherwise>
            </c:choose>
        </p>
        <br>
        <p><span>Caracterização:</span><input type="text" value="${tanque.caracterizacao}" name="caracterizacao" data-required="true" data-trigger="change" data-rangelength="[1,50]"></p>
            <%-- --%>      
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="editar" value="Editar" />
        </p>

    </div>
</form>