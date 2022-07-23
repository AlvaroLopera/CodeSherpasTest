# CodeSherpasTest
 
 
 
* DOCUMENTACION EN ESPAÑOL * 

Este proyecto ha sido desarrollado por Alvaro Lopera Mendizabal.

Se trata de API-Rest con un crud de Clientes ("Customers"), con la cual deberemos realizar acciones de creacion, modificacion, obtener uno o todos los clientes y la eliminacion de un cliente de la base de datos. 

Para ello he empleado un proyecto Maven (veersion: 3.0.0) con la utilidad de la bases de datos h2 para manejar datos en local sin necesidad de la creacion de una imagen java o bien la necesidad de agenetes externos.

Debido a la falta de tiempo no he podido configurar un metodo main con el cual poder tener un pagina de inicio, aunque la aplicacion inicia sin problemas y una vez iniciada con dirigirnos a http://localhost:8080 tendremos nuestra api en funcionamiento.

La aplicacion incluye test unitarios para comprobar su funcionamiento.

A su vez se ha utilizado un patron de diseño de estilo singleton para una mejor estructuracion del codigo y puesto que era el mas indicado en mi opinion para el desarrollo de la aplicacion. 


* ENGLISH DOC *

Project developed by Alvaro Lopera Mendizabal. 

Development tools: 

- Java jdk 1.8 & java 11 or higher.

- Maven 3.+0.0 or higher.

- Spring boot version 2.6.6 or higher. 

- Visual Studio Code as IDE. 

Introduction: 

The topic of this consist on develop an api-rest for a CRUD on java using maven & spring boot. The objective is develop an I/O system where u recive and send data to a database.

Development:

To develop this api we need to include some dependencies to our pom.xml, in this case we used: 

- Lombock for annotanions 

- h2 database (no need of external databases) 

- Spring boot 

- JUnit for unit test.

First thing we need to create a binder named "Entities" where we create our first Java class "Customer.java"  (https://github.com/AlvaroLopera/CodeSherpasTest/blob/0b2a719e6b431b6d32e75d7472113b6f5fb90726/src/main/java/alvaro/lopera/demo/entities/Customer.java)
