Types
=====

A **Type** is an object used to send data to and from a Service that uses a predefined structure, e.g. an Account, Person or Message.

The Java SDK provides a way to easily create Types in your service using annotations. Follow these instructions and you should have some Types in no time!

## Annotations

There are 3 annotations in the Java SDK that you use to create a Type:

* `@Type.Element`
* `@Type.Identifier`
* `@Type.Property`
    
### @Type.Element

The `@Type.Element` annotation is used on a class to indicate that the SDK should parse it as a Type Element. This means that when you add the Service to your Flow using the Draw Tool, this class will be added to the Service Description, allowing you to be able to use it in your Flow just like any other Type.

#### Annotation Elements

* **name** _(required)_ - this is used to define the name of the Type, as seen by builders in ManyWho
* **summary** - this is used to provide a human-readable description of the Type to builders

### @Type.Identifier

The `@Type.Identifier` annotation is to be used on fields in a class that already has the `@Type.Element` annotation. Each defined `@Type.Element` class **must** have a single `String` field that is annotated with `@Type.Identifier`, as it is used by ManyWho to uniquely identify each Value based on the Type.

#### Annotation Elements

*None*

### @Type.Property

The `@Type.Property` annotation is used on fields in a class that already has the `@Type.Element` annotation. They are also automatically included in the Service Description, are able to be used as bound fields in a Flow, and can be used to store values inside your Service.
 
#### Annotation Elements

* **name** _(required)_ - this is used to define the name of the Property, as seen by builders in ManyWho
* **contentType** _(required)_ - used by ManyWho to determine the kind of value this property can hold. Must be a value from the `ContentType` enum
* **bound** _(default **true**)_ - determines whether any bindings will be automatically generated for this Property in the Service Description, so they can be used in Database Loads and Saves.

## Interface

The only interface to define a Type is `Type`, and is used for greatly simplified Type detection and generic hinting in the SDK.

### Type

This interface contains no methods, but each Type must implement it to be picked up by the SDK.

## Example

The following example will create 2 properties on a Type called **Person**, each of a different `ContentType`, but the `Age` property won't be returned in a Database Load:

````java
package com.manywho.services.example.types;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = "Person")
public class Person implements Type {

    @Type.Identifier
    private String id;

    @Type.Property(name = "Name", contentType = ContentType.String)
    private String name;

    @Type.Property(name = "Age", contentType = ContentType.Number, bound = false)
    private Integer age;

    public Person(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
````