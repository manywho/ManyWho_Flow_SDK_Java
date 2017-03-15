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
