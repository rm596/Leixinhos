/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TipoUtilizador;
import entity.Utilizador;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author andre
 */
@Stateless
public class UtilizadorFacade extends AbstractFacade<Utilizador> {
    @PersistenceContext(unitName = "leixinhosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilizadorFacade() {
        super(Utilizador.class);
    }
    
    /*
     * Encriptar Password Utilizador
     * 
     * @param data Password Utilizador
     * @algorithm Tipo Encriptacao
     * @return boolean result
     */
    public static String encrypt(String data, String algorithm) throws NoSuchAlgorithmException {
        if (data == null) {
            return null;
        }
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(data.getBytes());
        byte[] digest = md.digest();
        StringBuffer buf = new StringBuffer();
        for (byte b : digest) {
            buf.append((Character.forDigit((b & 0xF0) >> 4, 16)));
            buf.append((Character.forDigit((b & 0xF), 16)));
        }
        return buf.toString();
    }
    
    /*
     * Verificar se Utilizador existe
     * 
     * @param username Username Utilizador
     * @param password Password Utilizador
     * @return boolean result
     */
    public boolean isRegisted(String username, String password) throws NoSuchAlgorithmException {
        String sha1 = encrypt(password, "SHA1");
        Utilizador user = (Utilizador) em.createNamedQuery("Utilizador.findByUsername").setParameter("username", username).getSingleResult();
        boolean result ;

        if (user != null && user.getPassword().equals(sha1)) {
            result = true;
        } else if (user == null) {//ainda no registado
            result = false;
        } else { //registado mas com pass errada
            result = false;
        }
        return result;
    }
    
    /*
     * Verificar se Username foi registado com sucesso
     * 
     * @param username Username Utilizador
     * @return Utilizador
     */
    public Object afterlogin(String username) {
        return (Utilizador) em.createNamedQuery("Utilizador.findByUsername").setParameter("username", username).getSingleResult();
    }
    
