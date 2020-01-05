package com.manywho.sdk.api.run.state;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Geolocation {
    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal accuracy;
    private BigDecimal altitude;
    private BigDecimal altitudeAccuracy;
    private BigDecimal heading;
    private BigDecimal speed;
    private LocalDateTime time;

    public BigDecimal getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(BigDecimal accuracy) {
        this.accuracy = accuracy;
    }

    public BigDecimal getAltitude() {
        return altitude;
    }

    public void setAltitude(BigDecimal altitude) {
        this.altitude = altitude;
    }

    public BigDecimal getAltitudeAccuracy() {
        return altitudeAccuracy;
    }

    public void setAltitudeAccuracy(BigDecimal altitudeAccuracy) {
        this.altitudeAccuracy = altitudeAccuracy;
    }

    public BigDecimal getHeading() {
        return heading;
    }

    public void setHeading(BigDecimal heading) {
        this.heading = heading;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public LocalDateTime getTimestamp() {
        return time;
    }

    public void setTimestamp(LocalDateTime time) {
        this.time = time;
    }
}
