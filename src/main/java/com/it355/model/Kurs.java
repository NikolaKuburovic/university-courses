package com.it355.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Nikola Kuburovic 1095
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KURS")
public class Kurs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kurs_id")
    private int kursId;

    @Column(name = "kurs_sifra")
    private String sifra;

    @ManyToOne
    @JoinColumn(name = "asistent_id", referencedColumnName = "asistent_id")
    private Asistent asistent;

    @ManyToOne
    @JoinColumn(name = "profesor_id", referencedColumnName = "profesor_id")
    private Profesor profesor;

    @Column(name = "kurs_naziv")
    private String naziv;

    @Column(name = "kurs_godina")
    private int godina;

    @Column(name = "kurs_espb")
    private int espb;

    @Column(name = "kurs_opis")
    private String opisKursa;

    @Column(name = "kurs_cena")
    private int cena;

    @Transient
    private String asId;

    @Transient
    private String prId;

    public Kurs() {

    }

    public Kurs(String sifra, String asId, String prId, String naziv, int godina,
            int espb, String opisKursa, int cena) {
        this.sifra = sifra;
        this.asId = asId;
        this.prId = prId;
        this.naziv = naziv;
        this.godina = godina;
        this.espb = espb;
        this.opisKursa = opisKursa;
        this.cena = cena;
    }

    public String getSifra() {
        return sifra;
    }

    public String getAsId() {
        return asId;
    }

    public void setAsId(String asId) {
        this.asId = asId;
    }

    public String getPrId() {
        return prId;
    }

    public void setPrId(String prId) {
        this.prId = prId;
    }

    public Kurs(int kursId, String sifra, Asistent asistent, Profesor profesor,
            String naziv, int godina, int espb, String opisKursa, int cena) {
        this.kursId = kursId;
        this.sifra = sifra;
        this.asistent = asistent;
        this.profesor = profesor;
        this.naziv = naziv;
        this.godina = godina;
        this.espb = espb;
        this.opisKursa = opisKursa;
        this.cena = cena;
    }

    public Kurs(String sifra, Asistent asistent, Profesor profesor, String naziv,
            int godina, int espb, String opisKursa, int cena) {
        this.sifra = sifra;
        this.asistent = asistent;
        this.profesor = profesor;
        this.naziv = naziv;
        this.godina = godina;
        this.espb = espb;
        this.opisKursa = opisKursa;
        this.cena = cena;
    }

    public int getKursId() {
        return kursId;
    }

    public void setKursId(int kursId) {
        this.kursId = kursId;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    /**
     * @return the asistent
     */
    public Asistent getAsistent() {
        return asistent;
    }

    /**
     * @param asistent the asistent to set
     */
    public void setAsistent(Asistent asistent) {
        this.asistent = asistent;
    }

    /**
     * @return the profesor
     */
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    /**
     * @return the naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * @param naziv the naziv to set
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     * @return the godina
     */
    public int getGodina() {
        return godina;
    }

    /**
     * @param godina the godina to set
     */
    public void setGodina(int godina) {
        this.godina = godina;
    }

    /**
     * @return the espb
     */
    public int getEspb() {
        return espb;
    }

    /**
     * @param espb the espb to set
     */
    public void setEspb(int espb) {
        this.espb = espb;
    }

    /**
     * @return the opis
     */
    public String getOpisKursa() {
        return opisKursa;
    }

    /**
     * @param opisKursa
     */
    public void setOpisKursa(String opisKursa) {
        this.opisKursa = opisKursa;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Kurs [kursId =" + kursId + ", sifra =" + sifra + ", asistent ="
                + asistent + ", profesor=" + profesor + ", naziv = " + naziv
                + ", godina = " + godina + ", espb = " + espb + ", opisKursa = "
                + opisKursa + ", cena=" + cena + "]";
    }

}
