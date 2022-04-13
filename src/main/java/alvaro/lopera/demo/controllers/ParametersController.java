package alvaro.lopera.demo.controllers;

import alvaro.lopera.demo.entities.Customer;

public class ParametersController {
    
    public boolean checkCustomerParametrers ( Customer c ) {

        if (  c.getName() != null && c.getBirthday() != null 
            && c.getEmail() != null && c.getSurName() != null ) {

                return true;

            }
        
        return false;
    }
    
}
