/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.ClasseTanque;
import java.io.File;
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
public class ClasseTanqueFacadeTest {
        
    private static EJBContainer CTcontainer;
    private static ClasseTanqueFacade instance;
    
    public ClasseTanqueFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("build/jar"));
        CTcontainer = EJBContainer.createEJBContainer(properties);
        System.out.println("Opening the container");
    }
    
    @AfterClass
    public static void tearDownClass() {
        CTcontainer.close();
        System.out.println("Closing the container");
    }
    
    @Before
    public void setUp() throws NamingException {
        instance = (ClasseTanqueFacade)CTcontainer.getContext().lookup("java:global/classes/ClasseTanqueFacade");
    }
    
    @After
    public void tearDown() {
    }

     /**
     * Test of getClasseTanqueById method, of class ClasseTanqueFacade.
     */
    @Test
    public void testGetClasseTanqueById() throws Exception {
        System.out.println("getClasseTanqueById");
        int id = 1;
        ClasseTanque result = instance.getClasseTanqueById(id);
 
        ClasseTanque expResult = new ClasseTanque(1, "A50");
        assertEquals(expResult, result); //Correcto
        
        expResult = new ClasseTanque(2, "B30");
        assertNotSame(expResult, result); //Errado, esta e outra classe de tanque
        
        expResult = new ClasseTanque(1, "B30");
        assertNotSame(expResult, result); //Errado, esta e outra classe de tanque
                
        expResult = new ClasseTanque();
        assertNotSame(expResult, result); //Errado, classe de tanque vazia
    }
}