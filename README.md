# Sample Micro-service
This project provides a sample micro-service which contains an opinionated structure, technology stack, useful utilities and base classes and best practice based composition. 

This project can be used as is but is intended to provide the source material for a Maven
archetype which can be used to ensure that all your micro-services conform to the same architectural principals.

If you wish to customize the archetype, you should fork/clone this project, make the desired customizations, then generate the archetype. If you simply want to use the archetype without customizations, you can clone the archetype and follow the instructions for creating new projects.

## Structure

The project is implemented as a Maven multi-module project with the following modules

### /
Project parent.

### /api
Public API types, for example data transfer types.

### /service
REST service implementation.

### /acceptance
Acceptance (functional/feature) tests for the REST service.

*NOTE: if this module is named test archetype:create-from-project will fail to gather the project content (likely because test is also the value of a phase).*

### /container
Containerization (Docker) of the REST service. If you don't plan to use Docker you can remove the module from the parent POM. 

*NOTE: The standard Dockerfile is renamed Dockerfile.txt so that it will match the filtering fileset and be included in the achetype resources.*

## Building and Running

In the project home directory 

    $ mvn clean package
    $ java -jar service/target/service-<version>-bin.jar options
    
    where:  
        --server.port=####		override the default server listener port of 8080
Make sure to replace <version> with your build version, for example 1.0.0.Final.

## Generating the archetype

In the project home directory 

    $ mvn archetype:create-from-project
    $ cd target/generated-sources/archetype
    $ mvn install
## Create a new project from the archetype

In the directory you wish the project to be created

    $ mvn archetype:generate -DarchetypeGroupId=org.rnott.samples.microservice \
        -DarchetypeArtifactId=microservice-archetype -DarchetypeVersion=1.0.0.Final \
        -DgroupId=<your-groupId> -DartifactId=<your-artifactId>

