package session;

import java.util.*;

import javax.ejb.Stateless;

@Stateless
public class Permissions {

    public boolean checkPermissions(int id, String path) {
        HashMap<String, List<String>> permissions = getMap();
        List<String> check = permissions.get(Integer.toString(id));
        return check.contains(path);
    }

    public HashMap<String, List<String>> getMap() {
        HashMap<String, List<String>> permissions = new HashMap<String, List<String>>();
        List<String> user1 = new ArrayList<String>();   // ADMINISTRADOR
        List<String> user2 = new ArrayList<String>();   // UTILIZADOR COMUM
        List<String> user3 = new ArrayList<String>();   // GESTOR ORGANISMOS
        List<String> user4 = new ArrayList<String>();   // GESTOR TANQUES
        List<String> user5 = new ArrayList<String>();   // NAO APROVADO

        // UTILIZADOR COMUM
        user2.add("/consultar_tanques");
        user2.add("/consultar_tipos_tanques");
        user2.add("/consultar_classes_tanques");
        user2.add("/consultar_lote");
        user2.add("/consultar_manutencao_efectuada");
        user2.add("/consultar_tipo_manutencao");
        user2.add("/consultar_intervencao");
        user2.add("/consultar_plano_alimentar");
        user2.add("/consultar_tratamento_efectuado");
        user2.add("/consultar_dados_ambientais");
        user2.add("/myprofile");
        user2.add("/editmyprofile");
        user2.add("/index");
        user2.add("/searchLote");
        user2.add("/searchTratamentoEfectuado");
        user2.add("/searchTanques");
        user2.add("/searchIntervencao");
        user2.add("/help");

        permissions.put("2", user2);

        // ADMINISTRADOR
        user1.add("/consultar_tanques");
        user1.add("/consultar_tipos_tanques");
        user1.add("/consultar_classes_tanques");
        //user1.add("/tanques");
        user1.add("/consultar_plano_alimentar");
        user1.add("/criar_plano_alimentar");
        user1.add("/consultar_lote");
        user1.add("/criar_tipo_manutencao");
        user1.add("/criar_manutencao_efectuada");
        user1.add("/consultar_manutencao_efectuada");
        user1.add("/consultar_dados_ambientais");
        user1.add("/criar_dados_ambientais");
        user1.add("/consultar_intervencao");
        user1.add("/consultar_tipo_manutencao");
        user1.add("/consultar_tratamento_efectuado");
        user1.add("/criar_tipo_tanque");
        user1.add("/criar_classe_tanque");
        user1.add("/myprofile");
        user1.add("/editmyprofile");
        user1.add("/criar_tanque");
        user1.add("/criar_intervencao");
        user1.add("/eliminar_man_efect");
        user1.add("/edit_man_efect");
        user1.add("/eliminar_dados_ambientais");
        user1.add("/eliminar_tratamento");
        user1.add("/editar_dados_ambientais");
        user1.add("/all_users");
        user1.add("/admin_edit_users");
        user1.add("/delete_user");
        user1.add("/criar_tratamento_efectuado");
        user1.add("/editar_tratamento_efectuado");
        user1.add("/eliminar_plano_alimentar");
        user1.add("/eliminar_intervencao");
        user1.add("/searchUsers");
        user1.add("/searchTanques");
        user1.add("/editar_plano_alimentar");
        user1.add("/searchLote");
        user1.add("/searchTratamentoEfectuado");
        user1.add("/editar_classe_tanque");
        user1.add("/editar_tipo_tanques");
        user1.add("/editar_tanque");
        user1.add("/editar_intervencao");
        user1.add("/editar_tipo_man");
        user1.add("/criar_lote");
        user1.add("/editar_lote");
        user1.add("/searchIntervencao");
        user1.add("/help");


        permissions.put("1", user1);

        // GESTOR TANQUES
        user4.add("/consultar_tanques");
        user4.add("/consultar_tipos_tanques");
        user4.add("/consultar_classes_tanques");
        user4.add("/consultar_plano_alimentar");
        user4.add("/consultar_lote");
        user4.add("/consultar_manutencao_efectuada");
        user4.add("/consultar_dados_ambientais");
        user4.add("/consultar_tipo_manutencao");
        user4.add("/consultar_intervencao");
        user4.add("/consultar_tratamento_efectuado");
        user4.add("/criar_tipo_manutencao");
        user4.add("/criar_manutencao_efectuada");
        user4.add("/criar_tipo_tanque");
        user4.add("/criar_classe_tanque");
        user4.add("/myprofile");
        user4.add("/editmyprofile");
        user4.add("/criar_tanque");
        user4.add("/eliminar_man_efect");
        user4.add("/edit_man_efect");
        user4.add("/searchTanques");
        user4.add("/editar_classe_tanque");
        user4.add("/editar_tipo_tanques");
        user4.add("/editar_tanque");
        user4.add("/editar_tipo_man");
        user4.add("/searchLote");
        user4.add("/searchTratamentoEfectuado");
        user4.add("/eliminar_tratamento");
        user4.add("/criar_tratamento_efectuado");
        user4.add("/editar_tratamento_efectuado");
        user4.add("/searchIntervencao");
        user4.add("/help");

        permissions.put("4", user4);

        // GESTOR ORGANISMOS
        user3.add("/consultar_tanques");
        user3.add("/consultar_tipos_tanques");
        user3.add("/consultar_classes_tanques");
        user3.add("/consultar_plano_alimentar");
        user3.add("/criar_plano_alimentar");
        user3.add("/consultar_lote");
        user3.add("/consultar_manutencao_efectuada");
        user3.add("/consultar_dados_ambientais");
        user3.add("/criar_dados_ambientais");
        user3.add("/consultar_tipo_manutencao");
        user3.add("/consultar_intervencao");
        user3.add("/consultar_tratamento_efectuado");
        user3.add("/myprofile");
        user3.add("/editmyprofile");
        user3.add("/criar_intervencao");
        user3.add("/eliminar_dados_ambientais");
        user3.add("/editar_dados_ambientais");
        user3.add("/eliminar_plano_alimentar");
        user3.add("/eliminar_intervencao");
        user3.add("/searchTanques");
        user3.add("/editar_plano_alimentar");
        user3.add("/searchLote");
        user3.add("/editar_intervencao");
        user3.add("/criar_lote");
        user3.add("/editar_lote");
        user3.add("/searchIntervencao");
        user3.add("/searchTratamentoEfectuado");
        user3.add("/help");

        permissions.put("3", user3);

        // NAO APROVADO
        user5.add("");

        permissions.put("5", user5);

        return permissions;
    }
}
