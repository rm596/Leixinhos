/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TipoTanque;
import java.io.File;
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
public class TipoTanqueFacadeTest {
    
    private static EJBContainer TTcontainer;
    private static TipoTanqueFacade instance;
    
    public TipoTanqueFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("build/jar"));
        TTcontainer = EJBContainer.createEJBContainer(properties);
        System.out.println("Opening the container");
    }
    
    @AfterClass
    public static void tearDownClass() {
        TTcontainer.close();
        System.out.println("Closing the container");
    }
    
    @Before
    public void setUp() throws NamingException {
        instance = (TipoTanqueFacade)TTcontainer.getContext().lookup("java:global/classes/TipoTanqueFacade");
    }
    
    @After
    public void tearDown() {
    }

     /**
     * Test of gettipoTanqueById method, of class TipoTanqueFacade.
     */
    @Test
    public void testGettipoTanqueById() throws Exception {
        System.out.println("gettipoTanqueById");
        int id = 2;
        TipoTanque result = instance.gettipoTanqueById(id);
        
        TipoTanque expResult = new TipoTanque(2, "A", 500.0, 300.0, 15.6, 0.0, 15.6, 15.62);
        assertEquals(expResult, result); //Correcto
        
        expResult = new TipoTanque(3, "B", 550.0, 400.0, 15.1, 0.0, 15.1, 15.1);
        assertNotSame(expResult, result); //Errado, TipoTanque diferente
        
        expResult = new TipoTanque(2, "B", 550.0, 400.0, 15.1, 0.0, 15.1, 15.1);
        assertNotSame(expResult, result); //Errado, TipoTanque nao existe
        
        expResult = new TipoTanque();
        assertNotSame(expResult, result); //Errado, TipoTanque vazio
    }
}