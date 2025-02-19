package br.com.dio.board;

import br.com.dio.board.persistence.config.ConnectionConfig;
import br.com.dio.board.persistence.migration.MigrationStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        try (var connection = ConnectionConfig.getConnection()){
            new MigrationStrategy(connection).executeMigration();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
