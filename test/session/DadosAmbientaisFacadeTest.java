/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.DadosAmbientais;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
public class DadosAmbientaisFacadeTest {
    
    private static EJBContainer DAcontainer;
    private static DadosAmbientaisFacade instance;
    
    public DadosAmbientaisFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("build/jar"));
        DAcontainer = EJBContainer.createEJBContainer(properties);
        System.out.println("Opening the container");
    }
    
    @AfterClass
    public static void tearDownClass() {
        DAcontainer.close();
        System.out.println("Closing the container");
    }
    
    @Before
    public void setUp() throws NamingException {
        instance = (DadosAmbientaisFacade)DAcontainer.getContext().lookup("java:global/classes/DadosAmbientaisFacade");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDadosAmbientaisById method, of class DadosAmbientaisFacade.
     */
    @Test
    public void testGetDadosAmbientaisById() throws Exception {
        System.out.println("getDadosAmbientaisById");
        int id = 9;
        DadosAmbientais result = instance.getDadosAmbientaisById(id);
        
        //Estes passos sao necessarios para utilizar datas
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date d = df.parse("2013-05-17 11:33:19");
        
        DadosAmbientais expResult = new DadosAmbientais(9, 32, 23, 13.03, d);
        assertEquals(expResult, result); //Correcto
        
        d = df.parse("2013-06-26 15:00:42");
        expResult = new DadosAmbientais(11, 20.1, 12, 45, d);
        assertNotSame(expResult, result); //Errado, estes sao outros dados ambientais
        
        d = df.parse("2013-06-26 15:00:42");
        expResult = new DadosAmbientais(9, 20.1, 12, 45, d);
        assertNotSame(expResult, result); //Errado, estes dados ambientais nao existem
        
        expResult = new DadosAmbientais();
        assertNotSame(expResult, result); //Errado, dados ambientais vazios
    }
}