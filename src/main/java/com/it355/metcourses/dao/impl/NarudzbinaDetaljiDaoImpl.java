package com.it355.metcourses.dao.impl;

import com.it355.metcourses.dao.NarudzbinaDetaljiDao;
import com.it355.model.NarudzbinaDetalji;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ubuntu
 */
@Repository
@Transactional
public class NarudzbinaDetaljiDaoImpl implements NarudzbinaDetaljiDao {

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
    public NarudzbinaDetalji dodajNarudzbinaDetalji(NarudzbinaDetalji narudzbinaDetalji) {
        getSession().saveOrUpdate(narudzbinaDetalji);
        return narudzbinaDetalji;
    }

}
