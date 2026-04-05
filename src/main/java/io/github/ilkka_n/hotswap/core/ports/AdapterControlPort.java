package io.github.ilkka_n.hotswap.core.ports;

import java.util.List;

public interface AdapterControlPort<T>{
    void activate(String name);
    List<String> getAdapterNames();
}
