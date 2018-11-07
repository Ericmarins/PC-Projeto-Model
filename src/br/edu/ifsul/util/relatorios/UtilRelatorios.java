/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util.relatorios;


import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Encontro;
import br.edu.ifsul.modelo.Ficha;
import br.edu.ifsul.modelo.Tipo;
import br.edu.ifsul.modelo.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
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

        Encontro encontro= new Encontro();
        encontro.setDia(Calendar.getInstance());
        encontro.setHoraFinal(Calendar.getInstance());        
        encontro.setHoraInicial(Calendar.getInstance());
        encontro.setAssuntos("Assuntos tratados no encontro: Apresentação do que"
                + " deve ser desenvolvido durante o PC1. Definição das tarefas "
                + "para o próximo encontro. Tarefas para o próximo encontro: "
                + "Desenvolver a primeira versão do relatório até o tópico"
                + " Justificativa; Pesquisas sobre trabalhos relacionados;");
        obj.getEncontros().add(encontro);
        
        Encontro encontro2= new Encontro();
        encontro2.setDia(Calendar.getInstance());
        encontro2.setHoraFinal(Calendar.getInstance());        
        encontro2.setHoraInicial(Calendar.getInstance());
        encontro2.setAssuntos("Assuntos tratados no encontro: Apresentação do que"
                + " deve ser desenvolvido durante o PC1. Definição das tarefas "
                + "para o próximo encontro. Tarefas para o próximo encontro: "
                + "Desenvolver a primeira versão do relatório até o tópico"
                + " Justificativa; Pesquisas sobre trabalhos relacionados;");
        obj.getEncontros().add(encontro2);
        
        Encontro encontro3= new Encontro();
        encontro3.setDia(Calendar.getInstance());
        encontro3.setHoraFinal(Calendar.getInstance());        
        encontro3.setHoraInicial(Calendar.getInstance());
        encontro3.setAssuntos("Assuntos tratados no encontro: Apresentação do que"
                + " deve ser desenvolvido durante o PC1. Definição das tarefas "
                + "para o próximo encontro. Tarefas para o próximo encontro: "
                + "Desenvolver a primeira versão do relatório até o tópico"
                + " Justificativa; Pesquisas sobre trabalhos relacionados;");
        obj.getEncontros().add(encontro3);
        
        Encontro encontro4= new Encontro();
        encontro4.setDia(Calendar.getInstance());
        encontro4.setHoraFinal(Calendar.getInstance());        
        encontro4.setHoraInicial(Calendar.getInstance());
        encontro4.setAssuntos("Assuntos tratados no encontro: Apresentação do que"
                + " deve ser desenvolvido durante o PC1. Definição das tarefas "
                + "para o próximo encontro. Tarefas para o próximo encontro: "
                + "Desenvolver a primeira versão do relatório até o tópico"
                + " Justificativa; Pesquisas sobre trabalhos relacionados;");
        obj.getEncontros().add(encontro4);
        
        lista.add(obj);
        

        return lista;
    }
}
