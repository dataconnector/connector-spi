package io.github.dataconnector.spi;

import io.github.dataconnector.spi.model.ConnectorContext;
import io.github.dataconnector.spi.model.ConnectorResult;

/**
 * Connector for reading data from a source.
 */
public interface DataSource extends DataConnector {

    /**
     * Read data from the source.
     * 
     * @param context The context of the connector.
     * @return The result of the read operation.
     * @throws Exception If an error occurs while reading the data.
     */
    ConnectorResult read(ConnectorContext context) throws Exception;

}
