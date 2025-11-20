package io.github.dataconnector.spi.model;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

/**
 * The result of a connector operation.
 */
@Data
@Builder
public class ConnectorResult {

    /**
     * Whether the connector operation was successful.
     */
    private boolean success;

    /**
     * The message of the connector operation.
     */
    private String message;

    /**
     * The number of records processed.
     */
    private int recordsProcessed;

    /**
     * The records processed.
     */
    private List<Map<String, Object>> records;

    /**
     * The execution time of the connector operation in milliseconds.
     */
    private long executionTimeMillis;

}
