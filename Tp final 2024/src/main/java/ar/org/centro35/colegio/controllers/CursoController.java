package ar.org.centro35.colegio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.org.centro35.colegio.entities.Curso;
import ar.org.centro35.colegio.repositories.CursoRepository;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CursoController {

    private CursoRepository cursoRepository=new CursoRepository();
    private String mensajeCursos="Ingrese un nuevo curso!";

    @GetMapping("/cursos")
    public String getCursos(@RequestParam(name = "buscar", defaultValue = "") String buscar,Model model) {
        model.addAttribute("mensaje", mensajeCursos);
        model.addAttribute("curso", new Curso());
        //model.addAttribute("all", cursoRepository.getAll());
        model.addAttribute("likeTitulo", cursoRepository.getLikeTitulo(buscar));
        return "cursos";
    }

    @PostMapping("/cursosSave")
    public String cursosSave(@ModelAttribute Curso curso) {
        //System.out.println("*************************************************");
        //System.out.println("-- Método .save() --");
        //System.out.println(curso);
        //System.out.println("*************************************************");
        cursoRepository.save(curso);
        if(curso.getId()!=0){
            mensajeCursos="Se guardo el curso id: "+curso.getId();
        }else{
            mensajeCursos="No se guardo el curso";
        }
        return "redirect:cursos";
    }
    
}
