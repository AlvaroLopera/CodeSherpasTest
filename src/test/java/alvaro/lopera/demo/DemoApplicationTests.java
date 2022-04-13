package alvaro.lopera.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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
	void getAllCustomerTest ( ) throws Exception {

		List<Customer> list = new ArrayList<>();

		list.add(c1);
		list.add(c2);
		list.add(c3);

		Mockito.when(cr.findAll()).thenReturn(list);

		mockMvc.perform( ( MockMvcRequestBuilders
						.get("/Customer")
						.contentType(MediaType.APPLICATION_JSON))
						); 			

	}

	@Test
	void getOneCostumerTest ( ) throws Exception {

		Mockito.when(cr.findById(c1.getId())).thenReturn(java.util.Optional.of(c1));

		mockMvc.perform( ( MockMvcRequestBuilders
						.get("/Customer/1")
						.contentType(MediaType.APPLICATION_JSON))
						);

	}

	@Test
	void createNewCustomerTest ( ) throws Exception {

		Customer custom = new Customer(6L , "Alex", "Perez", "ap@gmail.com", "17");

		Mockito.when(cr.save(custom)).thenReturn(custom);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/customer")
													.contentType(MediaType.APPLICATION_JSON)
													.accept(MediaType.APPLICATION_JSON)
													.content(this.mapper.writeValueAsString(custom));


		mockMvc.perform(mockRequest);

	}

	@Test
	void customerUpdate ( ) throws Exception {

		Customer updated = new Customer(2L , "Fernando", "Cabras", "fc@gmail.com", "16");

		Mockito.when(cr.findById(c2.getId() ) ).thenReturn(Optional.of(c2));
		Mockito.when(cr.save(updated)).thenReturn(updated);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/customer")
													.contentType(MediaType.APPLICATION_JSON)
													.accept(MediaType.APPLICATION_JSON)
													.content(this.mapper.writeValueAsString(updated));
		
		mockMvc.perform(mockRequest);

	}

	@Test
	void deleteCustomer ( ) throws Exception {

		Mockito.when(cr.findById(c2.getId())).thenReturn(Optional.of(c2));

		mockMvc.perform(MockMvcRequestBuilders
						.delete("/customer/2")
						.contentType(MediaType.APPLICATION_JSON)
						);
		
	}

	

}
