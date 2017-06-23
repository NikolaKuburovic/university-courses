package com.it355.metcourses.dao;

import com.it355.model.Profesor;
import java.util.List;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public interface ProfesorDao {

    public int getCount();

    public List<Profesor> getAllProfesor();

    public Profesor addProfesor(Profesor profesor);

    public void deleteProfesor(int id);

    public Profesor updateProfesor(Profesor profesor);

    public Profesor getProfesorById(int id);

}
