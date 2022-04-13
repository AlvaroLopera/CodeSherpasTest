package alvaro.lopera.demo.controllers;

import alvaro.lopera.demo.entities.Client;

public class ParametersController {
    
    public boolean checkCustomerParametrers ( Client c ) {

        if (  c.getName() != null && c.getBirthday() != null 
            && c.getEmail() != null && c.getSurName() != null ) {

                return true;

            }
        
        return false;
    }
    
}
