package io.github.dataconnector.spi;

import java.util.List;

import io.github.dataconnector.spi.model.ConnectorContext;
import io.github.dataconnector.spi.model.ConnectorMetadata;

public interface DataConnector {

    /**
     * Get the type of the connector.
     * 
     * The type is used to identify the connector in the system.
     * 
     * @return The type of the connector.
     */
    String getType();

    /**
     * Get the metadata of the connector.
     * 
     * @return The metadata of the connector.
     */
    ConnectorMetadata getMetadata();

    /**
     * Validate the configuration of the connector.
     * 
     * The configuration is validated before the connector is initialized.
     * 
     * @param context The context of the connector.
     * @return The list of validation errors.
     */
    default List<String> validateConfiguration(ConnectorContext context) {
        return List.of();
    }

    /**
     * Initialize the connector.
     * 
     * The connector is initialized before it is used.
     */
    default void initialize() {
    }

    /**
     * Close the connector.
     * 
     * The connector is closed after it is used.
     */
    default void close() {
    }

}
