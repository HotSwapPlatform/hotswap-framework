package io.github.ilkka_n.hotswap.core.ports;

import java.util.List;

/**
 * Controls active adapters.
 * -Activates adapters
 * -Enumerates adapters
 */
public interface MultiAdapterSelectorPort<T> extends AdapterControlPort<T> {
    void close(String name);
    List<T> getActiveAdapters();
    List<String> getActiveAdapterNames();
}
