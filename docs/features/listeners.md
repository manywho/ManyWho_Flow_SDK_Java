Listeners
=========

**Listeners** are used to listen to events on a particular object or list of objects. When an event occurs on the object
that is listened to, the Service can invoke a Flow for it to take appropriate action.
 
More information on Listeners can be found in [our documentation](https://manywho.github.io/slate/#listeners).

## Annotations

There is a single annotation in the SDK that is used to create a Listener:

* `@Listener.Metadata`

### @Listener.Metadata

The `@Listener.Metadata` annotation is used on a class to provide the SDK with the information for a listener.

#### Annotation Elements

* **event** _(required)_ - the name of the event, and what the builder enters into their Flow must match with this

## Interface

There is a single interface to define a Listener - `Listener<C, T>`.

### Listener&lt;C extends Configuration, T extends Type>

#### Generic Type Parameters

* `C` - this parameter must be the previously-defined [Configuration Settings](../features/configuration.md) class
* `T` - this parameter must be a previously-defined [Type](../features/types.md)

#### Methods

All the methods in this interface have `C configuration` as their first parameter, which is an instance of the Service's 
[Configuration Settings](../features/configuration.md) class, populated with the appropriate values from the request.

They should also save the incoming listener data and register a webhook/trigger/event handler with the underlying 
application. There should also be a worker of some kind that processes incoming events from the underlying application, 
matches with any relevant stored listener data and triggers the Flow to progress forward.
 
##### void create(C configuration, T value, ListenerData listenerData)

This method is called when the incoming value to listen to is a single object.

###### Parameters

* **configuration** - an instance of the Service's [Configuration Settings](../features/configuration.md) class, populated with the appropriate values from the request
* **value** - the object to listen to
* **listenerData** - a wrapper object containing the currently authenticated user information and the incoming `ListenerServiceRequest`

##### void createMultiple(C configuration, List<T> values, ListenerData listenerData)

This method is called when the incoming value to listen to is a list of objects.

###### Parameters

* **configuration** - an instance of the Service's [Configuration Settings](../features/configuration.md) class, populated with the appropriate values from the request
* **values** - a list of objects to listen to
* **listenerData** - a wrapper object containing the currently authenticated user information and the incoming `ListenerServiceRequest`

## Example

> An example for Listeners is coming soon. Feel free to [open an issue](https://github.com/manywho/sdk-java/issues/new) 
or [post a message on Gitter](https://gitter.im/manywho/sdk-java) if you need any help with implementing them in your Service