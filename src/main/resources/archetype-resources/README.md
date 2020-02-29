# Service Name
This is the description of what Service Name does.

## Structure

The project is implemented as a Maven multi-module project with the following modules

### /
Project parent.

### /api
Public API types, for example data transfer types.

### /service
REST service implementation.

### /test
Functional tests for the REST service.

### /container
Containerization (Docker) of the REST servvice.

## Build Instructions

## Runtime instructions

    $ java -jar ServiceName-bin.jar options
    
    where:  
        --server.port=####		override the default server listener port of 8080
