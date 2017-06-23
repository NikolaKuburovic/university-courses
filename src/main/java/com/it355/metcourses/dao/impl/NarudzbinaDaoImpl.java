package com.it355.metcourses.dao.impl;

import com.it355.metcourses.dao.NarudzbinaDao;
import com.it355.model.Narudzbina;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nikola Kuburovic 1095
 */
@Repository
@Transactional
public class NarudzbinaDaoImpl implements NarudzbinaDao {

    //Instanciramo sesiju
    @Autowired
    private SessionFactory sessionFactory;

    //kreiramo seter za sesiju

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //kreiramo geter za sesiju

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public Narudzbina dodajNarudzbinu(Narudzbina narudzbina) {
        getSession().saveOrUpdate(narudzbina);
        return narudzbina;
    }

}
