<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/manutencao.png" alt="manutenção" /><h1 style="margin: 15px 0 0 0;">Editar informação da manutenção efectuada <c:out value="${man_efec.id}"/></h1>

<br> <br>


<form id="checkoutForm" action="<c:url value='edit_man_efect'/>" method="post" data-validate="parsley">
    <div class="form_settings">
        <p><span>Tanque:</span>
        
        <select name="idtanque" style="width: 250px" >
                <c:forEach var="columnName" items="${tanque}">
                    <c:choose>
                        <c:when test="${man_efec.id == columnName.id}">
                            <option value="${columnName.id}" selected> Id: <c:out value="${columnName.id}"/>, Estado: <c:out value="${columnName.estadoTanque}"/> 
                        </c:when>
                        <c:otherwise>
                            <option value="${columnName.id}"> Id: <c:out value="${columnName.id}"/>, Estado: <c:out value="${columnName.estadoTanque}"/> 
                        </c:otherwise>
                    </c:choose>
                </c:forEach>                
        </select>
        
        </p>
        <input type="hidden" name="id" value="${man_efec.id}">

      <p><span>Tipo de manutenção:</span>
          <select name="tipo_manutencao" style="width: 250px" >
                <c:forEach var="columnName" items="${tipo_manutencao}">
                    <c:choose>
                        <c:when test="${man_efec.tipoManutencao.getId() == columnName.id}">
                            <option value="${columnName.id}" selected> Tipo: <c:out value="${columnName.id}"/>, Nome: <c:out value="${columnName.nome}"/>
                        </c:when>
                        <c:otherwise>
                            <option value="${columnName.id}" > Tipo: <c:out value="${columnName.id}"/>, Nome: <c:out value="${columnName.nome}"/>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>                
        </select>          
      </p>        
  <%-- 
        <input  class="radio" type="radio" name="tipo_manutencao" value="${columnName.id}" > Tipo: <c:out value="${columnName.id}"/>, Nome: <c:out value="${columnName.nome}"/>
--%>
        
        <p>
            <span>Observações:</span>
            <textarea rows="5" cols="50" name="observacoes" value="${man_efec.observacoes}" placeholder="${man_efec.observacoes}" data-rangelength="[0,100]" style="width:350px; max-width: 590px; height:150px; max-height: 250px"><c:out value="${man_efec.observacoes}"/></textarea>
        </p>
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="editar" value="Editar" />
        </p>
    </div>
</form>


<%
    if (request.getAttribute("ManutencaoEfectuadaALTERADO") == "1") {
%>
<script>

    alert("Manutenção efectuada alterada com sucesso!");

</script>
<%                                }
%>