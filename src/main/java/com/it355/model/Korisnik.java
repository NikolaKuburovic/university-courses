package com.it355.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nikola Kuburovic 1095
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "KORISNIK")

public class Korisnik implements Serializable {

    @Column(name = "korisnik_id")
    private int id;

    @Column(name = "korisnik_ime")
    private String ime;

    @Column(name = "korisnik_prezime")
    private String prezime;

    @Id
    @Column(name = "korisnik_username")
    private String username;

    @Column(name = "korisnik_password")
    private String password;

    @Column(name = "enabled")
    private int enabled;

    public Korisnik() {

    }

    public Korisnik(String ime, String prezime, String username, String password) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    public Korisnik(int id, String ime, String prezime, String username, String password) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    public Korisnik(int id, String ime, String prezime, String username, String password, int enabled) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * @param ime the ime to set
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * @return the prezime
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * @param prezime the prezime to set
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", username=" + username
                + ", password=" + password + ", enabled=" + enabled + '}';
    }

}
