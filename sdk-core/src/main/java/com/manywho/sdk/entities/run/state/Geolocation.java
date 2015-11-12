package com.manywho.sdk.entities.run.state;

import java.math.BigDecimal;
import java.util.Date;

public class Geolocation implements com.manywho.sdk.entities.security.Geolocation {
    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal accuracy;
    private BigDecimal altitude;
    private BigDecimal altitudeAccuracy;
    private BigDecimal heading;
    private BigDecimal speed;
    private Date time;

    @Override
    public BigDecimal getLatitude() {
        return latitude;
    }

    @Override
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Override
    public BigDecimal getLongitude() {
        return longitude;
    }

    @Override
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public BigDecimal getAccuracy() {
        return accuracy;
    }

    @Override
    public void setAccuracy(BigDecimal accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public BigDecimal getAltitude() {
        return altitude;
    }

    @Override
    public void setAltitude(BigDecimal altitude) {
        this.altitude = altitude;
    }

    @Override
    public BigDecimal getAltitudeAccuracy() {
        return altitudeAccuracy;
    }

    @Override
    public void setAltitudeAccuracy(BigDecimal altitudeAccuracy) {
        this.altitudeAccuracy = altitudeAccuracy;
    }

    @Override
    public BigDecimal getHeading() {
        return heading;
    }

    @Override
    public void setHeading(BigDecimal heading) {
        this.heading = heading;
    }

    @Override
    public BigDecimal getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    @Override
    public Date getTimestamp() {
        return time;
    }

    @Override
    public void setTimestamp(Date time) {
        this.time = time;
    }
}
