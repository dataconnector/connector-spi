package io.github.dataconnector.spi.model;

import lombok.Builder;
import lombok.Data;

/**
 * The metadata of a connector.
 */
@Data
@Builder
public class ConnectorMetadata {

    /**
     * The name of the connector.
     */
    private String name;

    /**
     * The description of the connector.
     */
    private String description;

    /**
     * The version of the connector.
     */
    private String version;

    /**
     * The author of the connector.
     */
    private String author;

}
