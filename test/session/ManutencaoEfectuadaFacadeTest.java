/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.ManutencaoEfectuada;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class ManutencaoEfectuadaFacadeTest {
    
    private static EJBContainer MEcontainer;
    private static ManutencaoEfectuadaFacade instance;
    
    public ManutencaoEfectuadaFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("build/jar"));
        MEcontainer = EJBContainer.createEJBContainer(properties);
        System.out.println("Opening the container");
    }
    
    @AfterClass
    public static void tearDownClass() {
        MEcontainer.close();
        System.out.println("Closing the container");
    }
    
    @Before
    public void setUp() throws NamingException {
        instance = (ManutencaoEfectuadaFacade)MEcontainer.getContext().lookup("java:global/classes/ManutencaoEfectuadaFacade");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getManEfectById method, of class ManutencaoEfectuadaFacade.
     */
    @Test
    public void testGetManEfectById() throws Exception {
        System.out.println("getManEfectById");
        int id = 1;
        ManutencaoEfectuada result = instance.getManEfectById(id);
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        
        Date d = df.parse("2013-04-14 15:53:43"); 
        ManutencaoEfectuada expResult = new ManutencaoEfectuada(1, d);        
        assertEquals(expResult, result); //Correcto
        
        d = df.parse("2013-04-14 15:54:40"); 
        expResult = new ManutencaoEfectuada(2, d);        
        assertNotSame(expResult, result); //Errado, ManutencaoEfectuada diferente
        
        d = df.parse("2013-04-14 15:54:40"); 
        expResult = new ManutencaoEfectuada(1, d);        
        assertNotSame(expResult, result); //Errado, ManutencaoEfectuada nao existe
        
        expResult = new ManutencaoEfectuada();        
        assertNotSame(expResult, result); //Errado, ManutencaoEfectuada vazia
    }
}