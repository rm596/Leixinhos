/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Intervencao;
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
public class IntervencaoFacadeTest {
    
    private static EJBContainer ITcontainer;
    private static IntervencaoFacade instance;
    
    public IntervencaoFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("build/jar"));
        ITcontainer = EJBContainer.createEJBContainer(properties);
        System.out.println("Opening the container");
    }
    
    @AfterClass
    public static void tearDownClass() {
        ITcontainer.close();
        System.out.println("Closing the container");
    }
    
    @Before
    public void setUp() throws NamingException {
        instance = (IntervencaoFacade)ITcontainer.getContext().lookup("java:global/classes/IntervencaoFacade");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of likeByTipo method, of class IntervencaoFacade.
     */
    @Test
    public void testLikeByTipo() throws Exception {
        System.out.println("likeByTipo");
        String search = "Adicao";
        List<Intervencao> expResult = new ArrayList();         
        List<Intervencao> result = instance.likeByTipo(search);       
        
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date d = df.parse("2013-06-26 14:58:03");        
        Intervencao ToexpResult = new Intervencao(15, "Nova chegada de peixes", "Adicao", d, "carapau", 10);     
        expResult.add(ToexpResult);
        assertEquals(expResult, result); //Correcto
        
        d = df.parse("2013-06-26 14:57:01");        
        ToexpResult = new Intervencao(14, "Retiro de atuns para experiencia", "Remocao", d, "Atum", 8);     
        expResult.add(ToexpResult);        
        assertNotSame(expResult, result); //Errado, nao e a mesma intervenca
        
        d = df.parse("2013-06-26 14:57:01");        
        ToexpResult = new Intervencao(14, "Retiro de atuns para experiencia", "Adicao", d, "Atum", 8);     
        expResult.add(ToexpResult);        
        assertNotSame(expResult, result); //Errado, esta intervencao nao existe
              
        ToexpResult = new Intervencao();     
        expResult.add(ToexpResult);        
        assertNotSame(expResult, result); //Errado, intervanecao vazia
    }

    /**
     * Test of likeByEspecie method, of class IntervencaoFacade.
     */
    @Test
    public void testLikeByEspecie() throws Exception {
        System.out.println("likeByEspecie");
        String search = "carapau";
        List<Intervencao> expResult = new ArrayList();   
        List<Intervencao> result = instance.likeByEspecie(search);     
        
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date d = df.parse("2013-06-26 14:58:03");        
        Intervencao ToexpResult = new Intervencao(15, "Nova chegada de peixes", "Adicao", d, "carapau", 10);     
        expResult.add(ToexpResult);        
        assertEquals(expResult, result); //Correcto
        
        d = df.parse("2013-06-26 14:57:01");        
        ToexpResult = new Intervencao(14, "Retiro de atuns para experiencia", "Remocao", d, "Atum", 8);     
        expResult.add(ToexpResult);        
        assertNotSame(expResult, result); //Errado, esta e outra intervencao
        
        d = df.parse("2013-06-26 14:57:01");        
        ToexpResult = new Intervencao(14, "Retiro de atuns para experiencia", "Remocao", d, "carapau", 8);     
        expResult.add(ToexpResult);        
        assertNotSame(expResult, result); //Errado, esta intervencao nao existe
              
        ToexpResult = new Intervencao();     
        expResult.add(ToexpResult);        
        assertNotSame(expResult, result); //Errado, intervencao vazia
    }

    /**
     * Test of getIntervencaoById method, of class IntervencaoFacade.
     */
    @Test
    public void testGetIntervencaoById() throws Exception {
        System.out.println("getIntervencaoById");
        int id = 14;
        Intervencao result = instance.getIntervencaoById(id);
        
        //Estes passos sao necessarios para utilizar datas
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date d = df.parse("2013-06-26 14:57:01");
        
        Intervencao expResult = new Intervencao(14, "Retiro de atuns para experiencia", "Remocao", d, "Atum", 8);
        assertEquals(expResult, result); //Correcto
        
        d = df.parse("2013-06-26 14:58:03");
        expResult = new Intervencao(15, "Nova chegada de peixes", "Adicao", d, "carapau", 10);
        assertNotSame(expResult, result); //Errado, esta e outra intervencao
        
        d = df.parse("2013-06-26 14:58:03");
        expResult = new Intervencao(14, "Nova chegada de peixes", "Adicao", d, "carapau", 10);
        assertNotSame(expResult, result); //Errado, esta intervencao nao existe
        
        expResult = new Intervencao();
        assertNotSame(expResult, result); //Errado, intervencao vazia
    }
}