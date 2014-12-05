<div id="sidebar_container" style="margin-left: 30px">
    <img class="paperclip" src="images/paperclip.png" alt="paperclip" />
    <div class="sidebar">
        <h3>Utilizador</h3>
        <ul>
            <h4 style="color: #009FBC; padding: 0 0 5px 0; font: normal 120% arial;">Bem-vindo(a), ${userNAME}</h4>
            <a href="logout">Logout</a>
        </ul>
    </div>

    <c:choose>
        <c:when test="${tipoUSER == 1 && size!=0}">
        <img class="paperclip" src="images/paperclip.png" alt="paperclip" />
        <div class="sidebar">
            <h3>�ltimas not�cias:</h3>
            <h4 style="color: #009FBC; padding: 0 0 5px 0; font: normal 120% arial;">Utilizadores por validar:</h4>
            <c:forEach var="pointer" items="${adminTasks}">
                <p> <c:out value="${pointer.nome}"/> </p>
            </c:forEach>
            <p><a href="all_users">Listar Utilizadores</a></p>
            <h5>
                <script type="text/javascript">
                    var currentTime = new Date()
                    var month = currentTime.getMonth() + 1;
                    var day = currentTime.getDate();
                    var year = currentTime.getFullYear();
                    document.write(day + "/" + month + "/" + year)
                </script>
            </h5>
        </div>
        </c:when>
        <c:when test="${tipoUSER == 1 && size==0}">
        <img class="paperclip" src="images/paperclip.png" alt="paperclip" />
        <div class="sidebar">
            <h3>Utilizadores por aprovar:</h3>
            <h4 style="color: #009FBC; padding: 0 0 5px 0; font: normal 120% arial;">Sem Utilizadores por validar</h4>
            <h5>
                <script type="text/javascript">
                    var currentTime = new Date()
                    var month = currentTime.getMonth() + 1;
                    var day = currentTime.getDate();
                    var year = currentTime.getFullYear();
                    document.write(day + "/" + month + "/" + year)
                </script>
            </h5>
        </div>
        </c:when>
        <c:otherwise>
            ;
        </c:otherwise>
    </c:choose>
</div>



<h1 style="margin: 15px 0 0 0;">&nbsp;Bem-vindo ao Leixinhos</h1>
<img style="float: left; vertical-align: middle; margin: 0 10px 0 20px; height: 170px;" src="images/ramalhete.png" alt="ramalhete" />
<p><br></p><br><p><br></p><br><br><br>
<p>O Leixinhos � um software de gest�o de biot�rio criado por estudantes universit�rios com o intuito de facilitar a gest�o do <a href="http://www.ualg.pt/home/pt/content/ramalhete">Centro do Ramalhete</a>.</p>
<p>O Centro do Ramalhete � uma infraestrutura da Universidade do Algarve gerida pelo Centro de Ci�ncias do Mar do Algarve (CCMAR) desde  1994. Esta esta��o mar�tima, bastante vers�til, possui tanques e aqu�rios para a manuten��o de organismos vivos, desde baterias de pequenos tanques at� grandes mesocosmos ao ar livre. Acolhe maioritariamente projetos de investiga��o relacionados com organismos marinhos da sua �rea geogr�fica.</p>
