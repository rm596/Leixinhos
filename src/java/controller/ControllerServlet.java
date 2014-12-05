package controller;

import entity.ClasseTanque;
import entity.DadosAmbientais;
import entity.Intervencao;
import entity.Lote;
import entity.ManutencaoEfectuada;
import entity.PlanoAlimentar;
import entity.Tanque;
import entity.TipoManutencao;
import entity.TipoTanque;
import entity.TipoUtilizador;
import entity.Tratamento;
import entity.Utilizador;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.ClasseTanqueFacade;
import session.DadosAmbientaisFacade;
import session.Email;
import session.IntervencaoFacade;
import session.LoteFacade;
import session.ManutencaoEfectuadaFacade;
import session.Permissions;
import session.PlanoAlimentarFacade;
import session.TanqueFacade;
import session.TipoManutencaoFacade;
import session.TipoTanqueFacade;
import session.TipoUtilizadorFacade;
import session.TratamentoFacade;
import session.UtilizadorFacade;

/**
 *
 * @author Frederico
 */
@WebServlet(name = "ControllerServlet",
loadOnStartup = 1,
urlPatterns = {
    "",//NAO TIRAR SFF
    "/index",
    "/login",
    "/consultar_tanques",
    "/consultar_tipos_tanques",
    "/consultar_classes_tanques",
    "/regist",
    "/tanques",
    "/utilizadores",
    "/consultar_plano_alimentar",
    "/criar_plano_alimentar",
    "/consultar_lote",
    "/criar_tipo_manutencao",
    "/criar_manutencao_efectuada",
    "/consultar_manutencao_efectuada",
    "/consultar_dados_ambientais",
    "/criar_dados_ambientais",
    "/consultar_tipo_manutencao",
    "/consultar_intervencao",
    "/consultar_tratamento_efectuado",
    "/criar_tipo_tanque",
    "/criar_classe_tanque",
    "/mail",
    "/logout",
    "/check",
    "/recover",
    "/myprofile",
    "/editmyprofile",
    "/criar_tanque",
    "/criar_intervencao",
    "/eliminar_man_efect",
    "/edit_man_efect",
    "/eliminar_dados_ambientais",
    "/eliminar_tratamento",
    "/deny",
    "/all_users",
    "/admin_edit_users",
    "/delete_user",
    "/editar_dados_ambientais",
    "/criar_tratamento_efectuado",
    "/editar_tratamento_efectuado",
    "/eliminar_plano_alimentar",
    "/searchUsers",
    "/searchTanques",
    "/eliminar_intervencao",
    "/searchLote",
    "/editar_plano_alimentar",
    "/searchTratamentoEfectuado",
    "/editar_classe_tanque",
    "/editar_tipo_tanques",
    "/editar_tanque",
    "/editar_intervencao",
    "/editar_tipo_man",
    "/criar_lote",
    "/editar_lote",
    "/help",
    "/searchIntervencao",})
public class ControllerServlet extends HttpServlet {

    boolean login = false;
    int count = 0;
    int idUSER, tipoUSER;
    String userNAME;
    @EJB
    private UtilizadorFacade utilizadorfacade;
    @EJB
    private TanqueFacade tanquefacade;
    @EJB
    private ClasseTanqueFacade classetanquefacade;
    @EJB
    private TipoTanqueFacade tipotanquefacade;
    @EJB
    private TipoUtilizadorFacade tipoutilizadorfacade;
    @EJB
    private PlanoAlimentarFacade planoalimentarfacade;
    @EJB
    private TipoManutencaoFacade tipomanutencaofacade;
    @EJB
    private LoteFacade lotefacade;
    @EJB
    private ManutencaoEfectuadaFacade manutencaoefectuadafacade;
    private Date dataInicio;
    @EJB
    private Email emailfacade;
    @EJB
    private IntervencaoFacade intervencaofacade;
    @EJB
    private DadosAmbientaisFacade dadosambientaisfacade;
    @EJB
    private TratamentoFacade tratamentofacade;
    @EJB
    private Permissions permissionsFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("GET");
        String url = "";
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        System.out.println("-----> " + userPath);

