package com.it355.metcourses.service.impl;

import com.it355.metcourses.dao.NarudzbinaDao;
import com.it355.metcourses.service.NarudzbinaService;
import com.it355.model.Narudzbina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nikola Kuburovic 1095
 */
@Service
public class NarudzbinaServiceImpl implements NarudzbinaService {

    @Autowired
    NarudzbinaDao narudzbinaDao;

    
    @Override
    public Narudzbina dodajNarudzbinu(Narudzbina narudzbina) {
        return narudzbinaDao.dodajNarudzbinu(narudzbina);
    }

}