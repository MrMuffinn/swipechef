package com.itann.swipechef.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@Entity(name = "gebruiker")
@Table(name = "gebruiker")
public class Gebruiker {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "gebruiker_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "id")
    private int id;
    @Column(name = "voornaam")
    private String voornaam;
    @Column(name = "achternaam")
    private String achternaam;
    @Column(name = "email")
    private String email;
    @Column(name = "wachtwoord")
    private String wachtwoord;
    @Column(name = "rol")
    private String rol;

    public enum Rol {
        ADMIN,
        USER;
    }
}
