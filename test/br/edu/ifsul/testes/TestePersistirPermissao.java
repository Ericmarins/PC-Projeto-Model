package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author eric_
 */
public class TestePersistirPermissao {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirPermissao() {

    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("PC-ModelPU");
        em = emf.createEntityManager();
    }
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    @Test
    public void teste() {
        boolean exception = false;
        try {
            Permissao p1 = new Permissao();
            p1.setNome("ADMINISTRADOR");
            p1.setDescricao("Usuario administrativo");
            Permissao p2 = new Permissao();
            p2.setNome("ALUNO");
            p2.setDescricao("Usuario aluno");
            Permissao p3= new Permissao();
            p3.setNome("PROFESSOR");
            p3.setDescricao("Usuario professor");
            em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
