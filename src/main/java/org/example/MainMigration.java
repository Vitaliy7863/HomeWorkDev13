package org.example;

import org.flywaydb.core.Flyway;

public class MainMigration {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:./test;", "", "")
                .locations("filesystem:src/main/resources/db.migration")
                .baselineOnMigrate(true)
                .load();

        flyway.migrate();
    }
}