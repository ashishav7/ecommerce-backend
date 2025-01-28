package com.ecommerce.utility.generator;

import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class IdGenerator implements IdentifierGenerator, Configurable {

    private String keyPrefix;
    private int paddingLength = 8;

    @Override
    public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
        this.keyPrefix = properties.getProperty("prefix", keyPrefix);
        this.paddingLength = Integer.parseInt(properties.getProperty("paddingLength", "8"));

    }

    @Override
    public Object generate(SharedSessionContractImplementor session, Object o) {
        final long[] nextValue = {0};
        session.doWork(connection -> {
            try {
                // Query to get the next counter value
                String selectQuery = "SELECT next_val FROM id_counter_table WHERE key_prefix = ?";
                PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
                selectStmt.setString(1, keyPrefix);

                ResultSet resultSet = selectStmt.executeQuery();

                if (resultSet.next()) {
                    nextValue[0] = resultSet.getLong("next_val");

                    // Update the counter in the database
                    String updateQuery = "UPDATE id_counter_table SET next_val = next_val + 1 WHERE key_prefix = ?";
                    PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
                    updateStmt.setString(1, keyPrefix);
                    updateStmt.executeUpdate();
                } else {
                    // Initialize the counter if the prefix does not exist
                    nextValue[0] = 1;
                    String insertQuery = "INSERT INTO id_counter_table (key_prefix, next_val) VALUES (?, ?)";
                    PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
                    insertStmt.setString(1, keyPrefix);
                    insertStmt.setLong(2, 2);
                    insertStmt.executeUpdate();
                }

                resultSet.close();
                selectStmt.close();
            } catch (Exception e) {
                throw new RuntimeException("Error generating custom ID", e);
            }
        });

        return keyPrefix + String.format("%0" + paddingLength + "d", nextValue[0]);
    }
}
