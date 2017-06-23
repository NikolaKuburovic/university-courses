package com.it355.metcourses.service.impl;

import com.it355.metcourses.dao.KorisnikDao;
import com.it355.metcourses.service.KorisnikService;
import com.it355.model.Korisnik;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    KorisnikDao korisnikDao;

    @Override
    public List<Korisnik> getAllKorisnik() {
        return korisnikDao.getAllKorisnik();
    }

    @Override
    public Korisnik addKorisnik(Korisnik korisnik) {
        return korisnikDao.addKorisnik(korisnik);
    }

    @Override
    public void deleteKorisnik(Korisnik korisnik) {
        korisnikDao.deleteKorisnik(korisnik);
    }

    @Override
    public Korisnik updateKorisnik(Korisnik korisnik) {
        return korisnikDao.updateKorisnik(korisnik);
    }

    @Override
    public Korisnik getKorisnikById(int id) {
        return korisnikDao.getKorisnikById(id);
    }

}
