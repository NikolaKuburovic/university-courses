package com.it355.metcourses.service;

import com.it355.model.Asistent;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public interface AsistentService {

    public int getCount();

    public List<Asistent> getAllAsistent();

    public Asistent addAsistent(Asistent asistent);

    public void deleteAsistent(int id);

    public Asistent updateAsistent(Asistent asistent);

    public Asistent getAsistentById(int id);
    
    public Map<String, Asistent> getAllAsistentMap();
}
