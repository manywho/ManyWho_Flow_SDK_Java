package com.manywho.sdk.api.translate;

import java.util.UUID;

public class Culture {

    private UUID id;
    private String developerName;
    private String developerSummary;
    private String brand;
    private String language;
    private String country;
    private String variant;

    public Culture(String language, String country) {
        this(null, null, null, null, language, country, null);
    }

    public Culture(UUID id, String developerName, String developerSummary, String brand, String language, String country, String variant) {
        this.id = id;
        this.developerName = developerName;
        this.developerSummary = developerSummary;
        this.brand = brand;
        this.language = language;
        this.country = country;
        this.variant = variant;
    }

    public Culture() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getDeveloperSummary() {
        return developerSummary;
    }

    public void setDeveloperSummary(String developerSummary) {
        this.developerSummary = developerSummary;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }
}
