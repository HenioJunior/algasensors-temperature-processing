package com.algasensors.temperature.processing.common;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

public class UUIDv7Utils {

    public UUIDv7Utils() {
    }

    public static OffsetDateTime extractOffsetDateTime(UUID uuid) {

        if(uuid == null){
            return null;
        }

        if (!isUuidV7(uuid)) {
            throw new IllegalArgumentException("UUID não é versão 7");
        }

        // UUID v7: timestamp ocupa os 48 bits mais significativos
        long msb = uuid.getMostSignificantBits();

        long timestampMillis = (msb >>> 16) & 0xFFFFFFFFFFFFL;

        return OffsetDateTime.ofInstant(
                Instant.ofEpochMilli(timestampMillis),
                ZoneId.systemDefault()
        );
    }

    private static boolean isUuidV7(UUID uuid) {
        return uuid.version() == 7;
    }

}
