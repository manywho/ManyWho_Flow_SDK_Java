package com.manywho.sdk.validation.social;

import com.manywho.sdk.entities.run.elements.config.SocialServiceRequest;
import com.manywho.sdk.validation.ServiceRequestValidator;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FollowStreamValidator implements ConstraintValidator<FollowStream, SocialServiceRequest> {
    private ServiceRequestValidator serviceRequestValidator;

    @Inject
    public FollowStreamValidator(ServiceRequestValidator serviceRequestValidator) {
        this.serviceRequestValidator = serviceRequestValidator;
    }

    @Override
    public void initialize(FollowStream annotation) {

    }

    @Override
    public boolean isValid(SocialServiceRequest socialServiceRequest, ConstraintValidatorContext constraintValidatorContext) {
        return serviceRequestValidator.isValid(socialServiceRequest, constraintValidatorContext);
    }
}