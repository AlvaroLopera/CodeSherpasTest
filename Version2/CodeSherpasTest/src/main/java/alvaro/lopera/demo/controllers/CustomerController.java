package alvaro.lopera.demo.controllers;

import java.util.List;
import java.util.Optional;


import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import alvaro.lopera.demo.entities.Client;
import alvaro.lopera.demo.repositories.ClientRepository;

public class CustomerController {
    // This gonna be the spring api for the test, http api will be develop in other class

    // The objective is to get a list of customers 
    // For that we will reference a property to hold the repository
    private ClientRepository customers;


    @GetMapping
    public List<Client> getAllcustomers() {
        
        // this will return a list of customers 
        return customers.findAll();
    }

    @GetMapping
    public Client getCustomer ( @PathVariable String surname ) {
        return customers.findById(surname).get(); 
    }


    @PostMapping("/Client")
    public Client createNewCustomer ( @RequestBody @Validated Client newCustomer) {
        return customers.save(newCustomer);
    }

    @PutMapping() 
    public Client updateCustomer ( @RequestBody Client updatedCustomer ) throws NotFoundException {

        if ( updatedCustomer == null || updatedCustomer.getSurName() == null ) {
            throw new InvalidRequestException(" ERROR: Customers or his id cant be null!!\n ");
        }

        Optional<Client> optional = customers.findById(updatedCustomer.getSurName()); 
         
        if ( optional.isEmpty() ) {
            throw new NotFoundException();
        }

        Client customerEx = optional.get();

        customerEx.setName(updatedCustomer.getName());
        customerEx.setEmail(updatedCustomer.getEmail());
        customerEx.setBirthday(updatedCustomer.getBirthday());


        return customers.save(customerEx);
    }

    @DeleteMapping("/client/{surname}")
    public void deleteCustomer ( @PathVariable String sn ) {

        if ( sn == null ) {
             throw new InvalidRequestException(""); 
        }

        customers.deleteById(sn);

    }

}
