ManyWho Java SDK
================

[![Join the chat at https://gitter.im/manywho/sdk-java](https://badges.gitter.im/manywho/sdk-java.svg)](https://gitter.im/manywho/sdk-java?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

[![Build Status](https://travis-ci.org/manywho/sdk-java.svg?branch=master)](https://travis-ci.org/manywho/sdk-java)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.manywho/sdk/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.manywho/sdk)

An open source SDK that allows you to easily build plugins and services that integrate with Flows running on
the [ManyWho](https://manywho.com) platform.

## Installation

The SDK is available on Maven and is automatically published there on each release, so it's easy to integrate with your 
Java application:

```xml
<dependency>
    <groupId>com.manywho</groupId>
    <artifactId>sdk</artifactId>
    <version>${version.manywho.sdk}</version>
</dependency>
```

The latest version is always available to find on the [Releases tab](https://github.com/manywho/sdk-java/releases).

## Usage

Some initial basic information on how to build a plugin that integrates with ManyWho using this SDK is available on
the [ManyWho Developers](https://developers.manywho.com/display/MA/Building+a+Service) site.

## Modules

### sdk-bom

`sdk-bom` is a bill of materials that is used by Maven to make sure that related dependencies have the correct versions
to work together. It should be placed in the `dependencyManagement` section in your `pom.xml` like so:

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.manywho.sdk</groupId>
            <artifactId>sdk-bom</artifactId>
            <version>${version.manywho.sdk}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

<!-- No versions for the ManyWho SDK packages are needed, due to including the BOM above -->
<dependencies>
    <dependency>
        <groupId>com.manywho</groupId>
        <artifactId>sdk</artifactId>
    </dependency>
    <dependency>
        <groupId>com.manywho.sdk</groupId>
        <artifactId>sdk-client</artifactId>
    </dependency>
</dependencies>
```

### sdk-client

**Warning:** This module is in flux, and the object structures/names/classes might change at any time!

This module supplies some clients that help you integrate with the various ManyWho APIs. It currently supports parts of
the Run API and is actively being improved to cover the other APIs.

```xml
<dependency>
    <groupId>com.manywho.sdk</groupId>
    <artifactId>sdk-client</artifactId>
    <version>${version.manywho.sdk}</version>
</dependency>
```

### sdk-core

This module is probably what you want - it includes the vast majority of the SDK's functionality and is currently being
split out into separate modules bit-by-bit.

```xml
<dependency>
    <groupId>com.manywho.sdk</groupId>
    <artifactId>sdk-core</artifactId>
    <version>${version.manywho.sdk}</version>
</dependency>
```

### sdk-test

This module contains some handy test cases and utilities that can be used to write unit tests and integration tests for
your services.

```xml
<dependency>
    <groupId>com.manywho.sdk</groupId>
    <artifactId>sdk-test</artifactId>
    <version>${version.manywho.sdk}</version>
</dependency>
```

### sdk

This module is a meta package that includes the `sdk-client`, `sdk-core` and `sdk-test` packages. It's mostly around for 
backwards compatibility with old services and clients. 

It's now recommended to use the `sdk-bom` package and to depend on the individual packages in your `pom.xml`.

## Contributing

Contribution are welcome to the project - whether they are feature requests, improvements or bug fixes! Refer to 
[CONTRIBUTING.md](CONTRIBUTING.md) for our contribution requirements.

## License

This SDK is released under the [MIT License](http://opensource.org/licenses/mit-license.php).