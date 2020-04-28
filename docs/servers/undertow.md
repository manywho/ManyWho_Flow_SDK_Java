Undertow
========

> Using Undertow is our recommended way of running a Service

The SDK supports running a Service using the high-performance, embedded Undertow web server - this requires the 
`sdk-server-undertow` dependency.
  
Using Undertow is our recommended way of running a service, as it's very performant, easy to deploy, and it's the server 
we use the most internally so it's very battle tested in the realm of ManyWho Services!

## Example

This is an example of integrating support for Undertow into a Service.

```java
import com.manywho.sdk.services.servers.EmbeddedServer;
import com.manywho.sdk.services.servers.undertow.UndertowServer;

public class Application {
    public static void main(String[] args) throws Exception {
        EmbeddedServer server = new UndertowServer();
        server.addModule(new ApplicationModule());
        server.setApplication(Application.class);
        server.start();
    }
}
```