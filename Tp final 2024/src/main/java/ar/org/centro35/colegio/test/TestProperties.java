package ar.org.centro35.colegio.test;

import java.time.LocalDate;

public class TestProperties {
    public static void main(String[] args) {
        System.getProperties().forEach((k,v)->System.out.println(k+" - "+v));

        System.out.println(LocalDate.now()
                                    .toString()
                                    .replace("-", "/"));
    }
}
