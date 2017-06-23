package com.it355.metcourses.mapper;

import com.it355.model.Korisnik;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class KorisnikMapper implements RowMapper<Korisnik> {

    @Override
    public Korisnik mapRow(ResultSet rs, int arg1) throws SQLException {
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(rs.getString("korisnik_ime"));
        korisnik.setPrezime(rs.getString("korisnik_prezime"));
        korisnik.setUsername(rs.getString("korisnik_username"));
        korisnik.setPassword(rs.getString("korisnik_password"));
        korisnik.setEnabled(rs.getInt("enabled"));
        return korisnik;
    }
}
