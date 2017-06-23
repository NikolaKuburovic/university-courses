package com.it355.metcourses;

/**
 *
 * @author Nikola Kuburovic
 */
import com.it355.metcourses.service.AsistentService;
import com.it355.metcourses.service.KorisnikService;
import com.it355.metcourses.service.KursService;
import com.it355.metcourses.service.ProfesorService;
import com.it355.model.Korisnik;
import com.it355.model.Kurs;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    ProfesorService profesorService;

    @Autowired
    AsistentService asistentService;

    @Autowired
    KorisnikService korisnikService;

    @Autowired
    KursService kursService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView printHello() {
        ModelAndView modelAndView = new ModelAndView();
        List<Kurs> kursevi = kursService.getAllKurs();
        modelAndView.addObject("kursevi", kursevi);
        modelAndView.addObject("kurs", new Kurs());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = {"/hello"}, method = RequestMethod.GET)
    public ModelAndView helloPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Сада си пријављен на апликацију!");
        model.setViewName("hello");
        return model;
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Сада си пријављен на апликацију!");
        model.setViewName("admin");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Лоши подаци за пријаву!");
        }
        if (logout != null) {
            model.addObject("msg", "Одјавили сте се.");
        }
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);
            model.addObject("username", userDetail.getUsername());
        }
        model.setViewName("403");
        return model;
    }

    @RequestMapping(value = "/korisnik", method = RequestMethod.GET)
    public ModelAndView getKorisnik(ModelAndView modelAndView) {
        List<Korisnik> korisnici = korisnikService.getAllKorisnik();
        modelAndView.addObject("korisnici", korisnici);
        modelAndView.addObject("korisnik", new Korisnik());
        return modelAndView;
    }

    @RequestMapping(value = "/addkorisnik", method = RequestMethod.GET)
    public String addKorisnik(Model model) {
        model.addAttribute("korisnik", new Korisnik());
        return "addkorisnik";
    }

    @RequestMapping(value = "/addkorisnik", method = RequestMethod.POST)
    public ModelAndView addKorisnik(@ModelAttribute("korisnik") Korisnik k) {
        korisnikService.addKorisnik(k);
        return new ModelAndView("redirect:/korisnik");
    }

    @RequestMapping(value = "/editkorisnik/{id}", method = RequestMethod.GET)
    public String editKorisnik(@PathVariable int id, Model model) {
        Korisnik korisnik = korisnikService.getKorisnikById(id);
        model.addAttribute("korisnik", korisnik);
        return "editkorisnik";
    }

    @RequestMapping(value = "/editkorisnik/{id}", method = RequestMethod.POST)
    public ModelAndView editKorisnik(@ModelAttribute("korisnik") Korisnik k) {
        korisnikService.updateKorisnik(k);
        return new ModelAndView("redirect:/korisnik");
    }

    @RequestMapping(value = "/deletekorisnik/{id}", method = RequestMethod.GET)
    public ModelAndView deleteKor(@PathVariable int id) {
        Korisnik korisnik = korisnikService.getKorisnikById(id);
        korisnikService.deleteKorisnik(korisnik);
        return new ModelAndView("redirect:/korisnik");
    }

    @RequestMapping(value = "/kurs", method = RequestMethod.GET)
    public ModelAndView getKurs(ModelAndView modelAndView) {
        List<Kurs> kursevi = kursService.getAllKurs();
        modelAndView.addObject("kursevi", kursevi);
        modelAndView.addObject("kurs", new Kurs());
        return modelAndView;
    }

    @RequestMapping(value = "/addkurs", method = RequestMethod.GET)
    public String addKurs(Model model) {
        model.addAttribute("kurs", new Kurs());
        model.addAttribute("asistenti", kursService.getAllAsistent());
        model.addAttribute("profesori", kursService.getAllProfesor());
        return "addkurs";
    }

    @RequestMapping(value = "/addkurs", method = RequestMethod.POST)
    public ModelAndView addKurs(@ModelAttribute("kurs") Kurs k) {
        int aid = Integer.parseInt(k.getAsId());
        int pid = Integer.parseInt(k.getPrId());
        k.setAsistent(asistentService.getAsistentById(aid));
        k.setProfesor(profesorService.getProfesorById(pid));
        kursService.addKurs(k);
        return new ModelAndView("redirect:/kurs");
    }

    @RequestMapping(value = "/editkurs/{id}", method = RequestMethod.GET)
    public String editKurs(@PathVariable int id, Model model) {
        Kurs kurs = kursService.getKursById(id);
        model.addAttribute("kurs", kurs);
        model.addAttribute("asistenti", kursService.getAllAsistent());
        model.addAttribute("profesori", kursService.getAllProfesor());
        return "editkurs";
    }

    @RequestMapping(value = "/editkurs/{id}", method = RequestMethod.POST)
    public ModelAndView editKurs(@PathVariable int id, @ModelAttribute("kurs") Kurs k) {
        int aid = Integer.parseInt(k.getAsId());
        int pid = Integer.parseInt(k.getPrId());
        k.setKursId(id);
        k.setAsistent(asistentService.getAsistentById(aid));
        k.setProfesor(profesorService.getProfesorById(pid));
        kursService.updateKurs(k);
        return new ModelAndView("redirect:/kurs");
    }

    @RequestMapping(value = "/deletekurs/{id}", method = RequestMethod.GET)
    public ModelAndView deleteKurs(@PathVariable int id) {
        Kurs kurs = kursService.getKursById(id);
        kursService.deleteKurs(kurs);
        return new ModelAndView("redirect:/kurs");
    }

}
