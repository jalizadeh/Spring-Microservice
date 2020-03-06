# Spring Microservices

![](diagram.png)


### Limits Service
- [http://localhost:8080/limits](http://localhost:8080/limits)

### Cloud Config Server

### git-localconfig
- ALWAYS new changes must be commited, to be accessible
- `/cloudconfigserver/git-localconfig/limits-service.properties`

#### Limits Service Environments
- [http://localhost:8888/limits-service/default](http://localhost:8080/limits/default)
- [http://localhost:8888/limits-service/dev](http://localhost:8080/limits/dev)
- [http://localhost:8888/limits-service/qa](http://localhost:8080/limits/qa)
- [http://localhost:8888/limits-service/stage](http://localhost:8080/limits/stage)
- [http://localhost:8888/limits-service/product](http://localhost:8080/limits/product)

### Currency Exchange Service
- [http://localhost:8000/](http://localhost:8000)
- [http://localhost:8000/currency-exchange/from/EUR/to/USD](http://localhost:8000/currency-exchange/from/EUR/to/USD)

#### H2 Database
- `data.sql` contains some dummy data
- use [http://localhost:8000/h2-console](http://localhost:8000/h2-console) to view the database
	- Dirver Class: org.h2.Driver
	- JDBC URL: jdbc:h2:mem:testdb
	- User Name: sa
	- Password:


### Currency Conversion Service
- After a request on [http://localhost:8100/currency-convertor/from/{from}/to/{to}/quantity/1000](http://localhost:8100/currency-convertor/from/{from}/to/{to}/quantity/1000), `from` and `to` parameters will be sent to **CES** [http://localhost:8000/currency-exchange/from/{from}/to/{to}](http://localhost:8000/currency-exchange/from/{from}/to/{to}), where has the database of the `conversionMultiple` value. Then the response will be calculated in **CCS**.
- With **Feign** this process becomes much simpler.


#### Ribbon Load Balancer
**Ribbon** tries to access one of the defined instances (in `application.properties` [hard-coded] or **NamingServer**) at each request, which leads to balance the client side pressure on the running instances of **CES**.



### Netflix Eureka Naming Server
- Service registration and discovery
- [http://localhost:8761](http://localhost:8761)

To register clinets in the Eureka server, do the followings:
1. Add `eureka` dependency
```
<!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-eureka -->
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-eureka</artifactId>
	<version>1.4.7.RELEASE</version>
</dependency>
```
2. In each client, enable the dicovery
```java
@SpringBootApplication
@EnableDiscoveryClient
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```
3. In `application.properties` add
```
eureka.client.service-url.default-zone=http://localhost:8761/eureka
```


### Netflix Zuul API Gateways
- Authentication, Authorization & Security
- Rate Limits
- Fault Tolerance
- Service Aggregation