Files
=====

**Files** can be loaded, saved and deleted using a Service, and the SDK provides a very easy way to support this with 
the `FileHandler` interface.

## Interface

The only interface needed to provide support for Files is `FileHandler<C>`, and this interface provides some methods that
greatly abstract some of the logic needed for file handling in Services.

### FileHandler&lt;C>

This interface is used to create a handler to manage File actions.

#### Generic Type Parameters

* **C** - this parameter must be the previously-defined [Configuration Settings](configuration.md) class

#### Methods

* **List<$File> findAll(C configuration, FileListFilter filter, String path)** - this method has three parameters:
  * **configuration** - an instance of the Service's [Configuration Settings](configuration.md) class, populated with the appropriate values from the request
  * **filter** - the filter that should be used to search for Files
  * **path** - the path in which to search for files
  
The method should perform a search of the backing file store with any provided filters, and return a populated list of
`$File` objects.

* **$File upload(C configuration, String path, FileUpload upload)** - this method has three parameters:
  * **configuration** - an instance of the Service's [Configuration Settings](configuration.md) class, populated with the appropriate values from the request
  * **path** - the path in which to upload the file
  * **upload** - an object containing the uploaded file as a stream, and the original filename if one was provided
  
The method should save the uploaded file into the backing file store, and return a single populated `$File` object.

## Example

```java
import com.manywho.sdk.api.run.elements.type.FileListFilter;
import com.manywho.sdk.services.files.FileHandler;
import com.manywho.sdk.services.files.FileUpload;
import com.manywho.sdk.services.types.system.$File;
import com.manywho.services.example.ServiceConfiguration;

import java.util.List;

public class FileHandlerExample implements FileHandler<ServiceConfiguration> {
    private final FileManager fileManager;
    
    @Inject
    public FileHandlerExample(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public List<$File> findAll(ServiceConfiguration configuration, FileListFilter filter, String path) {
        return fileManager.findAll(configuration, filter, path);
    }

    @Override
    public $File upload(ServiceConfiguration configuration, String path, FileUpload upload) {
        return fileManager.upload(configuration, path, upload.getContent(), upload.getName());
    }
}
```