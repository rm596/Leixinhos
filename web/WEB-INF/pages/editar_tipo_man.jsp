<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/manutencao.png" alt="manutenção" /><h1 style="margin: 15px 0 0 0;">Editar informação do tipo de manutenção <c:out value="${tipo_manutencao.id}"/></h1>

<br> <br>

<form id="checkoutForm" action="<c:url value='editar_tipo_man'/>" method="post" data-validate="parsley">
    <div class="form_settings">

        <input type="hidden" name="id" value="${tipo_manutencao.id}">

        <p><span>Nome:</span><input type="text" name="nome" value="${tipo_manutencao.nome}" data-required="true" data-trigger="change" data-rangelength="[1,50]"></p>
        <br>
        <p><span>Nível:</span>
            <c:choose>
                <c:when test="${tipo_manutencao.getNivel() == '0'}">
                    <input class="radio" type="radio" name="nivel" value="0" checked data-group="mygroup" data-required="true"> 0
                    <input class="radio" type="radio" name="nivel" value="1" data-group="mygroup" > 1
                    <input class="radio" type="radio" name="nivel" value="2" data-group="mygroup" > 2
                    <input class="radio" type="radio" name="nivel" value="3" data-group="mygroup" > 3
                    <input class="radio" type="radio" name="nivel" value="4" data-group="mygroup" > 4
                </c:when>
                <c:when test="${tipo_manutencao.getNivel() == '1'}">
                    <input class="radio" type="radio" name="nivel" value="0"  data-group="mygroup" data-required="true"> 0
                    <input class="radio" type="radio" name="nivel" value="1" checked data-group="mygroup" > 1
                    <input class="radio" type="radio" name="nivel" value="2" data-group="mygroup" > 2
                    <input class="radio" type="radio" name="nivel" value="3" data-group="mygroup" > 3
                    <input class="radio" type="radio" name="nivel" value="4" data-group="mygroup" > 4
                </c:when>
                <c:when test="${tipo_manutencao.getNivel() == '2'}">
                    <input class="radio" type="radio" name="nivel" value="0"  data-group="mygroup" data-required="true"> 0
                    <input class="radio" type="radio" name="nivel" value="1"  data-group="mygroup" > 1
                    <input class="radio" type="radio" name="nivel" value="2" checked data-group="mygroup" > 2
                    <input class="radio" type="radio" name="nivel" value="3" data-group="mygroup" > 3
                    <input class="radio" type="radio" name="nivel" value="4" data-group="mygroup" > 4
                </c:when>
                <c:when test="${tipo_manutencao.getNivel() == '3'}">
                    <input class="radio" type="radio" name="nivel" value="0"  data-group="mygroup" data-required="true"> 0
                    <input class="radio" type="radio" name="nivel" value="1"  data-group="mygroup" > 1
                    <input class="radio" type="radio" name="nivel" value="2"  data-group="mygroup" > 2
                    <input class="radio" type="radio" name="nivel" value="3" checked data-group="mygroup" > 3
                    <input class="radio" type="radio" name="nivel" value="4" data-group="mygroup" > 4
                </c:when>
                <c:otherwise>
                    <input class="radio" type="radio" name="nivel" value="0"  data-group="mygroup" data-required="true"> 0
                    <input class="radio" type="radio" name="nivel" value="1"  data-group="mygroup" > 1
                    <input class="radio" type="radio" name="nivel" value="2"  data-group="mygroup" > 2
                    <input class="radio" type="radio" name="nivel" value="3"  data-group="mygroup" > 3
                    <input class="radio" type="radio" name="nivel" value="4" checked data-group="mygroup" > 4
                </c:otherwise>
            </c:choose>
        </p>
        <br>
        <p><span>Frequência:</span>
            <c:choose>
                <c:when test="${tipo_manutencao.getFrequencia() == 'diaria'}">
                    <input class="radio" type="radio" name="frequencia" checked value="diaria" data-group="mygroup2" data-required="true"> Diária
                    <input class="radio" type="radio" name="frequencia" value="semanal" data-group="mygroup2" > Semanal
                    <input class="radio" type="radio" name="frequencia" value="mensal" data-group="mygroup2" > Mensal
                    <input class="radio" type="radio" name="frequencia" value="ocasional" data-group="mygroup2" > Ocasional
                </c:when>
                <c:when test="${tipo_manutencao.getFrequencia() == 'semanal'}">
                    <input class="radio" type="radio" name="frequencia" value="diaria" data-group="mygroup2" data-required="true"> Diária
                    <input class="radio" type="radio" name="frequencia" checked value="semanal" data-group="mygroup2" > Semanal
                    <input class="radio" type="radio" name="frequencia" value="mensal" data-group="mygroup2" > Mensal
                    <input class="radio" type="radio" name="frequencia" value="ocasional" data-group="mygroup2" > Ocasional
                </c:when>
                <c:when test="${tipo_manutencao.getFrequencia() == 'mensal'}">
                    <input class="radio" type="radio" name="frequencia" value="diaria" data-group="mygroup2" data-required="true"> Diária
                    <input class="radio" type="radio" name="frequencia" value="semanal" data-group="mygroup2" > Semanal
                    <input class="radio" type="radio" name="frequencia" checked value="mensal" data-group="mygroup2" > Mensal
                    <input class="radio" type="radio" name="frequencia" value="ocasional" data-group="mygroup2" > Ocasional
                </c:when>
                <c:otherwise>
                    <input class="radio" type="radio" name="frequencia" value="diaria" data-group="mygroup2" data-required="true"> Diária
                    <input class="radio" type="radio" name="frequencia" value="semanal" data-group="mygroup2" > Semanal
                    <input class="radio" type="radio" name="frequencia" value="mensal" data-group="mygroup2" > Mensal
                    <input class="radio" type="radio" name="frequencia" checked value="ocasional" data-group="mygroup2" > Ocasional
                </c:otherwise>
            </c:choose>
        </p>
        <br>
        <p>
            <span>Descrição:</span>
            <textarea rows="5" cols="50" name="descricao" data-trigger="keyup" value="${tipo_manutencao.descricao}" data-rangelength="[0,100]" style="width:350px; max-width: 590px; height:150px; max-height: 250px"><c:out value="${tipo_manutencao.descricao}"/></textarea>
        </p>
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="editar" value="Editar" />
        </p>
    </div>
</form>