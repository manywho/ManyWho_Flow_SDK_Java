package com.manywho.sdk.validation.social;

import com.manywho.sdk.entities.run.elements.config.SocialServiceRequest;
import com.manywho.sdk.validation.ServiceRequestValidator;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GetStreamFollowersValidator implements ConstraintValidator<GetStreamFollowers, SocialServiceRequest> {
    private ServiceRequestValidator serviceRequestValidator;

    @Inject
    public GetStreamFollowersValidator(ServiceRequestValidator serviceRequestValidator) {
        this.serviceRequestValidator = serviceRequestValidator;
    }

    @Override
    public void initialize(GetStreamFollowers annotation) {

    }

    @Override
    public boolean isValid(SocialServiceRequest socialServiceRequest, ConstraintValidatorContext constraintValidatorContext) {
        return serviceRequestValidator.isValid(socialServiceRequest, constraintValidatorContext);
    }
}