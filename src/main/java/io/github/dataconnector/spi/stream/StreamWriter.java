package io.github.dataconnector.spi.stream;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * A writer for a stream.
 */
public interface StreamWriter extends AutoCloseable {

    /**
     * Write a batch of records to the stream.
     * 
     * @param records The records to write.
     * @throws IOException If an error occurs while writing the records.
     */
    void writeBatch(List<Map<String, Object>> records) throws IOException;

    /**
     * Close the stream writer.
     */
    @Override
    void close() throws IOException;

}
