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
            <h3>Últimas notícias:</h3>
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
<p>O Leixinhos é um software de gestão de biotério criado por estudantes universitários com o intuito de facilitar a gestão do <a href="http://www.ualg.pt/home/pt/content/ramalhete">Centro do Ramalhete</a>.</p>
<p>O Centro do Ramalhete é uma infraestrutura da Universidade do Algarve gerida pelo Centro de Ciências do Mar do Algarve (CCMAR) desde  1994. Esta estação marítima, bastante versátil, possui tanques e aquários para a manutenção de organismos vivos, desde baterias de pequenos tanques até grandes mesocosmos ao ar livre. Acolhe maioritariamente projetos de investigação relacionados com organismos marinhos da sua área geográfica.</p>
