Case Study: myRetail RESTful Service
====================================

Outline
=======
•	Responds to an HTTP GET request as below
	Example product IDs: 15117729, 16483589, 16696652, 16752456, 15643793) 
    Example response: {"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}}
      	
	For example Raw Request:
    GET http://localhost:9000/retail/v1/products/13860428 HTTP/1.1
	Accept-Encoding: gzip,deflate
	Host: localhost:9000
	Connection: Keep-Alive
	User-Agent: Apache-HttpClient/4.1.1 (java 1.5)
	
	& Raw Response:
		GET http://localhost:9000/retail/v1/products/13860428 HTTP/1.1 
	    Date: Wed, 07 Sep 2016 16:37:44 GMT 
	    statusCode: 0
	    Content-Type: application/json
	    Content-Encoding: gzip
	    Vary: Accept-Encoding, User-Agent
	    Transfer-Encoding: chunked
	    {"id":13860428,"name":"The Big Lebowski (Blu-ray)","current_price":{"value":13.49,"currency_code":"USD"}}
  & so on...
     --verified for product id - 13860428 & 15117729.
•	Performs an HTTP GET to retrieve the product name from an external API. (For this exercise the data will come from api.target.com, but let’s just pretend this is an internal resource hosted by myRetail) Example: https://api.target.com/products/v3/13860428?fields=descriptions&id_type=TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz
     --verified for product id - 13860428 & 15117729.
•	Reads pricing information from a NoSQL data store used NoSQL couchbase couchbase-server-community_4.1.0 and combines it with the product id and name from the HTTP request into a single response. 
     --verified for product id - 13860428 & 15117729.
•	BONUS: Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product’s price in the data store. 
     --verified for product id - 13860428 & 15117729.

Junit & Cucumber feature report both are created and shared seperately.

Also, soapUI project created to run them through testSuite just in one click. 


Choosing up RESTful Framework
---
On the Java side there are probably fewer framework choices, but still plenty of options. Jersey, cxf, RESTEasy & others are the reference implementation for Java's API for REST services, JAX-RS, and is very established. Other choices include Spring, Restlet, Play Framework, and Dropwizard.

Picked-up Dropwizard API to develop this case study :
(http://www.javadoc.io/doc/io.dropwizard/dropwizard-core) 
or
http://www.javadoc.io/doc/io.dropwizard/dropwizard-core/1.0.0

My local sandbox setup is using little older version, but it can be upgraded to work on the latest version with a little tweak.

Setting Up Gradle/Maven
---
We recommend you use Maven for new Dropwizard applications. If you’re a big Ant / Ivy, Buildr, Gradle, SBT, Leiningen, or Gant fan, that’s cool, but we use Maven, and we’ll be using Maven as we go through this example application. If you have any questions about how Maven works, Maven: The Complete Reference should have what you’re looking for. (We’re assuming you know how to create a new Maven project. If not, you can use this to get started.)

First, add a dropwizard.version property to your POM with the current version of Dropwizard (which is 1.0.0):

java -jar build/lib/your-application-0.0.1-SNAPSHOT.jar server your-application.yml
*Dropwizard is a sneaky way of making fast Java web applications.*
It's a little bit of opinionated glue code which bangs together a set of libraries which have
historically not sxxked:

* [Jetty](http://www.eclipse.org/jetty/) for HTTP servin'.
* [Jersey](http://jersey.java.net/) for REST modelin'.
* [Jackson](https://github.com/FasterXML/jackson) for JSON parsin' and generatin'.
* [Logback](http://logback.qos.ch/) for loggin'.
* [Hibernate Validator](http://hibernate.org/validator/) for validatin'.
* [Metrics](http://metrics.dropwizard.io) for figurin' out what your application is doin' in production.

Used NoSQL com.couchbase.client version 2.3.1 with java 
Also, other dependcies as per build.gradle in the respective module.

Read more at [dropwizard.io](http://www.dropwizard.io).

a. Creating A Configuration Class
---
To add a configuration class.

b. Creating An Application Class
---
To add an configuration class.

c. Creating A Representation Class
---
To add a representation class.

d. Creating A Resource Class
---
To add a resource class.

e. Registering A Resource 
---
To register a resource.

f. Creating A Health Check 
---
To create a health check.

g. Adding A Health Check 
---
To add a health check.

h. Building Fat JARs 
---
To build Fat jars.

i. Versioning Your JARs 
---
To version your Jar.

j. Running Your Application
---
Now that you’ve built a JAR file, it’s time to run it.

In your project directory, run this:

java -jar target/your-application-0.0.1-SNAPSHOT.jar
You should see something like the following:

usage: java -jar your-application-0.0.1-SNAPSHOT.jar
    [-h [-v] {server} ...

positional arguments:
  {server}               available commands

optional arguments:
  -h, --help             show this help message and exit
  -v, --version          show the service version and exit
Dropwizard takes the first command line argument and dispatches it to a matching command. In this case, the only command available is server, which runs your application as an HTTP server. The server command requires a configuration file, so let’s go ahead and give it the YAML file we previously saved:

java -jar build/lib/your-application-0.0.1-SNAPSHOT.jar server your-application.yml   

or through Eclipse IDE - 

// dropWizard - The main class of the application to begin the fun:)
mainClassName = 'com.retail.api.service.product.RetailProductService'
// dropWizard - Configure the run task to start the Dropwizard service
run {
    args 'server', './src/main/resources/retail-service.yml'
}
// to run Restful dropWizard application use the -  clean run

or through eclipse IDE - 
-----------------------

using gradle : clean build install   @main - ret
& followed by
using gralde : run

k. How to use it ?
---
Your Dropwizard application is now listening on ports 9000 as this port is configurable for application requests and 9001 for administration requests. If you press ^C, the application will shut down gracefully, first closing the server socket, then waiting for in-flight requests to be processed, then shutting down the process itself.

However, while it’s up, let’s give it a whirl! Click here to say hello! Click here to get even friendlier!

So, we’re generating sayings. Awesome. But that’s not all your application can do. One of the main reasons for using Dropwizard is the out-of-the-box operational tools it provides, all of which can be found on the admin port.

If you click through to the metrics resource, you can see all of your application’s metrics represented as a JSON object.

The threads resource allows you to quickly get a thread dump of all the threads running in that process.

Hint
When a Jetty worker thread is handling an incoming HTTP request, the thread name is set to the method and URI of the request. This can be very helpful when debugging a poorly-behaving request.
The healthcheck resource runs the health check class we wrote. You should see something like this:

* deadlocks: OK
* template: OK

For Metrics, Healthcheck etc
http://localhost:9001/

l. Performance benefits?
---
Well, congratulations. You’ve got a your application ready for production (except for the lack of tests which you can add using various framework avialble for unit testing) that’s capable of doing 30,000-50,000 requests per second. Hopefully, you’ve gotten a feel for how Dropwizard combines Jetty, Jersey, Jackson, and other stable, mature libraries to provide a phenomenal platform for developing RESTful web applications.

There’s a lot more to Dropwizard than is covered here (commands, bundles, servlets, advanced configuration, validation, HTTP clients, database clients, views, etc.), all of which is covered by the User Manual provided at http://www.dropwizard.io/1.0.0/docs/manual/index.html#manual-index
