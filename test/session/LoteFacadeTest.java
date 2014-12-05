/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Lote;
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
public class LoteFacadeTest {
    
    private static EJBContainer Lcontainer;
    private static LoteFacade instance;
    
    public LoteFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("build/jar"));
        Lcontainer = EJBContainer.createEJBContainer(properties);
        System.out.println("Opening the container");
    }
    
    @AfterClass
    public static void tearDownClass() {
        Lcontainer.close();
        System.out.println("Closing the container");
    }
    
    @Before
    public void setUp() throws NamingException {
        instance = (LoteFacade)Lcontainer.getContext().lookup("java:global/classes/LoteFacade");
    }
    
    @After
    public void tearDown() {
    }

     /**
     * Test of likeByEspecie method, of class LoteFacade.
     */
    @Test
    public void testLikeByEspecie() throws Exception {
        System.out.println("likeByEspecie");
        String search = "carapau";
        List<Lote> expResult = new ArrayList();
        List<Lote> result = instance.likeByEspecie(search);
        
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date d = df.parse("2013-06-26 16:05:10");
        Lote ToexpResult = new Lote(1, d, 1, "carapau", "peixinhos", "carapesca", "Quarteira", "Fred", "Leixinhos", 60, 75);
        expResult.add(ToexpResult);
        assertEquals(expResult, result); //Correcto
        expResult.clear();
        
        d = df.parse("2013-06-26 16:11:03");
        ToexpResult = new Lote(3, d, 6, "Atum", "Atum", "Atunesca", "Vila Real", "PVentura", "Pescanova", 95, 67);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote diferente
        expResult.clear();
        
        d = df.parse("2013-06-26 16:11:03");
        ToexpResult = new Lote(3, d, 6, "carapau", "Atum", "Atunesca", "Vila Real", "PVentura", "Pescanova", 95, 67);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote nao existe
        expResult.clear();
        
        ToexpResult = new Lote();
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote vazio
    }

    /**
     * Test of likeByTitular method, of class LoteFacade.
     */
    @Test
    public void testLikeByTitular() throws Exception {
        System.out.println("likeByTitular");
        String search = "Fred";
        List<Lote> expResult = new ArrayList();
        List<Lote> result = instance.likeByTitular(search);
        
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date d = df.parse("2013-06-26 16:05:10");
        Lote ToexpResult = new Lote(1, d, 1, "carapau", "peixinhos", "carapesca", "Quarteira", "Fred", "Leixinhos", 60, 75);
        expResult.add(ToexpResult);
        assertEquals(expResult, result); //Correcto
        expResult.clear();
        
        d = df.parse("2013-06-26 16:11:03");
        ToexpResult = new Lote(3, d, 6, "Atum", "Atum", "Atunesca", "Vila Real", "PVentura", "Pescanova", 95, 67);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote diferente
        expResult.clear();
        
        d = df.parse("2013-06-26 16:11:03");
        ToexpResult = new Lote(3, d, 6, "Atum", "Atum", "Atunesca", "Vila Real", "Fred", "Pescanova", 95, 67);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote nao existe
        expResult.clear();
        
        ToexpResult = new Lote();
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote vazio
    }

    /**
     * Test of likeByTipoContentor method, of class LoteFacade.
     */
    @Test
    public void testLikeByTipoContentor() throws Exception {
        System.out.println("likeByTipoContentor");
        String search = "Plastico";
        List<Lote> expResult = new ArrayList();
        List<Lote> result = instance.likeByTipoContentor(search);
        
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date d = df.parse("2013-06-26 16:05:10");
        Lote ToexpResult = new Lote(1, d, 1, "carapau", "peixinhos", "carapesca", "Quarteira", "Fred", "Leixinhos", 60, 75);
        expResult.add(ToexpResult);
        assertEquals(expResult, result); //Correcto
        expResult.clear();
        
        d = df.parse("2013-06-26 16:11:03");
        ToexpResult = new Lote(3, d, 6, "Atum", "Atum", "Atunesca", "Vila Real", "PVentura", "Pescanova", 95, 67);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote diferente
        expResult.clear();
                
        ToexpResult = new Lote();
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote vazio
    }

    /**
     * Test of likeBySala method, of class LoteFacade.
     */
    @Test
    public void testLikeBySala() throws Exception {
        System.out.println("likeBySala");
        Double search = 1.0;
        List<Lote> expResult = new ArrayList<Lote>();
        List<Lote> result = instance.likeBySala(search);
        
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date d = df.parse("2013-06-26 16:05:10");
        Lote ToexpResult = new Lote(1, d, 1, "carapau", "peixinhos", "carapesca", "Quarteira", "Fred", "Leixinhos", 60, 75);
        expResult.add(ToexpResult);
        assertEquals(expResult, result); //Correcto
        expResult.clear();
        
        d = df.parse("2013-06-26 16:11:03");
        ToexpResult = new Lote(3, d, 6, "Atum", "Atum", "Atunesca", "Vila Real", "PVentura", "Pescanova", 95, 67);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote diferente
        expResult.clear();
        
        d = df.parse("2013-06-26 16:11:03");
        ToexpResult = new Lote(3, d, 1, "Atum", "Atum", "Atunesca", "Vila Real", "PVentura", "Pescanova", 95, 67);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote nao existe
        expResult.clear();
        
        ToexpResult = new Lote();
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote vazio
        
    }

    /**
     * Test of likeByGrupoInvestigacao method, of class LoteFacade.
     */
    @Test
    public void testLikeByGrupoInvestigacao() throws Exception {
        System.out.println("likeByGrupoInvestigacao");
        String search = "Leixinhos";
        List<Lote> expResult = new ArrayList();
        List<Lote> result = instance.likeByGrupoInvestigacao(search);
        
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date d = df.parse("2013-06-26 16:05:10");
        Lote ToexpResult = new Lote(1, d, 1, "carapau", "peixinhos", "carapesca", "Quarteira", "Fred", "Leixinhos", 60, 75);
        expResult.add(ToexpResult);
        assertEquals(expResult, result); //Correcto
        expResult.clear();
        
        d = df.parse("2013-06-26 16:11:03");
        ToexpResult = new Lote(3, d, 6, "Atum", "Atum", "Atunesca", "Vila Real", "PVentura", "Pescanova", 95, 67);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote diferente
        expResult.clear();
        
        d = df.parse("2013-06-26 16:11:03");
        ToexpResult = new Lote(3, d, 6, "Atum", "Atum", "Atunesca", "Vila Real", "PVentura", "Leixinhos", 95, 67);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote nao existe
        expResult.clear();
        
        ToexpResult = new Lote();
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote vazio
    }

    /**
     * Test of likeByOrigem method, of class LoteFacade.
     */
    @Test
    public void testLikeByOrigem() throws Exception {
        System.out.println("likeByOrigem");
        String search = "Quarteira";
        List<Lote> expResult = new ArrayList();
        List<Lote> result = instance.likeByOrigem(search);
        
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date d = df.parse("2013-06-26 16:05:10");
        Lote ToexpResult = new Lote(1, d, 1, "carapau", "peixinhos", "carapesca", "Quarteira", "Fred", "Leixinhos", 60, 75);
        expResult.add(ToexpResult);
        assertEquals(expResult, result); //Correcto
        expResult.clear();
        
        d = df.parse("2013-06-26 16:11:03");
        ToexpResult = new Lote(3, d, 6, "Atum", "Atum", "Atunesca", "Vila Real", "PVentura", "Pescanova", 95, 67);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote diferente
        expResult.clear();
        
        d = df.parse("2013-06-26 16:11:03");
        ToexpResult = new Lote(3, d, 6, "Atum", "Atum", "Atunesca", "Quarteira", "PVentura", "Pescanova", 95, 67);
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote nao existe
        expResult.clear();
        
        ToexpResult = new Lote();
        expResult.add(ToexpResult);
        assertNotSame(expResult, result); //Errado, lote vazio
    }

    /**
     * Test of getLoteById method, of class LoteFacade.
     */
    @Test
    public void testGetLoteById() throws Exception {
        System.out.println("getLoteById");
        int id = 1;
        Lote result = instance.getLoteById(id);
        
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date d = df.parse("2013-06-26 16:05:10");
        Lote expResult = new Lote(1, d, 1, "carapau", "peixinhos", "carapesca", "Quarteira", "Fred", "Leixinhos", 60, 75);
        assertEquals(expResult, result); //Correcto
        
        d = df.parse("2013-06-26 16:11:03");
        expResult = new Lote(3, d, 6, "Atum", "Atum", "Atunesca", "Vila Real", "PVentura", "Pescanova", 95, 67);
        assertNotSame(expResult, result); //Errado, lote diferente
        
        d = df.parse("2013-06-26 16:11:03");
        expResult = new Lote(1, d, 6, "Atum", "Atum", "Atunesca", "Vila Real", "PVentura", "Pescanova", 95, 67);
        assertNotSame(expResult, result); //Errado, lote nao existe
        
        expResult = new Lote();
        assertNotSame(expResult, result); //Errado, lote vazio
    }
}