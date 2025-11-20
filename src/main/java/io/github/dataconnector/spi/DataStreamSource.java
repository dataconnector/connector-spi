package io.github.dataconnector.spi;

import io.github.dataconnector.spi.model.ConnectorContext;
import io.github.dataconnector.spi.model.ConnectorResult;
import io.github.dataconnector.spi.stream.StreamObserver;

/**
 * Connector for reading data from a source as a stream.
 */
public interface DataStreamSource extends DataConnector {

    /**
     * Start a stream from the source.
     * 
     * @param context  The context of the connector.
     * @param observer The observer of the stream.
     * @return The result of the start stream operation.
     * @throws Exception If an error occurs while starting the stream.
     */
    ConnectorResult startStream(ConnectorContext context, StreamObserver observer) throws Exception;
}
