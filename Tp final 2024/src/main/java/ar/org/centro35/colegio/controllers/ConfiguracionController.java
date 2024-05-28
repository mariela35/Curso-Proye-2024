package ar.org.centro35.colegio.controllers;

import java.net.InetAddress;
import java.time.LocalDate;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.org.centro35.colegio.connectors.Connector;

@Controller
public class ConfiguracionController {
    
    @GetMapping("/configuracion")
    public String getConfiguracion(Model model) {
        String so=System.getProperty("os.name")+" "+System.getProperty("os.version")+" "+System.getProperty("os.arch");
        String java=System.getProperty("java.vm.vendor")+" "+System.getProperty("java.vm.version")+" "+System.getProperty("java.version.date");
        String user=System.getProperty("user.name");
        String ubicacion=Calendar
                                    .getInstance()
                                    .getTimeZone()
                                    .getID()
                                    .replace("/", " ")
                                    .replace("_", " ");
        String ip="";
        String bd=Connector.getUrl();
        String date=LocalDate.now()
                                    .toString()
                                    .replace("-", "/");
        try {
            ip=InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            System.out.println(e);
        }

        model.addAttribute("so", so);
        model.addAttribute("java", java);
        model.addAttribute("user", user);
        model.addAttribute("ubicacion", ubicacion);
        model.addAttribute("ip", ip);
        model.addAttribute("bd", bd);
        model.addAttribute("date", date);
        return "configuracion";
    }

}
