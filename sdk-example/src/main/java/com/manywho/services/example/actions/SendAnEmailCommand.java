package com.manywho.services.example.actions;

import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.actions.ActionResponse;
import com.manywho.services.example.ServiceConfiguration;
import com.manywho.services.example.actions.SendAnEmail.Input;
import com.manywho.services.example.actions.SendAnEmail.Output;
import com.manywho.services.example.managers.EmailManager;

import javax.inject.Inject;
import java.time.OffsetDateTime;

public class SendAnEmailCommand implements ActionCommand<ServiceConfiguration, SendAnEmail, Input, Output> {
    private final EmailManager emailManager;

    @Inject
    public SendAnEmailCommand(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    @Override
    public ActionResponse<Output> execute(ServiceConfiguration configuration, ServiceRequest request, Input input) {
        // Do whatever logic is necessary to send the email here
        OffsetDateTime sentAt = emailManager.sendEmail(configuration, input.getTo(), input.getSubject(), input.getMessage());

        // Create the outputs
        Output output = new Output(sentAt);

        // Return the action response, telling the Flow to go forward
        return new ActionResponse<>(output, InvokeType.Forward);
    }
}
