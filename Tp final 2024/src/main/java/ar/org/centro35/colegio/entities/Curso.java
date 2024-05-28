package ar.org.centro35.colegio.entities;

import ar.org.centro35.colegio.enums.Dia;
import ar.org.centro35.colegio.enums.Turno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //toString //getter //setter //equal //hashcode
@AllArgsConstructor //constructor
@NoArgsConstructor  //Constructor vacio
public class Curso {
    private int id;
    private String titulo;
    private String profesor;
    private Dia dia;
    private Turno turno;
}
