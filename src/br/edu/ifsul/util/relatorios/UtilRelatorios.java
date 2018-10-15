/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util.relatorios;


import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Ficha;
import br.edu.ifsul.modelo.Tipo;
import br.edu.ifsul.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric_
 */
public class UtilRelatorios {    
    public static List<Ficha> carregarFichas(){
        List<Ficha> lista= new ArrayList<>();

        Ficha obj = new Ficha();
        obj.setSemestre("6° Semestre");
        obj.setTema("Sistema de gerenciamento dos encontros de orientação.");
        Usuario professor= new Usuario();
        professor.setNome("Jorge");
        obj.setProfessor(professor);
        Usuario aluno= new Usuario();
        aluno.setNome("Eric");
        obj.setAluno(aluno);
        Tipo tipo= new Tipo();
        tipo.setDescricao("teste");
        obj.setTipo(tipo);
        Curso curso= new Curso();
        curso.setDescricao("teste");
        obj.setCurso(curso);

        lista.add(obj);
        
        Ficha obj2 = new Ficha();
        obj2.setSemestre("6° Semestre 2");
        obj2.setTema("Sistema de gerenciamento dos encontros de orientação.2");
        Usuario professor2= new Usuario();
        professor2.setNome("Jorge2");
        obj2.setProfessor(professor);
        Usuario aluno2= new Usuario();
        aluno2.setNome("Eric2");
        obj2.setAluno(aluno);
        Tipo tipo2= new Tipo();
        tipo2.setDescricao("teste2");
        obj2.setTipo(tipo);
        Curso curso2= new Curso();
        curso2.setDescricao("teste2");
        obj2.setCurso(curso);
        
        lista.add(obj2);

        return lista;
    }
}
