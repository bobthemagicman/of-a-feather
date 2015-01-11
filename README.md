Current Build Status Using Drone.io: [![Build Status](https://drone.io/bitbucket.org/bobthemagicman/flockspring/status.png)](https://drone.io/bitbucket.org/bobthemagicman/flockspring/latest)

## Synopsis

This is the Of A Feather website application project repository. Here you will find the code necessary to build and deploy the entire Of A Feather website to an environment. 

## Development Installation

The following short guide will help you to setup a basic development environment. 

Requirements:
* A Development IDE (preferably Eclipse)
* Java 8 SE
* Apache Maven 3.2.5

This goal of this guide is to assist you in starting and debugging the Of A Feather web application, as such instruction relating to installing and setting up the prerequisites is not provided at this time.

1. Clone this repository in to your working directory:
    ```
    git clone https://bobthemagicman@bitbucket.org/bobthemagicman/flockspring.git
    ```
    
2. To start the application run:
    mvn tomcat7:run

## Production Installation

## Tests

To run the test suites simply run:
    mvn validate

## Contributors

Active Contributors:
* Justen Britian - justen@ofafeather.org
* Steven Yarbrough 

## License

There is no licensing available for this project. Copyright held by FlockSpring Inc. 2015. All rights reserved.