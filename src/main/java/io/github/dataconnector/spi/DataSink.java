package io.github.dataconnector.spi;

import java.util.List;
import java.util.Map;

import io.github.dataconnector.spi.model.ConnectorContext;
import io.github.dataconnector.spi.model.ConnectorResult;

/**
 * Connector for writing data to a sink.
 */
public interface DataSink extends DataConnector {

    /**
     * Write data to the sink.
     * 
     * @param context The context of the connector.
     * @param data    The data to write.
     * @return The result of the write operation.
     * @throws Exception If an error occurs while writing the data.
     */
    ConnectorResult write(ConnectorContext context, List<Map<String, Object>> data) throws Exception;
}