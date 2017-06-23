package com.it355.metcourses.service.impl;

import com.it355.metcourses.dao.KursDao;
import com.it355.metcourses.service.KursService;
import com.it355.model.Asistent;
import com.it355.model.Kurs;
import com.it355.model.Profesor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class KursServiceImpl implements KursService {

    @Autowired
    KursDao kursDao;

    @Override
    public List<Kurs> getAllKurs() {
        return kursDao.getAllKurs();
    }

    @Override
    public Kurs addKurs(Kurs kurs) {
        return kursDao.addKurs(kurs);
    }

    @Override
    public void deleteKurs(Kurs kurs) {
        kursDao.deleteKurs(kurs);
    }

    @Override
    public boolean updateKurs(Kurs kurs) {
        return kursDao.updateKurs(kurs);
    }

    @Override
    public Kurs getKursById(int id) {
        return kursDao.getKursById(id);
    }
    
    @Override
    public Kurs getKursBySifra(String sifra){
        return kursDao.getKursBySifra(sifra);
    }

    @Override
    public List<Asistent> getAllAsistent() {
        return kursDao.getAllAsistent();
    }

    @Override
    public List<Profesor> getAllProfesor() {
        return kursDao.getAllProfesor();
    }

}
