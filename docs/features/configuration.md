Configuration
=============

**Configuration Settings** are the way for a Flow builder to setup a Service with a specific configuration. For example, a generic Email Service might have **SMTP Hostname** and **SMTP Port** Configuration Settings that the builder can use to tell the Service to send emails through Gmail or Office 365.

The Java SDK gives you a way to easily define Configuration Settings in your service using annotations, and have these injected straight into your Actions, Databases, etc. The following documentation should have you creating Settings in no time!

## Interface

The only interface used when defining Configuration Settings is `Configuration`, and is used for greatly simplified detection and generic hinting in the SDK.

### Configuration

This interface contains no methods, but your Configuration Settings class must implement it to be picked up by the SDK. Only **one** class in your service may implement this interface.

## Annotations

There is a single annotation in the Java SDK that is used to define a Configuration Setting:

* `@Configuration.Setting`

### @Configuration.Setting

The `@Configuration.Setting` annotation is used on fields in a class that should be used as definitions for Settings. Fields with this annotation are automatically included in the Service Description, meaning that Flow builders can setup the Service right away.

#### Annotation Elements

* **name** _(required)_ - this is used to define the name of the Configuration Setting, as seen by builders in ManyWho
* **contentType** _(required)_ - used by ManyWho to determine the kind of value this Setting can hold. Must be a value from the `ContentType` enum
* **required** - used to determine whether a Configuration Setting is required when installing the Service

## Example

The following example will define 2 Configuration Settings for a Service - a **Username** setting and a **Password** setting:

````java
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.configuration.Configuration;

public class ServiceConfiguration implements Configuration {
    @Configuration.Setting(name = "Username", contentType = ContentType.String)
    private String username;

    @Configuration.Setting(name = "Password", contentType = ContentType.Password)
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
````