package com.manywho.sdk.services.validation;

import javax.validation.ConstraintValidator;
import java.lang.annotation.Annotation;

public abstract class AbstractConstraintValidator<A extends Annotation, T> implements ConstraintValidator<A, T> {
    @Override
    public void initialize(A annotation) {
        // Not used
    }
}
