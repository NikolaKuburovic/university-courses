package com.it355.metcourses.mapper;

import com.it355.model.Asistent;
import com.it355.model.Kurs;
import com.it355.model.Profesor;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class KursMapper implements RowMapper<Kurs> {

    @Override
    public Kurs mapRow(ResultSet rs, int arg1) throws SQLException {
        Kurs kurs = new Kurs();
        kurs.setSifra(rs.getString("kurs_sifra"));
        kurs.setAsistent(rs.getObject("asistent_id", Asistent.class));
        kurs.setProfesor(rs.getObject("profesor_id", Profesor.class));
        kurs.setNaziv(rs.getString("kurs_naziv"));
        kurs.setGodina(rs.getInt("kurs_godina"));
        kurs.setEspb(rs.getInt("kurs_espb"));
        kurs.setOpisKursa(rs.getString("kurs_opis"));
        kurs.setCena(rs.getInt("kurs_cena"));
        return kurs;
    }
}
