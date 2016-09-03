ManyWho Java SDK (v2)
================

[![Build Status](https://travis-ci.org/manywho/sdk-java.svg?branch=feature/2.0)](https://travis-ci.org/manywho/sdk-java) [![Maven Central](https://img.shields.io/badge/pre--release-2.0.0--SNAPSHOT-orange.svg?style=flat)](https://oss.sonatype.org/#nexus-search;gav~com.manywho.sdk~~2.0.0-SNAPSHOT~~)

> **WARNING:** This version of the SDK is in development, and shouldn't yet be considered stable. The modules are in flux, and the object structures/names/classes might change at any time!

An open source SDK that allows you to easily build plugins and services that integrate with Flows running on
the [ManyWho](https://manywho.com) platform.

## Installation

The SDK is currently available from the Maven Snapshots repository and is automatically published there on each commit, so it's easy to integrate with your Java application:

```xml
<repositories>
    <repository>
        <id>ossrh</id>
        <url>https://oss.sonatype.org/content/repositories/snapshots</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.manywho.sdk</groupId>
        <artifactId>sdk-services</artifactId>
        <version>2.0.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```

## Usage

Some initial basic information on how to build a plugin that integrates with ManyWho using this SDK is available in the [Wiki](https://github.com/manywho/sdk-java/wiki).

## Modules

**WARNING:** These modules are in flux, and the object structures/names/classes might change at any time!

### sdk-api

This module contains the ManyWho API objects, spanning across our [Draw](https://manywho.github.io/slate/#draw), [Run](https://manywho.github.io/slate/#run) and [Translate](https://manywho.github.io/slate/#translate) APIs. Our APIs aren't 100% covered (yet!) but the most commonly used objects are available. If there are objects missing that you need in your application, feel free to [open an issue](https://github.com/manywho/sdk-java/issues/new) or [submit a pull request](https://github.com/manywho/sdk-java/blob/master/CONTRIBUTING.md) and we'll include them as soon as possible.

```xml
<dependency>
    <groupId>com.manywho.sdk</groupId>
    <artifactId>sdk-api</artifactId>
    <version>${version.manywho.sdk}</version>
</dependency>
```

### sdk-client

This module supplies some clients that help you integrate with the various ManyWho APIs. It currently supports parts of the [Run API](https://manywho.github.io/slate/#run) and is actively being improved to cover the other APIs.

```xml
<dependency>
    <groupId>com.manywho.sdk</groupId>
    <artifactId>sdk-client</artifactId>
    <version>${version.manywho.sdk}</version>
</dependency>
```

### sdk-server-servlet3

This module enables support for running services using a Servlet 3 compatible container (e.g. Tomcat) and 
includes the `sdk-services` module as a dependency.

```xml
<dependency>
    <groupId>com.manywho.sdk</groupId>
    <artifactId>sdk-server-servlet3</artifactId>
    <version>${version.manywho.sdk}</version>
</dependency>
```

### sdk-server-undertow

This module is _probably_ what you want - it enables support for running services using the high-performance, embedded Undertow server and
includes the `sdk-services` module as a dependency.

```xml
<dependency>
    <groupId>com.manywho.sdk</groupId>
    <artifactId>sdk-server-undertow</artifactId>
    <version>${version.manywho.sdk}</version>
</dependency>
```

### sdk-services

This module includes the vast majority of the SDK's functionality for building services. Basic documentation for using it is being actively written [on the Wiki](https://github.com/manywho/sdk-java/wiki), but if there is anything missing feel free to [open an issue](https://github.com/manywho/sdk-java/issues/new) or [submit a pull request](https://github.com/manywho/sdk-java/blob/master/CONTRIBUTING.md) and we'll update them as soon as possible.

```xml
<dependency>
    <groupId>com.manywho.sdk</groupId>
    <artifactId>sdk-services</artifactId>
    <version>${version.manywho.sdk}</version>
</dependency>
```

## Contributing

Contributions are welcome to the project - whether they are feature requests, improvements or bug fixes! Refer to [CONTRIBUTING.md](CONTRIBUTING.md) for our contribution requirements.

## License

This SDK is released under the [MIT License](http://opensource.org/licenses/mit-license.php).