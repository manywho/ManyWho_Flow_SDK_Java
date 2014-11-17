package com.manywho.sdk.entities;

import java.math.BigDecimal;
import java.util.Date;

public interface GeolocationInterface {
    public Date getTimestamp();
    public void setTimestamp(Date timestamp);
    public BigDecimal getLatitude();
    public void setLatitude(BigDecimal latitude);
    public BigDecimal getLongitude();
    public void setLongitude(BigDecimal longitude);
    public BigDecimal getAccuracy();
    public void setAccuracy(BigDecimal accuracy);
    public BigDecimal getAltitude();
    public void setAltitude(BigDecimal altitude);
    public BigDecimal getAltitudeAccuracy();
    public void setAltitudeAccuracy(BigDecimal altitudeAccuracy);
    public BigDecimal getHeading();
    public void setHeading(BigDecimal heading);
    public BigDecimal getSpeed();
    public void setSpeed(BigDecimal speed);
}
