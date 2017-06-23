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
@Table(name="ASISTENT")
public class Asistent implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asistent_id")
    private int id;
    @Column(name = "asistent_ime")
    private String ime;
    @Column(name = "asistent_prezime")
    private String prezime;
    @Column(name = "asistent_oblast")
    private String oblast;
    
    public Asistent(){
        
    }
    
    public Asistent(int id, String ime, String prezime, String oblast){
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.oblast = oblast;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the oblast
     */
    public String getOblast() {
        return oblast;
    }

    /**
     * @param oblast the oblast to set
     */
    public void setOblast(String oblast) {
        this.oblast = oblast;
    }
    
        
    @Override
    public String toString() {
        return "Asistent [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", oblast = " + oblast + "]";
    }

    
}