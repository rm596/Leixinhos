<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/manutencao.png" alt="manutenção" /><h1 style="margin: 15px 0 0 0;">Inserir manutenção efectuada</h1>

<br> <br>


<form id="checkoutForm" action="<c:url value='criar_manutencao_efectuada'/>" method="post" data-validate="parsley">
    <div class="form_settings">
        <p><span>Tanque:</span>
        
            <select name="idtanque" style="width: 430px" >
                <c:forEach var="columnName" items="${tanque}">
                    <option value="${columnName.id}"> Id: <c:out value="${columnName.id}"/>, Estado: <c:out value="${columnName.estadoTanque}"/>    
                </c:forEach>
            </select>
        </p>
        
        <br>
        <p><span>Tipo de manutenção:</span>
            <select name="tipo_manutencao" style="width: 430px" >
                <c:forEach var="columnName" items="${tipo_manutencao}">
                    <option value="${columnName.id}" > Tipo: <c:out value="${columnName.id}"/>, Nome: <c:out value="${columnName.nome}"/>
                </c:forEach>
            </select>
        </p>
       
        <br>
        <p>
            <span>Observações:</span>
            <textarea rows="5" cols="50" name="observacoes" data-rangelength="[0,100]" style="width:350px; max-width: 590px; height:150px; max-height: 250px"></textarea>
        </p>
         <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="criar" value="Criar" />
        </p>
    </div>
</form>

<%
    if (request.getAttribute("ManutencaoEfectuadaINSERIDO") == "1") {
%>
<script>

    alert("Manutenção efectuada inserida com sucesso!");

</script>
<%                                }
%>
