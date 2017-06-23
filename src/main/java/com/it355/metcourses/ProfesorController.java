package com.it355.metcourses;

import com.it355.metcourses.dao.ProfesorDao;
import com.it355.metcourses.service.ProfesorService;
import com.it355.model.Profesor;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nikola Kuburovic 1095
 */
@Controller
public class ProfesorController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    ProfesorDao profesorDao;

    @Autowired
    ProfesorService profesorService;

    @RequestMapping(value = "/profesor", method = RequestMethod.GET)
    public ModelAndView profesori(ModelAndView modelAndView) {
        System.out.println("Pozivam message source za profesore");
        System.out.println(messageSource.getMessage("name", null, Locale.ENGLISH));
        List<Profesor> profesori = profesorService.getAllProfesor();
        modelAndView.addObject("profesori", profesori);
        modelAndView.setViewName("profesor");
        return modelAndView;
    }

    @RequestMapping(value = "/addprofesor", method = RequestMethod.GET)
    public String addProfesor(Model model) {
        model.addAttribute("profesor", new Profesor());
        return "addprofesor";
    }

    @RequestMapping(value = "/addprofesor", method = RequestMethod.POST)
    public ModelAndView addProfesor(@ModelAttribute("profesor") Profesor p) {
        profesorService.addProfesor(p);
        return new ModelAndView("redirect:/profesor");
    }

    @RequestMapping(value = "/editprofesor/{id}", method = RequestMethod.GET)
    public String editProfesor(@PathVariable int id, Model model) {
        Profesor profesor = profesorService.getProfesorById(id);
        model.addAttribute("profesor", profesor);
        return "editprofesor";
    }

    @RequestMapping(value = "/editprofesor/{id}", method = RequestMethod.POST)
    public ModelAndView editProfesor(@ModelAttribute("profesor") Profesor p) {
        profesorService.updateProfesor(p);
        return new ModelAndView("redirect:/profesor");
    }

    @RequestMapping(value = "/deleteProfesor/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProf(@PathVariable int id) {
        profesorService.deleteProfesor(id);
        return new ModelAndView("redirect:/profesor");
    }
    
    @RequestMapping(value = "/profesori", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Profesor>> profesoriRest() {
        System.out.println("Lista profesora");
        List<Profesor> profesori = profesorService.getAllProfesor();
        System.out.println(profesori);
        if (profesori.isEmpty()) {
            System.out.println("Lista profesora je prazna");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(profesori, HttpStatus.OK);
    }

    @RequestMapping(value = "/addprofesori", method = RequestMethod.POST)
    public ResponseEntity<Void> addProfesoriRest(@RequestBody Profesor profesor) {
        System.out.println("Dodajem profesora " + profesor.toString());
        profesorService.addProfesor(profesor);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/editprofesori/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Profesor> editProfesoriRest(@PathVariable("id") int id, @RequestBody Profesor profesor) {
        System.out.println("Izmena podataka za profesora " + id);
        profesor.setId(id);
        profesorService.updateProfesor(profesor);
        return new ResponseEntity<>(profesor, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteprofesori/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Profesor> deleteProfesorRest(@PathVariable("id") int id) {
        System.out.println("Brisem profesora " + id);
        Profesor profesor = profesorService.getProfesorById(id);
        if (profesor == null) {
            System.out.println("Brisanje nije moguce. Profesor " + id + " nije pronadjen");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        profesorService.deleteProfesor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
