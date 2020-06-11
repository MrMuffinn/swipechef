package com.itann.swipechef.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity(name = "voorkeursgerecht")
@Table(name = "voorkeursgerecht")
public class Voorkeursgerecht{

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "voorkeursgerecht_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name="id")
    private int id;
    @Column(name = "gerecht")
    private int gerecht;
    @Column(name = "gebruiker")
    private int gebruiker;

}
