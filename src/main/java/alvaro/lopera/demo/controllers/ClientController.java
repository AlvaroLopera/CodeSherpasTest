package alvaro.lopera.demo.controllers;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import alvaro.lopera.demo.entities.Client;
import alvaro.lopera.demo.repositories.ClientRepository;

public class ClientController {
    // This gonna be the spring api for the test, http api will be develop in other class

    // The objective is to get a list of customers 
    // For that we will reference a property to hold the repository
    private ClientRepository customers;
    private ParametersController pc;

    // A constructor for our class
    public ClientController( ClientRepository cp ) {
        this.customers = cp;
    }

    @GetMapping("/Client")
    public List<Client> getAllcustomers() {
        
        // this will return a list of customers 
        return customers.findAll();
    }

    @PostMapping("/Client")
    public void createNewCustomer ( @RequestBody Client newCustomer) {
        
       if ( pc.checkCustomerParametrers(newCustomer) ) {
            // creates an empty object Client
            customers.save(newCustomer);
       
        } else {

            throw new RuntimeException("ERROR: INVALID OBJECT! ");

       }
    }

    @PutMapping("/people/{surname}") 
    public void updateCustomer ( @RequestBody Client updatedCustomer , @PathVariable String surname  ) {

        if ( pc.checkCustomerParametrers(updatedCustomer) ) {
            
            List<Client> cl = getAllcustomers(); 

            for ( Client c : cl ) {

                if ( c.getSurName().equals(surname) ) {
                
                    c.setName( updatedCustomer.getName() );
                    c.setEmail( updatedCustomer.getEmail() );
                    c.setBirthday( updatedCustomer.getBirthday() );

                    System.out.println("SUCCES: USER WAS UPDATED!\n");
                    break;
                }

            }
        } else {

            throw new RuntimeException("");
        
        }

    }

    @DeleteMapping("/client/{surname}")
    public void deleteCustomer ( @PathVariable String sn ) {

        List<Client> cl = getAllcustomers();

        // for each to search 
        for ( Client c : cl ) {

            if ( c.getSurName().equals(sn) ) {
                //una vez encontrado lo elimina
                cl.remove(c);
                System.out.println("SUCCESS: Users was suzzesfully remove!!\n");
                break; 
            }
            
        } 

    }

}
