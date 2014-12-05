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
public class TipoUtilizadorFacadeTest {
    
    private static EJBContainer TUcontainer;
    private static TipoUtilizadorFacade instance;
    
    public TipoUtilizadorFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("build/jar"));
        TUcontainer = EJBContainer.createEJBContainer(properties);
        System.out.println("Opening the container");
    }
    
    @AfterClass
    public static void tearDownClass() {
        TUcontainer.close();
        System.out.println("Closing the container");
    }
    
    @Before
    public void setUp() throws NamingException {
        instance = (TipoUtilizadorFacade)TUcontainer.getContext().lookup("java:global/classes/TipoUtilizadorFacade");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of procurarID method, of class TipoUtilizadorFacade.
     */
    @Test
    public void testProcurarID() throws Exception {
        System.out.println("procurarID");
        int id = 1;
        Object result = instance.procurarID(id);
        
        Object expResult = new TipoUtilizador(1, "Administrador");        
        assertEquals(expResult, result); //Correcto
        
        expResult = new TipoUtilizador(2, "Utilizador Comum");        
        assertNotSame(expResult, result); //Errado, o utilizador nao e deste tipo
        
        expResult = new TipoUtilizador(1, "Utilizador Comum");        
        assertNotSame(expResult, result); //Errado, este TipoUtilizador nao existe
        
        expResult = new TipoUtilizador();        
        assertNotSame(expResult, result); //Errado, TipoUtilizador vazio
    }

    /**
     * Test of likebynome method, of class TipoUtilizadorFacade.
     */
    @Test
    public void testLikebynome() throws Exception {
        System.out.println("likebynome");
        String nome = "Administrador";
        TipoUtilizador result = instance.likebynome(nome);
        
        TipoUtilizador expResult = new TipoUtilizador(1, "Administrador");        
        assertEquals(expResult, result); //Correcto
        
        expResult = new TipoUtilizador(2, "Utilizador Comum");        
        assertNotSame(expResult, result); //Errado, TipoUtilizador diferente
        
        expResult = new TipoUtilizador(2, "Administrador");        
        assertNotSame(expResult, result); //Errado, TipoUtilizador nao existe
        
        expResult = new TipoUtilizador();        
        assertNotSame(expResult, result); //Errado, TipoUtilizador vazio
    }

    /**
     * Test of geTypeById method, of class TipoUtilizadorFacade.
     */
    @Test
    public void testGeTypeById() throws Exception {
        System.out.println("geTypeById");
        int id = 4;
        List<Utilizador> result = instance.geTypeById(id);
        List<Utilizador> expResult = new ArrayList();
        DateFormat dfI = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        DateFormat dfF = new SimpleDateFormat("yyyy-mm-dd");
        
        Date dI = dfI.parse("2013-06-26 16:25:12");
        Date dF = dfF.parse("2013-08-20");
        Utilizador ToexpResult = new Utilizador(25, "Marcelo Gon?alves", "marcel.palma@hotmail.com", "marcelo", "46ed215d4162eb1145147b7e6ffd66ea7891f172", "UALG", dI, dF);
        expResult.add(ToexpResult);
        assertEquals(expResult, result); //Correcto
        expResult.clear();
        
        dI = dfI.parse("2013-06-26 16:23:43");
        dF = dfF.parse("2013-08-20");
        ToexpResult = new Utilizador(24, "Liliana Falcao", "lilimargarida@hotmail.com", "liliana", "55cd92128d2d99f8f263b48c20ad324b34f8e05a", "UALG", dI, dF);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, este nao e o Utilizador certo
        expResult.clear();
        
        dI = dfI.parse("2010-06-26 16:23:43");
        dF = dfF.parse("2010-08-20");
        ToexpResult = new Utilizador(50, "Maria da Luz", "mluz@hotmail.com", "mluz", "55f4dd4fs49gh9f8f263b48c20ad324b34f8e05a", "OUTSIDER", dI, dF);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, este Utilizador nao existe
        expResult.clear();
        
        ToexpResult = new Utilizador();
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, Utilizador vazio
    }
}