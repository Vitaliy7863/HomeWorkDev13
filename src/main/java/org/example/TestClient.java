package org.example;

import org.example.dao.ClientCrudService;
import org.example.model.Client;
import org.example.util.HibernateUtil;

public class TestClient {
    public static void main(String[] args) {
        ClientCrudService crudClient = new ClientCrudService();
        System.out.println(crudClient.findAll());

        Client newClient = new Client();
        newClient.setName("Andriy");
        crudClient.save(newClient);

        Client client = crudClient.findById(9);
        System.out.println("Found client: " + client.getName());

        client.setName("Jane Doe");
        crudClient.update(client);

        crudClient.delete(client);

        HibernateUtil.getInstance().close();

    }
}
