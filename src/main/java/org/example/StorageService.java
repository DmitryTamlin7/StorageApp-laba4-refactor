package org.example;

import java.util.HashMap;
import java.util.Optional;

public class StorageService {
    private final HashMap<String, String> storage = new HashMap<>();

    public boolean storeItem(String code, String item, boolean overwrite) {
        if (!overwrite && storage.containsKey(code)) {
            return false; // уже существует
        }
        storage.put(code, item);
        return true;
    }

    public Optional<String> retrieveItem(String code) {
        if (!storage.containsKey(code)) {
            return Optional.empty();
        }
        String item = storage.remove(code);
        return Optional.of(item);
    }

    public boolean containsCode(String code) {
        return storage.containsKey(code);
    }
}
