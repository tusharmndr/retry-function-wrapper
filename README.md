# retry-function-wrapper

This is a simple helper library to retry any function. This library compiles only on Java 8.

# Usage

```java

      int MAX_RETRY = 3;
      RetryUtil.<Boolean>retry(MAX_RETRY,
          () -> {
                    //Function to retry
                    return true;
           });

```