# Setup

+ Install OpenJDK

  `brew install openjdk`

+ For the system Java wrappers to find this JDK, symlink it with Java in `Library/`

  `sudo ln -sfn /usr/local/opt/openjdk/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk.jdk`

+ Set `JAVA_HOME`

  `export JAVA_HOME="/Library/Java/JavaVirtualMachines/openjdk.jdk/Contents/Home"`

+ Bootstrap application with [Spring Initializr][1]

+ Technical Specifications:

  + Project: Maven

  + Snapshot: 2.4.0

  + Project Metadata:

    + Packaging: JAR

    + Java Version: 15

    + Dependencies: Spring Web


[1]: https://start.spring.io/