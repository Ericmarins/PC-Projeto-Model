/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eric_
 */
public class TestePersistirUsuario {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirUsuario() {
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
            Usuario obj = new Usuario();
            obj.setEmail("eric_marins@hotmail.com");
            obj.setNome("Eric");
            obj.setUser("admin");
            obj.setSenha("123456");
            obj.setProfessor(false);
            obj.setTelefone("54996288746");
            Permissao p = em.find(Permissao.class, "ADMINISTRADOR");
            Permissao p1 = em.find(Permissao.class, "ALUNO");
            obj.getPermissoes().add(p);
            obj.getPermissoes().add(p1);
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}
