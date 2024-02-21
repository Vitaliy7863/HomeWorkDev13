package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "planet")
@Getter
@Setter
public class Planet {
    @Id
    private String id;
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "fromPlanet",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Ticket> ticketsFrom;

    @OneToMany(mappedBy = "toPlanet",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Ticket> ticketsTo;
}
