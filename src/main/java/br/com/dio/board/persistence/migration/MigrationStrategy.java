package br.com.dio.board.persistence.migration;

import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.AllArgsConstructor;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@AllArgsConstructor
public class MigrationStrategy {

    private Connection connection;

    public void executeMigration() {
        var originalOut = System.out;
        var originalError = System.err;

        try (var fos = new FileOutputStream("liquibase.log")) {
            System.setOut(new PrintStream(fos));
            System.setErr(new PrintStream(fos));
            try (
                    var connection = DriverManager.getConnection("jdbc:sqlite:liquibase.log");
                    var jdbcConnection = new JdbcConnection(connection);
            ) {
                var liquibase = new Liquibase(
                        "/db/changelog/db.changelog-master.yml",
                        new ClassLoaderResourceAccessor(),
                        jdbcConnection
                );
                liquibase.update();
            } catch (SQLException | LiquibaseException e) {
                e.printStackTrace();
            }
            System.setErr(originalError);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.setOut(originalOut);
            System.setErr(originalError);
        }
    }
}