    /*
     * Verificar se Username Utilizador existe
     * 
     * @param username Username Utilizador
     * @return boolean result
     */
    public boolean isUsernameRegisted(String username) {
        List resultList = em.createNamedQuery("Utilizador.findByUsername").setParameter("username", username).getResultList();
        if (resultList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /*
     * Verificar se Email Utilizador existe
     * 
     * @param email Email Utilizador
     * @return boolean result
     */
    public boolean isEmailRegisted(String email) {
        List resultList = em.createNamedQuery("Utilizador.findByEmail").setParameter("email", email).getResultList();
        if (resultList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /*
     * Verificar se Email Utilizador existe
     * 
     * @param email Email Utilizador
     * @param id ID Utilizador
     * @return boolean result
     */
    public boolean isEmailRepeat(String email, int id) {
        List<Utilizador> resultList = em.createNamedQuery("Utilizador.findByEmail").setParameter("email", email).getResultList();
        int count = 0;//n utilizadores com email igual ao desejado sem ser o actual
        for (Utilizador utilizador : resultList) {
            if (utilizador.getEmail().equals(email)) {
                if (utilizador.getId() != id) {
                    //problema
                    count++;
                }
            }
        }
        boolean result;
        if (count == 0) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }
    
    /*
     * Verificar se Username Utilizador existe
     * 
     * @param username Username Utilizador
     * @param id ID Utilizador
     * @return boolean result
     */
    public boolean isUsernameRepeat(String username, int id) {
        List<Utilizador> resultList = em.createNamedQuery("Utilizador.findByUsername").setParameter("username", username).getResultList();
        int count = 0;//n utilizadores com email igual ao desejado sem ser o actual
        for (Utilizador utilizador : resultList) {
            if (utilizador.getUsername().equals(username)) {
                if (utilizador.getId() != id) {
                    //problema
                    count++;
                }
            }
        }
        boolean result;
        if (count == 0) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }
    
    /*
     * Registar Utilizador
     * 
     * @param nome Nome Utilizador
     * @param email Email Utilizador
     * @param morada Morada Utilizador
     * @param telemove Telemovel Utilizador
     * @param username Username Utilizador
     * @param password Password Utilizador
     * @param Grupo Grupo Utilizador
     * @param dataFIM Data Fim Utilizador
     * @param listaUtilizadores Lista Utilizador
     * @return void
     */
    public void registerFirstTime(String nome, String email, String morada, int telemove, String username, String password, String Grupo, String dataFIM, List<TipoUtilizador> tiposUtilizadores) throws NoSuchAlgorithmException, ParseException {
        Utilizador userNew = new Utilizador();
        userNew.setId(Integer.SIZE);
        userNew.setNome(nome);
        userNew.setEmail(email);
        userNew.setMorada(morada);
        userNew.setTelemovel(telemove);
        userNew.setUsername(username);
        String sha1 = encrypt(password, "SHA1");
        userNew.setPassword(sha1);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        Date date1 = new Date();

        String datainicio = dateFormat.format(date1);

        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        Date datafim = data.parse(dataFIM);

        Date dataInicio = dateFormat.parse(datainicio);

        userNew.setDataInicio(dataInicio);
        userNew.setGrupoPro(Grupo);
        userNew.setDataFim(datafim);
        TipoUtilizador get = tiposUtilizadores.get(4);
        userNew.setTipoUtilizador(get);
        em.persist(userNew);
    }
    
    /*
     * Obter ID Utilizador por username
     * 
     * @param username Username Utilizador
     * @return ID do Utilizador
     */
    public int getIdUser(String username) {
        Utilizador check = (Utilizador) em.createNamedQuery("Utilizador.findByUsername").setParameter("username", username).getSingleResult();
        return check.getId();
    }
    
    /*
     * Verificar se Utilizador existe
     * 
     * @param id ID Utilizador
     * @return Utilizador
     */
    public Utilizador getUserById(int id) {
        return (Utilizador) em.createNamedQuery("Utilizador.findById").setParameter("id", id).getSingleResult();
    }
    
    /*
     * Verificar se Email existe
     * 
     * @param email Email Utilizador
     * @return Utilizador
     */
    public Utilizador isEmailRecover(String email) {
        Utilizador check = (Utilizador) em.createNamedQuery("Utilizador.findByEmail").setParameter("email", email).getSingleResult();
        return check;
    }
    
    /*
     * Gerar Nova Password Utilizador
     * 
     * @param length tamanho Password
     * @return nova Password Utilizador
     */
    public static String generateNewPassword(int length) {
        String alphabet = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"); // 9
        int n = alphabet.length(); // 10

        String result = new String();
        Random r = new Random(); // 11

        for (int i = 0; i < length; i++) {
            result = result + alphabet.charAt(r.nextInt(n)); // 13
        }
        return result;
    }
    
    /*
     * Atualizar Password Utilizador
     * 
     * @param id email Email Utilizador
     * @return nova Password Utilizador
     */
    public String recoverPassword(String email) throws NoSuchAlgorithmException {
        String newPassword = "";
        Utilizador check = isEmailRecover(email);
        if (check.getEmail().equals(email)) {
            newPassword=generateNewPassword(8);
            String sha1 = encrypt(newPassword, "SHA1");
            updatePassword(check.getId(), sha1);
        } else {
            newPassword = "1";
        }
        return newPassword;
    }
    
    /*
     * Atualizar Utilizador
     * 
     * @param id ID Utilizador
     * @param nome nome Utilizador
     * @param email email Utilizador
     * @param morada morada Utilizador
     * @param telemovel telemovel Utilizador
     * @param username Username Utilizador
     * @param grupoPRO string grupo Utilizador 
     * @return void
     */
    public void updateProfile(int id, String nome, String email, String morada, int telemovel, String username, String grupoPRO) {
        Query update_query = em.createNamedQuery("Utilizador.updateNormal").setParameter("nome", nome).setParameter("email", email).setParameter("morada", morada).setParameter("telemovel", telemovel).setParameter("username", username).setParameter("grupoPro", grupoPRO).setParameter("id", id);
        update_query.executeUpdate();
    }
    
    /*
     * Atualizar Password Utilizador por ID
     * 
     * @param id ID Utilizador
     * @param newPassword nova Password 
     * @return void
     */
    public void updatePassword(int id, String newPassword) {
        Query update_query = em.createNamedQuery("Utilizador.updadePassword").setParameter("password", newPassword).setParameter("id", id);
        update_query.executeUpdate();
    }
    
    /*
     * Atualizar Username Utilizador por ID
     * 
     * @param id ID Utilizador
     * @param username novo Username 
     * @return void
     */
    public void testUpdate(int id, String username) {
        Query update_query = em.createNamedQuery("Utilizador.updateUsername").setParameter("username", username).setParameter("id", id);
        update_query.executeUpdate();
    }
    
    /*
     * Atualizar Tipo Utilizador por ID
     * 
     * @param id ID Utilizador
     * @param newUserType ID novo Utilizador 
     * @return void
     */
    public void updateUserType(int id, int newUserType) {
        List<TipoUtilizador> findAll = em.createNamedQuery("TipoUtilizador.findAll").getResultList();
        //TipoUtilizador oldUserType = findAll.get(1);
        TipoUtilizador newUser = findAll.get(newUserType - 1);
        Query update_query = em.createNamedQuery("Utilizador.updateUserType").setParameter("tipoUtilizador", newUser).setParameter("id", id);
        update_query.executeUpdate();
    }
    
    /*
     * Eliminar Utilizador por ID
     * 
     * @param id ID Utilizador
     * @return void
     */
    public void deleteById(int id){
        Query delete_query = em.createNamedQuery("Utilizador.deleteById").setParameter("id", id);
        delete_query.executeUpdate();
    }
    
    /*
     * Procura por Username
     * 
     * @param username string procura 
     * @return lista Utilizadores
     */
    public List<Utilizador> likebynome(String nome){
        Query query = em.createNamedQuery("Utilizador.likeByNome");
        nome = "%"+nome+"%";
        query.setParameter("nome",nome);
        List<Utilizador> resultList = query.getResultList();
        return resultList;
    }
    
    /*
     * Procura por Email
     * 
     * @param email string procura 
     * @return lista Utilizadores
     */
    public List<Utilizador> likebyemail(String email){
        Query query = em.createNamedQuery("Utilizador.likeByEmail");
        email = "%"+email+"%";
        query.setParameter("email",email);
        List<Utilizador> resultList = query.getResultList();
        return resultList;
    }
    
    /*
     * Procura por Username
     * 
     * @param username string procura 
     * @return lista Utilizadores
     */
    public List<Utilizador> likebyusername(String username){
        Query query = em.createNamedQuery("Utilizador.likeByUsername");
        username = "%"+username+"%";
        query.setParameter("username",username);
        List<Utilizador> resultList = query.getResultList();
        return resultList;
    }
}
