package io.github.dataconnector.spi.stream;

import java.util.Map;

/**
 * An observer for a stream.
 */
public interface StreamObserver {

    /**
     * Called when a new record is available.
     * 
     * @param record The record.
     */
    void onNext(Map<String, Object> record);

    /**
     * Called when an error occurs.
     * 
     * @param error The error.
     */
    void onError(Throwable error);

    /**
     * Called when the stream is complete.
     */
    void onComplete();

}
