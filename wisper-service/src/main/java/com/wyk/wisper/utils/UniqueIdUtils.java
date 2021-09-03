package com.wyk.wisper.utils;

import java.util.UUID;

/**
 * Static utility methods pertaining to {@code UniqueIdUtils} instances.
 *
 * @author elt
 * @since 1.0
 */
public class UniqueIdUtils {
    private UniqueIdUtils() {
    }

    /**
     * Create a new unique id.
     *
     * @return a {@code String} value.
     */
    public static String newUniqueId() {
        return UUID.randomUUID().toString();
    }
}
