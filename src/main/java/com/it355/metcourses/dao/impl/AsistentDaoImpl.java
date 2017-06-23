package com.it355.metcourses.dao.impl;

import com.it355.metcourses.dao.AsistentDao;
import com.it355.metcourses.mapper.AsistentMapper;
import com.it355.model.Asistent;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class AsistentDaoImpl implements AsistentDao {

    private JdbcTemplate jdbcTemplate;
    @SuppressWarnings("unused")
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM asistent";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<Asistent> getAllAsistent() {
        String sql = "SELECT * FROM ASISTENT";
        List<Asistent> asistent = jdbcTemplate.query(sql, new AsistentMapper());
        return asistent;
    }

    @Override
    public Asistent addAsistent(Asistent asistent) {
        String sql = "INSERT INTO ASISTENT " + "(asistent_ime, asistent_prezime,"
                + "asistent_oblast) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{asistent.getIme(), asistent.getPrezime(),
            asistent.getOblast()});
        return asistent;
    }

    @Override
    public void deleteAsistent(int id) {
        String sql = "DELETE FROM ASISTENT WHERE asistent_id=" + id + "";
        jdbcTemplate.update(sql);
    }

    @Override
    public Asistent updateAsistent(Asistent asistent) {
        String sql = "UPDATE ASISTENT SET asistent_ime=?, asistent_prezime=?,"
                + "asistent_oblast=? WHERE asistent_id=?";
        jdbcTemplate.update(sql, asistent.getIme(), asistent.getPrezime(), asistent.getOblast(),
                asistent.getId());
        return asistent;
    }

    @Override
    public Asistent getAsistentById(int id) {
        String sql = "SELECT * FROM ASISTENT WHERE asistent_id=" + id + "";
        Asistent asistent = jdbcTemplate.queryForObject(sql, new AsistentMapper());
        return asistent;
    }
}
