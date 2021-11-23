package ua.alevel.util;

import ua.alevel.entity.BaseEntity;

import java.util.Collection;
import java.util.UUID;

public final class GenerateIdUtil {

    private GenerateIdUtil() { }

    public static String generateId(Collection<? extends BaseEntity> items) {
        String id = UUID.randomUUID().toString();
        if (items.stream().anyMatch(entity -> entity.getId().equals(id))) {
            return generateId(items);
        }
        return id;
    }
}
