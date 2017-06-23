package com.it355.metcourses.dao.impl;

import com.it355.metcourses.dao.ProfesorDao;
import com.it355.metcourses.mapper.ProfesorMapper;
import com.it355.model.Profesor;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class ProfesorDaoImpl implements ProfesorDao {

    private JdbcTemplate jdbcTemplate;
    @SuppressWarnings("unused")
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM PROFESOR";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<Profesor> getAllProfesor() {
        String sql = "SELECT * FROM PROFESOR";
        List<Profesor> profesor = jdbcTemplate.query(sql, new ProfesorMapper());
        return profesor;
    }

    @Override
    public Profesor addProfesor(Profesor profesor) {
        String sql = "INSERT INTO PROFESOR " + "(profesor_ime, profesor_prezime,"
                + "profesor_oblast) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{profesor.getIme(), profesor.getPrezime(),
            profesor.getOblast()});
        return profesor;
    }

    @Override
    public void deleteProfesor(int id) {
        String sql = "DELETE FROM PROFESOR WHERE profesor_id=" + id + "";
        jdbcTemplate.update(sql);
    }

    @Override
    public Profesor updateProfesor(Profesor profesor) {
        String sql = "UPDATE PROFESOR SET profesor_ime=?, profesor_prezime=?,"
                + "profesor_oblast=? WHERE profesor_id=?";
        jdbcTemplate.update(sql, profesor.getIme(), profesor.getPrezime(), profesor.getOblast(),
                profesor.getId());
        return profesor;
    }

    @Override
    public Profesor getProfesorById(int id) {
        String sql = "SELECT * FROM PROFESOR WHERE profesor_id=" + id + "";
        Profesor profesor = jdbcTemplate.queryForObject(sql, new ProfesorMapper());
        return profesor;
    }
}
