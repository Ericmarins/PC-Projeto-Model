/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Documento;
import br.edu.ifsul.modelo.Encontro;
import br.edu.ifsul.modelo.Ficha;
import br.edu.ifsul.modelo.Tipo;
import br.edu.ifsul.modelo.Usuario;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
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
public class TestePersistirFicha {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirFicha() {
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
            Ficha obj = new Ficha();
            obj.setSemestre("6° Semestre");
            obj.setTema("Sistema de gerenciamento dos encontros de orientação.");
            Usuario professor= em.find(Usuario.class, 1);
            obj.setProfessor(professor);
            Usuario aluno= em.find(Usuario.class, 1);
            obj.setAluno(aluno);
            obj.setTipo(em.find(Tipo.class, 1));
            obj.setCurso(em.find(Curso.class, 1));
            
            Encontro encontro= new Encontro();
            encontro.setDia(Calendar.getInstance());
            encontro.setAssuntos("Cronologia e andamento do trabalho.");
            encontro.setHoraFinal(Calendar.getInstance());
            encontro.setHoraInicial(Calendar.getInstance());

            Documento documento= new Documento();
            String path = "C:\\Users\\eric_\\Desktop\\TSPI\\6° Semestre\\PCII\\PC_I.doc";
            File arq = new File(path);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            FileInputStream in = new FileInputStream(arq);
            int b;
            while((b = in.read())>-1){
               out.write(b);
            }
            out.close();
            in.close();
            byte[] array = out.toByteArray();
            documento.setVersaoAtual(array);
            documento.setDataVersao(Calendar.getInstance());
            
            obj.adicionarEncontro(encontro);
            obj.adicionarDocumento(documento);
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}
