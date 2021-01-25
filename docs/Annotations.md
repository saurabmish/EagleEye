# Annotations

## `Application.java`

+ `@SpringBootApplication`

  This annotation adds all of the following:

  `@Configuration`: Tags the class as a source of bean definitions for the application context.

  `@EnableAutoConfiguration`: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
  
  `@EnableWebMvc`: Flags the application as a web application and activates key behaviors, such as setting up a `DispatcherServlet`. Spring Boot adds it automatically when it sees `spring-webmvc` on the classpath.
  
  `@ComponentScan`: Tells Spring to look for other components, configurations, and services in the the `com.thoughtmechanix.licenses` package, letting it find the `LicenseController` class.

## `ApplicationTests.java`

+ `@SpringBootTest` 

  This annotation tells Spring Boot to look for the main configuration class (one with `@SpringBootApplication`) and use that to start a Spring application context. 
  
  When `./mvnw test` is run from the command line, this is the file that gets executed.  

## `LicenseController.java`

+ `@RestController`

+ `@GetMapping`

+ Alternatively, `@RequestMapping`

## `LicenseControllerUnitTest.java`

+ `@WebMvcTest`

  Since unit tests have to be fast, spring boot annotations have to be avoided as much as possible. `@SpringBootTest` creates the entire application context.
  Using `@WebMvcTest` ensures that only the web layer of the context is created. 

  Ideally, if an application has multiple controllers, only one should be instantiated using this annotation. It is often used in combination with `@MockBean` to provide mock implementations for required collaborators.

+ `@ExtendWith`
  
  This annotation accepts any class that implements the `Extension` interface.

  In this case, `@ExtendWith(MockitoExtension.class)` is used instead of `@ExtendWith(SpringExtension.class)` so that unit tests are run outside Spring context. This prevents Spring test framweworks from being used in the test and unneeded stuff isn't loaded. 

  `MockMvc` is used to prevent the server from being started; only the layer below the server is tested. At this layer, Spring handles the incoming HTTP request and hands it off to the controller. The benefit of this approach is that the source code will be called in exactly the same way a HTTP request but without the cost of starting the server. 
  
  `MockMvc` is injected by using the `@WebMvcTest`, which narrows the tests to only the web layer **and** without the server. If it was injected using `@AutoConfigureMockMvc`, the full Spring application context would be started (also **without** the server). 

## `LicenseControllerIntegrationTest.java`

+ `@ExtendWith`

  In this case, the test have to mimic the Spring application, so `@ExtendWith(SpringExtension.class)` is used. With the Spring framework, usually multiple classes are tested, if only one class has to be tested, a unit testing it is the right approach.

+ `@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)`

  The server is started with a random port (useful to avoid conflicts in test environments), and the actual port is discovered at runtime with `@LocalServerPort`.

+ `@BeforeEach`

  This annotation is executed before each test. If there are ten tests in the class, code annotated with `@BeforeEach` will be executed ten times.
