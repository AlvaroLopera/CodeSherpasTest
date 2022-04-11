package alvaro.lopera.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import alvaro.lopera.demo.entities.Client;

public interface ClientRepository extends JpaRepository <Client, String> {
    
}
