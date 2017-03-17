Database
========

A **Database** is a way for Services to handle Database actions in a managed way, using previously-defined [Types](types.md).

The Java SDK provides a way to easily create Databases in your Service. The following documentation should give you a nice overview of how to define and use them.

## Interfaces

There are 2 interfaces to choose from when defining a Database, depending on how your Types are defined.

### Database&lt;C extends Configuration, T extends Type>

This interface should be used if your Service contains statically-defined Types (using the `Type` interface).

#### Generic Type Parameters

* `C` - this parameter must be the previously-defined [Configuration Settings](configuration.md) class
* `T` - this parameter must be the previously-defined [Type](types.md)

#### Methods

All methods have `C configuration` as their first parameter, which is an instance of the Service's [Configuration Settings](configuration.md) class, populated with the appropriate values from the request.

* `T create(C configuration, T object)`:
	- `object` - the object to be created/saved by the Service
	
This method will take the object passed in, assign an ID to it, save it in the appropriate store then return the object again (with the created ID).

* `List<T> create(C configuration, List<T> objects)`:
	- `objects` - a list of objects to be created/saved by the Service
	
This method will take a list of objects passed in, assign IDs to each item, save them in the appropriate store then return the list of objects again (with the created IDs).

* `void delete(C configuration, T object)`:
	- `object` - the object to be deleted by the Service
	
This method will take the passed in object and delete it from the appropriate store.

* `void delete(C configuration, List<T> objects)`:
	- `objects` - the list of objects to be deleted by the Service

This method will take the passed in objects and delete them from the appropriate store.

* `T update(C configuration, T object)`:
	- `object` - the object to be updated/saved by the Service
	
This method will take the object passed in, update the existing record in the appropriate store, then return the updated object again.

* `List<T> update(C configuration, List<T> objects)`:
	- `objects` - the list of objects to be updated/saved by the Service
	
This method will take the list of objects passed in, update the existing records in the appropriate store, then return the updated list of objects again.

### RawDatabase&lt;C extends Configuration>

This interface should be used if your Service contains dynamically-defined Types (probably through the `TypeProvider` interface).

#### Generic Type Parameters

* `C` - this parameter must be the previously-defined [Configuration Settings](configuration.md) class

#### Methods

All methods have `C configuration` as their first parameter, which is an instance of the Service's [Configuration Settings](configuration.md) class, populated with the appropriate values from the request.

* `MObject create(C configuration, MObject object)`:
	- `object` - the object to be created/saved by the Service
	
This method will take the object passed in, assign an External ID to it, extract the Properties, save them in the appropriate store then return the object again (with the created External ID).

* `List<MObject> create(C configuration, List<MObject> objects)`:
	- `objects` - a list of objects to be created/saved by the Service
	
This method will take a list of objects passed in, assign External IDs to each item, extract the Properties, save them in the appropriate store then return the list of objects again (with the created External IDs).

* `void delete(C configuration, MObject object)`:
	- `object` - the object to be deleted by the Service
	
This method will take the passed in object and delete it from the appropriate store.

* `void delete(C configuration, List<MObject> objects)`:
	- `objects` - the list of objects to be deleted by the Service

This method will take the passed in objects and delete them from the appropriate store.

* `MObject update(C configuration, MObject object)`:
	- `object` - the object to be updated/saved by the Service
	
This method will take the object passed in, update the existing record in the appropriate store, then return the updated object again.

* `List<MObject> update(C configuration, List<MObject> objects)`:
	- `objects` - the list of objects to be updated/saved by the Service
	
This method will take the list of objects passed in, update the existing records in the appropriate store, then return the updated list of objects again.

## Example

This example shows a Database implementation to handle a Type called `Person`:

````java
import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.services.database.Database;
import com.manywho.services.example.ServiceConfiguration;
import com.manywho.services.example.repositories.PersonRepository;
import com.manywho.services.example.types.Person;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDatabase implements Database<ServiceConfiguration, Person> {
    private final PersonRepository personRepository;

    @Inject
    public PersonDatabase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person create(ServiceConfiguration configuration, Person person) {
        return personRepository.create(configuration, person);
    }

    @Override
    public List<Person> create(ServiceConfiguration configuration, List<Person> objects) {
        return objects.stream()
                      .map(object -> create(configuration, object))
                      .collect(Collectors.toList());
    }

    @Override
    public void delete(ServiceConfiguration configuration, Person person) {
        personRepository.delete(configuration, person);
    }

    @Override
    public void delete(ServiceConfiguration configuration, List<Person> objects) {
        objects.forEach(object -> delete(configuration, object));
    }

    @Override
    public Person find(ServiceConfiguration configuration, String id) {
        return personRepository.find(id);
    }

    @Override
    public List<Person> findAll(ServiceConfiguration configuration, ListFilter filter) {
        return personRepository.findAll(filter.getLimit(), filter.getOffset());
    }

    @Override
    public Person update(ServiceConfiguration configuration, Person person) {
        return personRepository.update(configuration, person);
    }

    @Override
    public List<Person> update(ServiceConfiguration configuration, List<Person> people) {
        return people.stream()
                     .map(person -> update(configuration, person))
                     .collect(Collectors.toList());
    }
}
````