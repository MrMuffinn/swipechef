package com.itann.swipechef.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity(name = "voorkeursgerecht")
@Table(name = "voorkeursgerecht")
public class Voorkeursgerecht{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @Column(name = "gerecht")
    private int gerecht;
    @Column(name = "gebruiker")
    private int gebruiker;

    public int getGerecht() {
        return gerecht;
    }

    public void setGerecht(int gerecht) {
        this.gerecht = gerecht;
    }

    public int getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(int gebruiker) {
        this.gebruiker = gebruiker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//
}
