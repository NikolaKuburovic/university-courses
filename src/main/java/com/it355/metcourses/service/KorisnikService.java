package com.it355.metcourses.service;

import com.it355.model.Korisnik;
import java.util.List;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public interface KorisnikService {

    public List<Korisnik> getAllKorisnik();

    public Korisnik addKorisnik(Korisnik korisnik);

    public void deleteKorisnik(Korisnik korisnik);

    public Korisnik updateKorisnik(Korisnik korisnik);

    public Korisnik getKorisnikById(int id);

}
