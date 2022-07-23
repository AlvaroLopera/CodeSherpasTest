# CodeSherpasTest
 
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

- JPA 

- Spring boot 

- JUnit for unit test.

First thing we need to create a binder named "Entities" where we create our first Java class "Customer.java"  (https://github.com/AlvaroLopera/CodeSherpasTest/blob/0b2a719e6b431b6d32e75d7472113b6f5fb90726/src/main/java/alvaro/lopera/demo/entities/Customer.java) where we need to assign the
@Entity annotation at the head of the class.

with this annotation plus the h2 dependecy, when the aplication is compiled, maven will create a table on the databse, and thanks to the h2 dependency we dont need external connections because we will use an internal database. 


Next we need to create an interface called "CustomerRepository" and as his name indicate is going to be our repo for our Customer class. Where the interface extends to JpaRepository for that.

For the last step, we are going to create the next classes: 

- CustomerController.java

- InvalidRequestException.java (Control the exceptions for the Customer.Class).

- ParametersController.java (Controls the input of the data).

Customer control is the class where we are going to code the functions of the api, in this case as we are developing a CRUD we code these fuctions: 

- ( @GetMapping ) public List<Customer> getAllcustomers()

- ( @GetMapping ) public Customer getCustomer ( @PathVariable Long id )

- ( @PostMapping("/Customer") ) public Customer createNewCustomer ( @RequestBody @Validated Customer newCustomer) 
 
- ( @PutMapping("/Customer") )  public Customer updateCustomer ( @RequestBody Customer updatedCustomer ) throws NotFoundException

- ( @DeleteMapping("/client/{surname}") )  public void deleteCustomer ( @PathVariable Long id )
 
*How to use* 

Just import the project and execute the enxt command "mmvn clean install" and go to http://localhost:8080, also u cant test the api using the junir test that are implemented or u can test by your self with you'r own test. 


Thanks for reading. 

a cordial greeting, Alvaro Lopera Mendizabal.
