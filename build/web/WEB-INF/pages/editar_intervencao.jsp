<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/intervencao.png" alt="intervencao" /><h1 style="margin: 15px 0 0 0;">Editar informação da intervenção <c:out value="${intervencao.id}"/></h1>

<br> <br>

<form id="checkoutForm" action="<c:url value='editar_intervencao'/>" method="post" data-validate="parsley">
    <div class="form_settings">

        <input type="hidden" name="id" value="${intervencao.id}">

        <p><span>Nome:</span><input type="text" name="nome" value="${intervencao.nome}" data-required="true" data-trigger="change" data-rangelength="[1,50]"></p>
        <br>
        <p><span>Lote da intervenção:</span>
            <select name="id_lote" style="width: 370px" >
            <c:forEach var="columnName" items="${lote}">
            <c:choose>
                <c:when test="${intervencao.idLote.getId() == columnName.id}">
                    <option value="${columnName.id}" selected> Id: <c:out value="${columnName.id}"/>, Espécie: <c:out value="${columnName.especie}"/>, Origem: <c:out value="${columnName.origem}"/> 
                </c:when>
                <c:otherwise>
                    <option value="${columnName.id}"> Id: <c:out value="${columnName.id}"/>, Espécie: <c:out value="${columnName.especie}"/>, Origem: <c:out value="${columnName.origem}"/> 
                </c:otherwise>
              </c:choose>
            </c:forEach>
        </select>
            
        </p>
        <p><span>Tipo de intervenção:</span>
            <c:choose>
                <c:when test="${intervencao.getTipo() == 'Remocao'}">
                    <input class="radio" type="radio" checked name="tipo" value="Remocao"> Remoção
                    <input class="radio" type="radio" name="tipo" value="Adicao"> Adição
                </c:when>
                <c:otherwise>
                    
                    <input class="radio" type="radio" name="tipo" value="Remocao"> Remoção
                    
                    <input class="radio" type="radio" checked name="tipo" value="Adicao"> Adição
                </c:otherwise>
            </c:choose>
        </p>
        <br>
        <p>
            <span>Descrição:</span>
            <textarea rows="5" cols="50" value="${intervencao.descricao}" name="descricao" data-rangelength="[0,100]" style="width:350px; max-width: 590px; height:150px; max-height: 250px"><c:out value="${intervencao.descricao}"/></textarea>
        </p>
        <br>
        <p><span>Espécie:</span><input type="text" value="${intervencao.especie}" name="especie" data-required="true" data-trigger="change" data-rangelength="[1,50]"></p>
        <br>
        <p>
            <span>Quantidade:</span>
            <input type="text" name="quantidade" value="${intervencao.quantidade}" data-rangelength="[1,9]" data-required="true" data-trigger="change" data-type="digits"/>
        </p>
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="editar" value="Editar" />
        </p>
    </div>
</form>

