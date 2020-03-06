package com.manywho.sdk.services.unit.utils;

import com.manywho.sdk.services.utils.UUIDs;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class UUIDsTest {
    @Test
    public void testFromNullableString() {
        UUID uuid = UUIDs.fromNullableString(null);
        Assert.assertNull(uuid);

        String validUuidString = "8a3f64a4-9c83-11e8-98d0-529269fb1459";
        UUID uuidFromString = UUIDs.fromNullableString(validUuidString);
        Assert.assertEquals(UUID.fromString(validUuidString), uuidFromString);
    }
}
