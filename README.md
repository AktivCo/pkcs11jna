## Description

This is a Java library which makes PKCS#11 (also known as Cryptoki) modules accessible from Java.
Communication of Java and C code is implemented with Java Native Access (JNA) library.

This product includes software developed by IAIK of Graz University of Technology.

## How to build

Project can be built using IntelliJ IDEA or from a console.

To build from a console:

    cd <project-root>
    ./gradlew build

## Add pkcs11jna to your project

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/ru.rutoken/pkcs11jna/badge.svg)](https://maven-badges.herokuapp.com/maven-central/ru.rutoken/pkcs11jna)

Grab pkcs11jna from Maven Central at the coordinates `ru.rutoken:pkcs11jna:${pkcs11jnaVersion}` or add it to your project:

### Gradle example

```groovy
dependencies {
    implementation 'ru.rutoken:pkcs11jna:${pkcs11jnaVersion}'
}
```

Notice that pkcs11jna depends on JNA library.
In case you want to include your own version of JNA in the project you should exclude pkcs11jna's JNA dependency.
This is mandatory for Android projects.

### Android Gradle example

```groovy
dependencies {
    implementation 'ru.rutoken:pkcs11jna:${pkcs11jnaVersion}@jar'
    implementation 'net.java.dev.jna:jna:5.11.0@aar'
}
```
