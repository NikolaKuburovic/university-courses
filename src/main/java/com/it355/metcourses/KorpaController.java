package com.it355.metcourses;

/**
 *
 * @author Nikola Kuburovic
 */
import com.it355.metcourses.dao.KursDao;
import com.it355.metcourses.service.NarudzbinaDetaljiService;
import com.it355.metcourses.service.NarudzbinaService;
import com.it355.model.Kurs;
import com.it355.model.Narudzbina;
import com.it355.model.NarudzbinaDetalji;
import com.it355.model.Stavka;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/korpa")
public class KorpaController {

    @Autowired
    KursDao kursDao;

    @Autowired
    NarudzbinaService narudzbinaService;

    @Autowired
    NarudzbinaDetaljiService narudzbinaDetaljiService;

    private Kurs kurs = new Kurs();

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "korpa";

    }

    @RequestMapping(value = "/kupikurs/{sifra}", method = RequestMethod.GET)
    public String kupikurs(@PathVariable(value = "sifra") String sifra, HttpSession session) {
        if (session.getAttribute("korpa") == null) {
            List<Stavka> korpa = new ArrayList<>();
            korpa.add(new Stavka(this.kursDao.getKursBySifra(sifra), 1));
            session.setAttribute("korpa", korpa);
        } else {
            List<Stavka> korpa = (List<Stavka>) session.getAttribute("korpa");
            int index = kursUKorpi(sifra, session);
            if (index == -1) {
                korpa.add(new Stavka(this.kursDao.getKursBySifra(sifra), 1));
            } else {
                int kolicina = korpa.get(index).getKolicina() + 1;
                korpa.get(index).setKolicina(kolicina);
            }

            session.setAttribute("korpa", korpa);
        }
        return "korpa";
    }

    @RequestMapping(value = "/obrisi/{sifra}", method = RequestMethod.GET)
    public String obrisi(@PathVariable(value = "sifra") String sifra, HttpSession session) {

        List<Stavka> korpa = (List<Stavka>) session.getAttribute("korpa");
        int index = kursUKorpi(sifra, session);
        korpa.remove(index);
        session.setAttribute("korpa", korpa);
        return "korpa";

    }

    private int kursUKorpi(String sifra, HttpSession session) {
        List<Stavka> korpa = (List<Stavka>) session.getAttribute("korpa");
        for (int i = 0; i < korpa.size(); i++) {
            if (korpa.get(i).getKurs().getSifra().equals(sifra)) {
                return i;
            }
        }
        return -1;
    }

    @RequestMapping(value = "/potvrdikupovinu", method = RequestMethod.GET)
    public String potvrdiKupovinu(HttpSession session, ModelMap model, Principal principal) {

        if (session.getAttribute("korpa") == null) {
            model.addAttribute("error", "Молимо Вас да претходно убаците курс у корпу!");
            return "korpa";
        } else {

            Narudzbina narudzbina = new Narudzbina();
            narudzbina.setKorisnikUsername(principal.getName());
            narudzbina.setDatum(new Date());

            Narudzbina narudzbinaNova = narudzbinaService.dodajNarudzbinu(narudzbina);

            List<Stavka> korpa = (List<Stavka>) session.getAttribute("korpa");
            for (Stavka stavka : korpa) {
                NarudzbinaDetalji narudzbinaDetalji = new NarudzbinaDetalji();
                narudzbinaDetalji.setKursSifra(stavka.getKurs().getSifra());
                narudzbinaDetalji.setNarudzbinaId(narudzbinaNova.getNarudzbinaId());
                narudzbinaDetalji.setCena(stavka.getKurs().getCena());
                narudzbinaDetalji.setKolicina(stavka.getKolicina());
                narudzbinaDetaljiService.dodajNarudzbinaDetalji(narudzbinaDetalji);
            }

            session.removeAttribute("korpa");

            return "uspesnakupovina";
        }

    }

}
