package com.manywho.services.example.managers;

import com.manywho.services.example.ServiceConfiguration;

import java.time.OffsetDateTime;

public class EmailManager {
    public OffsetDateTime sendEmail(ServiceConfiguration configuration, String to, String subject, String message) {
        return OffsetDateTime.now();
    }
}
