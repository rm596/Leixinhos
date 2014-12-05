/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TipoManutencao;
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
public class TipoManutencaoFacadeTest {
    
    private static EJBContainer TMcontainer;
    private static TipoManutencaoFacade instance;
    
    public TipoManutencaoFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("build/jar"));
        TMcontainer = EJBContainer.createEJBContainer(properties);
        System.out.println("Opening the container");
    }
    
    @AfterClass
    public static void tearDownClass() {
        TMcontainer.close();
        System.out.println("Closing the container");
    }
    
    @Before
    public void setUp() throws NamingException {
        instance = (TipoManutencaoFacade)TMcontainer.getContext().lookup("java:global/classes/TipoManutencaoFacade");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTipoManutencaoById method, of class TipoManutencaoFacade.
     */
    @Test
    public void testGetTipoManutencaoById() throws Exception {
        System.out.println("getTipoManutencaoById");
        int id = 1;
        TipoManutencao result = instance.getTipoManutencaoById(id);
        
        TipoManutencao expResult = new TipoManutencao(1, "Limpar vidros", "1", "semanal");
        assertEquals(expResult, result); //Correcto
        
        expResult = new TipoManutencao(2, "Retirar água", "2", "ocasional");
        assertNotSame(expResult, result); //Errado, TipoManutencao diferente
        
        expResult = new TipoManutencao(20, "Retirar água", "2", "ocasional");
        assertNotSame(expResult, result); //Errado, TipoManutencao nao existe
        
        expResult = new TipoManutencao();
        assertNotSame(expResult, result); //Errado, TipoManutencao vazia
        
    }
}