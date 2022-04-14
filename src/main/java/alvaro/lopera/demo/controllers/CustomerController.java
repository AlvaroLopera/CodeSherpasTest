package alvaro.lopera.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alvaro.lopera.demo.entities.Customer;
import alvaro.lopera.demo.repositories.ClientRepository;

@CrossOrigin( origins = "http://localhost:8081" )
@RestController
@RequestMapping
public class CustomerController {
    // This gonna be the spring api for the test, http api will be develop in other class

    // The objective is to get a list of customers 
    // For that we will reference a property to hold the repository
    @Autowired
    private ClientRepository customers;


    @GetMapping
    public List<Customer> getAllcustomers() {
        
        // this will return a list of customers 
        return customers.findAll();
    }

    @GetMapping
    public Customer getCustomer ( @PathVariable Long id ) {
        return customers.findById(id).get(); 
    }


    @PostMapping("/Client")
    public Customer createNewCustomer ( @RequestBody @Validated Customer newCustomer) {
        return customers.save(newCustomer);
    }

    @PutMapping() 
    public Customer updateCustomer ( @RequestBody Customer updatedCustomer ) throws NotFoundException {

        if ( updatedCustomer == null || updatedCustomer.getId() == null ) {
            throw new InvalidRequestException(" ERROR: Customers or his id cant be null!!\n ");
        }

        Optional<Customer> optional = customers.findById(updatedCustomer.getId()); 
         
        if ( optional.isEmpty() ) {
            throw new NotFoundException();
        }

        Customer customerEx = optional.get();

        customerEx.setName(updatedCustomer.getName());
        customerEx.setSurName(updatedCustomer.getSurName());
        customerEx.setEmail(updatedCustomer.getEmail());
        customerEx.setBirthday(updatedCustomer.getBirthday());


        return customers.save(customerEx);
    }

    @DeleteMapping("/client/{surname}")
    public void deleteCustomer ( @PathVariable Long id ) {

        if ( id == null ) {
             throw new InvalidRequestException(""); 
        }

        customers.deleteById(id);

    }

}
