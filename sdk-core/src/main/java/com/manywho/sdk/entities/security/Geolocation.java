package com.manywho.sdk.entities.security;

import java.math.BigDecimal;
import java.util.Date;

public interface Geolocation {
    BigDecimal getLatitude();

    void setLatitude(BigDecimal latitude);

    BigDecimal getLongitude();

    void setLongitude(BigDecimal longitude);

    BigDecimal getAccuracy();

    void setAccuracy(BigDecimal accuracy);

    BigDecimal getAltitude();

    void setAltitude(BigDecimal altitude);

    BigDecimal getAltitudeAccuracy();

    void setAltitudeAccuracy(BigDecimal altitudeAccuracy);

    BigDecimal getHeading();

    void setHeading(BigDecimal heading);

    BigDecimal getSpeed();

    void setSpeed(BigDecimal speed);

    Date getTimestamp();

    void setTimestamp(Date time);
}
