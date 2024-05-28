package ar.org.centro35.colegio.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDateTime;

import ar.org.centro35.colegio.connectors.Connector;


public class TestConnection {

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        LocalDateTime horaInicial=LocalDateTime.now();
        try (Connection conn = Connector.getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery("select * from cursos");
            if (rs.next()) {
                System.out.println(rs.getString("titulo"));
                System.out.println(ANSI_GREEN+"OK - Se conecto a la BD"+ANSI_RESET);
                LocalDateTime horaFinal=LocalDateTime.now();
                Duration duration=Duration.between(horaInicial, horaFinal);
                //System.out.println(duration.getSeconds());
                if(duration.getSeconds()>1){
                    System.out.println(ANSI_RED+"Error - tiempo de conexión muy lento! "+duration.getSeconds()+" segundos"+ANSI_RESET);
                }else{
                    System.out.println(ANSI_GREEN+"OK - Velocidad de conexión correcta! "+duration.getSeconds()+" segundos"+ANSI_RESET);
                }
            } else {
                System.out.println(ANSI_RED+"Error - No se pudo conectar a la BD!"+ANSI_RESET);
            }
        } catch (Exception e) {
            System.out.println(ANSI_RED+"Error - No se pudo conectar a la BD!"+ANSI_RESET);
        }
    }
}
