/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Tratamento;
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
public class TratamentoFacadeTest {
    
    private static EJBContainer TRTcontainer;
    private static TratamentoFacade instance;
    
    public TratamentoFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("build/jar"));
        TRTcontainer = EJBContainer.createEJBContainer(properties);
        System.out.println("Opening the container");
    }
    
    @AfterClass
    public static void tearDownClass() {
        TRTcontainer.close();
        System.out.println("Closing the container");
    }
    
    @Before
    public void setUp() throws NamingException {
        instance = (TratamentoFacade)TRTcontainer.getContext().lookup("java:global/classes/TratamentoFacade");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTratamentoByReferencia method, of class TratamentoFacade.
     */
    @Test
    public void testGetTratamentoByReferencia() throws Exception {
        System.out.println("getTratamentoByReferencia");
        int id = 11;
        Tratamento result = instance.getTratamentoByReferencia(id);        
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        
        Date d = df.parse("2013-04-14 16:29:02");
        Tratamento expResult = new Tratamento(11, "lixivia", 15.3, "Profilatico", 97.0, 14.0, d);        
        assertEquals(expResult, result); //Correcto
        
        d = df.parse("2013-04-14 01:00:00");
        expResult = new Tratamento(12, "sais minerais", 23.0, "Terapeutico", 45.0, 1.3, d);        
        assertNotSame(expResult, result); //Errado, Tratamento diferente
        
        d = df.parse("2010-04-14 01:00:00");
        expResult = new Tratamento(11, "sais minerais", 12.0, "Terapeutico", 40.0, 1.1, d);        
        assertNotSame(expResult, result); //Errado, Tratamento nao existe
        
        expResult = new Tratamento();        
        assertNotSame(expResult, result); //Errado, Tratamento vazio        
    }

    /**
     * Test of likeByAgente method, of class TratamentoFacade.
     */
    @Test
    public void testLikeByAgente() throws Exception {
        System.out.println("likeByAgente");
        String search = "lixivia";
        List<Tratamento> result = instance.likeByAgente(search);
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        List<Tratamento> expResult = new ArrayList();
        
        Date d = df.parse("2013-04-14 16:29:02");
        Tratamento ToexpResult = new Tratamento(11, "lixivia", 15.3, "Profilatico", 97.0, 14.0, d);
        expResult.add(ToexpResult);
        assertEquals(expResult, result); //Correcto
        expResult.clear();
        
        d = df.parse("2013-04-14 01:00:00");
        ToexpResult = new Tratamento(12, "sais minerais", 23.0, "Terapeutico", 45.0, 1.3, d);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, Tratamento diferente
        expResult.clear();
        
        d = df.parse("2010-04-14 01:00:00");
        ToexpResult = new Tratamento(12, "lixivia", 12.0, "Terapeutico", 40.0, 1.1, d);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, Tratamento nao existe
        expResult.clear();
        
        ToexpResult = new Tratamento();
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, Tratamento vazio
    }

    /**
     * Test of likeByTipo method, of class TratamentoFacade.
     */
    @Test
    public void testLikeByTipo() throws Exception {
        System.out.println("likeByTipo");
        String search = "Terapeutico";
        List<Tratamento> result = instance.likeByTipo(search);
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        List<Tratamento> expResult = new ArrayList();
        
        Date d = df.parse("2013-04-14 01:00:00");
        Tratamento ToexpResult = new Tratamento(12, "sais minerais", 23.0, "Terapeutico", 45.0, 1.3, d);
        expResult.add(ToexpResult);
        assertEquals(expResult, result); //Correcto
        expResult.clear();
        
        d = df.parse("2013-04-14 16:29:02");
        ToexpResult = new Tratamento(11, "lixivia", 15.3, "Profilatico", 97.0, 14.0, d);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, Tratamento diferente
        expResult.clear();
        
        d = df.parse("2013-04-14 16:29:02");
        ToexpResult = new Tratamento(11, "lixivia", 15.3, "Terapeutico", 97.0, 14.0, d);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, Tratamento nao existe
        expResult.clear();
        
        ToexpResult = new Tratamento();
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, Tratamento vazio
    }
}