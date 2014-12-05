<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/tratamento.png" alt="tratamento" /><h1 style="margin: 15px 0 0 0;">Inserir tratamento</h1>

<br> <br>


<form id="checkoutForm" action="<c:url value='criar_tratamento_efectuado'/>" method="post" data-validate="parsley">
    <div class="form_settings">
        <p><span>Tanque da intervenção:</span>
            <select name="tanque" style="width: 400px" >
                <c:forEach var="columnName" items="${tanque}">
                    <option value="${columnName.id}"> ID do tanque: <c:out value="${columnName.id}"/>, Volume usado: <c:out value="${columnName.volumeUsado}"/>L, Estado: <c:out value="${columnName.estadoTanque}"/>
                </c:forEach>
            </select>
        </p>
        
        <p><span>Agente:</span><input type="text" name="agente" data-required="true" data-trigger="change" data-rangelength="[1,50]"></p>
        <br> 
        <p>
            <span>Temperatura: (Graus ºC)</span>
            <input type="double" name="temperatura" data-required="true" data-trigger="change" data-type="number">
        </p>
        <p><span>Tipo de tratamento:</span>
            
            <input class="radio" type="radio" name="tipo" value="Terapeutico"> Terapêutico
            
            <input class="radio" type="radio" name="tipo" value="Profilatico"> Profilático
        </p>
        <br>
        <p>
            <span>Duração: (Minutos)</span>
            <input type="double" name="duracao" data-required="true" data-trigger="change" data-type="number">
        </p>
        <br>
        <p>
            <span>Dose: (Kg ou Litros)</span>
            <input type="double" name="dose" data-required="true" data-trigger="change" data-type="number">
        </p>
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="criar" value="Criar" />
        </p>
    </div>
</form>

<%
    if (request.getAttribute("TratamentoEfectuadoINSERIDO") == "1") {
%>
<script>

    alert("Tratamento inserido com sucesso!");

</script>
<%                                }
%>