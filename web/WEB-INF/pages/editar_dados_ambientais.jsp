<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/ambientais.png" alt="dados" /><h1 style="margin: 15px 0 0 0;">Editar informação do dado ambiental <c:out value="${dados.id}"/> </h1>

<br> <br>


<form id="checkoutForm" action="<c:url value='editar_dados_ambientais'/>" method="post" data-validate="parsley">
    <div class="form_settings">
        <p><span>Tanque:</span>
            <input type="hidden" name="id" value="${dados.id}">
            <select name="idtanque" style="width: 315px" >
                <c:forEach var="columnName" items="${tanque}">
                <c:choose>
                    <c:when test="${dados.idTanque.getId() == columnName.id}">
                        <option value="${columnName.id}" selected> Id: <c:out value="${columnName.id}"/>, Estado: <c:out value="${columnName.estadoTanque}"/> 
                    </c:when>
                    <c:otherwise>
                        <option value="${columnName.id}"> Id: <c:out value="${columnName.id}"/>, Estado: <c:out value="${columnName.estadoTanque}"/> 
                    </c:otherwise>
                  </c:choose>
                </c:forEach>
            </select> 
        </p>
        
        <p>
            <span>Temperatura:</span>
            <input type="double" name="temperatura" value="${dados.temperatura}" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Salinidade da água:</span>
            <input type="double" name="salinidadeAgua" value="${dados.salinidadeAgua}" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Oxigénio:</span>
            <input type="double" name="oxigenio" value="${dados.oxigenio}" data-required="true" data-trigger="change" data-type="number">
        </p>
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="editar" value="Editar" />
        </p>
    </div>
</form>
  
