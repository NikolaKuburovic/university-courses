package com.it355.metcourses.mapper;

import com.it355.model.Asistent;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class AsistentMapper implements RowMapper<Asistent> {

    @Override
    public Asistent mapRow(ResultSet rs, int arg1) throws SQLException {
        Asistent asistent = new Asistent();
        asistent.setId(rs.getInt("asistent_id"));
        asistent.setIme(rs.getString("asistent_ime"));
        asistent.setPrezime(rs.getString("asistent_prezime"));
        asistent.setOblast(rs.getString("asistent_oblast"));
        return asistent;
    }
}
