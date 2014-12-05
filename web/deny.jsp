<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML>
<html>

    <head>
        <title>Sistema de Gestão de Biotério - Leixinhos</title>
        <meta name="Leixinhos" content="Trabalho Pratico na cadeira de LES da Universidade Algarve" />
        <meta name="UALG leixinhos lei " content="website keywords, website keywords" />
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />

        <link rel="stylesheet" type="text/css" href="loginCSS/bootstrap-combined.min.css">
        <link rel="stylesheet" type="text/css" href="loginCSS/extra.css">

        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <!-- modernizr enables HTML5 elements and feature detects -->
        <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>

        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery-latest.js"></script>
        <script type="text/javascript" src="js/parsley-standalone.min.js"></script>
        <script type="text/javascript" src="js/messages.pt_br.js"></script>



    </head>

    <body>
        <div id="main">
            <header>
                <div id="logo">
                    <div id="logo_text">
                        <!-- class="logo_colour", allows you to change the colour of the text -->
                        <h1><a href="index">Lei<span class="logo_colour">xinhos</span></a></h1>
                        <h2>Software de Gestão de Biotério</h2>
                    </div>
                </div>
                <nav>
                    <div id="menu_container">
                        <ul class="sf-menu" id="nav">
                            <li><a href="index">Início</a></li>
                            <li><a href="">Tanque</a>
                                <ul>
                                    <li><a href="">Inserir</a>
                                        <ul>
                                            <li><a href="criar_tanque">Tanque</a></li>
                                            <li><a href="criar_tipo_tanque">Tipo de tanque</a></li>
                                            <li><a href="criar_classe_tanque">Classe de tanque</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="">Listar</a>
                                        <ul>
                                            <li><a href="consultar_tanques">Tanque</a></li>
                                            <li><a href="consultar_tipos_tanques">Tipo de tanque</a></li>
                                            <li><a href="consultar_classes_tanques">Classe de tanque</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li><a href="">Lote</a>
                                <ul>
                                    <li><a href="criar_lote">Inserir lote</a></li>
                                    <li><a href="consultar_lote">Listar lote</a></li>             
                                    <!--<li><a href="#">Dividir lote</a></li>-->
                                </ul>
                            </li>
                            <li><a href="">Manutenção</a>
                                <ul>
                                    <li><a href="#">Inserir</a>
                                        <ul>
                                            <li><a href="criar_manutencao_efectuada">Manutenção efectuada</a></li>
                                            <li><a href="criar_tipo_manutencao">Tipo de manutenção</a></li>
                                        </ul>
                                    </li>           
                                    <li><a href="#">Listar</a>
                                        <ul>
                                            <li><a href="consultar_manutencao_efectuada">Manutenção efectuada</a></li>
                                            <li><a href="consultar_tipo_manutencao">Tipo de manutenção</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li><a href="">Intervenção</a>
                                <ul>
                                    <li><a href="criar_intervencao">Inserir intervenção</a></li>
                                    <li><a href="consultar_intervencao">Listar intervenção</a></li>
                                </ul>
                            </li>
                            <li><a href="consultar_plano_alimentar">Plano Alimentar</a>
                                <ul>
                                    <li><a href="criar_plano_alimentar">Criar plano alimentar</a></li>
                                    <li><a href="consultar_plano_alimentar">Listar plano alimentar</a></li>
                                </ul>
                            </li>
                            <li><a href="">Tratamento efectuado</a>
                                <ul>
                                    <li><a href="criar_tratamento_efectuado">Inserir tratamento</a></li>
                                    <li><a href="consultar_tratamento_efectuado">Listar tratamento</a></li>
                                </ul>
                            </li>
                            <li><a href="">Dado ambiental</a>
                                <ul>
                                    <li><a href="criar_dados_ambientais">Inserir dado ambiental</a></li>
                                    <li><a href="consultar_dados_ambientais">Listar dado ambiental</a></li>
                                </ul>
                            </li>
                            <li><a href="">Utilizador</a>
                                <ul>
                                    <li><a href="myprofile">Ver Perfil</a></li>
                                    <li><a href="editmyprofile">Editar Perfil</a></li>
                                    <li><a href="all_users">Consultar utilizadores</a></li>
                                    <li><a href="logout">Logout</a></li>
                                </ul>
                            </li>
                            <li><a href="help">Ajuda</a>
                            </li>

                        </ul>
                    </div>
                </nav>
            </header>
            <div id="site_content">
                <div class="content">

                    <img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 90px; height: 90px;" src="images/deny.png" alt="falha" /><h1 style="margin: 15px 0 0 0;">Erro!</h1>

                    <br> <br>

                    Ocorreu uma falha no sistema. Esta poderá ter ocorrido por erro do sistema ou por estar a tentar aceder a uma área à qual não tem permissões de acesso.
                    Tente novamente, se a falha voltar a ocorrer contacte o administrador do sistema.
                    <form action="#" method="post">
                        <div class="form_settings">
                            <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="button" name="name" value="Retroceder" onClick="history.go(-1);return true;"/></p>
                        </div>
                    </form>
                </div>
                <p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p>
            </div>
            <div id="scroll">
                <a title="Voltar ao topo" class="top" href="#"><img src="images/top.png" alt="topo" /></a>
            </div>
            <footer>
                <br>
                <p><a href="http://www.ualg.pt" target="_blank">Universidade do Algarve</a> | Laborat&oacuterio de Engenharia de Software | 2012/2013</p>
            </footer>
        </div>
        <!-- javascript at the bottom for fast page loading -->
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery.easing-sooper.js"></script>
        <script type="text/javascript" src="js/jquery.sooperfish.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('ul.sf-menu').sooperfish();
                $('.top').click(function() {$('html, body').animate({scrollTop:0}, 'fast'); return false;});
            });
        </script>
    </body>
</html>