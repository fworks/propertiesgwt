# propertiesgwt

[![](https://img.shields.io/travis/fworks/propertiesgwt/master.svg)](https://travis-ci.org/fworks/propertiesgwt)
[![](https://img.shields.io/maven-central/v/com.github.fworks/propertiesgwt.svg)](https://mvnrepository.com/artifact/com.github.fworks/propertiesgwt)
[![](https://img.shields.io/github/license/fworks/propertiesgwt.svg)](#)

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

### 1) Inherit the module

```
<!-- propertiesgwt -->
<inherits name="com.github.fworks.propertiesgwt.PropertiesGWT" />
```
   
### 2) Add the servlet config, you can pass a list of properties files separated by comma.

```
<!-- PropertiesGwt Servlet Config -->
<servlet>
	<servlet-name>propertiesGwtServlet</servlet-name>
	<servlet-class>com.github.fworks.propertiesgwt.server.PropertiesServlet</servlet-class>
	<init-param>
		<param-name>PROPERTIES_FILES</param-name>
		<param-value>application.properties</param-value>
	</init-param>
</servlet>

<servlet-mapping>
	<servlet-name>propertiesGwtServlet</servlet-name>
	<url-pattern>/propertiesGwt</url-pattern>
</servlet-mapping>
```

### 3) Just call the static methods

on your properties file:

```properties
property-name=blah
```

on the gwt code:

```java
String value = PropertiesGwt.getValue("property-name");
```

For more info, see the example project:

[propertiesgwt-example](https://github.com/fworks/propertiesgwt-example)
        
# Notes

It is simple as it sounds.
