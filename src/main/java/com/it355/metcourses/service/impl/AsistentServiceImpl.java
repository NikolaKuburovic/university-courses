package com.it355.metcourses.service.impl;

import com.it355.metcourses.dao.AsistentDao;
import com.it355.metcourses.messaging.MessageSender;
import com.it355.metcourses.service.AsistentRepository;
import com.it355.metcourses.service.AsistentService;
import com.it355.model.Asistent;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class AsistentServiceImpl implements AsistentService {

    static final Logger LOG = LoggerFactory.getLogger(AsistentServiceImpl.class);

    @Autowired
    MessageSender messageSender;

    @Autowired
    AsistentRepository asistentRepository;

    @Autowired
    AsistentDao asistentDao;

    @Override
    public int getCount() {
        return asistentDao.getCount();
    }

    @Override
    public List<Asistent> getAllAsistent() {
        return asistentDao.getAllAsistent();
    }

    @Override
    public Asistent addAsistent(Asistent asistent) {
        LOG.info("**************************************");
        asistentRepository.putAsistent(asistent);
        LOG.info("Aplikacija dodaje asistenta {}", asistent);
        System.out.println("****MESSAGE SENDER JE: " + messageSender);
        messageSender.sendMessage(asistent);
        LOG.info("**************************************");
        return asistentDao.addAsistent(asistent);
    }

    @Override
    public void deleteAsistent(int id) {
        asistentDao.deleteAsistent(id);
    }

    @Override
    public Asistent updateAsistent(Asistent asistent) {
        return asistentDao.updateAsistent(asistent);
    }

    @Override
    public Asistent getAsistentById(int id) {
        return asistentDao.getAsistentById(id);
    }
    
    @Override
    public Map<String, Asistent> getAllAsistentMap(){
        return asistentRepository.getAllAsistent();
    }

}
