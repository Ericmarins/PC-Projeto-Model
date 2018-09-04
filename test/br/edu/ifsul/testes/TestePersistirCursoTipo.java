/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Tipo;
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
public class TestePersistirCursoTipo {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirCursoTipo() {
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
            em.getTransaction().begin();
            Curso obj= new Curso();
            obj.setDescricao("TSPI");
            Tipo obj1= new Tipo();
            obj1.setDescricao("PC II");
            em.persist(obj);
            em.persist(obj1);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}
