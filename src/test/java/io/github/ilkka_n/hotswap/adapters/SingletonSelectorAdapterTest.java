package io.github.ilkka_n.hotswap.adapters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SingletonSelectorAdapterTest {

    interface StubAdapter {}

    @Mock
    private StubAdapter adapterA;
    @Mock
    private StubAdapter adapterB;

    private SingletonSelectorAdapter<StubAdapter> adapter;

    @BeforeEach
    void setUp() {
        adapter = new SingletonSelectorAdapter<>(
                Map.of("adapterA", adapterA, "adapterB", adapterB),
                "adapterA"
        );
    }

    @Test
    void shouldReturnDefaultAdapter() {
        assertEquals(adapterA, adapter.getActiveAdapter());
    }

    @Test
    void shouldActivateAdapter() {
        adapter.activate("adapterB");
        assertEquals(adapterB, adapter.getActiveAdapter());
    }

    @Test
    void shouldNotSwitchIfAdapterNameUnknown() {
        adapter.activate("tuntematon");
        assertEquals(adapterA, adapter.getActiveAdapter());
    }

    @Test
    void shouldNotSwitchIfAdapterNameIsNull() {
        adapter.activate(null);
        assertEquals(adapterA, adapter.getActiveAdapter());
    }

    @Test
    void shouldReturnActiveAdapterName() {
        assertEquals("adapterA", adapter.getActiveAdapterName());
        adapter.activate("adapterB");
        assertEquals("adapterB", adapter.getActiveAdapterName());
    }

    @Test
    void shouldReturnAllAdapterNames() {
        List<String> names = adapter.getAdapterNames();
        assertTrue(names.contains("adapterA"));
        assertTrue(names.contains("adapterB"));
        assertEquals(2, names.size());
    }
}
