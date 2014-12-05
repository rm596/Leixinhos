/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Tanque;
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
public class TanqueFacadeTest {
    
    private static EJBContainer Tcontainer;
    private static TanqueFacade instance;
    
    public TanqueFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("build/jar"));
        Tcontainer = EJBContainer.createEJBContainer(properties);
        System.out.println("Opening the container");
    }
    
    @AfterClass
    public static void tearDownClass() {
        Tcontainer.close();
        System.out.println("Closing the container");
    }
    
    @Before
    public void setUp() throws NamingException {
        instance = (TanqueFacade)Tcontainer.getContext().lookup("java:global/classes/TanqueFacade");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of likeTanqueByLocal method, of class TanqueFacade.
     */
    @Test
    public void testLikeTanqueByLocal() throws Exception {
        System.out.println("likeTanqueByLocal");
        String search = "Campus das Gambelas";
        List<Tanque> result = instance.likeTanqueByLocal(search);
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        List<Tanque> expResult = new ArrayList();
        
        Date d = df.parse("2013-06-26");
        Tanque ToexpResult = new Tanque(1, 300.0, "Campus das Gambelas", d, "Usado");
        expResult.add(ToexpResult);
        
        d = df.parse("2013-04-24");
        ToexpResult = new Tanque(2, 200.0, "Campus das Gambelas", d, "Quarentena");
        expResult.add(ToexpResult);
        
        d = df.parse("2013-04-26");
        ToexpResult = new Tanque(3, 100.0, "Campus das Gambelas", d, "Livre");
        expResult.add(ToexpResult);
        
        assertEquals(expResult, result); //Correcto
        expResult.clear();
        
        d = df.parse("2013-06-26");
        ToexpResult = new Tanque(20, 310.0, "Campus", d, "Livre");
        expResult.add(ToexpResult);
        
        d = df.parse("2013-04-24");
        ToexpResult = new Tanque(22, 210.0, "Campus", d, "Livre");
        expResult.add(ToexpResult);
        
        d = df.parse("2013-04-26");
        ToexpResult = new Tanque(30, 110.0, "Gambelas", d, "Livre");
        expResult.add(ToexpResult);
        
        assertNotSame(expResult, result); //Errado, Tanques nao existem
        expResult.clear();
         
        ToexpResult = new Tanque();
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, Tanque vazio        
    }

    /**
     * Test of likeTanqueByeEstado method, of class TanqueFacade.
     */
    @Test
    public void testLikeTanqueByeEstado() throws Exception {
        System.out.println("likeTanqueByeEstado");
        String search = "Usado";
        List<Tanque> result = instance.likeTanqueByeEstado(search);
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        
        Date d = df.parse("2013-06-26");
        List<Tanque> expResult = new ArrayList();
        Tanque ToexpResult = new Tanque(1, 300.0, "Campus das Gambelas", d, "Usado");
        expResult.add(ToexpResult);
        assertEquals(expResult, result); //Correcto
        expResult.clear();
        
        d = df.parse("2013-04-24");
        ToexpResult = new Tanque(4, 600.0, "Campus da Penha", d, "Quarentena");
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, Tanque diferente
        expResult.clear();
        
        d = df.parse("2013-04-24");
        ToexpResult = new Tanque(4, 600.0, "Campus da Penha", d, "Usado");
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, Tanque nao existe
        expResult.clear(); 
        
        ToexpResult = new Tanque();
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, Tanque vazio
    }

    /**
     * Test of getTanqueById method, of class TanqueFacade.
     */
    @Test
    public void testGetTanqueById() throws Exception {
        System.out.println("getTanqueById");
        int id = 1;
        Tanque result = instance.getTanqueById(id);
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        
        Date d = df.parse("2013-06-26");
        Tanque expResult = new Tanque(1, 300.0, "Campus das Gambelas", d, "Usado");
        assertEquals(expResult, result); //Correcto
        
        d = df.parse("2013-04-24");
        expResult = new Tanque(4, 600.0, "Campus da Penha", d, "Quarentena");
        assertNotSame(expResult, result); //Errado, Tanque diferente
        
        d = df.parse("2013-04-24");
        expResult = new Tanque(1, 600.0, "Campus da Penha", d, "Quarentena");
        assertNotSame(expResult, result); //Errado, Tanque nao existe        
        
        expResult = new Tanque();
        assertNotSame(expResult, result); //Errado, Tanque vazio        
    }
}