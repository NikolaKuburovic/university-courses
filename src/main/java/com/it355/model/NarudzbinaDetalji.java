package com.it355.model;

import java.io.Serializable;
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
@Table(name = "NARUDZBINA_DETALJI")
public class NarudzbinaDetalji implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "narudzbina_detalji_id")
    private int narudzbinaDetaljiId;

    @Column(name = "kurs_sifra")
    private String kursSifra;

    @Column(name = "narudzbina_id")
    private int narudzbinaId;

    @Column(name = "narudzbina_detalji_cena")
    private int cena;

    @Column(name = "narudzbina_detalji_kolicina")
    private int kolicina;

    public NarudzbinaDetalji() {

    }

    public NarudzbinaDetalji(String kursSifra, int narudzbinaId, int cena, int kolicina) {
        this.kursSifra = kursSifra;
        this.narudzbinaId = narudzbinaId;
        this.cena = cena;
        this.kolicina = kolicina;
    }

    public NarudzbinaDetalji(int narudzbinaDetaljiId, String kursSifra, int narudzbinaId,
            int cena, int kolicina) {
        this.narudzbinaDetaljiId = narudzbinaDetaljiId;
        this.kursSifra = kursSifra;
        this.narudzbinaId = narudzbinaId;
        this.cena = cena;
        this.kolicina = kolicina;
    }

    /**
     * @return the narudzbinaDetaljiId
     */
    public int getNarudzbinaDetaljiId() {
        return narudzbinaDetaljiId;
    }

    /**
     * @param narudzbinaDetaljiId the narudzbinaDetaljiId to set
     */
    public void setNarudzbinaDetaljiId(int narudzbinaDetaljiId) {
        this.narudzbinaDetaljiId = narudzbinaDetaljiId;
    }

    /**
     * @return the cena
     */
    public int getCena() {
        return cena;
    }

    /**
     * @param cena the cena to set
     */
    public void setCena(int cena) {
        this.cena = cena;
    }

    /**
     * @return the kolicina
     */
    public int getKolicina() {
        return kolicina;
    }

    /**
     * @param kolicina the kolicina to set
     */
    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    /**
     * @return the kursId
     */
    public String getKursSifra() {
        return kursSifra;
    }

    /**
     * @param kursSifra the kursId to set
     */
    public void setKursSifra(String kursSifra) {
        this.kursSifra = kursSifra;
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

    @Override
    public String toString() {
        return "NarudzbinaDetalji [narudzbinaDetaljiId =" + narudzbinaDetaljiId + ", kursSifra =" + kursSifra
                + ", narudzbinaId =" + narudzbinaId + ", cena =" + cena + ", kolicina =" + kolicina + "]";
    }
}
