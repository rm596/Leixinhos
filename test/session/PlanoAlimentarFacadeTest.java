/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.PlanoAlimentar;
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
public class PlanoAlimentarFacadeTest {
    
    private static EJBContainer PAcontainer;
    private static PlanoAlimentarFacade instance;
    
    public PlanoAlimentarFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("build/jar"));
        PAcontainer = EJBContainer.createEJBContainer(properties);
        System.out.println("Opening the container");
    }
    
    @AfterClass
    public static void tearDownClass() {
        PAcontainer.close();
        System.out.println("Closing the container");
    }
    
    @Before
    public void setUp() throws NamingException {
        instance = (PlanoAlimentarFacade)PAcontainer.getContext().lookup("java:global/classes/PlanoAlimentarFacade");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of consultarTodosPlanos method, of class PlanoAlimentarFacade.
     */
    @Test
    public void testConsultarTodosPlanos() throws Exception {
        System.out.println("consultarTodosPlanos");
        List<PlanoAlimentar> expResult = new ArrayList();
        List<PlanoAlimentar> result = instance.consultarTodosPlanos();
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        
        Date d = df.parse("2013-04-14 17:04:39");
        PlanoAlimentar ToexpResult = new PlanoAlimentar(2, "ração", d, 5.0, "deitar no tanque", 3);
        expResult.add(ToexpResult);
        
        d = df.parse("2013-04-14 17:05:22");
        ToexpResult = new PlanoAlimentar(3, "ração", d, 2.0, "à mão", 4);
        expResult.add(ToexpResult);
        
        d = df.parse("2013-04-14 17:05:40");
        ToexpResult = new PlanoAlimentar(4, "ração", d, 1.0, "deitar no tanque", 1);
        expResult.add(ToexpResult);
        
        d = df.parse("2013-06-26 14:59:43");
        ToexpResult = new PlanoAlimentar(7, "Sera Vipan", d, 5.0, "Deitar na gua", 5);
        expResult.add(ToexpResult);
        assertEquals(expResult, result); //Correcto
        expResult.clear();
        
        d = df.parse("2013-04-14 17:04:39");
        ToexpResult = new PlanoAlimentar(10, "ração", d, 5.0, "deitar no tanque", 3);
        expResult.add(ToexpResult);
        
        d = df.parse("2013-04-14 17:05:22");
        ToexpResult = new PlanoAlimentar(11, "ração", d, 2.0, "à mão", 4);
        expResult.add(ToexpResult);
        
        d = df.parse("2013-04-14 17:05:40");
        ToexpResult = new PlanoAlimentar(12, "ração", d, 1.0, "deitar no tanque", 1);
        expResult.add(ToexpResult);
        
        d = df.parse("2013-06-26 14:59:43");
        ToexpResult = new PlanoAlimentar(13, "Sera Vipan", d, 5.0, "Deitar na gua", 5);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, PlanosAlimentares nao existem
        expResult.clear();
        
        ToexpResult = new PlanoAlimentar();
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, nao tem PlanosAlimentares
    }

    /**
     * Test of getPlanById method, of class PlanoAlimentarFacade.
     */
    @Test
    public void testGetPlanById() throws Exception {
        System.out.println("getPlanById");
        int id = 7;
        PlanoAlimentar result = instance.getPlanById(id);
        
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date d = df.parse("2013-06-26 14:59:43");
        PlanoAlimentar expResult = new PlanoAlimentar(7, "Sera Vipan", d, 5.0, "Deitar na gua", 5);
        assertEquals(expResult, result); //Correcto
        
        d = df.parse("2013-04-14 17:05:40");
        expResult = new PlanoAlimentar(4, "ração", d, 1.0, "deitar no tanque", 1);
        assertNotSame(expResult, result); //Errado, PlanoAlimentar diferente
        
        d = df.parse("2013-04-14 17:05:40");
        expResult = new PlanoAlimentar(7, "ração", d, 1.0, "deitar no tanque", 1);
        assertNotSame(expResult, result); //Errado, PlanoAlimentar nao existe
        
        expResult = new PlanoAlimentar();
        assertNotSame(expResult, result); //Errado, PlanoAlimentar vazio
    }
}