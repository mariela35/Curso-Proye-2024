package ar.org.centro35.colegio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro35.colegio.entities.Alumnos;
import ar.org.centro35.colegio.repositories.AlumnosRepository;

@Controller
public class AlumnosController {
      private AlumnosRepository alumnosRepository=new AlumnosRepository();
    private String mensajeAlumno="Ingrese un nuevo alumno!";
    

    @GetMapping("/alumnos")
    public String getAlumno(@RequestParam(name = "buscar", defaultValue = "") String buscar,Model model) {
        model.addAttribute("mensaje", mensajeAlumno);
        model.addAttribute("alumno", new Alumnos());
        //model.addAttribute("all", alumnoRepository.getAll());
        model.addAttribute("likeNombre", alumnosRepository.getLikeNombre(buscar));
        return "alumnos";
    }

    @PostMapping("/alumnosSave")
    public String alumnosSave(@ModelAttribute Alumnos alumno) {
        //System.out.println("*************************************************");
        //System.out.println("-- Método .save() --");
        //System.out.println(curso);
        //System.out.println("*************************************************");
        alumnosRepository.save(alumno);
        if(alumno.getId()!=0){
            mensajeAlumno="Se guardo el alumno id: "+alumno.getId();
        }else{
            mensajeAlumno="No se guardo el alumno";
        }
        return "redirect:alumnos";
    }
    
}  

    

