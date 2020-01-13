package com.manywho.sdk.services.types.system;

import com.manywho.sdk.api.AuthorizationType;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

import java.time.OffsetDateTime;

@Type.Element(name = "$User")
public class $User implements Type {
    @Type.Property(name = "Altitude Accuracy", contentType = ContentType.Number)
    private Integer altitudeAccuracy;

    @Type.Property(name = "AuthenticationType", contentType = ContentType.String)
    private AuthorizationType authenticationType;

    @Type.Property(name = "Brand", contentType = ContentType.String)
    private String brand;

    @Type.Property(name = "Country", contentType = ContentType.String)
    private String country;

    @Type.Property(name = "Current Altitude", contentType = ContentType.Number)
    private Float currentAltitude;

    @Type.Property(name = "Current Heading", contentType = ContentType.Number)
    private Float currentHeading;

    @Type.Property(name = "Current Latitude", contentType = ContentType.Number)
    private Float currentLatitude;

    @Type.Property(name = "Current Longitude", contentType = ContentType.Number)
    private Float currentLongitude;

    @Type.Property(name = "Current Speed", contentType = ContentType.Number)
    private Float currentSpeed;

    @Type.Property(name = "Directory Id", contentType = ContentType.String)
    private String directoryId;

    @Type.Property(name = "Directory Name", contentType = ContentType.String)
    private String directoryName;

    @Type.Property(name = "Email", contentType = ContentType.String)
    private String email;

    @Type.Property(name = "First Name", contentType = ContentType.String)
    private String firstName;

    @Type.Property(name = "Language", contentType = ContentType.String)
    private String language;

    @Type.Property(name = "Last Name", contentType = ContentType.String)
    private String lastName;

    @Type.Property(name = "Location", contentType = ContentType.Object)
    private $Location location;

    @Type.Property(name = "Location Accuracy", contentType = ContentType.Number)
    private Float locationAccuracy;

    @Type.Property(name = "Location Timestamp", contentType = ContentType.DateTime)
    private OffsetDateTime locationTimestamp;

    @Type.Property(name = "LoginUrl", contentType = ContentType.String)
    private String loginUrl;

    @Type.Property(name = "Primary Group Id", contentType = ContentType.String)
    private String primaryGroupId;

    @Type.Property(name = "Primary Group Name", contentType = ContentType.String)
    private String primaryGroupName;

    @Type.Property(name = "Role Id", contentType = ContentType.String)
    private String roleId;

    @Type.Property(name = "Role Name", contentType = ContentType.String)
    private String roleName;

    @Type.Property(name = "Status", contentType = ContentType.String)
    private String status;

    @Type.Identifier
    @Type.Property(name = "User ID", contentType = ContentType.String)
    private String userId;

    @Type.Property(name = "Username", contentType = ContentType.String)
    private String username;

    @Type.Property(name = "Variant", contentType = ContentType.String)
    private String variant;

    public Integer getAltitudeAccuracy() {
        return altitudeAccuracy;
    }

    public $User setAltitudeAccuracy(Integer altitudeAccuracy) {
        this.altitudeAccuracy = altitudeAccuracy;
        return this;
    }

    public AuthorizationType getAuthenticationType() {
        return authenticationType;
    }

    public $User setAuthenticationType(AuthorizationType authenticationType) {
        this.authenticationType = authenticationType;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public $User setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public $User setCountry(String country) {
        this.country = country;
        return this;
    }

    public Float getCurrentAltitude() {
        return currentAltitude;
    }

    public $User setCurrentAltitude(Float currentAltitude) {
        this.currentAltitude = currentAltitude;
        return this;
    }

    public Float getCurrentHeading() {
        return currentHeading;
    }

    public $User setCurrentHeading(Float currentHeading) {
        this.currentHeading = currentHeading;
        return this;
    }

    public Float getCurrentLatitude() {
        return currentLatitude;
    }

    public $User setCurrentLatitude(Float currentLatitude) {
        this.currentLatitude = currentLatitude;
        return this;
    }

    public Float getCurrentLongitude() {
        return currentLongitude;
    }

    public $User setCurrentLongitude(Float currentLongitude) {
        this.currentLongitude = currentLongitude;
        return this;
    }

    public Float getCurrentSpeed() {
        return currentSpeed;
    }

    public $User setCurrentSpeed(Float currentSpeed) {
        this.currentSpeed = currentSpeed;
        return this;
    }

    public String getDirectoryId() {
        return directoryId;
    }

    public $User setDirectoryId(String directoryId) {
        this.directoryId = directoryId;
        return this;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public $User setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public $User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public $User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public $User setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public $User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public $Location getLocation() {
        return location;
    }

    public $User setLocation($Location location) {
        this.location = location;
        return this;
    }

    public Float getLocationAccuracy() {
        return locationAccuracy;
    }

    public $User setLocationAccuracy(Float locationAccuracy) {
        this.locationAccuracy = locationAccuracy;
        return this;
    }

    public OffsetDateTime getLocationTimestamp() {
        return locationTimestamp;
    }

    public $User setLocationTimestamp(OffsetDateTime locationTimestamp) {
        this.locationTimestamp = locationTimestamp;
        return this;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public $User setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
        return this;
    }

    public String getPrimaryGroupId() {
        return primaryGroupId;
    }

    public $User setPrimaryGroupId(String primaryGroupId) {
        this.primaryGroupId = primaryGroupId;
        return this;
    }

    public String getPrimaryGroupName() {
        return primaryGroupName;
    }

    public $User setPrimaryGroupName(String primaryGroupName) {
        this.primaryGroupName = primaryGroupName;
        return this;
    }

    public String getRoleId() {
        return roleId;
    }

    public $User setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public $User setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public $User setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public $User setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public $User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getVariant() {
        return variant;
    }

    public $User setVariant(String variant) {
        this.variant = variant;
        return this;
    }
}
