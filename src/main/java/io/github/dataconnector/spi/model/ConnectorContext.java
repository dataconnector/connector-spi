package io.github.dataconnector.spi.model;

import java.util.Map;
import java.util.Optional;

import lombok.Builder;
import lombok.Data;

/**
 * The context of a connector operation.
 */
@Data
@Builder
public class ConnectorContext {

    /**
     * The execution id of the connector operation.
     */
    private String executionId;

    /**
     * The configuration of the connector.
     */
    private Map<String, Object> configuration;

    /**
     * Get a configuration value by key and type.
     * 
     * @param key  The key.
     * @param type The type of the configuration value.
     * @return The configuration value, or empty if the key is not found or the
     *         value is not of the given type.
     */
    public <T> Optional<T> getConfiguration(String key, Class<T> type) {
        if (configuration == null) {
            return Optional.empty();
        }
        Object value = configuration.get(key);
        if (value != null && type.isAssignableFrom(value.getClass())) {
            return Optional.of(type.cast(value));
        }
        return Optional.empty();
    }

}
