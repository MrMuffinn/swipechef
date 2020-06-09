package com.itann.swipechef.domain;

import javax.persistence.*;

@Entity(name="gerecht")
@Table(name="gerecht")
public class Gerecht {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="bereidingstijd")
    private int bereidingstijd;
    @Column(name="bereidingswijze")
    private String bereidingswijze;
    @Column(name="energiePP")
    private int energiePP;
    @Column(name="naam")
    private String naam;

//    public Gerecht(int id, int bereidingstijd, String bereidingswijze, int energiePP, String naam){
//        this.id = id;
//        this.bereidingstijd = bereidingstijd;
//        this.bereidingswijze = bereidingswijze;
//        this.energiePP = energiePP;
//        this.naam = naam;
//    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBereidingstijd() {
        return bereidingstijd;
    }

    public void setBereidingstijd(int bereidingstijd) {
        this.bereidingstijd = bereidingstijd;
    }

    public String getBereidingswijze() {
        return bereidingswijze;
    }

    public void setBereidingswijze(String bereidingswijze) {
        this.bereidingswijze = bereidingswijze;
    }

    public int getEnergiePP() {
        return energiePP;
    }

    public void setEnergiePP(int energiePP) {
        this.energiePP = energiePP;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
