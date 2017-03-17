Message Actions
===============

A **Message Action** is a method on a Service that allows a Flow to perform a task, like "Send an Email" or "Mark as Completed".

The Java SDK provides a way to easily create a Message Action in your service using annotations. Follow these instructions and you should have a working Message Action in no time!

## Annotations

There are 3 annotations in the Java SDK that you use to create a Message Action:

* `@Action.Metadata`
* `@Action.Input`
* `@Action.Output`
    
### @Action.Metadata

The `@Action.Metadata` annotation is used on a class to indicate that the SDK should parse it as an Action. This means that when you add the Service to your Flow using the Draw Tool, this class will be added to the Service Description, allowing you to be able to use it in your Flow.

#### Annotation Elements

* **name** _(required)_ - this is used to define the name of the Action, as seen by builders in ManyWho
* **summary** - this is used to provide a human-readable description of the Action to builders
* **uri** - the URI that will be used to expose the action as a REST endpoint on the service (automatically prefixed with `/actions` in the SDK)

### @Action.Input

The `@Action.Input` annotation is used to define the Inputs for an action, and fields annotated with it are automatically included in the Action metadata in the Service Description.

#### Annotation Elements

* **name** _(required)_ - this is used to define the name of the Input, as seen by builders in ManyWho
* **contentType** _(required)_ - used by ManyWho to determine the kind of value this Input can hold. Must be a value from the `ContentType` enum
* **required** - used to determine whether an Input is required when using an Action in a Flow

### @Action.Output

The `@Action.Output` annotation is used to define the Outputs for an action, and fields annotated with it are automatically included in the Action metadata in the Service Description.

#### Annotation Elements

* **name** _(required)_ - this is used to define the name of the Output, as seen by builders in ManyWho
* **contentType** _(required)_ - used by ManyWho to determine the kind of value this Output can hold. Must be a value from the `ContentType` enum
* **required** - used to determine whether an Output is required when using an Action in a Flow

## Interface

The interface to define the command for an action is `ActionCommand<C, A, I, O>`. It has 4 generic type parameters, and defines an `execute` method to run your action and return an appropriate response.

### ActionCommand&lt;C, A, I, O>

This interface is used to create a command to execute your previously-defined Action.

#### Generic Type Parameters

* **C** - this parameter must be the previously-defined [Configuration Settings](configuration.md) class
* **A** - this parameter must be the previously-defined class annotated with `@Action.Metadata`
* **I** - this parameter must be the previously-defined class that has one or more fields annotated with `@Action.Input`
* **O** - if any ouputs are required, this parameter must be the previously-defined class that has one or more fields annotated with `@Action.Output`, but if no outputs are required, this can be `Void`

#### Methods

* **ActionResponse&lt;O> execute(C configuration, ServiceRequest request, I input)** - this method has three parameters:
  * **configuration** - an instance of the Service's [Configuration Settings](configuration.md) class, populated with the appropriate values from the request
  * **request** - the raw ManyWho request object
  * **input** - the class containing the populated `@Action.Input` fields
  
The method should then perform the required message logic, and return an `ActionResponse` object with the generic type of the desired output class, along with the appropriate `InvokeType`.

## Example

The following example will create an Action called **Send an Email**, which will be automatically included in your Service Description:

### SendAnEmail.java

This is the class that defines the Action, along with any Inputs and Outputs.

````java
package com.manywho.services.example.actions;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.actions.Action;

import java.time.OffsetDateTime;

@Action.Metadata(name = "Send an Email", summary = "Send an email that gives some information", uri = "sendanemail")
public class SendAnEmail {

    // This doesn't need to be a static inner class, but it helps to logically separate the inputs from the outputs
    public static class Input {
        @Action.Input(name = "To", contentType = ContentType.String)
        private String to;

        @Action.Input(name = "Subject", contentType = ContentType.String)
        private String subject;

        @Action.Input(name = "Message", contentType = ContentType.String)
        private String message;

        public String getTo() {
            return to;
        }

        public String getSubject() {
            return subject;
        }

        public String getMessage() {
            return message;
        }
    }

    public static class Output {
        @Action.Output(name = "Sent At", contentType = ContentType.DateTime)
        private OffsetDateTime sentAt;

        public Output(OffsetDateTime sentAt) {
            this.sentAt = sentAt;
        }
    }
}

````

### SendAnEmailCommand.java

This is the class that actually runs the Action, given the incoming Inputs, and returns the appropriate Outputs back to ManyWho.


````java
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

public class SendAnEmailCommand implements ActionCommand<ServiceConfiguration, SendAnEmail, SendAnEmail.Input, SendAnEmail.Output> {
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
````