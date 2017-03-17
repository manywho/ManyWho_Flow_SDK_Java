Servlet 3
=========

Running using a Servlet 3 container (e.g. Tomcat) is supported with the SDK - you'll need to use the `sdk-server-servlet3`
dependency, which enables general support for a Service.

Currently, the SDK is only tested using Tomcat but the module is written to be compatible with multiple containers - if 
you encounter a problem using another container, feel free to [open an issue](https://github.com/manywho/sdk-java/issues/new) 
and we'll try to get to the bottom of it.

## Example

This is a simple example of integrating support for Servlet 3 into a Service.

#### pom.xml

```xml
<dependency>
    <groupId>com.manywho.sdk</groupId>
    <artifactId>sdk-server-servlet3</artifactId>
    <version>${version.sdk}</version>
</dependency>
```

#### Application.java

```java
import com.manywho.sdk.services.servers.Servlet3Server;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class Application extends Servlet3Server {
    public Application() {
        
        // Register any Guice modules that are needed
        this.addModule(new ApplicationModule());
        
        // Set the Application class (the entry point to the Service, usually this class)
        this.setApplication(Application.class);
        
        // Initialize the application
        this.start();
    }
}
```