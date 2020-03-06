package com.manywho.services.example.actions;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.actions.Action;
import com.manywho.services.example.types.Person;

import java.time.OffsetDateTime;

@Action.Metadata(name = "Add Annotation", summary = "Add an annotation to a person", uri = "addannotation")
public class AddAnnotation {
    public static class Input {
        @Action.Input(name = "Person", contentType = ContentType.Object)
        private Person person;

        @Action.Input(name = "Annotation", contentType = ContentType.String)
        private String annotation;

        public Person getPerson() {
            return person;
        }

        public String getAnnotation() {
            return annotation;
        }
    }

    public static class Output {
        @Action.Output(name = "Person", contentType = ContentType.Object)
        private Person person;

        @Action.Output(name = "Annotation", contentType = ContentType.String)
        private String annotation;

        @Action.Output(name = "Created At", contentType = ContentType.DateTime)
        private OffsetDateTime createdAt;

        public Output(Person person, String annotation, OffsetDateTime createdAt) {
            this.person = person;
            this.annotation = annotation;
            this.createdAt = createdAt;
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        public void setAnnotation(String annotation) {
            this.annotation = annotation;
        }

        public void setCreatedAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
        }
    }
}
