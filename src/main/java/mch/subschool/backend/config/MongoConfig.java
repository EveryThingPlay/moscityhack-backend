package mch.subschool.backend.config;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

@Profile("mongo")
@Configuration
@EnableMongoRepositories
public class MongoConfig {
    private static final String DATABASE_NAME = System.getenv("DATABASE_NAME");
    private static final String USER_NAME = System.getenv("USER_NAME");
    private static final String PASSWORD = System.getenv("PASSWORD");
    private static final String HOST = System.getenv("HOST");
    private static final String PORT = System.getenv("PORT");

    @Bean
    public MongoClient client() {
        return MongoClients.create(getConnectionString());
    }

    @Bean
    public MongoTemplate template(MongoClient client) {
        return new MongoTemplate(client, DATABASE_NAME);
    }

    private ConnectionString getConnectionString() {
        StringBuilder connectionStringBuilder = new StringBuilder();
        connectionStringBuilder.append("mongodb://");

        if (USER_NAME != null && PASSWORD != null) {
            connectionStringBuilder.append(USER_NAME)
                    .append(":")
                    .append(PASSWORD)
                    .append("@");
        }

        connectionStringBuilder.append(HOST)
                .append(":")
                .append(PORT)
                .append("/");

        return new ConnectionString(connectionStringBuilder.toString());
    }

}
