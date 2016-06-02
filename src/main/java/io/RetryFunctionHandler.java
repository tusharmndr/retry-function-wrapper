package io;

/**
 * Created by tushar.mandar on 6/2/16.
 */
public interface RetryFunctionHandler<T> {
    T run() throws Exception;
}
