package com.manywho.sdk.services.validation.social;

import com.google.common.base.Strings;
import com.manywho.sdk.api.run.elements.config.SocialServiceRequest;
import com.manywho.sdk.services.validation.AbstractConstraintValidator;
import com.manywho.sdk.services.validation.ServiceRequestValidator;

import javax.inject.Inject;
import javax.validation.ConstraintValidatorContext;

public class PostNewMessageValidator extends AbstractConstraintValidator<PostNewMessage, SocialServiceRequest> {
    private ServiceRequestValidator serviceRequestValidator;

    @Inject
    public PostNewMessageValidator(ServiceRequestValidator serviceRequestValidator) {
        this.serviceRequestValidator = serviceRequestValidator;
    }

    @Override
    public boolean isValid(SocialServiceRequest socialServiceRequest, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid = serviceRequestValidator.isValid(socialServiceRequest, constraintValidatorContext);

        if (socialServiceRequest.getNewMessage() == null) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("{javax.validation.constraints.NotNull.message}")
                    .addPropertyNode("socialServiceRequest.newMessage")
                    .addConstraintViolation();

            return false;
        }

        if (Strings.isNullOrEmpty(socialServiceRequest.getNewMessage().getSenderId())) {
            valid = false;

            constraintValidatorContext.buildConstraintViolationWithTemplate("{org.hibernate.validator.constraints.NotBlank.message}")
                    .addPropertyNode("socialServiceRequest.newMessage.senderId")
                    .addConstraintViolation();
        }

        if (Strings.isNullOrEmpty(socialServiceRequest.getNewMessage().getMessageText())) {
            valid = false;

            constraintValidatorContext.buildConstraintViolationWithTemplate("{org.hibernate.validator.constraints.NotBlank.message}")
                    .addPropertyNode("socialServiceRequest.newMessage.messageText")
                    .addConstraintViolation();
        }

        if (socialServiceRequest.getNewMessage().getMentionedWhos() == null) {
            valid = false;

            constraintValidatorContext.buildConstraintViolationWithTemplate("{javax.validation.constraints.NotNull.message}")
                    .addPropertyNode("socialServiceRequest.newMessage.mentionedWhos")
                    .addConstraintViolation();
        }

        return valid;
    }
}
