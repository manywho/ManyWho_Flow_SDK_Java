package com.manywho.sdk.services.validation.social;

import com.manywho.sdk.api.run.elements.config.SocialServiceRequest;
import com.manywho.sdk.services.validation.AbstractConstraintValidator;
import com.manywho.sdk.services.validation.ServiceRequestValidator;

import javax.inject.Inject;
import javax.validation.ConstraintValidatorContext;

public class SearchUsersByNameValidator extends AbstractConstraintValidator<SearchUsersByName, SocialServiceRequest> {
    private ServiceRequestValidator serviceRequestValidator;

    @Inject
    public SearchUsersByNameValidator(ServiceRequestValidator serviceRequestValidator) {
        this.serviceRequestValidator = serviceRequestValidator;
    }

    @Override
    public boolean isValid(SocialServiceRequest socialServiceRequest, ConstraintValidatorContext constraintValidatorContext) {
        return serviceRequestValidator.isValid(socialServiceRequest, constraintValidatorContext);
    }
}