package com.it355.metcourses.dao.impl;

import com.it355.metcourses.dao.KorisnikDao;
import com.it355.model.Korisnik;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nikola Kuburovic 1095
 */
@Repository("korisnikDao")
@Service
public class KorisnikDaoImpl implements KorisnikDao {

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
    public List<Korisnik> getAllKorisnik() {
        List<Korisnik> korisnik = (List<Korisnik>) getSession().createCriteria(Korisnik.class).list();
        return korisnik;
    }

    @Override
    @Transactional
    public Korisnik addKorisnik(Korisnik korisnik) {
        getSession().saveOrUpdate(korisnik);
        return korisnik;
    }

    @Override
    @Transactional
    public void deleteKorisnik(Korisnik korisnik) {
        getSession().delete(korisnik);
    }

    @Override
    @Transactional
    public Korisnik updateKorisnik(Korisnik korisnik) {
        getSession().saveOrUpdate(korisnik);
        return korisnik;
    }

    @Override
    @Transactional
    public Korisnik getKorisnikById(int id) {
        Korisnik korisnik = (Korisnik) getSession().createCriteria(Korisnik.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        return korisnik;
    }

}
