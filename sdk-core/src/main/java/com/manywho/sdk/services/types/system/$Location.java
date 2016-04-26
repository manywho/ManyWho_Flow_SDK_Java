package com.manywho.sdk.services.types.system;

import com.manywho.sdk.enums.ContentType;
import com.manywho.sdk.services.annotations.TypeElement;
import com.manywho.sdk.services.annotations.TypeProperty;
import org.joda.time.DateTime;

@TypeElement(name = "$Location")
public class $Location {
    @TypeProperty(name = "Altitude Accuracy", contentType = ContentType.Number)
    private int altitudeAccuracy;

    @TypeProperty(name = "Current Altitude", contentType = ContentType.Number)
    private float currentAltitude;

    @TypeProperty(name = "Current Heading", contentType = ContentType.Number)
    private float currentHeading;

    @TypeProperty(name = "Current Latitude", contentType = ContentType.Number)
    private float currentLatitude;

    @TypeProperty(name = "Current Longitude", contentType = ContentType.Number)
    private float currentLongitude;

    @TypeProperty(name = "Current Speed", contentType = ContentType.Number)
    private float currentSpeed;

    @TypeProperty(name = "Location Accuracy", contentType = ContentType.String)
    private float locationAccuracy;

    @TypeProperty(name = "Location Timestamp", contentType = ContentType.String)
    private DateTime locationTimestamp;

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

    public DateTime getLocationTimestamp() {
        return locationTimestamp;
    }
}
