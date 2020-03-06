package com.manywho.sdk.services.types.system;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

import java.time.OffsetDateTime;

@Type.Element(name = "$Location")
public class $Location implements Type {
    @Type.Property(name = "Altitude Accuracy", contentType = ContentType.Number)
    private int altitudeAccuracy;

    @Type.Property(name = "Current Altitude", contentType = ContentType.Number)
    private float currentAltitude;

    @Type.Property(name = "Current Heading", contentType = ContentType.Number)
    private float currentHeading;

    @Type.Property(name = "Current Latitude", contentType = ContentType.Number)
    private float currentLatitude;

    @Type.Property(name = "Current Longitude", contentType = ContentType.Number)
    private float currentLongitude;

    @Type.Property(name = "Current Speed", contentType = ContentType.Number)
    private float currentSpeed;

    @Type.Property(name = "Location Accuracy", contentType = ContentType.String)
    private float locationAccuracy;

    @Type.Property(name = "Location Timestamp", contentType = ContentType.String)
    private OffsetDateTime locationTimestamp;

    public int getAltitudeAccuracy() {
        return altitudeAccuracy;
    }

    public float getCurrentAltitude() {
        return currentAltitude;
    }

    public float getCurrentHeading() {
        return currentHeading;
    }

    public float getCurrentLatitude() {
        return currentLatitude;
    }

    public float getCurrentLongitude() {
        return currentLongitude;
    }

    public float getCurrentSpeed() {
        return currentSpeed;
    }

    public float getLocationAccuracy() {
        return locationAccuracy;
    }

    public OffsetDateTime getLocationTimestamp() {
        return locationTimestamp;
    }
}
