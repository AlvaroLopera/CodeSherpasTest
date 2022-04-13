package alvaro.lopera.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import alvaro.lopera.demo.entities.Customer;

public interface ClientRepository extends JpaRepository <Customer, Long> {
    
}
