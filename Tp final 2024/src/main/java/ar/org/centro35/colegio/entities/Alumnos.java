package ar.org.centro35.colegio.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //toString //getter //setter //equal //hashcode
@AllArgsConstructor //constructor
@NoArgsConstructor  //Constructor vacio

public class Alumnos {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private int idcurso;

    
}
