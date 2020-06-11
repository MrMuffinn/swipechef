package com.itann.swipechef.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "eenheid")
@Table(name = "eenheid")
public class Eenheid {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "naam")
    private String naam;

}


