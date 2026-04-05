package io.github.ilkka_n.hotswap.core.ports;

/**
 * Controls active adapters.
 * -Set active adapter
 * -Enumerates adapters
 */
public interface SingletonAdapterSelectorPort<T> extends AdapterControlPort<T> {
    T getActiveAdapter();
    String getActiveAdapterName();
}
