package com.itann.swipechef.domain;

import lombok.Data;

import javax.persistence.*;

@Data
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

}
