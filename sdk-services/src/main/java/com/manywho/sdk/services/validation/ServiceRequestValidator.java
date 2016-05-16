package com.manywho.sdk.services.validation;

import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import org.apache.commons.lang3.StringUtils;

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

        if (StringUtils.isEmpty(serviceRequest.getJoinPlayerUri())) {
            valid = false;

            constraintValidatorContext.buildConstraintViolationWithTemplate("{org.hibernate.validator.constraints.NotBlank.message}")
                    .addPropertyNode("serviceRequest.joinPlayerUri")
                    .addConstraintViolation();
        }

        if (StringUtils.isEmpty(serviceRequest.getTenantId())) {
            valid = false;

            constraintValidatorContext.buildConstraintViolationWithTemplate("{org.hibernate.validator.constraints.NotBlank.message}")
                    .addPropertyNode("serviceRequest.tenantId")
                    .addConstraintViolation();
        }

        if (!serviceRequest.getTenantId().matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}")) {
            valid = false;

            constraintValidatorContext.buildConstraintViolationWithTemplate("is not a valid UUID")
                    .addPropertyNode("serviceRequest.tenantId")
                    .addConstraintViolation();
        }

        if (StringUtils.isEmpty(serviceRequest.getToken())) {
            valid = false;

            constraintValidatorContext.buildConstraintViolationWithTemplate("{org.hibernate.validator.constraints.NotBlank.message}")
                    .addPropertyNode("serviceRequest.token")
                    .addConstraintViolation();
        }

        return valid;
    }
}
