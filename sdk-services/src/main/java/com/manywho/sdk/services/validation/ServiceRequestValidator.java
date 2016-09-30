package com.manywho.sdk.services.validation;

import com.manywho.sdk.api.run.elements.config.ServiceRequest;

import javax.validation.ConstraintValidatorContext;

public class ServiceRequestValidator {
    public boolean isValid(ServiceRequest serviceRequest, ConstraintValidatorContext constraintValidatorContext) {
        if (serviceRequest == null) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("{javax.validation.constraints.NotNull.message}")
                    .addPropertyNode("serviceRequest")
                    .addConstraintViolation();

            return false;
        }

        boolean valid = true;

        if (serviceRequest.getJoinPlayerUri() == null || serviceRequest.getJoinPlayerUri().isEmpty()) {
            valid = false;

            constraintValidatorContext.buildConstraintViolationWithTemplate("{org.hibernate.validator.constraints.NotBlank.message}")
                    .addPropertyNode("serviceRequest.joinPlayerUri")
                    .addConstraintViolation();
        }

        if (serviceRequest.getTenantId() == null) {
            valid = false;

            constraintValidatorContext.buildConstraintViolationWithTemplate("{javax.validation.constraints.NotNull.message}")
                    .addPropertyNode("serviceRequest.tenantId")
                    .addConstraintViolation();
        }

        if (serviceRequest.getToken() == null || serviceRequest.getToken().isEmpty()) {
            valid = false;

            constraintValidatorContext.buildConstraintViolationWithTemplate("{org.hibernate.validator.constraints.NotBlank.message}")
                    .addPropertyNode("serviceRequest.token")
                    .addConstraintViolation();
        }

        return valid;
    }
}
