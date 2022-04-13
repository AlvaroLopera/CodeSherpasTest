package alvaro.lopera.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import alvaro.lopera.demo.controllers.CustomerController;
import alvaro.lopera.demo.entities.Customer;
import alvaro.lopera.demo.repositories.ClientRepository;

@WebMvcTest(CustomerController.class)
class DemoApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@MockBean
	ClientRepository cr;

	Customer c1 = new Customer(1L , "Pepe", "Garcia", "pg@gmail.com", "13"); 
	Customer c2 = new Customer(2L , "Ana", "Garcia", "ag@gmail.com", "11"); 
	Customer c3 = new Customer(3L , "Nicolas", "Felipe", "nf@gmail.com", "12");
	Customer c4 = new Customer(4L , "Pablo", "Motillo", "pm@gmail.com", "14"); 
	Customer c5 = new Customer(5L , "Fernando", "Cabras", "fc@gmail.com", "16"); 
	Customer c6 = new Customer(6L , "Alex", "Perez", "ap@gmail.com", "17");

	@Test
	void contextLoads() {
	}

}
