package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.example.dao.ClientCrudService;
import org.example.dao.PlanetCrudService;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Entity
@Table(name = "ticket")
@Getter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet fromPlanet;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet toPlanet;

    public void setClientId(int id) {
        ClientCrudService clientCrudService = new ClientCrudService();
        this.client = clientCrudService.findById(id);
    }

    public void setFromPlanetId(String id) {
        PlanetCrudService planetCrudService = new PlanetCrudService();
        this.fromPlanet = planetCrudService.findById(id);
    }

    public void setToPlanetId(String id) {
        PlanetCrudService planetCrudService = new PlanetCrudService();
        this.toPlanet = planetCrudService.findById(id);
    }
}
