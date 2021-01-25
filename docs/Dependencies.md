# Dependencies

+ JUnit

  Mockito and AssertJ are automatically imported with the spring-boot-starter-test

  This project uses JUnit 5 (Jupiter), Mockito, and AssertJ, all of which are a part of the `spring-boot-starter-test`

  In JUnit 5, `@RunWith` doesn't exists, it is superseded by `@ExtendWith`. Since this project is using JUnit 5, the following annotations will be used:

  ```
  @ExtendWith(SpringExtension.class)
  @ExtendWith(MockitoExtension.class)
  ```

  instead of the below annotations, which are valid in JUnit 4:

  ```
  @RunWith(SpringRunner.class)
  @RunWith(MockitoJUnitRunner.class)
  ```
