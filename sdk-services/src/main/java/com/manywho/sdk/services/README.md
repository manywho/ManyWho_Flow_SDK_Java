sdk-services
============

The `sdk-services` module includes the vast majority of the SDK's functionality for building services. Basic documentation for using it is being actively written [on the Wiki](https://github.com/manywho/sdk-java/wiki), but if there is anything missing feel free to [open an issue](https://github.com/manywho/sdk-java/issues/new) or [submit a pull request](https://github.com/manywho/sdk-java/blob/master/CONTRIBUTING.md) and we'll update them as soon as possible.

## Overview

Each separate aspect of the SDK is split out into its own package, containing functionality only specific to itself. This is done to make the codebase a bit cleaner, and to make it more obvious where a piece of functionality is located (hopefully!).

Here is a short overview of all the packages and what each one contains:

#### actions

This contains all the annotations, interfaces, entities and logic specific to creating and using [Message Actions](https://manywho.github.io/slate/#message-actions).

#### configuration

This contains the interfaces and logic specific to easily creating and using Configuration Values.

#### controllers

This contains the abstract and default implementations of JAX-RS controllers that are specific to each segment of the Service API. The abstract controllers can be used directly by a service that wants to override the default implementations that the SDK provides.

#### database

This contains the interfaces, entities and logic specific to handling [Database](https://manywho.github.io/slate/#data-actions) calls.

#### describe

This contains the builders and logic used to construct Service metadata descriptions needed for installation.

#### files

This contains the interfaces, entities and logic used to handle Files inside Services.

#### identity

This contains the interfaces, entites and logic used to handle Identity inside Services.

#### jaxrs

This contains a bunch of JAX-RS providers that Services need for things like configuring [Jackson](https://github.com/FasterXML/jackson) (for parsing incoming JSON correctly) and mapping an `Exception` to a response.

#### listeners

This contains the interfaces, entities and logic for creating and handling [Listeners](https://manywho.github.io/slate/#listeners).

#### providers

This contains some [Guice](https://github.com/google/guice) providers used internally inside the SDK, and some that can be used to inject things into Services.

#### servers

This contains interfaces that must be implemented by server wrappers to support running Services (e.g. Undertow, Tomcat, etc.) 

#### types

This contains representations of the built-in ManyWho System Types, and interfaces and logic needed to create and use custom [Types](https://manywho.github.io/slate/#type-element) in Services.

#### utils

This contains some miscellaneous "utility" classes that don't fit into a specific domain.

#### validation

This contains entities and validators for various API objects and Service endpoints.

#### values

This contains logic and entities used for parsing [Values](https://manywho.github.io/slate/#value-element).
