package com.it355.metcourses.service.impl;

import com.it355.metcourses.service.AsistentRepository;
import com.it355.model.Asistent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nikola Kuburovic 1095
 */
@Service("asistentRepository")
public class AsistentRepositoryImpl implements AsistentRepository {

    private final Map<String, Asistent> asistenti = new ConcurrentHashMap<>();

    @Override
    public void putAsistent(Asistent asistent) {
        asistenti.put(String.valueOf(asistent.getId()), asistent);
    }

    @Override
    public Asistent getAsistent(String asistentId) {
        return asistenti.get(asistentId);
    }

    @Override
    public Map<String, Asistent> getAllAsistent() {
        return asistenti;
    }

}
