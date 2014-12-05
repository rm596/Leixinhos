<%@page import="entity.TipoUtilizador"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/utilizador.png" alt="utilizador" /><h1 style="margin: 15px 0 0 0;">O meu perfil</h1>

<br> <br>

<!--<h2>Meu Perfil:</h2>-->
<div class="form_settings">
<p><span class="format">Numero Utilizador:</span> <c:out value="${user.id}"/></p>
<p><span class="format">Nome:</span> <c:out value="${user.nome}"/></p>
<p><span class="format">Tipo Utilizador:</span> <c:out value="${userType.nome}"/></p>
<p><span class="format">Email:</span> <c:out value="${user.email}"/></p>
<p><span class="format">Morada:</span> <c:out value="${user.morada}"/></p>
<p><span class="format">Telemovel:</span> <c:out value="${user.telemovel}"/></p>
<p><span class="format">Username:</span> <c:out value="${user.username}"/></p>
<p><span class="format">Grupo:</span> <c:out value="${user.grupoPro}"/></p>
<p><span class="format">Data Inicio:</span> <c:out value="${user.dataInicio}"/></p>
<p><span class="format">Data Fim:</span> <c:out value="${user.dataFim}"/></p>
</div>
