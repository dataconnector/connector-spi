package io.github.dataconnector.spi.stream;

/**
 * A cancellable stream.
 */
@FunctionalInterface
public interface StreamCancellable {

    /**
     * Stop the stream.
     */
    void stop();

}
