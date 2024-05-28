package ar.org.centro35.colegio.test;

import ar.org.centro35.colegio.entities.Curso;
import ar.org.centro35.colegio.enums.Dia;
import ar.org.centro35.colegio.enums.Turno;
import ar.org.centro35.colegio.repositories.CursoRepository;

public class TestCursoRepository {
    public static void main(String[] args) {
        CursoRepository cursoRepository=new CursoRepository();
        Curso curso=new Curso(0,"Javascript","Gomez",Dia.JUEVES,Turno.TARDE);
        cursoRepository.save(curso);
        System.out.println(curso);
        System.out.println("********************************************************************");
        System.out.println(cursoRepository.getById(10));
        cursoRepository.remove(cursoRepository.getById(14));
        System.out.println("********************************************************************");
        cursoRepository.getAll().forEach(System.out::println);

        System.out.println("********************************************************************");
        cursoRepository.getLikeTitulo("ja").forEach(System.out::println);

    }
}
