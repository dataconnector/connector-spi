package io.github.dataconnector.spi;

import java.io.IOException;

import io.github.dataconnector.spi.model.ConnectorContext;
import io.github.dataconnector.spi.stream.StreamWriter;

/**
 * Connector for writing data to a stream sink.
 */
public interface DataStreamSink extends DataConnector {

    /**
     * Create a writer for the stream sink.
     * 
     * @param context The context of the connector.
     * @return The writer for the stream sink.
     * @throws IOException If an error occurs while creating the writer.
     */
    StreamWriter createWriter(ConnectorContext context) throws IOException;

}
