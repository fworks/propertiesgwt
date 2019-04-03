# propertiesgwt

![Travis (.org) branch](https://img.shields.io/travis/fworks/propertiesgwt/master.svg)
![Maven Central](https://img.shields.io/maven-central/v/com.github.fworks/propertiesgwt.svg)
![GitHub](https://img.shields.io/github/license/fworks/propertiesgwt.svg)

Simple properties file reader for GWT

It provides a map with the content of a properties file to be used on the GWT client application.

# maven

```
<dependency>
  <groupId>com.github.fworks</groupId>
  <artifactId>propertiesgwt</artifactId>
  <version>0.0.1</version>
</dependency>
```

# How to use

1) Inherit the module

```
<!-- propertiesgwt -->
<inherits name="com.github.fworks.propertiesgwt.PropertiesGWT" />
```
   
2) Add the servlet config

```
```

3) Just call the static methods

on your properties file:

```properties
property-name=blah
```

on the gwt code:

```java
String value = PropertiesGwt.get("property-name");
```
				
        
# Notes

It is simple as it sounds.
