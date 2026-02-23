package com.algasensors.temperature.processing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class UUIDv7Test {

    @Test
    public void shouldGenerateUUIDv7() {

        UUID uuid = IdGenerator.generateTimeBasedUUID();
        OffsetDateTime uuidDateTime = UUIDv7Utils.extractOffsetDateTime(uuid).truncatedTo(ChronoUnit.MINUTES);
        OffsetDateTime now = OffsetDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        Assertions.assertEquals(uuidDateTime, now);

    }
}