        //NAO MEXER TIVE 1 DIA NISTO SFF
        if (userPath.equals("/login") && login == true) {
            userPath = "index";
            request.setAttribute("idUSER", idUSER);
            request.setAttribute("tipoUSER", tipoUSER);
            request.setAttribute("userNAME", userNAME);
            request.setAttribute("adminTasks", tipoutilizadorfacade.geTypeById(5));
            request.setAttribute("size", tipoutilizadorfacade.geTypeById(5).size());
        } else if (userPath.equals("") && login == false) {
            userPath = "login";
        } else if (userPath.equals("") && login == true) {
            userPath = "index";
            request.setAttribute("idUSER", idUSER);
            request.setAttribute("tipoUSER", tipoUSER);
            request.setAttribute("userNAME", userNAME);
            request.setAttribute("adminTasks", tipoutilizadorfacade.geTypeById(5));
            request.setAttribute("size", tipoutilizadorfacade.geTypeById(5).size());
        } else if (userPath.equals("/index") && login == true) {
            userPath = "index";
            request.setAttribute("idUSER", idUSER);
            request.setAttribute("tipoUSER", tipoUSER);
            request.setAttribute("userNAME", userNAME);
            request.setAttribute("adminTasks", tipoutilizadorfacade.geTypeById(5));
            request.setAttribute("size", tipoutilizadorfacade.geTypeById(5).size());
        } else if (userPath.equals("/index") && login == false) {
            userPath = "login";
        } //CUMPRIMENTOS MESSI
        else if (userPath.equals("/regist") && login == false) {
            userPath = "regist";
        } else if (userPath.equals("/logout")) {
            session.invalidate();
            login = false;
            count = 0;
            userPath = "login";
        } else if (userPath.equals("/consultar_tanques") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/consultar_tanques")) {
                url += "/WEB-INF/pages";
                userPath = "/consultar_tanques";
                request.setAttribute("tanques", tanquefacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/consultar_tanques") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/consultar_tipos_tanques") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/consultar_tipos_tanques")) {
                url += "/WEB-INF/pages";
                userPath = "/consultar_tipos_tanques";
                request.setAttribute("tipos_tanques", tipotanquefacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/consultar_tipos_tanques") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/consultar_classes_tanques") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/consultar_classes_tanques")) {
                url += "/WEB-INF/pages";
                userPath = "/consultar_classes_tanques";
                request.setAttribute("classes_tanques", classetanquefacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/consultar_classes_tanques") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/consultar_dados_ambientais") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/consultar_dados_ambientais")) {
                url += "/WEB-INF/pages";
                userPath = "/consultar_dados_ambientais";
                request.setAttribute("dados_ambientais", dadosambientaisfacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/consultar_classes_tanques") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/consultar_tratamento_efectuado") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/consultar_tratamento_efectuado")) {
                url += "/WEB-INF/pages";
                userPath = "/consultar_tratamento_efectuado";
                request.setAttribute("tratamento", tratamentofacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/consultar_tratamento_efectuado") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/utilizadores") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/utilizadores")) {
                url += "/WEB-INF/pages";
                userPath = "/utilizadores";
                request.setAttribute("tipo_utilizador", tipoutilizadorfacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/utilizadores") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/criar_tipo_manutencao") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/criar_tipo_manutencao")) {
                url += "/WEB-INF/pages";
                userPath = "/criar_tipo_manutencao";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/criar_tipo_manutencao") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/criar_dados_ambientais") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/criar_dados_ambientais")) {
                url += "/WEB-INF/pages";
                userPath = "/criar_dados_ambientais";
                request.setAttribute("tanque", tanquefacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/criar_dados_ambientais") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/criar_tanque") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/criar_tanque")) {
                url += "/WEB-INF/pages";
                userPath = "/criar_tanque";
                request.setAttribute("tipo_tanque", tipotanquefacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/criar_tanque") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/criar_manutencao_efectuada") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/criar_manutencao_efectuada")) {
                url += "/WEB-INF/pages";
                userPath = "/criar_manutencao_efectuada";
                request.setAttribute("tipo_manutencao", tipomanutencaofacade.findAll());
                request.setAttribute("tanque", tanquefacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/criar_manutencao_efectuada") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/criar_plano_alimentar") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/criar_plano_alimentar")) {
                url += "/WEB-INF/pages";
                userPath = "/criar_plano_alimentar";
                request.setAttribute("tanque", tanquefacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/criar_plano_alimentar") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/criar_lote") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/criar_lote")) {
                url += "/WEB-INF/pages";
                userPath = "/criar_lote";
                request.setAttribute("tanque", tanquefacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/criar_lote") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/criar_classe_tanque") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/criar_classe_tanque")) {
                url += "/WEB-INF/pages";
                userPath = "/criar_classe_tanque";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/criar_classe_tanque") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/criar_tipo_tanque") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/criar_tipo_tanque")) {
                url += "/WEB-INF/pages";
                userPath = "/criar_tipo_tanque";
                request.setAttribute("classe_tanque", classetanquefacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/criar_tipo_tanque") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/criar_intervencao") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/criar_intervencao")) {
                url += "/WEB-INF/pages";
                userPath = "/criar_intervencao";
                request.setAttribute("lote", lotefacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/criar_intervencao") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/consultar_plano_alimentar") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/consultar_plano_alimentar")) {
                url += "/WEB-INF/pages";
                userPath = "/consultar_plano_alimentar";
                request.setAttribute("cons_plano_ali", planoalimentarfacade.consultarTodosPlanos());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/consultar_plano_alimentar") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/consultar_lote") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/consultar_lote")) {
                url += "/WEB-INF/pages";
                userPath = "/consultar_lote";
                List<Lote> findAll = lotefacade.findAll();
                request.setAttribute("cons_lote", findAll);
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/consultar_lote") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/consultar_manutencao_efectuada") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/consultar_manutencao_efectuada")) {
                List<ManutencaoEfectuada> findAll = manutencaoefectuadafacade.findAll();
                request.setAttribute("cons_man_efectuada", findAll);
                url += "/WEB-INF/pages";
                userPath = "/consultar_manutencao_efectuada";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/consultar_manutencao_efectuada") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/consultar_tipo_manutencao") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/consultar_tipo_manutencao")) {
                request.setAttribute("cons_tipo_manutencao", tipomanutencaofacade.findAll());
                url += "/WEB-INF/pages";
                userPath = "/consultar_tipo_manutencao";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/consultar_tipo_manutencao") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/consultar_intervencao") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/consultar_intervencao")) {
                url += "/WEB-INF/pages";
                userPath = "/consultar_intervencao";
                request.setAttribute("cons_intervencao", intervencaofacade.findAll());
            } else {
                userPath = "/deny";
            }

        } else if (userPath.equals("/consultar_intervencao") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/recover") && login == false) {
            userPath = "/recover";
        } else if (userPath.equals("/recover") && login == true) {
            userPath = "/index";
        } else if (userPath.equals("/myprofile") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/myprofile") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/myprofile")) {
                System.out.println("idUSER " + idUSER);
                Utilizador user = utilizadorfacade.getUserById(idUSER);
                TipoUtilizador userType = user.getTipoUtilizador();
                request.setAttribute("user", user);
                request.setAttribute("userType", userType);
                url += "/WEB-INF/pages";
                userPath = "/myprofile";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/editmyprofile") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/editmyprofile") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/myprofile")) {
                Utilizador user = utilizadorfacade.getUserById(idUSER);
                request.setAttribute("user", user);
                url += "/WEB-INF/pages";
                userPath = "/editmyprofile";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/eliminar_man_efect") && login == true) { // ELIMINAR MANUTENCAO EFECTUADA
            if (permissionsFacade.checkPermissions(tipoUSER, "/eliminar_man_efect")) {
                System.out.println("AQUIIIIIIIIIIII NO REMOVER MAN EFECT!!!");
                ManutencaoEfectuada man = manutencaoefectuadafacade.find(Integer.parseInt(request.getQueryString()));
                System.out.println("FIND DEU BEM!!!");
                manutencaoefectuadafacade.remove(man);
                System.out.println("REMOVE DEU BEM!!");
                List<ManutencaoEfectuada> findAll = manutencaoefectuadafacade.findAll();
                request.setAttribute("cons_man_efectuada", findAll);
                url += "/WEB-INF/pages";
                userPath = "/consultar_manutencao_efectuada";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/eliminar_intervencao") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/eliminar_intervencao") && login == true) { // ELIMINAR INTERVENCAO
            if (permissionsFacade.checkPermissions(tipoUSER, "/eliminar_intervencao")) {
                System.out.println("AQUIIIIIIIIIIII NO REMOVER INTERVENCAO!!!");
                Intervencao interv = intervencaofacade.find(Integer.parseInt(request.getQueryString()));
                System.out.println("FIND DEU BEM!!!");

                // Agora fazer o update no Lote
                Lote lote_get = lotefacade.getLoteById(interv.getIdLote().getId());
                int quantidade_update_lote = lote_get.getNExemplares();
                if (interv.getTipo().equals("Remocao")) {
                    quantidade_update_lote = quantidade_update_lote + interv.getQuantidade();
                    lote_get.setNExemplares(quantidade_update_lote);
                    lotefacade.edit(lote_get);
                } else {
                    quantidade_update_lote = quantidade_update_lote - interv.getQuantidade();
                    lote_get.setNExemplares(quantidade_update_lote);
                    lotefacade.edit(lote_get);
                }

                intervencaofacade.remove(interv);
                System.out.println("REMOVE DEU BEM!!");
                url += "/WEB-INF/pages";
                userPath = "/consultar_intervencao";
                request.setAttribute("cons_intervencao", intervencaofacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/eliminar_intervencao") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/eliminar_dados_ambientais") && login == true) { // ELIMINAR DADOS AMBIENTAIS
            if (permissionsFacade.checkPermissions(tipoUSER, "/eliminar_man_efect")) {
                System.out.println("AQUIIIIIIIIIIII NO REMOVER DADOS AMBIENTAIS!!!");
                DadosAmbientais dados = dadosambientaisfacade.find(Integer.parseInt(request.getQueryString()));
                System.out.println("FIND DEU BEM!!!");
                dadosambientaisfacade.remove(dados);
                System.out.println("REMOVE DEU BEM!!");
                request.setAttribute("dados_ambientais", dadosambientaisfacade.findAll());
                url += "/WEB-INF/pages";
                userPath = "/consultar_dados_ambientais";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/eliminar_plano_alimentar") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/eliminar_plano_alimentar") && login == true) { // ELIMINAR DADOS AMBIENTAIS
            if (permissionsFacade.checkPermissions(tipoUSER, "/eliminar_plano_alimentar")) {
                System.out.println("AQUIIIIIIIIIIII NO REMOVER PLANO ALIMENTAR!!!");
                PlanoAlimentar plan = planoalimentarfacade.find(Integer.parseInt(request.getQueryString()));
                System.out.println("FIND DEU BEM!!!");
                planoalimentarfacade.remove(plan);
                System.out.println("REMOVE DEU BEM!!");
                url += "/WEB-INF/pages";
                userPath = "/consultar_plano_alimentar";
                request.setAttribute("cons_plano_ali", planoalimentarfacade.consultarTodosPlanos());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/eliminar_dados_ambientais") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/criar_tratamento_efectuado") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/criar_tratamento_efectuado")) {
                url += "/WEB-INF/pages";
                userPath = "/criar_tratamento_efectuado";
                request.setAttribute("tanque", tanquefacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/criar_tratamento_efectuado") && login == false) {
            userPath = "/login";
            url += userPath + ".jsp";
        } else if (userPath.equals("/eliminar_tratamento") && login == true) { // ELIMINAR TRATAMENTO
            if (permissionsFacade.checkPermissions(tipoUSER, "/eliminar_tratamento")) {
                System.out.println("AQUIIIIIIIIIIII NO REMOVER TRATAMENTO!!!");
                Tratamento trat = tratamentofacade.find(Integer.parseInt(request.getQueryString()));
                System.out.println("FIND DEU BEM!!!");
                tratamentofacade.remove(trat);
                System.out.println("REMOVE DEU BEM!!");
                request.setAttribute("tratamento", tratamentofacade.findAll());
                url += "/WEB-INF/pages";
                userPath = "/consultar_tratamento_efectuado";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/eliminar_tratamento") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/edit_man_efect") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/edit_man_efect")) {
                ManutencaoEfectuada man = manutencaoefectuadafacade.getManEfectById(Integer.parseInt(request.getQueryString()));
                request.setAttribute("man_efec", man);
                request.setAttribute("tipo_manutencao", tipomanutencaofacade.findAll());
                request.setAttribute("tanque", tanquefacade.findAll());
                int idManEfec = man.getId();
                request.setAttribute("idManEfec", idManEfec);
                url += "/WEB-INF/pages";
                userPath = "/edit_man_efect";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/edit_man_efect") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/editar_dados_ambientais") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/edit_man_efect")) {
                DadosAmbientais dados = dadosambientaisfacade.getDadosAmbientaisById(Integer.parseInt(request.getQueryString()));
                request.setAttribute("dados", dados);
                request.setAttribute("tanque", tanquefacade.findAll());
                int idDados = dados.getId();
                request.setAttribute("idDados", idDados);
                url += "/WEB-INF/pages";
                userPath = "/editar_dados_ambientais";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/editar_dados_ambientais") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/editar_lote") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/editar_lote")) {
                Lote lote = lotefacade.getLoteById(Integer.parseInt(request.getQueryString()));
                request.setAttribute("lote", lote);
                request.setAttribute("tanque", tanquefacade.findAll());
                int idLote = lote.getId();
                request.setAttribute("idLote", idLote);
                url += "/WEB-INF/pages";
                userPath = "/editar_lote";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/editar_dados_ambientais") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/editar_intervencao") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/editar_intervencao")) {
                Intervencao interv = intervencaofacade.getIntervencaoById(Integer.parseInt(request.getQueryString()));
                request.setAttribute("intervencao", interv);
                request.setAttribute("lote", lotefacade.findAll());
                int idIntervencao = interv.getId();
                request.setAttribute("idIntervencao", idIntervencao);
                url += "/WEB-INF/pages";
                userPath = "/editar_intervencao";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/editar_intervencao") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/editar_tipo_man") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/editar_tipo_man")) {
                TipoManutencao tipo_man = tipomanutencaofacade.getTipoManutencaoById(Integer.parseInt(request.getQueryString()));
                request.setAttribute("tipo_manutencao", tipo_man);
                int idTipoManutencao = tipo_man.getId();
                request.setAttribute("idTipoManutencao", idTipoManutencao);
                url += "/WEB-INF/pages";
                userPath = "/editar_tipo_man";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/editar_tipo_man") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/editar_classe_tanque") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/editar_classe_tanque")) {
                ClasseTanque classe = classetanquefacade.getClasseTanqueById(Integer.parseInt(request.getQueryString()));
                request.setAttribute("classe_tanque", classe);

                int idClasse = classe.getId();
                request.setAttribute("idClasse", idClasse);
                url += "/WEB-INF/pages";
                userPath = "/editar_classe_tanque";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/editar_classe_tanque") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/editar_tipo_tanques") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/editar_tipo_tanques")) {
                TipoTanque tipo = tipotanquefacade.gettipoTanqueById(Integer.parseInt(request.getQueryString()));
                request.setAttribute("tipo_tanques", tipo);
                request.setAttribute("classe_tanque", classetanquefacade.findAll());
                int idTanque = tipo.getId();
                request.setAttribute("idTanque", idTanque);
                url += "/WEB-INF/pages";
                userPath = "/editar_tipo_tanques";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/editar_tipo_tanques") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/editar_tanque") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/editar_tanque")) {
                Tanque tanq = tanquefacade.getTanqueById(Integer.parseInt(request.getQueryString()));
                request.setAttribute("tanque", tanq);
                request.setAttribute("tipo_tanque", tipotanquefacade.findAll());
                int idTanque = tanq.getId();
                request.setAttribute("idTanque", idTanque);
                url += "/WEB-INF/pages";
                userPath = "/editar_tanque";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/editar_tanque") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/editar_plano_alimentar") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/editar_plano_alimentar")) {
                PlanoAlimentar plan = planoalimentarfacade.getPlanById(Integer.parseInt(request.getQueryString()));
                request.setAttribute("plano", plan);
                request.setAttribute("tanque", tanquefacade.findAll());
                int id = plan.getId();
                request.setAttribute("id", id);
                url += "/WEB-INF/pages";
                userPath = "/editar_plano_alimentar";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/editar_plano_alimentar") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/editar_tratamento_efectuado") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/editar_tratamento_efectuado")) {
                Tratamento trat = tratamentofacade.getTratamentoByReferencia(Integer.parseInt(request.getQueryString()));
                request.setAttribute("tratamento", trat);
                request.setAttribute("tanque", tanquefacade.findAll());
                int referencia = trat.getReferencia();
                request.setAttribute("idDados", referencia);
                url += "/WEB-INF/pages";
                userPath = "/editar_tratamento_efectuado";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/editar_tratamento_efectuado") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/all_users") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/all_users")) {
                url += "/WEB-INF/pages";
                userPath = "/all_users";
                request.setAttribute("users", utilizadorfacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/all_users") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/admin_edit_users") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/admin_edit_users")) {
                Utilizador user = utilizadorfacade.getUserById(Integer.parseInt(request.getQueryString()));
                request.setAttribute("userType", tipoutilizadorfacade.findAll());
                request.setAttribute("user", user);
                url += "/WEB-INF/pages";
                userPath = "/admin_edit_users";
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/admin_edit_users") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/delete_user") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/delete_user")) {
                int id = Integer.parseInt(request.getQueryString());
                System.out.println(id);
                //apagar intervenção?
                utilizadorfacade.deleteById(id);
                url += "/WEB-INF/pages";
                userPath = "/all_users";
                request.setAttribute("users", utilizadorfacade.findAll());
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/delete_user") && login == false) {
            userPath = "/login";
        } else if(userPath.equals("/help") && login == true){
            if (permissionsFacade.checkPermissions(tipoUSER, "/help")) {
                url += "/WEB-INF/pages";
                userPath = "/help";
            } else {
                userPath = "/deny";
            }
            
        }
        url += userPath + ".jsp";
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        System.out.println("POST");
        request.setCharacterEncoding("UTF-8");
        String userPath = request.getServletPath();
        String url = "";

        System.out.println("-----------> " + userPath);

        if (userPath.equals("/index") && login == false) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            boolean registed = false;
            try {
                registed = utilizadorfacade.isRegisted(username, password);
            } catch (Exception e) {
                registed = false;
            }
            if (registed) {
                Utilizador logado = (Utilizador) utilizadorfacade.afterlogin(username);
                TipoUtilizador tipoUser = logado.getTipoUtilizador();

                idUSER = logado.getId();
                tipoUSER = tipoUser.getId();
                userNAME = username;
                login = true;

                //session.setAttribute("idUSER", idUSER);
                //session.setAttribute("tipoUSER", tipoUSER);
                //session.setAttribute("userNAME", userNAME);

                request.setAttribute("idUSER", idUSER);
                request.setAttribute("tipoUSER", tipoUSER);
                request.setAttribute("userNAME", userNAME);
                request.setAttribute("adminTasks", tipoutilizadorfacade.geTypeById(5));
                request.setAttribute("size", tipoutilizadorfacade.geTypeById(5).size());

                userPath = "/index";
            } else if (!registed) {//erros 
                request.setAttribute("error", "1");
                userPath = "/login";
            }
        } else if (userPath.equals("/regist")) {

            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String morada = request.getParameter("morada");
            if (morada.equals("")) {
                morada = "morada nao registada";
            }
            String tele = request.getParameter("phone");
            int telemove;
            if (tele.equals("")) {
                telemove = -1;
            } else {
                telemove = Integer.parseInt(tele);
            }
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String Grupo = request.getParameter("grupoPRO");
            String dataFIM = request.getParameter("dataFIM");

            boolean isUsernameRegisted = utilizadorfacade.isUsernameRegisted(username);
            boolean isEmailRegisted = utilizadorfacade.isEmailRegisted(email);

            if (isUsernameRegisted == true && isEmailRegisted == false) {
                request.setAttribute("usernameREGISTADO", "1");
                request.setAttribute("emailREGISTADO", "0");
            } else if (isUsernameRegisted == false && isEmailRegisted == true) {
                request.setAttribute("emailREGISTADO", "1");
                request.setAttribute("usernameREGISTADO", "0");
            } else if (isUsernameRegisted == true && isEmailRegisted == true) {
                request.setAttribute("emailREGISTADO", "1");
                request.setAttribute("usernameREGISTADO", "1");
            } else if (isUsernameRegisted == false && isEmailRegisted == false) {
                List<TipoUtilizador> findAll = tipoutilizadorfacade.findAll();
                int idRegisted = 0;
                try {
                    utilizadorfacade.registerFirstTime(nome, email, morada, telemove, username, password, Grupo, dataFIM, findAll);
                    idRegisted = utilizadorfacade.getIdUser(username);
                    //session.setAttribute("idUSER", idRegisted);
                    //session.setAttribute("tipoUSER", 5);
                    //session.setAttribute("userNAME", username);
                    login = true;

                    idUSER = idRegisted;
                    tipoUSER = 5;
                    userNAME = username;

                    request.setAttribute("idUSER", idRegisted);
                    request.setAttribute("tipoUSER", 5);
                    request.setAttribute("userNAME", username);

                    userPath = "/index";
                    emailfacade.sendEmail(email, "Bem vindo ao Software de gestão de Biotérios, Leixinhos.\n\nA sua conta terá de ser aprovada pelos Administradores do sistema.\n\nOs seus dados acesso a esta plataforma são:\n\nUsername: " + username + "\n\nPassword: " + password + "\n\nCom os melhores cumprimentos, o Administrador", "Registo Plataforma Leixinhos");
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(ControllerServlet.class
                            .getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(ControllerServlet.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (userPath.equals("/criar_tipo_manutencao")) {
            System.out.println("entrei no if");

            String nome = request.getParameter("nome");
            String nivel = request.getParameter("nivel");
            //int nivel = Integer.parseInt(nivel_string);
            String frequencia = request.getParameter("frequencia");
            String descricao = request.getParameter("descricao");

            TipoManutencao tipoMan = new TipoManutencao();
            tipoMan.setId(Integer.SIZE);
            tipoMan.setNome(nome);
            tipoMan.setNivel(nivel);
            tipoMan.setFrequencia(frequencia);
            tipoMan.setDescricao(descricao);
            System.out.println("teste");
            tipomanutencaofacade.create(tipoMan);
            //System.out.println("id: " + tipoMan.getId());
            request.setAttribute("TipomanutencaoINSERIDO", "1");

            url += "/WEB-INF/pages";

        } else if (userPath.equals("/criar_manutencao_efectuada")) {
            try {
                System.out.println("entrei no if");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date1 = new Date();
                String dataIns = dateFormat.format(date1);
                Date data = dateFormat.parse(dataIns);


                String tanque_string = request.getParameter("idtanque");
                int idTanque = Integer.parseInt(tanque_string);

                String tipo_manutencao_string = request.getParameter("tipo_manutencao");
                int nivel = Integer.parseInt(tipo_manutencao_string);
                String observacoes = request.getParameter("observacoes");

                ManutencaoEfectuada ManEfect = new ManutencaoEfectuada();
                ManEfect.setId(Integer.SIZE);
                ManEfect.setData(data);
                TipoManutencao tipo = new TipoManutencao();
                tipo.setId(nivel);

                Tanque tanq = new Tanque();
                tanq.setId(idTanque);

                System.out.println("teste antes do ultimo set");
                ManEfect.setIdTanque(tanq);
                ManEfect.setTipoManutencao(tipo);
                ManEfect.setObservacoes(observacoes);
                System.out.println("teste depois do set, antes do create");
                manutencaoefectuadafacade.create(ManEfect);

                request.setAttribute("ManutencaoEfectuadaINSERIDO", "1");

                url += "/WEB-INF/pages";
                userPath = "/criar_manutencao_efectuada";
                request.setAttribute("tipo_manutencao", tipomanutencaofacade.findAll());
                request.setAttribute("tanque", tanquefacade.findAll());
            } catch (ParseException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/criar_dados_ambientais")) {
            try {
                System.out.println("ENTREI NO IF DE CRIAR DADOS AMBIENTAIS");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date1 = new Date();
                String dataIns = dateFormat.format(date1);
                Date data = dateFormat.parse(dataIns);


                String tanque_string = request.getParameter("idtanque");
                int idTanque = Integer.parseInt(tanque_string);

                String read = request.getParameter("temperatura");
                double temperatura = Double.parseDouble(read);

                read = request.getParameter("salinidadeAgua");
                double salinidadeAgua = Double.parseDouble(read);

                read = request.getParameter("oxigenio");
                double oxigenio = Double.parseDouble(read);

                DadosAmbientais dados = new DadosAmbientais();
                dados.setId(Integer.SIZE);
                dados.setData(data);
                Tanque tanq = new Tanque();
                tanq.setId(idTanque);


                System.out.println("TESTE ANTES DOS ULTIMOS SETS");
                dados.setIdTanque(tanq);
                dados.setOxigenio(oxigenio);
                dados.setSalinidadeAgua(salinidadeAgua);
                dados.setTemperatura(temperatura);
                System.out.println("teste depois do set, antes do create");
                dadosambientaisfacade.create(dados);

                request.setAttribute("DadosAmbientaisINSERIDO", "1");

                request.setAttribute("tanque", tanquefacade.findAll());
                url += "/WEB-INF/pages";
            } catch (ParseException ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/criar_tanque")) {
            try {
                System.out.println("ENTREI NO IF DE CRIAR TANQUE");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date1 = new Date();
                String dataIns = dateFormat.format(date1);
                Date data = dateFormat.parse(dataIns);


                String tipo_tanque_string = request.getParameter("tipo_tanque");
                int idTipoTanque = Integer.parseInt(tipo_tanque_string);

                String read = request.getParameter("volumeusado");
                double volumeusado = Double.parseDouble(read);

                String localizacao = request.getParameter("localizacao");

                String estado = request.getParameter("estado");

                String caracterizacao = request.getParameter("caracterizacao");

                Tanque tanq = new Tanque();
                tanq.setId(Integer.SIZE);
                tanq.setDataAquisicao(data);
                TipoTanque tipo_tanq = new TipoTanque();
                tipo_tanq.setId(idTipoTanque);


                System.out.println("TESTE ANTES DOS ULTIMOS SETS");
                tanq.setCaracterizacao(caracterizacao);
                tanq.setEstadoTanque(estado);
                tanq.setIdTipo(tipo_tanq);
                tanq.setLocalizacaoFisica(localizacao);
                tanq.setVolumeUsado(volumeusado);
                System.out.println("teste depois do set, antes do create");
                tanquefacade.create(tanq);

                request.setAttribute("TanqueINSERIDO", "1");

                request.setAttribute("tanque", tanquefacade.findAll());
                url += "/WEB-INF/pages";
            } catch (ParseException ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/criar_intervencao")) {
            try {
                System.out.println("entrei no if");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date1 = new Date();
                String dataIns = dateFormat.format(date1);
                Date data = dateFormat.parse(dataIns);


                String nome = request.getParameter("nome");
                String descricao = request.getParameter("descricao");
                String tipo = request.getParameter("tipo");
                String id_lote_string = request.getParameter("id_lote");
                int id_lote = Integer.parseInt(id_lote_string);

                String especie = request.getParameter("especie");
                String quantidade_string = request.getParameter("quantidade");
                int quantidade = Integer.parseInt(quantidade_string);

                System.out.println("TESTE DO UTILZIADOR DO FACADE");
                Utilizador user = utilizadorfacade.getUserById(idUSER);

                // Agora fazer o update no Lote
                Lote lote_get = lotefacade.getLoteById(id_lote);
                int quantidade_update_lote = lote_get.getNExemplares();
                if (tipo.equals("Remocao")) {
                    quantidade_update_lote = quantidade_update_lote - quantidade;
                    lote_get.setNExemplares(quantidade_update_lote);
                    lotefacade.edit(lote_get);
                } else {
                    quantidade_update_lote = quantidade_update_lote + quantidade;
                    lote_get.setNExemplares(quantidade_update_lote);
                    lotefacade.edit(lote_get);
                }

                Intervencao interv = new Intervencao();
                interv.setId(Integer.SIZE);
                interv.setData(data);
                Lote idLote = new Lote();
                idLote.setId(id_lote);

                interv.setDescricao(descricao);
                interv.setEspecie(especie);
                interv.setNome(nome);
                interv.setQuantidade(quantidade);
                interv.setTipo(tipo);
                interv.setIdLote(idLote);
                System.out.println("teste antes do ultimo set");
                interv.setIdUtilizador(user);

                System.out.println("teste depois do set, antes do create");
                intervencaofacade.create(interv);

                request.setAttribute("intervencaoFACADE", "1");

                url += "/WEB-INF/pages";




            } catch (ParseException ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/criar_plano_alimentar")) {
            try {
                System.out.println("entrei no if");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date1 = new Date();
                String dataIns = dateFormat.format(date1);
                Date data = dateFormat.parse(dataIns);

                String tanque_string = request.getParameter("tanque");
                int tanque = Integer.parseInt(tanque_string);
                String tipo_alimentacao = request.getParameter("tipo_alimentacao");
                String quantidade_string = request.getParameter("quantidade");
                Double quantidade = Double.parseDouble(quantidade_string);
                String forma_distribuicao = request.getParameter("distribuicao");
                String NVezesDia_string = request.getParameter("NVezesDia");
                int NVezesDia = Integer.parseInt(NVezesDia_string);

                PlanoAlimentar plano = new PlanoAlimentar();


                Tanque tipo = new Tanque();
                tipo.setId(tanque);
                System.out.println("teste antes dos sets");
                plano.setId(Integer.SIZE);
                plano.setIdTanque(tipo);
                plano.setTipoAlimentacao(tipo_alimentacao);
                plano.setData(data);
                plano.setQuantidade(quantidade);
                plano.setFormaDistribuicao(forma_distribuicao);
                plano.setNVezesDia(NVezesDia);

                System.out.println("teste depois do set, antes do create");
                planoalimentarfacade.create(plano);

                request.setAttribute("PlanoAlimentarINSERIDO", "1");

                url += "/WEB-INF/pages";




            } catch (ParseException ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/criar_lote")) {
            try {
                System.out.println("entrei no if");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date1 = new Date();
                String dataIns = dateFormat.format(date1);
                Date data = dateFormat.parse(dataIns);

                String tanque_string = request.getParameter("idTanque");
                int tanque = Integer.parseInt(tanque_string);

                String sala_string = request.getParameter("sala");
                double sala = Double.parseDouble(sala_string);

                String especie = request.getParameter("especie");

                String nvulgar_string = request.getParameter("nvulgar");
                int nvulgar;
                if (nvulgar_string.equals("")) {
                    nvulgar = 0;
                } else {
                    nvulgar = Integer.parseInt(nvulgar_string);
                }

                String grupoZoologico = request.getParameter("grupoZoologico");
                String familia = request.getParameter("familia");
                String origem = request.getParameter("origem");
                String fornecedor = request.getParameter("fornecedor");
                String titular = request.getParameter("titular");
                String grupoInvestigacao = request.getParameter("grupoInvestigacao");

                String referenciaFct_string = request.getParameter("referenciaFct");
                int referenciaFct;
                if (referenciaFct_string.equals("")) {
                    referenciaFct = 0;
                } else {
                    referenciaFct = Integer.parseInt(referenciaFct_string);
                }

                String NExemplares_string = request.getParameter("NExemplares");
                int NExemplares = Integer.parseInt(NExemplares_string);

                String pesosMedio_string = request.getParameter("pesosMedio");
                double pesosMedio;
                if (pesosMedio_string.equals("")) {
                    pesosMedio = 0;
                } else {
                    pesosMedio = Double.parseDouble(pesosMedio_string);
                }

                String comprimentoMedio_string = request.getParameter("comprimentoMedio");
                double comprimentoMedio;
                if (comprimentoMedio_string.equals("")) {
                    comprimentoMedio = 0;
                } else {
                    comprimentoMedio = Double.parseDouble(comprimentoMedio_string);
                }

                String NMachos_string = request.getParameter("NMachos");
                int NMachos;
                if (NMachos_string.equals("")) {
                    NMachos = 0;
                } else {
                    NMachos = Integer.parseInt(NMachos_string);
                }

                String NFemeas_string = request.getParameter("NFemeas");
                int NFemeas;
                if (NFemeas_string.equals("")) {
                    NFemeas = 0;
                } else {
                    NFemeas = Integer.parseInt(NFemeas_string);
                }
                String tipoContentor = request.getParameter("tipoContentor");

                String percentagemO2_string = request.getParameter("percentagemO2");
                double percentagemO2;
                if (percentagemO2_string.equals("")) {
                    percentagemO2 = 0;
                } else {
                    percentagemO2 = Double.parseDouble(percentagemO2_string);
                }

                String projecto = request.getParameter("projecto");


                Lote lote = new Lote();

                Tanque tanq = new Tanque();
                tanq.setId(tanque);

                System.out.println("teste antes dos sets");

                lote.setComprimentoMedio(comprimentoMedio);
                lote.setData(data);
                lote.setEspecie(especie);
                lote.setFamilia(familia);
                lote.setFornecedor(fornecedor);
                lote.setGrupoInvestigacao(grupoInvestigacao);
                lote.setGrupoZoologico(grupoZoologico);
                lote.setId(Integer.SIZE);
                lote.setIdTanque(tanq);
                lote.setNExemplares(NExemplares);
                lote.setNFemeas(NFemeas);
                lote.setNMachos(NMachos);
                lote.setNVulgar(nvulgar);
                lote.setOrigem(origem);
                lote.setPercentagemO2(percentagemO2);
                lote.setPesosMedio(pesosMedio);
                lote.setProjecto(projecto);
                lote.setReferenciaFct(referenciaFct);
                lote.setSala(sala);
                lote.setTipoContentor(tipoContentor);
                lote.setTitular(titular);

                System.out.println("teste depois do set, antes do create");
                lotefacade.create(lote);

                request.setAttribute("LoteINSERIDO", "1");

                url += "/WEB-INF/pages";


            } catch (ParseException ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/criar_tratamento_efectuado")) {
            try {
                System.out.println("entrei no if");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date1 = new Date();
                String dataIns = dateFormat.format(date1);
                Date data = dateFormat.parse(dataIns);

                String tanque_string = request.getParameter("tanque");
                int tanque = Integer.parseInt(tanque_string);
                String agente = request.getParameter("agente");
                String temperatura_string = request.getParameter("temperatura");
                Double temperatura = Double.parseDouble(temperatura_string);
                String tipo = request.getParameter("tipo");
                String duracao_string = request.getParameter("duracao");
                Double duracao = Double.parseDouble(duracao_string);
                String dose_string = request.getParameter("dose");
                Double dose = Double.parseDouble(duracao_string);

                Tratamento trat = new Tratamento();

                Tanque tanq = new Tanque();
                tanq.setId(tanque);
                System.out.println("teste antes dos sets");
                trat.setReferencia(Integer.SIZE);
                trat.setData(data);
                trat.setIdTanque(tanq);
                trat.setAgente(agente);
                trat.setDose(dose);
                trat.setDuracao(duracao);
                trat.setTemperatura(temperatura);
                trat.setTipo(tipo);

                System.out.println("teste depois do set, antes do create");
                tratamentofacade.create(trat);

                request.setAttribute("TratamentoEfectuadoINSERIDO", "1");

                url += "/WEB-INF/pages";




            } catch (ParseException ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/criar_classe_tanque")) {
            //System.out.println("entrei no if");

            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");

            ClasseTanque classeTanq = new ClasseTanque();
            classeTanq.setId(Integer.SIZE);
            classeTanq.setNome(nome);
            classeTanq.setDescricao(descricao);

            System.out.println("teste");
            classetanquefacade.create(classeTanq);
            System.out.println("teste1");
            request.setAttribute("ClasseTanqueINSERIDO", "1");

            url += "/WEB-INF/pages";
        } else if (userPath.equals("/criar_tipo_tanque")) {
            //System.out.println("entrei no if");

            String nome = request.getParameter("nome");
            String read;
            read = request.getParameter("volumetotal");
            Double volumeagua = Double.parseDouble(read);

            read = request.getParameter("idClasse");
            int idClasse = Integer.parseInt(read);

            read = request.getParameter("alturaagua");
            Double alturaagua = Double.parseDouble(read);

            read = request.getParameter("taxaexterior");
            Double taxaexterior = Double.parseDouble(read);

            read = request.getParameter("taxainterior");
            Double taxainterior = Double.parseDouble(read);

            read = request.getParameter("taxainteriorexc");
            Double taxainteriorexc = Double.parseDouble(read);

            read = request.getParameter("taxaexteriorexc");
            Double taxaexteriorexc = Double.parseDouble(read);

            TipoTanque tipoTanq = new TipoTanque();
            tipoTanq.setId(Integer.SIZE);
            tipoTanq.setNome(nome);

            ClasseTanque classTanq = new ClasseTanque();
            classTanq.setId(idClasse);

            tipoTanq.setIdClasse(classTanq);
            tipoTanq.setVolumeTotal(volumeagua);
            tipoTanq.setAlturaAgua(alturaagua);
            tipoTanq.setTaxaExterior(taxaexterior);
            tipoTanq.setTaxaInterior(taxainterior);
            tipoTanq.setTaxaIntExc(taxainteriorexc);
            tipoTanq.setTaxaIntSExc(taxaexteriorexc);

            System.out.println("AQUI NO TIPO TANQUE ANTES DO CREATE");
            tipotanquefacade.create(tipoTanq);
            System.out.println("AQUI NO TIPO TANQUE DEPOIS DO CREATE");
            request.setAttribute("TipoTanqueINSERIDO", "1");
            request.setAttribute("classe_tanque", classetanquefacade.findAll());
            url += "/WEB-INF/pages";

        } else if (userPath.equals("/recover")) {
            String email = request.getParameter("email");
            System.out.println("EMAIL " + email);
            String newPass = "";
            if (utilizadorfacade.isEmailRegisted(email)) {
                try {
                    newPass = utilizadorfacade.recoverPassword(email);
                } catch (NoSuchAlgorithmException ex) {
                    System.out.println("ERRO AQUI");
                }
            } else {
                newPass = "1";
            }
            if (newPass.length() <= 1) {
                request.setAttribute("sucesso", "0");
                userPath = "/recover";
            } else if (newPass.length() >= 2) {
                emailfacade.sendEmail(email, "Caro Utilizador.\n\nFoi pedida uma recuperação de password para a conta associada a este endereço de email.\n\nA nova password de acesso é: " + newPass, "Alteração de Password");
                request.setAttribute("sucesso", "1");
                userPath = "/login";
            }
        } else if (userPath.equals("/editmyprofile")) {
            System.out.println("AQUI0");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String morada = request.getParameter("morada");
            String telemove = request.getParameter("phone");
            int telemovel;
            if (telemove.equals("")) {
                telemovel = -1;
            } else {
                telemovel = Integer.parseInt(telemove);
            }
            String username = request.getParameter("username");
            String grupoPRO = request.getParameter("grupoPRO");
            System.out.println("--> " + nome);
            System.out.println("--> " + email);
            System.out.println("--> " + morada);
            System.out.println("--> " + telemovel);
            System.out.println("--> " + username);
            System.out.println("--> " + grupoPRO);

            System.out.println("AQUI1");
            boolean isUsernameRepited = utilizadorfacade.isUsernameRepeat(username, idUSER);
            boolean isEmailRepited = utilizadorfacade.isEmailRepeat(email, idUSER);

            System.out.println("--> " + isUsernameRepited);
            System.out.println("--> " + isEmailRepited);

            System.out.println("AQUI2");
            if (isUsernameRepited == true && isEmailRepited == false) {
                System.out.println("AQUI10");
                Utilizador user = utilizadorfacade.getUserById(idUSER);
                request.setAttribute("isUsernameRepited", "1");
                request.setAttribute("isEmailRepited", "0");
                request.setAttribute("user", user);
                url += "/WEB-INF/pages";
                userPath = "/editmyprofile";
            } else if (isUsernameRepited == false && isEmailRepited == true) {
                System.out.println("AQUI20");
                Utilizador user = utilizadorfacade.getUserById(idUSER);
                request.setAttribute("isEmailRepited", "1");
                request.setAttribute("isUsernameRepited", "0");
                request.setAttribute("user", user);
                url += "/WEB-INF/pages";
                userPath = "/editmyprofile";
            } else if (isUsernameRepited == true && isEmailRepited == true) {
                System.out.println("AQUI30");
                Utilizador user = utilizadorfacade.getUserById(idUSER);
                request.setAttribute("isEmailRepited", "1");
                request.setAttribute("isUsernameRepited", "1");
                request.setAttribute("user", user);
                url += "/WEB-INF/pages";
                userPath = "/editmyprofile";
            } else if (isUsernameRepited == false && isEmailRepited == false) {
                System.out.println("AQUI40");
                utilizadorfacade.updateProfile(idUSER, nome, email, morada, telemovel, username, grupoPRO);
                Utilizador user = utilizadorfacade.getUserById(idUSER);
                TipoUtilizador userType = user.getTipoUtilizador();
                request.setAttribute("user", user);
                request.setAttribute("userType", userType);
                url += "/WEB-INF/pages";
                userPath = "/myprofile";
            }
        } else if (userPath.endsWith("/admin_edit_users")) {
            System.out.println("AQUI112");
            String nome = request.getParameter("nome");
            String idTipo = request.getParameter("tipo");
            int idType = Integer.parseInt(idTipo);
            String email = request.getParameter("email");
            String morada = request.getParameter("morada");
            String telemove = request.getParameter("phone");
            String username = request.getParameter("username");
            String grupoPRO = request.getParameter("grupoPRO");
            String idUserString = request.getParameter("id");
            int idUser = Integer.parseInt(idUserString);
            int telemovel;
            if (telemove.equals("")) {
                telemovel = -1;
            } else {
                telemovel = Integer.parseInt(telemove);
            }
            boolean isUsernameRepited = utilizadorfacade.isUsernameRepeat(username, idUser);
            boolean isEmailRepited = utilizadorfacade.isEmailRepeat(email, idUser);

            if (isUsernameRepited == true && isEmailRepited == false) {
                System.out.println("AQUI10");
                Utilizador user = utilizadorfacade.getUserById(idUser);
                request.setAttribute("isUsernameRepited", "1");
                request.setAttribute("isEmailRepited", "0");
                request.setAttribute("user", user);
                request.setAttribute("userType", tipoutilizadorfacade.findAll());
                url += "/WEB-INF/pages";
                userPath = "/admin_edit_users";
            } else if (isUsernameRepited == false && isEmailRepited == true) {
                System.out.println("AQUI20");
                Utilizador user = utilizadorfacade.getUserById(idUser);
                request.setAttribute("isEmailRepited", "1");
                request.setAttribute("isUsernameRepited", "0");
                request.setAttribute("user", user);
                request.setAttribute("userType", tipoutilizadorfacade.findAll());
                url += "/WEB-INF/pages";
                userPath = "/admin_edit_users";
            } else if (isUsernameRepited == true && isEmailRepited == true) {
                System.out.println("AQUI30");
                Utilizador user = utilizadorfacade.getUserById(idUser);
                request.setAttribute("isEmailRepited", "1");
                request.setAttribute("isUsernameRepited", "1");
                request.setAttribute("user", user);
                request.setAttribute("userType", tipoutilizadorfacade.findAll());
                url += "/WEB-INF/pages";
                userPath = "/admin_edit_users";
            } else if (isUsernameRepited == false && isEmailRepited == false) {
                System.out.println("AQUI40");
                utilizadorfacade.updateProfile(idUser, nome, email, morada, telemovel, username, grupoPRO);
                utilizadorfacade.updateUserType(idUser, idType);
                request.setAttribute("users", utilizadorfacade.findAll());
                url += "/WEB-INF/pages";
                userPath = "/all_users";
            }
        } else if (userPath.equals("/edit_man_efect")) {

            try {
                System.out.println("entrei no if DO EIT MAN");

                ManutencaoEfectuada man = manutencaoefectuadafacade.getManEfectById(Integer.parseInt(request.getParameter("id")));



                String tanque_string = request.getParameter("idtanque");
                int idTanque = Integer.parseInt(tanque_string);

                String tipo_manutencao_string = request.getParameter("tipo_manutencao");
                int nivel = Integer.parseInt(tipo_manutencao_string);
                String observacoes = request.getParameter("observacoes");

                ManutencaoEfectuada ManEfect = new ManutencaoEfectuada();
                ManEfect.setId(man.getId());
                ManEfect.setData(man.getData());
                TipoManutencao tipo = new TipoManutencao();
                tipo.setId(nivel);

                Tanque tanq = new Tanque();
                tanq.setId(idTanque);

                System.out.println("teste antes do ultimo set");
                ManEfect.setIdTanque(tanq);
                ManEfect.setTipoManutencao(tipo);
                ManEfect.setObservacoes(observacoes);
                System.out.println("teste depois do set, antes do create");
                manutencaoefectuadafacade.edit(ManEfect);
                request.setAttribute("ManutencaoEfectuadaALTERADO", "1");
                List<ManutencaoEfectuada> findAll = manutencaoefectuadafacade.findAll();
                request.setAttribute("cons_man_efectuada", findAll);
                url += "/WEB-INF/pages";
                userPath = "/consultar_manutencao_efectuada";

            } catch (Exception ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/editar_plano_alimentar")) {

            try {
                System.out.println("entrei no if DO EDIT PLANO");

                PlanoAlimentar plan = planoalimentarfacade.getPlanById(Integer.parseInt(request.getParameter("id")));

                String tanque_string = request.getParameter("tanque");
                int tanque = Integer.parseInt(tanque_string);
                String tipo = request.getParameter("tipo_alimentacao");
                String quantidade_string = request.getParameter("quantidade");
                Double quantidade = Double.parseDouble(quantidade_string);
                String forma_distribuicao = request.getParameter("distribuicao");
                String num_dia_string = request.getParameter("NVezesDia");
                int NVezesDia = Integer.parseInt(num_dia_string);

                PlanoAlimentar plan_insert = new PlanoAlimentar();

                Tanque tanq = new Tanque();
                tanq.setId(tanque);

                plan_insert.setId(plan.getId());
                plan_insert.setData(plan.getData());
                plan_insert.setIdTanque(tanq);
                plan_insert.setFormaDistribuicao(forma_distribuicao);
                plan_insert.setNVezesDia(NVezesDia);
                plan_insert.setQuantidade(quantidade);
                plan_insert.setTipoAlimentacao(tipo);

                System.out.println("teste depois do set, antes do create");
                planoalimentarfacade.edit(plan_insert);
                System.out.println("FEZ O UPDATE");
                request.setAttribute("PlanoALTERADO", "1");

                url += "/WEB-INF/pages";
                userPath = "/consultar_plano_alimentar";
                request.setAttribute("cons_plano_ali", planoalimentarfacade.consultarTodosPlanos());

            } catch (Exception ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/editar_lote")) {

            try {
                System.out.println("entrei no if DO EDIT LOTE");

                Lote lote = lotefacade.getLoteById(Integer.parseInt(request.getParameter("id")));

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date1 = new Date();
                String dataIns = dateFormat.format(date1);
                Date data = dateFormat.parse(dataIns);

                String tanque_string = request.getParameter("idTanque");
                int tanque = Integer.parseInt(tanque_string);

                String sala_string = request.getParameter("sala");
                double sala = Double.parseDouble(sala_string);

                String especie = request.getParameter("especie");

                String nvulgar_string = request.getParameter("nvulgar");
                int nvulgar;
                if (nvulgar_string.equals("")) {
                    nvulgar = 0;
                } else {
                    nvulgar = Integer.parseInt(nvulgar_string);
                }

                String grupoZoologico = request.getParameter("grupoZoologico");
                String familia = request.getParameter("familia");
                String origem = request.getParameter("origem");
                String fornecedor = request.getParameter("fornecedor");
                String titular = request.getParameter("titular");
                String grupoInvestigacao = request.getParameter("grupoInvestigacao");

                String referenciaFct_string = request.getParameter("referenciaFct");
                int referenciaFct;
                if (referenciaFct_string.equals("")) {
                    referenciaFct = 0;
                } else {
                    referenciaFct = Integer.parseInt(referenciaFct_string);
                }

                String NExemplares_string = request.getParameter("NExemplares");
                int NExemplares = Integer.parseInt(NExemplares_string);

                String pesosMedio_string = request.getParameter("pesosMedio");
                double pesosMedio;
                if (pesosMedio_string.equals("")) {
                    pesosMedio = 0;
                } else {
                    pesosMedio = Double.parseDouble(pesosMedio_string);
                }

                String comprimentoMedio_string = request.getParameter("comprimentoMedio");
                double comprimentoMedio;
                if (comprimentoMedio_string.equals("")) {
                    comprimentoMedio = 0;
                } else {
                    comprimentoMedio = Double.parseDouble(comprimentoMedio_string);
                }

                String NMachos_string = request.getParameter("NMachos");
                int NMachos;
                if (NMachos_string.equals("")) {
                    NMachos = 0;
                } else {
                    NMachos = Integer.parseInt(NMachos_string);
                }

                String NFemeas_string = request.getParameter("NFemeas");
                int NFemeas;
                if (NFemeas_string.equals("")) {
                    NFemeas = 0;
                } else {
                    NFemeas = Integer.parseInt(NFemeas_string);
                }
                String tipoContentor = request.getParameter("tipoContentor");

                String percentagemO2_string = request.getParameter("percentagemO2");
                double percentagemO2;
                if (percentagemO2_string.equals("")) {
                    percentagemO2 = 0;
                } else {
                    percentagemO2 = Double.parseDouble(percentagemO2_string);
                }

                String projecto = request.getParameter("projecto");


                Lote lote_new = new Lote();

                Tanque tanq = new Tanque();
                tanq.setId(tanque);

                System.out.println("teste antes dos sets");

                lote_new.setComprimentoMedio(comprimentoMedio);
                lote_new.setData(data);
                lote_new.setEspecie(especie);
                lote_new.setFamilia(familia);
                lote_new.setFornecedor(fornecedor);
                lote_new.setGrupoInvestigacao(grupoInvestigacao);
                lote_new.setGrupoZoologico(grupoZoologico);
                lote_new.setId(lote.getId());
                lote_new.setIdTanque(tanq);
                lote_new.setNExemplares(NExemplares);
                lote_new.setNFemeas(NFemeas);
                lote_new.setNMachos(NMachos);
                lote_new.setNVulgar(nvulgar);
                lote_new.setOrigem(origem);
                lote_new.setPercentagemO2(percentagemO2);
                lote_new.setPesosMedio(pesosMedio);
                lote_new.setProjecto(projecto);
                lote_new.setReferenciaFct(referenciaFct);
                lote_new.setSala(sala);
                lote_new.setTipoContentor(tipoContentor);
                lote_new.setTitular(titular);

                System.out.println("teste depois do set, antes do create");
                lotefacade.edit(lote_new);
                System.out.println("FEZ O UPDATE");
                request.setAttribute("LoteALTERADO", "1");

                url += "/WEB-INF/pages";
                userPath = "/consultar_lote";
                List<Lote> findAll = lotefacade.findAll();
                request.setAttribute("cons_lote", findAll);

            } catch (Exception ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/editar_tratamento_efectuado")) {

            try {
                System.out.println("entrei no if DO EDIT TRAT");

                Tratamento trat = tratamentofacade.getTratamentoByReferencia(Integer.parseInt(request.getParameter("id")));

                String tanque_string = request.getParameter("tanque");
                int tanque = Integer.parseInt(tanque_string);
                String agente = request.getParameter("agente");
                String temperatura_string = request.getParameter("temperatura");
                Double temperatura = Double.parseDouble(temperatura_string);
                String tipo = request.getParameter("tipo");
                String duracao_string = request.getParameter("duracao");
                Double duracao = Double.parseDouble(duracao_string);
                String dose_string = request.getParameter("dose");
                Double dose = Double.parseDouble(duracao_string);

                Tratamento trat_insert = new Tratamento();

                Tanque tanq = new Tanque();
                tanq.setId(tanque);

                trat_insert.setReferencia(trat.getReferencia());
                trat_insert.setData(trat.getData());
                trat_insert.setIdTanque(tanq);
                trat_insert.setAgente(agente);
                trat_insert.setDose(dose);
                trat_insert.setDuracao(duracao);
                trat_insert.setTemperatura(temperatura);
                trat_insert.setTipo(tipo);

                System.out.println("teste depois do set, antes do create");
                tratamentofacade.edit(trat_insert);
                request.setAttribute("TratamentoALTERADO", "1");

                url += "/WEB-INF/pages";
                userPath = "/consultar_tratamento_efectuado";
                request.setAttribute("tratamento", tratamentofacade.findAll());

            } catch (Exception ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/editar_dados_ambientais")) {

            try {
                System.out.println("entrei no if DO EDIT DADOS");

                DadosAmbientais dados = dadosambientaisfacade.getDadosAmbientaisById(Integer.parseInt(request.getParameter("id")));

                String tanque_string = request.getParameter("idtanque");
                int idTanque = Integer.parseInt(tanque_string);

                String read = request.getParameter("temperatura");
                double temperatura = Double.parseDouble(read);

                read = request.getParameter("salinidadeAgua");
                double salinidadeAgua = Double.parseDouble(read);

                read = request.getParameter("oxigenio");
                double oxigenio = Double.parseDouble(read);

                DadosAmbientais dadosAmb = new DadosAmbientais();
                dadosAmb.setId(dados.getId());
                dadosAmb.setData(dados.getData());

                Tanque tanq = new Tanque();
                tanq.setId(idTanque);

                dadosAmb.setIdTanque(tanq);
                dadosAmb.setOxigenio(oxigenio);
                dadosAmb.setSalinidadeAgua(salinidadeAgua);
                dadosAmb.setTemperatura(temperatura);


                System.out.println("teste depois do set, antes do create");
                dadosambientaisfacade.edit(dadosAmb);
                request.setAttribute("DadosAmbientaisALTERADO", "1");
                url += "/WEB-INF/pages";
                userPath = "/consultar_dados_ambientais";
                request.setAttribute("dados_ambientais", dadosambientaisfacade.findAll());

            } catch (Exception ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/editar_classe_tanque")) {

            try {
                System.out.println("entrei no if DO EDIT CLASSE");

                ClasseTanque classe = classetanquefacade.getClasseTanqueById(Integer.parseInt(request.getParameter("id")));

                String nome = request.getParameter("nome");

                String descricao = request.getParameter("descricao");

                ClasseTanque classe_new = new ClasseTanque();
                classe_new.setId(classe.getId());
                classe_new.setNome(nome);
                classe_new.setDescricao(descricao);

                System.out.println("teste depois do set, antes do create");
                classetanquefacade.edit(classe_new);
                request.setAttribute("ClasseTanqueALTERADO", "1");
                url += "/WEB-INF/pages";
                userPath = "/consultar_classes_tanques";
                request.setAttribute("classes_tanques", classetanquefacade.findAll());

            } catch (Exception ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/editar_tipo_tanques")) {
            try {
                System.out.println("entrei no if DO EDIT TIPO");

                TipoTanque tipo = tipotanquefacade.gettipoTanqueById(Integer.parseInt(request.getParameter("id")));

                String nome = request.getParameter("nome");

                String idClasse_string = request.getParameter("idClasse");
                int idClasse = Integer.parseInt(idClasse_string);

                String read;
                read = request.getParameter("volumetotal");
                Double volumeagua = Double.parseDouble(read);

                read = request.getParameter("alturaagua");
                Double alturaagua = Double.parseDouble(read);

                read = request.getParameter("taxaexterior");
                Double taxaexterior = Double.parseDouble(read);

                read = request.getParameter("taxainterior");
                Double taxainterior = Double.parseDouble(read);

                read = request.getParameter("taxainteriorexc");
                Double taxainteriorexc = Double.parseDouble(read);

                read = request.getParameter("taxaexteriorexc");
                Double taxaexteriorexc = Double.parseDouble(read);

                ClasseTanque classe = new ClasseTanque();
                classe.setId(idClasse);

                TipoTanque tipo_new = new TipoTanque();
                tipo_new.setAlturaAgua(alturaagua);
                tipo_new.setId(tipo.getId());
                tipo_new.setIdClasse(classe);
                tipo_new.setNome(nome);
                tipo_new.setTaxaExterior(taxaexterior);
                tipo_new.setTaxaIntExc(taxainterior);
                tipo_new.setTaxaIntExc(taxainteriorexc);
                tipo_new.setTaxaIntSExc(taxaexteriorexc);
                tipo_new.setVolumeTotal(volumeagua);

                System.out.println("teste depois do set, antes do create");
                tipotanquefacade.edit(tipo_new);
                request.setAttribute("TipoTanqueALTERADO", "1");
                url += "/WEB-INF/pages";
                userPath = "/consultar_tipos_tanques";
                request.setAttribute("tipos_tanques", tipotanquefacade.findAll());

            } catch (Exception ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/editar_tanque")) {
            try {
                System.out.println("entrei no if DO EDIT TANQUE");

                Tanque tanq = tanquefacade.getTanqueById(Integer.parseInt(request.getParameter("id")));

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date1 = new Date();
                String dataIns = dateFormat.format(date1);
                Date data = dateFormat.parse(dataIns);

                String tipo_tanque_string = request.getParameter("tipo_tanque");
                int idTipoTanque = Integer.parseInt(tipo_tanque_string);

                String read = request.getParameter("volumeusado");
                double volumeusado = Double.parseDouble(read);

                String localizacao = request.getParameter("localizacao");

                String estado = request.getParameter("estado");

                String caracterizacao = request.getParameter("caracterizacao");

                Tanque tanq_new = new Tanque();

                tanq_new.setCaracterizacao(caracterizacao);
                tanq_new.setDataAquisicao(data);
                tanq_new.setEstadoTanque(estado);
                tanq_new.setId(tanq.getId());

                TipoTanque tipo = new TipoTanque();
                tipo.setId(idTipoTanque);

                tanq_new.setIdTipo(tipo);
                tanq_new.setLocalizacaoFisica(localizacao);
                tanq_new.setVolumeUsado(volumeusado);

                System.out.println("teste depois do set, antes do create");
                tanquefacade.edit(tanq_new);
                request.setAttribute("TanqueALTERADO", "1");
                url += "/WEB-INF/pages";
                userPath = "/consultar_tanques";
                request.setAttribute("tanques", tanquefacade.findAll());

            } catch (Exception ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/editar_intervencao")) {
            try {
                System.out.println("entrei no if DO EDIT INTERVENCAO");

                Intervencao interv = intervencaofacade.getIntervencaoById(Integer.parseInt(request.getParameter("id")));

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date1 = new Date();
                String dataIns = dateFormat.format(date1);
                Date data = dateFormat.parse(dataIns);

                String nome = request.getParameter("nome");
                String descricao = request.getParameter("descricao");
                String tipo = request.getParameter("tipo");
                String id_lote_string = request.getParameter("id_lote");
                int id_lote = Integer.parseInt(id_lote_string);

                String especie = request.getParameter("especie");
                String quantidade_string = request.getParameter("quantidade");
                int quantidade = Integer.parseInt(quantidade_string);

                System.out.println("TESTE DO UTILZIADOR DO FACADE");
                Utilizador user = utilizadorfacade.getUserById(idUSER);

                // Agora fazer o update no Lote
                Lote lote_get = lotefacade.getLoteById(id_lote);
                int quantidade_update_lote = lote_get.getNExemplares();
                int quantidade_interv_antes = interv.getQuantidade();
                int quantidade_interv_depois = quantidade;
                if (tipo.equals("Remocao") && interv.getTipo().equals("Remocao")) {
                    if (quantidade_interv_antes > quantidade_interv_depois) {
                        quantidade_update_lote = quantidade_update_lote + Math.abs(quantidade_interv_antes - quantidade_interv_depois);
                        lote_get.setNExemplares(quantidade_update_lote);
                        lotefacade.edit(lote_get);
                    } else if (quantidade_interv_antes < quantidade_interv_depois) {
                        quantidade_update_lote = quantidade_update_lote - Math.abs(quantidade_interv_antes - quantidade_interv_depois);
                        lote_get.setNExemplares(quantidade_update_lote);
                        lotefacade.edit(lote_get);
                    }
                } else if (tipo.equals("Adicao") && interv.getTipo().equals("Adicao")) {
                    if (quantidade_interv_antes > quantidade_interv_depois) {
                        quantidade_update_lote = quantidade_update_lote - Math.abs(quantidade_interv_antes - quantidade_interv_depois);
                        lote_get.setNExemplares(quantidade_update_lote);
                        lotefacade.edit(lote_get);
                    } else if (quantidade_interv_antes < quantidade_interv_depois) {
                        quantidade_update_lote = quantidade_update_lote + Math.abs(quantidade_interv_antes - quantidade_interv_depois);
                        lote_get.setNExemplares(quantidade_update_lote);
                        lotefacade.edit(lote_get);
                    }
                } else if (tipo.equals("Remocao") && interv.getTipo().equals("Adicao")) {
                    quantidade_update_lote = quantidade_update_lote - Math.abs(quantidade_interv_antes + quantidade_interv_depois);
                    lote_get.setNExemplares(quantidade_update_lote);
                    lotefacade.edit(lote_get);
                } else if (tipo.equals("Adicao") && interv.getTipo().equals("Remocao")) {
                    quantidade_update_lote = quantidade_update_lote + Math.abs(quantidade_interv_antes + quantidade_interv_depois);
                    lote_get.setNExemplares(quantidade_update_lote);
                    lotefacade.edit(lote_get);
                }

                Intervencao interv_new = new Intervencao();
                interv_new.setId(interv.getId());
                interv_new.setData(data);
                Lote idLote = new Lote();
                idLote.setId(id_lote);

                interv_new.setDescricao(descricao);
                interv_new.setEspecie(especie);
                interv_new.setNome(nome);
                interv_new.setQuantidade(quantidade);
                interv_new.setTipo(tipo);
                interv_new.setIdLote(idLote);
                interv_new.setIdUtilizador(user);

                System.out.println("teste depois do set, antes do create");
                intervencaofacade.edit(interv_new);
                request.setAttribute("IntervencaoALTERADO", "1");
                url += "/WEB-INF/pages";
                userPath = "/consultar_intervencao";
                request.setAttribute("cons_intervencao", intervencaofacade.findAll());

            } catch (Exception ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/editar_tipo_man")) {
            try {
                System.out.println("entrei no if DO EDIT TIPO MANUTENCAO");

                TipoManutencao tipo_man = tipomanutencaofacade.getTipoManutencaoById(Integer.parseInt(request.getParameter("id")));

                String nome = request.getParameter("nome");
                String nivel = request.getParameter("nivel");
                //int nivel = Integer.parseInt(nivel_string);
                String frequencia = request.getParameter("frequencia");
                String descricao = request.getParameter("descricao");

                TipoManutencao tipoMan_new = new TipoManutencao();
                tipoMan_new.setId(tipo_man.getId());
                tipoMan_new.setNome(nome);
                tipoMan_new.setNivel(nivel);
                tipoMan_new.setFrequencia(frequencia);
                tipoMan_new.setDescricao(descricao);

                System.out.println("teste depois do set, antes do create");
                tipomanutencaofacade.edit(tipoMan_new);
                request.setAttribute("TipoManALTERADO", "1");

                url += "/WEB-INF/pages";
                userPath = "/consultar_tipo_manutencao";
                request.setAttribute("cons_tipo_manutencao", tipomanutencaofacade.findAll());

            } catch (Exception ex) {
                Logger.getLogger(ControllerServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (userPath.equals("/searchUsers") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/searchUsers")) {
                String idTipo = request.getParameter("tipoUser");
                String search = request.getParameter("search");
                if (idTipo.equals("1")) {
                    System.out.println("1");
                    try {
                        TipoUtilizador tipoUser = tipoutilizadorfacade.likebynome(search);
                        System.out.println(tipoUser.getId() + " " + tipoUser.getNome());
                        List<Utilizador> user = utilizadorfacade.findAll();
                        List<Utilizador> finalusers = new ArrayList<Utilizador>();
                        for (Utilizador utilizador : user) {
                            if (utilizador.getTipoUtilizador().getId() == tipoUser.getId()) {
                                finalusers.add(utilizador);
                            }
                        }
                        request.setAttribute("idTIPO", idTipo);
                        request.setAttribute("TIPOS", tipoutilizadorfacade.findAll());
                        request.setAttribute("users", finalusers);
                        request.setAttribute("search", search);
                    } catch (Exception e) {
                        request.setAttribute("users", utilizadorfacade.findAll());
                    }
                    url += "/WEB-INF/pages";
                    userPath = "/all_users";
                } else if (idTipo.equals("2")) {
                    request.setAttribute("users", utilizadorfacade.likebynome(search));
                    request.setAttribute("idTIPO", idTipo);
                    request.setAttribute("TIPOS", tipoutilizadorfacade.findAll());
                    request.setAttribute("search", search);

                    url += "/WEB-INF/pages";
                    userPath = "/all_users";
                } else if (idTipo.equals("3")) {
                    request.setAttribute("users", utilizadorfacade.likebyemail(search));
                    request.setAttribute("idTIPO", idTipo);
                    request.setAttribute("TIPOS", tipoutilizadorfacade.findAll());
                    request.setAttribute("search", search);
                    url += "/WEB-INF/pages";
                    userPath = "/all_users";
                } else if (idTipo.equals("4")) {
                    request.setAttribute("users", utilizadorfacade.likebyusername(search));
                    request.setAttribute("idTIPO", idTipo);
                    request.setAttribute("TIPOS", tipoutilizadorfacade.findAll());
                    request.setAttribute("search", search);
                    url += "/WEB-INF/pages";
                    userPath = "/all_users";
                }
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/searchUsers") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/searchTanques") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/searchTanques")) {
                String search = request.getParameter("search");
                String searchId = request.getParameter("searchType");
                if (searchId.equals("1")) {//localizacao
                    request.setAttribute("tanques", tanquefacade.likeTanqueByLocal(search));
                    request.setAttribute("search", search);
                    request.setAttribute("idSEARCH", 1);
                    url += "/WEB-INF/pages";
                    userPath = "/consultar_tanques";
                } else if (searchId.equals("2")) {
                    request.setAttribute("tanques", tanquefacade.likeTanqueByeEstado(search));
                    request.setAttribute("search", search);
                    request.setAttribute("idSEARCH", 2);
                    url += "/WEB-INF/pages";
                    userPath = "/consultar_tanques";
                }
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/searchTanques") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/searchLote") && login == true) {
            if (permissionsFacade.checkPermissions(tipoUSER, "/searchLote")) {
                String search = request.getParameter("search");
                String searchId = request.getParameter("searchType");
                if (searchId.equals("1")) {
                    request.setAttribute("cons_lote", lotefacade.likeByEspecie(search));
                    request.setAttribute("search", search);
                    request.setAttribute("idSEARCH", 1);
                    url += "/WEB-INF/pages";
                    userPath = "/consultar_lote";
                } else if (searchId.equals("2")) {
                    request.setAttribute("cons_lote", lotefacade.likeByOrigem(search));
                    request.setAttribute("search", search);
                    request.setAttribute("idSEARCH", 2);
                    url += "/WEB-INF/pages";
                    userPath = "/consultar_lote";
                } else if (searchId.equals("3")) {
                    request.setAttribute("cons_lote", lotefacade.likeByTitular(search));
                    request.setAttribute("search", search);
                    request.setAttribute("idSEARCH", 3);
                    url += "/WEB-INF/pages";
                    userPath = "/consultar_lote";
                } else if (searchId.equals("4")) {
                    request.setAttribute("cons_lote", lotefacade.likeByGrupoInvestigacao(search));
                    request.setAttribute("search", search);
                    request.setAttribute("idSEARCH", 4);
                    url += "/WEB-INF/pages";
                    userPath = "/consultar_lote";
                } else if (searchId.equals("5")) {
                    request.setAttribute("cons_lote", lotefacade.likeByTipoContentor(search));
                    request.setAttribute("search", search);
                    request.setAttribute("idSEARCH", 5);
                    url += "/WEB-INF/pages";
                    userPath = "/consultar_lote";
                } else if (searchId.equals("6")) {
                     List<Lote> likeBySala;
                    try{
                        double test = Double.parseDouble(search);
                        likeBySala = lotefacade.likeBySala(test);
                    } catch (Exception e){
                        likeBySala = lotefacade.findAll();
                        
                    }
                    request.setAttribute("cons_lote", likeBySala);
                    request.setAttribute("search", search);
                    request.setAttribute("idSEARCH", 6);
                    url += "/WEB-INF/pages";
                    userPath = "/consultar_lote";
                }
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/searchLote") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/searchIntervencao") && login == true) {
            String search = request.getParameter("search");
            String searchId = request.getParameter("searchType");
            if (permissionsFacade.checkPermissions(tipoUSER, "/searchLote")) {
                if (searchId.equals("1")) {
                    List<Intervencao> lotefinal = intervencaofacade.findAll();
                    try {
                        List<Intervencao> result = new ArrayList<Intervencao>();
                        int id = Integer.parseInt(search);
                        for (Intervencao pointer : lotefinal) {
                            if (pointer.getIdLote().getId() == id) {
                                result.add(pointer);
                            }
                        }
                        request.setAttribute("cons_intervencao", result);
                    } catch (Exception e) {
                        request.setAttribute("cons_intervencao", lotefinal);
                    }
                    request.setAttribute("search", search);
                    request.setAttribute("idSEARCH", 1);
                    url += "/WEB-INF/pages";
                    userPath = "/consultar_intervencao";
                } else if (searchId.equals("2")) {
                    request.setAttribute("cons_intervencao", intervencaofacade.likeByTipo(search));
                    request.setAttribute("search", search);
                    request.setAttribute("idSEARCH", 2);
                    url += "/WEB-INF/pages";
                    userPath = "/consultar_intervencao";
                } else if (searchId.equals("3")) {
                    request.setAttribute("cons_intervencao", intervencaofacade.likeByEspecie(search));
                    request.setAttribute("search", search);
                    request.setAttribute("idSEARCH", 3);
                    url += "/WEB-INF/pages";
                    userPath = "/consultar_intervencao";
                } else if (searchId.equals("4")) {
                    List<Utilizador> users = utilizadorfacade.likebynome(search);
                    List<Intervencao> intervencao = intervencaofacade.findAll();
                    List<Intervencao> result = new ArrayList<Intervencao>();
                    try {
                        for (Utilizador utilizador : users) {
                            for (Intervencao pointer : intervencao) {
                                if (pointer.getIdUtilizador().getNome().equals(utilizador.getNome())) {
                                    result.add(pointer);
                                }
                            }
                        }
                    } catch (Exception e) {
                        ;
                    }
                    request.setAttribute("cons_intervencao", result);
                    request.setAttribute("search", search);
                    request.setAttribute("idSEARCH", 4);
                    url += "/WEB-INF/pages";
                    userPath = "/consultar_intervencao";
                }
            } else {
                userPath = "/deny";
            }
        } else if (userPath.equals("/searchIntervencao") && login == false) {
            userPath = "/login";
        } else if (userPath.equals("/searchTratamentoEfectuado") && login == true) {
            String search = request.getParameter("search");
            String searchId = request.getParameter("searchType");
            if (permissionsFacade.checkPermissions(tipoUSER, "/searchTratamentoEfectuado")) {
                if (searchId.equals("1")) {
                    List<Tratamento> tratfinal = tratamentofacade.findAll();
                    try {
                        List<Tratamento> result = new ArrayList<Tratamento>();
                        int id = Integer.parseInt(search);
                        for (Tratamento pointer : tratfinal) {
                            if (pointer.getIdTanque().getId() == id) {
                                result.add(pointer);
                            }
                        }
                        request.setAttribute("tratamento", result);
                    } catch (Exception e) {
                        request.setAttribute("tratamento", tratfinal);
                    }
                    request.setAttribute("search", search);
                    request.setAttribute("idSEARCH", 1);
                    url += "/WEB-INF/pages";
                    userPath = "/consultar_tratamento_efectuado";
                } else if (searchId.equals("2")) {
                    request.setAttribute("tratamento", tratamentofacade.likeByAgente(search));
                    request.setAttribute("search", search);
                    request.setAttribute("idSEARCH", 2);
                    url += "/WEB-INF/pages";
                    userPath = "/consultar_tratamento_efectuado";
                } else if (searchId.equals("3")) {
                    request.setAttribute("tratamento", tratamentofacade.likeByTipo(search));
                    request.setAttribute("search", search);
                    request.setAttribute("idSEARCH", 3);
                    url += "/WEB-INF/pages";
                    userPath = "/consultar_tratamento_efectuado";
                }
            } else if (userPath.equals("/searchTratamentoEfectuado") && login == false) {
                userPath = "/login";
            }
        }
        url += userPath + ".jsp";
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
