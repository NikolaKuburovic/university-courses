package com.it355.metcourses.service.impl;

import com.it355.metcourses.dao.ProfesorDao;
import com.it355.metcourses.service.ProfesorService;
import com.it355.model.Profesor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    ProfesorDao profesorDao;

    @Override
    public int getCount() {
        return profesorDao.getCount();
    }

    @Override
    public List<Profesor> getAllProfesor() {
        return profesorDao.getAllProfesor();
    }

    @Override
    public Profesor addProfesor(Profesor profesor) {
        return profesorDao.addProfesor(profesor);
    }

    @Override
    public void deleteProfesor(int id) {
        profesorDao.deleteProfesor(id);
    }

    @Override
    public Profesor updateProfesor(Profesor profesor) {
        return profesorDao.updateProfesor(profesor);
    }

    @Override
    public Profesor getProfesorById(int id) {
        return profesorDao.getProfesorById(id);
    }

}
