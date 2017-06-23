package com.it355.metcourses.dao;

import com.it355.model.Asistent;
import com.it355.model.Kurs;
import com.it355.model.Profesor;
import java.util.List;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public interface KursDao {

    public List<Kurs> getAllKurs();

    public Kurs addKurs(Kurs kurs);

    public void deleteKurs(Kurs kurs);

    public boolean updateKurs (Kurs kurs);

    public Kurs getKursById(int id);
    
    public Kurs getKursBySifra(String sifra);
    
    public List<Asistent> getAllAsistent();
    
    public List<Profesor> getAllProfesor();
    
}
