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
    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.userName}")
    private String userName;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Value("${spring.data.mongodb.port}")
    private int port;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Bean
    public MongoClient client() {
        return MongoClients.create(getConnectionString());
    }

    @Bean
    public MongoTemplate template(MongoClient client) {
        return new MongoTemplate(client, database);
    }

    private ConnectionString getConnectionString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mongodb://");

        if (userName != null && password != null) {
            sb.append(userName)
                    .append(":")
                    .append(password)
                    .append("@");
        }

        sb.append(host)
                .append(":")
                .append(port)
                .append("/");

        return new ConnectionString(sb.toString());
    }

}
