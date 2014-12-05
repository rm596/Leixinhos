<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/intervencao.png" alt="intervencao" /><h1 style="margin: 15px 0 0 0;">Inserir intervenção</h1>

<br> <br>

<form id="checkoutForm" action="<c:url value='criar_intervencao'/>" method="post" data-validate="parsley">
    <div class="form_settings">
        <p><span>Nome:</span><input type="text" name="nome" data-required="true" data-trigger="change" data-rangelength="[1,50]"></p>
        <br>
        <p><span>Lote da intervenção:</span>
            <select name="id_lote" style="width: 320px" >
                <c:forEach var="columnName" items="${lote}">
                    <option value="${columnName.id}"> Id: <c:out value="${columnName.id}"/>, Espécie: <c:out value="${columnName.especie}"/>, Origem: <c:out value="${columnName.origem}"/> 
                </c:forEach>
            </select>
        </p>
        
        <p><span>Tipo de intervenção:</span>
            
            <input class="radio" type="radio" name="tipo" value="Remocao" required="required"> Remoção
            
            <input class="radio" type="radio" name="tipo" value="Adicao" required="required"> Adição
        </p>
 
             
   
        <p>
            <span>Descrição:</span>
            <textarea rows="5" cols="50" name="descricao" data-rangelength="[0,100]" style="width:350px; max-width: 590px; height:150px; max-height: 250px"></textarea>
        </p>
        <br>
        <p><span>Espécie:</span><input type="text" name="especie" data-required="true" data-trigger="change" data-rangelength="[1,50]"></p>
        <br>
        <p>
            <span>Quantidade:</span>
            <input type="text" name="quantidade" data-rangelength="[1,9]" data-required="true" data-trigger="change" data-type="digits"/>
        </p>
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="criar" value="Criar" />
        </p>
    </div>
</form>

<%
    if (request.getAttribute("intervencaoFACADE") == "1") {
%>
<script>

    alert("Intervenção efectuada inserida com sucesso!");

</script>
<%                                }
%>
