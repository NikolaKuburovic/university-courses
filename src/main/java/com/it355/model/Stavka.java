package com.it355.model;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class Stavka {
    
    private Kurs kurs = new Kurs();
    private int kolicina;
    
    
    public Stavka(){
        
    }
    
    public Stavka(Kurs kurs, int kolicina){
        this.kurs = kurs;
        this.kolicina = kolicina;
    }

    /**
     * @return the kurs
     */
    public Kurs getKurs() {
        return kurs;
    }

    /**
     * @param kurs the kurs to set
     */
    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
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
    
}