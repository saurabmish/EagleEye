# Dependencies

+ JUnit 5

  Mockito and AssertJ are automatically imported with the `spring-boot-starter-test`.

  This project uses JUnit 5 (Jupiter), Mockito, and AssertJ, all of which are a part of the `spring-boot-starter-test`

  `@RunWith` is superseded by `@ExtendWith`

  ```
  @ExtendWith(SpringExtension.class)
  @ExtendWith(MockitoExtension.class)
  ```

  instead of the below annotations, which are valid in JUnit 4:

  ```
  @RunWith(SpringRunner.class)
  @RunWith(MockitoJUnitRunner.class)
  ```

  `@Before` and `@BeforeClass` are superseded by `@BeforeEach` and `@BeforeAll`