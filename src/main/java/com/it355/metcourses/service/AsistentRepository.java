package com.it355.metcourses.service;

import com.it355.model.Asistent;
import java.util.Map;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public interface AsistentRepository {

    public void putAsistent(Asistent asistent);

    public Asistent getAsistent(String asistentId);

    public Map<String, Asistent> getAllAsistent();

}
