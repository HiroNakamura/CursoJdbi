# Curso Jdbi


Este es un proyecto usando [Jdbi](http://jdbi.org/). La cual es una librería que nos provee toda la funcionalidad para acceder a una base de datos y operar sobre ella. Más sencillo que usar JDBC u otras alternativas com JPA o Hibernate.

Si usan Maven, será necesario agregar la dependencia necesaria.


**pom.xml**
```xml
<dependencies>
  <dependency>
    <groupId>org.jdbi</groupId>
    <artifactId>jdbi3-core</artifactId>
  </dependency>
</dependencies>
```
Si usan Gradle, añadirán la siguiente dependencia.

**build.gradle**
```java
compile group: 'org.jdbi', name: 'jdbi3-core', version: '3.12.0'
```

La documentación oficial nos ofrece dos "sabores" a escoger:

1. API fluida: El Core API proporciona una interfaz fluida e imperativa. Utilice los objetos de estilo Builder para conectar su SQL a tipos de datos Java enriquecidos.
2. API delarativa: La extensión del objeto SQL se encuentra sobre Core y proporciona una interfaz declarativa. Dígale a Jdbi qué SQL ejecutar y la forma de los resultados que desea declarando una interfaz Java anotada, y proporcionará la implementación.



Links:
* [Sitio oficial de Jdbi](http://jdbi.org/)
* [JDBI en Github](https://github.com/jdbi/jdbi).
