package com.manywho.sdk.validation.social;

import com.manywho.sdk.entities.run.elements.config.SocialServiceRequest;
import com.manywho.sdk.validation.ServiceRequestValidator;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreateStreamValidator implements ConstraintValidator<CreateStream, SocialServiceRequest> {
    private ServiceRequestValidator serviceRequestValidator;

    @Inject
    public CreateStreamValidator(ServiceRequestValidator serviceRequestValidator) {
        this.serviceRequestValidator = serviceRequestValidator;
    }

    @Override
    public void initialize(CreateStream annotation) {

    }

    @Override
    public boolean isValid(SocialServiceRequest socialServiceRequest, ConstraintValidatorContext constraintValidatorContext) {
        return serviceRequestValidator.isValid(socialServiceRequest, constraintValidatorContext);
    }
}