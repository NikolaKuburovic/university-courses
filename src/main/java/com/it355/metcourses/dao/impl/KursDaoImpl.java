package com.it355.metcourses.dao.impl;

import com.it355.metcourses.dao.KursDao;
import com.it355.model.Asistent;
import com.it355.model.Kurs;
import com.it355.model.Profesor;
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
@Repository("kursDao")
@Service
public class KursDaoImpl implements KursDao{
    
    //Instanciramo sesiju
    @Autowired
    private SessionFactory sessionFactory;
    //kreiramo seter za sesiju
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    //kreiramo geter za sesiju
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public List<Kurs> getAllKurs() {
        List<Kurs> kurs = (List<Kurs>) getSession().createCriteria(Kurs.class).list();
        return kurs;
    }

    @Override
    @Transactional
    public Kurs addKurs(Kurs kurs) {
       return (Kurs)getSession().merge(kurs);
    }

    @Override
    @Transactional
    public void deleteKurs(Kurs kurs) {
        getSession().delete(kurs);
    }

    @Override
    @Transactional
    public boolean updateKurs(Kurs kurs) {
        getSession().saveOrUpdate(kurs);
        return true;
    }
    
   @Override
   @Transactional
   public Kurs getKursById(int id) {
       Kurs kurs = (Kurs) getSession().createCriteria(Kurs.class).
               add(Restrictions.eq("id", id)).uniqueResult();
        return kurs;
}
    
   @Override
   @Transactional
   public Kurs getKursBySifra(String sifra){
       Kurs kurs = (Kurs) getSession().createCriteria(Kurs.class).
               add(Restrictions.eq("sifra", sifra)).uniqueResult();
       return kurs;
   }
   
    @Override
    @Transactional
    public List<Asistent> getAllAsistent() {
        List<Asistent> asistent = (List<Asistent>) getSession().createCriteria(Asistent.class).list();
        return asistent;
    }
    
    @Override
    @Transactional
    public List<Profesor> getAllProfesor() {
        List<Profesor> profesor = (List<Profesor>) getSession().createCriteria(Profesor.class).list();
        return profesor;
    }
}
