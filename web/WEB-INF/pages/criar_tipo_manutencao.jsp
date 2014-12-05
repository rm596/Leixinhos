<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/manutencao.png" alt="manutenção" /><h1 style="margin: 15px 0 0 0;">Inserir tipo de manutenção</h1>

<br> <br>



<form id="checkoutForm" action="<c:url value='criar_tipo_manutencao'/>" method="post" data-validate="parsley">
    <div class="form_settings">
        <p><span>Nome:</span><input type="text" name="nome" data-required="true" data-trigger="change" data-rangelength="[1,50]"></p>
        <br>
        <p><span>Nível:</span>
            <input class="radio" type="radio" name="nivel" value="0" data-group="mygroup" data-required="true"> 0
            <input class="radio" type="radio" name="nivel" value="1" data-group="mygroup" > 1
            <input class="radio" type="radio" name="nivel" value="2" data-group="mygroup" > 2
            <input class="radio" type="radio" name="nivel" value="3" data-group="mygroup" > 3
            <input class="radio" type="radio" name="nivel" value="4" data-group="mygroup" > 4
        </p>
        <br>
        <p><span>Frequência:</span>
            <input class="radio" type="radio" name="frequencia" value="diaria" data-group="mygroup2" data-required="true"> Diária
            <input class="radio" type="radio" name="frequencia" value="semanal" data-group="mygroup2" > Semanal
            <input class="radio" type="radio" name="frequencia" value="mensal" data-group="mygroup2" > Mensal
            <input class="radio" type="radio" name="frequencia" value="ocasional" data-group="mygroup2" > Ocasional
        </p>
        <br>
        <p>
            <span>Descrição:</span>
            <!-- <textarea rows="5" cols="50" name="descricao" data-trigger="keyup" data-rangelength="[0,100]" style="width:350px; max-width: 590px; height:150px; max-height: 250px"></textarea> -->
            <!-- 
                VE ESTE EXEMPLO 
                VO EXPLICAR PQ USO O rangelength ENTRE 20 E 100
                NAO SEI SE O CAMPO É OBRIGATORIO
                SE FOR OBRIGATORIO METES O data-rangelength="[0,100]" data-required="true"
                SE N METES O SO data-rangelength="[20,100]"
                ALGUM PROBLEMA MANDA MAIL
            -->
            <textarea rows="5" cols="50" name="descricao" data-trigger="keyup" data-rangelength="[0,100]" style="width:350px; max-width: 590px; height:150px; max-height: 250px"></textarea>
        </p>
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="criar" value="Criar" />
        </p>
    </div>
</form>

    <%
    if (request.getAttribute("TipomanutencaoINSERIDO") == "1") {
%>
<script>

    alert("Tipo de manutenção inserido com sucesso!");

</script>
<%                                }
%>
    