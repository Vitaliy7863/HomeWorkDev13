package org.example;

import org.example.dao.PlanetCrudService;
import org.example.model.Planet;
import org.example.util.HibernateUtil;

public class TestPlanet {
    public static void main(String[] args) {
        PlanetCrudService planetCrudService = new PlanetCrudService();
        System.out.println(planetCrudService.findAll());
        Planet newPlanet = new Planet();
        newPlanet.setId("SUN");
        newPlanet.setName("Sonce");
        planetCrudService.save(newPlanet);

        Planet planet = planetCrudService.findById("SUN");
        System.out.println("Found planet: " + planet.getName());

        planet.setName("Jane Doe");
        planetCrudService.update(planet);

        planetCrudService.delete(planet);


        HibernateUtil.getInstance().close();
    }
}
