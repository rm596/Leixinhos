/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TipoUtilizador;
import entity.Utilizador;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcelo
 */
public class UtilizadorFacadeTest {
    
    private static EJBContainer UTcontainer;
    private static UtilizadorFacade instance;
    
    public UtilizadorFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("build/jar"));
        UTcontainer = EJBContainer.createEJBContainer(properties);
        System.out.println("Opening the container");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        UTcontainer.close();
        System.out.println("Closing the container");
    }

    @Before
    public void setUp() throws NamingException {
        instance = (UtilizadorFacade) UTcontainer.getContext().lookup("java:global/classes/UtilizadorFacade");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of encrypt method, of class UtilizadorFacade.
     */
    @Test
    public void testEncrypt() throws Exception {
        System.out.println("encrypt");
        String data = "segredo";
        String algorithm = "SHA1";
        String result = UtilizadorFacade.encrypt(data, algorithm);
        
        String expResult = "781ecb5259a3dc9057b5332e57e72603d6bfe0fa";
        assertEquals(expResult, result); //Correcto
        
        expResult = "f015ac18607d506902ef7be959528d10638a7aaf";
        assertNotSame(expResult, result); //Errado, segreda
        
        expResult = "781ecb5259a3dc9057b5332e57e72603d6bfe0";
        assertNotSame(expResult, result); //Errado, falta um caracter
        
        expResult = "";
        assertNotSame(expResult, result); //Errado, resultado vazio
    }

    /**
     * Test of isRegisted method, of class UtilizadorFacade.
     */
    @Test
    public void testIsRegisted() throws Exception {
        System.out.println("isRegisted");
        String username = "andre";
        String password = "andre";
        boolean expResult = true;
        boolean result = instance.isRegisted(username, password);
        assertEquals(expResult, result); //Correcto
        
        username = "marcelo";
        password = "marcelo";
        expResult = true;
        result = instance.isRegisted(username, password);
        assertEquals(expResult, result); //Correcto
        
        username = "andre";
        password = "marcelo";
        expResult = true;
        result = instance.isRegisted(username, password);
        assertNotSame(expResult, result); //Password incorrecta
        
        username = "andre";
        password = "46ed215d4162eb1145147b7e6ffd66ea7891f172";
        expResult = false;
        result = instance.isRegisted(username, password);
        assertEquals(expResult, result); //Nao existe, password incorrecta
    }

    /**
     * Test of afterlogin method, of class UtilizadorFacade.
     */
    @Test
    public void testAfterlogin() throws Exception {
        System.out.println("afterlogin");
        String username = "marcelo";
        Object result = instance.afterlogin(username);
        
        DateFormat dfI = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        DateFormat dfF = new SimpleDateFormat("yyyy-mm-dd");
        Date dI = dfI.parse("2013-06-26 16:25:12");
        Date dF = dfF.parse("2013-08-20");
        Object expResult = new Utilizador(25, "Marcelo Gon?alves", "marcel.palma@hotmail.com", "marcelo", "46ed215d4162eb1145147b7e6ffd66ea7891f172", "UALG", dI, dF);
        assertEquals(expResult, result); //Correcto
        
        dI = dfI.parse("2013-06-26 16:27:36");
        dF = dfF.parse("2013-08-20");
        expResult = new Utilizador(27, "Andr? Santos", "andremlsantos5453@gmail.com", "marcelo", "bc9800b9d52a24cce72a73dd528afed53f10e5fc", "UALG", dI, dF);
        assertNotSame(expResult, result); //Errado, utilizador diferente
        
        dI = dfI.parse("2010-06-26 16:27:36");
        dF = dfF.parse("2010-08-20");
        expResult = new Utilizador(50, "Andr? Santos", "andremlsantos5453@gmail.com", "chico", "bc9800b9d52a24cce72a73dd528afed53f10e5fc", "Teste", dI, dF);
        assertNotSame(expResult, result); //Errado, utilizador nao existe
        
        expResult = new Utilizador();
        assertNotSame(expResult, result); //Errado, utilizador vazio
    }

    /**
     * Test of isUsernameRegisted method, of class UtilizadorFacade.
     */
    @Test
    public void testIsUsernameRegisted() throws Exception {
        System.out.println("isUsernameRegisted");
        String username = "marcelo";
        boolean expResult = true;
        boolean result = instance.isUsernameRegisted(username);
        assertEquals(expResult, result); //Correcto
        
        username = "andre";
        expResult = true;
        result = instance.isUsernameRegisted(username);
        assertEquals(expResult, result); //Correcto
        
        username = "andre";
        expResult = false;
        result = instance.isUsernameRegisted(username);
        assertNotSame(expResult, result); //Errado, utilizador existe
        
        username = "chico";
        expResult = true;
        result = instance.isUsernameRegisted(username);
        assertNotSame(expResult, result); //Errado, utilizador nao existe
    }

    /**
     * Test of isEmailRegisted method, of class UtilizadorFacade.
     */
    @Test
    public void testIsEmailRegisted() throws Exception {
        System.out.println("isEmailRegisted");
        String email = "marcel.palma@hotmail.com";
        boolean expResult = true;
        boolean result = instance.isEmailRegisted(email);
        assertEquals(expResult, result); //Correcto
        
        email = "andremlsantos5453@gmail.com";
        expResult = true;
        result = instance.isEmailRegisted(email);
        assertEquals(expResult, result); //Correcto
        
        email = "andremlsantos5453@gmail.com";
        expResult = false;
        result = instance.isEmailRegisted(email);
        assertNotSame(expResult, result); //Errado, email existe
        
        email = "chico";
        expResult = true;
        result = instance.isEmailRegisted(email);
        assertNotSame(expResult, result); //Errado, email nao existe
    }

    /**
     * Test of isEmailRepeat method, of class UtilizadorFacade.
     */
    @Test
    public void testIsEmailRepeat() throws Exception {
        System.out.println("isEmailRepeat");
        String email = "marcel.palma@hotmail.com";
        int id = 25;
        boolean expResult = false;
        boolean result = instance.isEmailRepeat(email, id);
        assertEquals(expResult, result); //Correcto
        
        expResult = true;
        assertNotSame(expResult, result); //Errado, apenas existe um utilizador correspondente
        
        email = "marcel.palma@gmail.com";
        id = 50;
        expResult = false;
        result = instance.isEmailRepeat(email, id);
        assertEquals(expResult, result); //Correcto, utilizador nao existe
        
        expResult = true;
        assertNotSame(expResult, result); //Errado, nao existem utilizadores correspondentes
    }

    /**
     * Test of isUsernameRepeat method, of class UtilizadorFacade.
     */
    @Test
    public void testIsUsernameRepeat() throws Exception {
        System.out.println("isUsernameRepeat");      
        String username = "marcelo";
        int id = 25;
        boolean expResult = false;
        boolean result = instance.isUsernameRepeat(username, id);
        assertEquals(expResult, result); //Correcto
        
        expResult = true;
        assertNotSame(expResult, result); //Errado, apenas existe um utilizador correspondente
        
        username = "chico";
        id = 50;
        expResult = false;
        result = instance.isUsernameRepeat(username, id);
        assertEquals(expResult, result); //Correcto, utilizador nao existe
        
        expResult = true;
        assertNotSame(expResult, result); //Errado, nao existem utilizadores correspondentes
    }

    /**
     * Test of getIdUser method, of class UtilizadorFacade.
     */
    @Test
    public void testGetIdUser() throws Exception {
        System.out.println("getIdUser");
        String username = "marcelo";
        int expResult = 25;
        int result = instance.getIdUser(username);
        assertEquals(expResult, result); //Correcto
        
        expResult = 50;
        assertNotSame(expResult, result); //Errado, id nao existe
        
        username = "andre";
        expResult = 25;
        result = instance.getIdUser(username);
        assertNotSame(expResult, result); //Errado, username nao existe        
    }

    /**
     * Test of getUserById method, of class UtilizadorFacade.
     */
    @Test
    public void testGetUserById() throws Exception {
        System.out.println("getUserById");
        int id = 25;
        Utilizador result = instance.getUserById(id);
        
        DateFormat dfI = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        DateFormat dfF = new SimpleDateFormat("yyyy-mm-dd");
        Date dI = dfI.parse("2013-06-26 16:25:12");
        Date dF = dfF.parse("2013-08-20");
        Utilizador expResult = new Utilizador(25, "Marcelo Gon?alves", "marcel.palma@hotmail.com", "marcelo", "46ed215d4162eb1145147b7e6ffd66ea7891f172", "UALG", dI, dF);
        assertEquals(expResult, result); //Correcto
        
        dI = dfI.parse(" 2013-06-26 16:27:36");
        dF = dfF.parse("2013-08-20");
        expResult = new Utilizador(27, "Andr? Santos", "andremlsantos5453@gmail.com", "andre", "bc9800b9d52a24cce72a73dd528afed53f10e5fc", "UALG", dI, dF);
        assertNotSame(expResult, result); //Errado, utilizador diferente
        
        dI = dfI.parse(" 2013-06-26 16:27:36");
        dF = dfF.parse("2013-08-20");
        expResult = new Utilizador(25, "Andr? Santos", "andremlsantos5453@gmail.com", "andre", "bc9800b9d52a24cce72a73dd528afed53f10e5fc", "UALG", dI, dF);
        assertNotSame(expResult, result); //Errado, utilizador nao existe
        
        expResult = new Utilizador();
        assertNotSame(expResult, result); //Errado, utilizador vazio
    }

    /**
     * Test of isEmailRecover method, of class UtilizadorFacade.
    @Test
    public void testIsEmailRecover() throws Exception*/
    //Nao foi feito teste a esta funcao por faria o mesmo que o teste "testIsEmailRegisted"

    /**
     * Test of generateNewPassword method, of class UtilizadorFacade.
    @Test
    public void testGenerateNewPassword() throws Exception*/
    //Nao e possivel testar esta funcao devido a sua aleatoriedade

    /**
     * Test of recoverPassword method, of class UtilizadorFacade.
    @Test
    public void testRecoverPassword() throws Exception*/
    //Nao e possivel testar esta funcao visto que a mesma apenas verifica se o email existe
    //e cria uma nova password aleatoria para o utilizador correspondente  

    /**
     * Test of likebynome method, of class UtilizadorFacade.
     */
    @Test
    public void testLikebynome() throws Exception {
        System.out.println("likebynome");
        String nome = "Marcelo";
        List<Utilizador> expResult = new ArrayList();
        List<Utilizador> result = instance.likebynome(nome);
       
        DateFormat dfI = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        DateFormat dfF = new SimpleDateFormat("yyyy-mm-dd");
        Date dI = dfI.parse("2013-06-26 16:25:12");
        Date dF = dfF.parse("2013-08-20");
        Utilizador ToexpResult = new Utilizador(25, "Marcelo Gon?alves", "marcel.palma@hotmail.com", "marcelo", "46ed215d4162eb1145147b7e6ffd66ea7891f172", "UALG", dI, dF);
        expResult.add(ToexpResult);        
        assertEquals(expResult, result); //Correcto
        expResult.clear();
        
        dI = dfI.parse("2013-06-26 16:27:36");
        dF = dfF.parse("2013-08-20");
        ToexpResult = new Utilizador(27, "Andr? Santos", "andremlsantos5453@gmail.com", "andre", "bc9800b9d52a24cce72a73dd528afed53f10e5fc", "UALG", dI, dF);
        expResult.add(ToexpResult);        
        assertNotSame(expResult, result); //Errado, utilizador diferente
        expResult.clear();
        
        dI = dfI.parse("2010-06-26 16:27:36");
        dF = dfF.parse("2010-08-20");
        ToexpResult = new Utilizador(50, "Marcelo Gon?alves", "andremlsantos5453@gmail.com", "andre", "bc9800b9d52a24cce72a73dd528afed53f10e5fc", "UALG", dI, dF);
        expResult.add(ToexpResult);        
        assertNotSame(expResult, result); //Errado, utilizador errado
        expResult.clear();
        
        ToexpResult = new Utilizador();
        expResult.add(ToexpResult);        
        assertNotSame(expResult, result); //Errado, utilizador vazio
    }

    /**
     * Test of likebyemail method, of class UtilizadorFacade.
     */
    @Test
    public void testLikebyemail() throws Exception {
        System.out.println("likebyemail");
        String email = "marcel.palma@hotmail.com";
        List<Utilizador> expResult = new ArrayList();
        List<Utilizador> result = instance.likebyemail(email);
        
        DateFormat dfI = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        DateFormat dfF = new SimpleDateFormat("yyyy-mm-dd");
        Date dI = dfI.parse("2013-06-26 16:25:12");
        Date dF = dfF.parse("2013-08-20");
        Utilizador ToexpResult = new Utilizador(25, "Marcelo Gon?alves", "marcel.palma@hotmail.com", "marcelo", "46ed215d4162eb1145147b7e6ffd66ea7891f172", "UALG", dI, dF);
        expResult.add(ToexpResult);        
        assertEquals(expResult, result); //Correcto
        expResult.clear();
        
        dI = dfI.parse("2013-06-26 16:27:36");
        dF = dfF.parse("2013-08-20");
        ToexpResult = new Utilizador(27, "Andr? Santos", "andremlsantos5453@gmail.com", "andre", "bc9800b9d52a24cce72a73dd528afed53f10e5fc", "UALG", dI, dF);
        expResult.add(ToexpResult);        
        assertNotSame(expResult, result); //Errado, utilizador diferente
        expResult.clear();
        
        dI = dfI.parse("2010-06-26 16:27:36");
        dF = dfF.parse("2010-08-20");
        ToexpResult = new Utilizador(50, "Andr? Santos", "marcel.palma@hotmail.com", "andre", "bc9800b9d52a24cce72a73dd528afed53f10e5fc", "UALG", dI, dF);
        expResult.add(ToexpResult);        
        assertNotSame(expResult, result); //Errado, utilizador errado
        expResult.clear();
        
        ToexpResult = new Utilizador();
        expResult.add(ToexpResult);        
        assertNotSame(expResult, result); //Errado, utilizador vazio
    }

    /**
     * Test of likebyusername method, of class UtilizadorFacade.
     */
    @Test
    public void testLikebyusername() throws Exception {
        System.out.println("likebyusername");
        String username = "marcelo";
        List<Utilizador> expResult = new ArrayList();
        List<Utilizador> result = instance.likebyusername(username);
        
        DateFormat dfI = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        DateFormat dfF = new SimpleDateFormat("yyyy-mm-dd");
        Date dI = dfI.parse("2013-06-26 16:25:12");
        Date dF = dfF.parse("2013-08-20");
        Utilizador ToexpResult = new Utilizador(25, "Marcelo Gon?alves", "marcel.palma@hotmail.com", "marcelo", "46ed215d4162eb1145147b7e6ffd66ea7891f172", "UALG", dI, dF);
        expResult.add(ToexpResult);        
        assertEquals(expResult, result); //Correcto
        expResult.clear();
        
        dI = dfI.parse("2013-06-26 16:27:36");
        dF = dfF.parse("2013-08-20");
        ToexpResult = new Utilizador(27, "Andr? Santos", "andremlsantos5453@gmail.com", "andre", "bc9800b9d52a24cce72a73dd528afed53f10e5fc", "UALG", dI, dF);
        expResult.add(ToexpResult);        
        assertNotSame(expResult, result); //Errado, utilizador diferente
        expResult.clear();
        
        dI = dfI.parse("2010-06-26 16:27:36");
        dF = dfF.parse("2010-08-20");
        ToexpResult = new Utilizador(50, "Andr? Santos", "andremlsantos5453@gmail.com", "marcelo", "bc9800b9d52a24cce72a73dd528afed53f10e5fc", "UALG", dI, dF);
        expResult.add(ToexpResult);        
        assertNotSame(expResult, result); //Errado, utilizador errado
        expResult.clear();
        
        ToexpResult = new Utilizador();
        expResult.add(ToexpResult);        
        assertNotSame(expResult, result); //Errado, utilizador vazio
    }
}