package com.it355.metcourses.mapper;

import com.it355.model.Profesor;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class ProfesorMapper implements RowMapper<Profesor> {

    @Override
    public Profesor mapRow(ResultSet rs, int arg1) throws SQLException {
        Profesor profesor = new Profesor();
        profesor.setId(rs.getInt("profesor_id"));
        profesor.setIme(rs.getString("profesor_ime"));
        profesor.setPrezime(rs.getString("profesor_prezime"));
        profesor.setOblast(rs.getString("profesor_oblast"));
        return profesor;
    }
}
