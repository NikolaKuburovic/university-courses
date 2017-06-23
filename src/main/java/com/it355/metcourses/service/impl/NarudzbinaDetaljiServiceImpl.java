package com.it355.metcourses.service.impl;

import com.it355.metcourses.dao.NarudzbinaDetaljiDao;
import com.it355.metcourses.service.NarudzbinaDetaljiService;
import com.it355.model.NarudzbinaDetalji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nikola Kuburovic 1095
 */
@Service
public class NarudzbinaDetaljiServiceImpl implements NarudzbinaDetaljiService {

    @Autowired
    NarudzbinaDetaljiDao narudzbinaDetaljiDao;

    
    @Override
    public NarudzbinaDetalji dodajNarudzbinaDetalji(NarudzbinaDetalji narudzbinaDetalji) {
        return narudzbinaDetaljiDao.dodajNarudzbinaDetalji(narudzbinaDetalji);
    }

}