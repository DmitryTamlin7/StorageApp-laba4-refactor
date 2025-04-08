import org.example.StorageService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class StorageServiceTest {

    private StorageService service;

    @BeforeEach
    void setUp() {
        service = new StorageService();
    }

    @Test
    void testStoreAndRetrieveItem() {
        boolean stored = service.storeItem("123", "Футболка", false);
        assertTrue(stored);

        Optional<String> retrieved = service.retrieveItem("123");
        assertTrue(retrieved.isPresent());
        assertEquals("Футболка", retrieved.get());
    }

    @Test
    void testStoreDuplicateWithoutOverwrite() {
        service.storeItem("321", "Сумка", false);
        boolean result = service.storeItem("321", "Зонт", false);
        assertFalse(result);
    }

    @Test
    void testStoreDuplicateWithOverwrite() {
        service.storeItem("321", "Сумка", false);
        boolean result = service.storeItem("321", "Зонт", true);
        assertTrue(result);

        Optional<String> retrieved = service.retrieveItem("321");
        assertTrue(retrieved.isPresent());
        assertEquals("Зонт", retrieved.get());
    }

    @Test
    void testRetrieveNonexistentCode() {
        Optional<String> item = service.retrieveItem("999");
        assertTrue(item.isEmpty());
    }
}
