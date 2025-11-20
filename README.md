# Connector SPI

Core Service Provider Interface (SPI) for Universal Data Connectors. This library provides the foundational interfaces and models for building data connectors that can read from and write to various data sources.

## Overview

The Connector SPI defines a standardized interface for data connectors, enabling developers to create connectors that can seamlessly integrate with the Universal Data Connectors framework. It supports both batch and streaming data operations.

## Features

- **Unified Interface**: Common base interface (`DataConnector`) for all connector types
- **Multiple Connector Types**:
  - `DataSource`: For reading data from sources
  - `DataSink`: For writing data to destinations
  - `DataStreamSource`: For streaming data from sources
  - `DataStreamSink`: For streaming data to destinations
- **Configuration Management**: Type-safe configuration access through `ConnectorContext`
- **Metadata Support**: Built-in metadata tracking for connectors
- **Result Tracking**: Comprehensive operation results with metrics
- **Streaming Support**: Reactive streaming with observer pattern
- **Lifecycle Management**: Built-in initialization and cleanup hooks

## Installation

### Maven

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.github.dataconnector</groupId>
    <artifactId>connector-spi</artifactId>
    <version>0.0.1</version>
</dependency>
```

## API Overview

### Core Interfaces

#### DataConnector

The base interface for all connectors:

```java
public interface DataConnector {
    String getType();
    ConnectorMetadata getMetadata();
    List<String> validateConfiguration(ConnectorContext context);
    void initialize();
    void close();
}
```

#### DataSource

Interface for reading data from a source:

```java
public interface DataSource extends DataConnector {
    ConnectorResult read(ConnectorContext context) throws Exception;
}
```

#### DataSink

Interface for writing data to a destination:

```java
public interface DataSink extends DataConnector {
    ConnectorResult write(ConnectorContext context, List<Map<String, Object>> data) throws Exception;
}
```

#### DataStreamSource

Interface for streaming data from a source:

```java
public interface DataStreamSource extends DataConnector {
    ConnectorResult startStream(ConnectorContext context, StreamObserver observer) throws Exception;
}
```

#### DataStreamSink

Interface for streaming data to a sink:

```java
public interface DataStreamSink extends DataConnector {
    StreamWriter createWriter(ConnectorContext context) throws IOException;
}
```

### Model Classes

#### ConnectorContext

Provides execution context and configuration:

```java
ConnectorContext context = ConnectorContext.builder()
    .executionId("exec-123")
    .configuration(configMap)
    .build();

Optional<String> host = context.getConfiguration("host", String.class);
```

#### ConnectorMetadata

Stores connector metadata:

```java
ConnectorMetadata metadata = ConnectorMetadata.builder()
    .name("My Connector")
    .description("A custom data connector")
    .version("1.0.0")
    .author("John Doe")
    .build();
```

#### ConnectorResult

Represents the result of a connector operation:

```java
ConnectorResult result = ConnectorResult.builder()
    .success(true)
    .message("Operation completed successfully")
    .recordsProcessed(1000)
    .records(dataRecords)
    .executionTimeMillis(5000)
    .build();
```

### Streaming

#### StreamWriter

Writer interface for pushing records into a streaming destination:

```java
StreamWriter writer = dataStreamSink.createWriter(context);
writer.writeBatch(records);
writer.close();
```

#### StreamObserver

Observer interface for handling stream events:

```java
StreamObserver observer = new StreamObserver() {
    @Override
    public void onNext(Map<String, Object> record) {
        // Process record
    }
    
    @Override
    public void onError(Throwable error) {
        // Handle error
    }
    
    @Override
    public void onComplete() {
        // Stream completed
    }
};
```

## Usage Example

### Implementing a DataSource

```java
public class MyDataSource implements DataSource {
    
    @Override
    public String getType() {
        return "my-source";
    }
    
    @Override
    public ConnectorMetadata getMetadata() {
        return ConnectorMetadata.builder()
            .name("My Data Source")
            .description("Custom data source implementation")
            .version("1.0.0")
            .build();
    }
    
    @Override
    public List<String> validateConfiguration(ConnectorContext context) {
        List<String> errors = new ArrayList<>();
        if (!context.getConfiguration("url", String.class).isPresent()) {
            errors.add("URL is required");
        }
        return errors;
    }
    
    @Override
    public void initialize() {
        // Initialize connection, load resources, etc.
    }
    
    @Override
    public ConnectorResult read(ConnectorContext context) throws Exception {
        long startTime = System.currentTimeMillis();
        
        // Read data from source
        List<Map<String, Object>> records = readData(context);
        
        long executionTime = System.currentTimeMillis() - startTime;
        
        return ConnectorResult.builder()
            .success(true)
            .message("Data read successfully")
            .recordsProcessed(records.size())
            .records(records)
            .executionTimeMillis(executionTime)
            .build();
    }
    
    @Override
    public void close() {
        // Cleanup resources
    }
    
    private List<Map<String, Object>> readData(ConnectorContext context) {
        // Implementation
        return new ArrayList<>();
    }
}
```

### Implementing a DataSink

```java
public class MyDataSink implements DataSink {
    
    @Override
    public String getType() {
        return "my-sink";
    }
    
    @Override
    public ConnectorMetadata getMetadata() {
        return ConnectorMetadata.builder()
            .name("My Data Sink")
            .description("Custom data sink implementation")
            .version("1.0.0")
            .build();
    }
    
    @Override
    public ConnectorResult write(ConnectorContext context, List<Map<String, Object>> data) throws Exception {
        long startTime = System.currentTimeMillis();
        
        // Write data to destination
        writeData(context, data);
        
        long executionTime = System.currentTimeMillis() - startTime;
        
        return ConnectorResult.builder()
            .success(true)
            .message("Data written successfully")
            .recordsProcessed(data.size())
            .executionTimeMillis(executionTime)
            .build();
    }
    
    private void writeData(ConnectorContext context, List<Map<String, Object>> data) {
        // Implementation
    }
}
```

## Requirements

- Java 8 or higher
- Lombok (provided scope)

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
