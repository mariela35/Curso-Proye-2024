package ar.org.centro35.colegio.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.org.centro35.colegio.connectors.Connector;
import ar.org.centro35.colegio.entities.Alumnos;

public class AlumnosRepository {


    private Connection conn=Connector.getConnection();

    public void save(Alumnos alumno){
        if(alumno == null) return;
        try (PreparedStatement ps=conn.prepareStatement(
        "INSERT INTO alumnos (idcurso, nombre, apellido, edad) values (?,?,?,?)",   
        PreparedStatement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, alumno.getIdcurso());
                ps.setString(2, alumno.getNombre());
                ps.setString(3, alumno.getApellido());
                ps.setInt(4, alumno.getEdad());                
                ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) alumno.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void remove(Alumnos alumno){
        if(alumno==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from alumnos where id=?")){
            ps.setInt(1, alumno.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Alumnos> getAll() {
        List<Alumnos> list = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM alumnos")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int idCurso = rs.getInt("idcurso");    
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                list.add(new Alumnos(id, nombre, apellido, edad, idCurso));
                             
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Alumnos getById(int id){
        return getAll()
                        .stream()
                        .filter(alumno->alumno.getId()==id)
                        .findAny()
                        .orElse(new Alumnos());
    }

    public List<Alumnos> getLikeNombre(String nombre){
        if(nombre==null) return new ArrayList<>();
        return getAll()
                        .stream()
                        .filter(alumno->alumno.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                        .toList();
    }
}
