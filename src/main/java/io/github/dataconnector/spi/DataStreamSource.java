package io.github.dataconnector.spi;

import io.github.dataconnector.spi.model.ConnectorContext;
import io.github.dataconnector.spi.stream.StreamCancellable;
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
     * @return The cancellable of the start stream operation.
     * @throws Exception If an error occurs while starting the stream.
     */
    StreamCancellable startStream(ConnectorContext context, StreamObserver observer) throws Exception;
}
