package org.example;

import org.example.dao.ClientCrudService;
import org.example.model.Client;
import org.example.util.HibernateUtil;
import org.flywaydb.core.Flyway;

public class TestClient {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:./test;", "", "")
                .locations("filesystem:src/main/resources/db.migration")
                .baselineOnMigrate(true)
                .load();

        flyway.migrate();

        ClientCrudService crudClient = new ClientCrudService();
        System.out.println(crudClient.findAll());

        Client newClient = new Client();
        newClient.setName("Andriy");
        crudClient.save(newClient);

        Client client = crudClient.findById(8);
        System.out.println("Found client: " + client.getName());

        client.setName("Jane Doe");
        crudClient.update(client);

        crudClient.delete(client);

        HibernateUtil.getInstance().close();

    }
}
