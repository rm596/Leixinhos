<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/tratamento.png" alt="tratamento" /><h1 style="margin: 15px 0 0 0;">Editar informação do tratamento <c:out value="${tratamento.referencia}"/> </h1>

<br> <br>


<form id="checkoutForm" action="<c:url value='editar_tratamento_efectuado'/>" method="post" data-validate="parsley">
    <div class="form_settings">
        <p><span>Tanque:</span>
            <select name="tanque" style="width: 370px" >
                <c:forEach var="columnName" items="${tanque}">
                <c:choose>
                    <c:when test="${tratamento.idTanque.getId() == columnName.id}">
                        <option value="${columnName.id}" selected> Id: <c:out value="${columnName.id}"/>, Estado: <c:out value="${columnName.estadoTanque}"/> 
                    </c:when>
                    <c:otherwise>
                        <option value="${columnName.id}"> Id: <c:out value="${columnName.id}"/>, Estado: <c:out value="${columnName.estadoTanque}"/> 
                    </c:otherwise>
                  </c:choose>
                </c:forEach>
            </select>                        
        </p>
        <input type="hidden" name="id" value="${tratamento.referencia}">
        
        
        <p><span>Agente:</span><input type="text" value="${tratamento.agente}" name="agente" data-required="true" data-trigger="change" data-rangelength="[1,50]"></p>
        <br> 
        <p>
            <span>Temperatura: (Graus ºC)</span>
            <input type="double" name="temperatura" value="${tratamento.temperatura}" data-required="true" data-trigger="change" data-type="number">
        </p>
        
        <p><span>Tipo de tratamento:</span>
        
        <c:choose>
            <c:when test="${tratamento.tipo == 'Terapeutico'}">
                <input class="radio" type="radio" name="tipo" checked value="Terapeutico"> Terapêutico
                
                <input class="radio" type="radio" name="tipo" value="Profilatico"> Profilático
                
            </c:when>
            <c:otherwise>
                <input class="radio" type="radio" name="tipo" value="Terapeutico"> Terapêutico
                
                <input class="radio" type="radio" name="tipo" checked value="Profilatico"> Profilático
                
            </c:otherwise>
        </c:choose>
                </p>
        
        <p>
            <span>Duração: (Minutos)</span>
            <input type="double" name="duracao" data-required="true" value="${tratamento.duracao}" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Dose: (Kg ou Litros)</span>
            <input type="double" name="dose" data-required="true" value="${tratamento.dose}" data-trigger="change" data-type="number">
        </p>
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="editar" value="Editar" />
        </p>
    </div>
</form>


