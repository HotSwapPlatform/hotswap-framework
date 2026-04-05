package io.github.ilkka_n.hotswap.adapters;

import io.github.ilkka_n.hotswap.core.ports.SingletonAdapterSelectorPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Yleiskäyttöinen singleton-selektori-adapteri.
 * Hallitsee joukon nimettyjä adaptereja ja pitää yllä tietoa aktiivisesta.
 * <p>
 * Käyttö Spring-sovelluksessa: rekisteröi @Bean-metodilla ja anna
 * Spring-injektoida Map<String, T> (kaikki T-tyyppiset beanit nimellä).
 *
 * @param <T> adapteri-tyyppi
 */
public class SingletonSelectorAdapter<T> implements SingletonAdapterSelectorPort<T> {

    private final Map<String, T> implementations;
    private String activeAdapterName;

    public SingletonSelectorAdapter(Map<String, T> implementations, String defaultAdapterName) {
        this.implementations = implementations;
        this.activeAdapterName = defaultAdapterName;
    }

    @Override
    public void activate(String name) {
        if (null != name && implementations.containsKey(name)) {
            activeAdapterName = name;
        }
    }

    @Override
    public T getActiveAdapter() {
        return implementations.get(activeAdapterName);
    }

    @Override
    public List<String> getAdapterNames() {
        return new ArrayList<>(implementations.keySet());
    }

    @Override
    public String getActiveAdapterName() {
        return activeAdapterName;
    }
}
