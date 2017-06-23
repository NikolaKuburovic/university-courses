package com.it355.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nikola Kuburovic 1095
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "NARUDZBINA")
public class Narudzbina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "narudzbina_id")
    private int narudzbinaId;

    @Column(name = "korisnik_username")
    private String korisnikUsername;
    
    @Column(name = "narudzbina_datum")
    private Date datum;

    
    public Narudzbina() {

    }
    
    public Narudzbina(int narudzbinaId, String korisnikUsername, Date datum){
        this.narudzbinaId = narudzbinaId;
        this.korisnikUsername = korisnikUsername;
        this.datum = datum;
    }
    
    public Narudzbina(String korisnikUsername, Date datum){
        this.korisnikUsername = korisnikUsername;
        this.datum = datum;
    }

    /**
     * @return the narudzbinaId
     */
    public int getNarudzbinaId() {
        return narudzbinaId;
    }

    /**
     * @param narudzbinaId the narudzbinaId to set
     */
    public void setNarudzbinaId(int narudzbinaId) {
        this.narudzbinaId = narudzbinaId;
    }

    /**
     * @return the datum
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    /**
     * @return the korisnikUsername
     */
    public String getKorisnikUsername() {
        return korisnikUsername;
    }

    /**
     * @param korisnikUsername the korisnikUsername to set
     */
    public void setKorisnikUsername(String korisnikUsername) {
        this.korisnikUsername = korisnikUsername;
    }

    @Override
    public String toString() {
        return "Narudzbina [narudzbinaId =" + narudzbinaId + ", korisnikUsername =" + korisnikUsername
                + ", datum=" + datum + "]";
    }
}
