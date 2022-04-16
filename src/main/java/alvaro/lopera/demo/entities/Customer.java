package alvaro.lopera.demo.entities;

import org.springframework.lang.NonNull;

@jakarta.persistence.Entity
public class Customer {
    
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO )
    private Long id;

    @NonNull
    private String surname;
    @NonNull
    private String email;
    @NonNull
    private String Birthday; 
    @NonNull
    private String name;

    // ------ Constructor -------

    public Customer ( ) {
        // Constructor vacio 
    }

    // The error exception will be programmed on the controller class
    public Customer( Long i, String n, String na, String e, String b ) {

        this.id = i;
        this.name = n;
        this.surname = na;
        this.email = e; 
        this.Birthday = b; 

    }
    
    // --------------------- Getters & Setters -------------------------

    public Long getId ( ) {
        return id;
    }

    public String getName() {
        return name; 
    }

    public String getSurName() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setName( String n ) {
        this.name = n;
    }

    public void setSurName( String sn ) {
        this.surname = sn;
    }

    public void setEmail( String e ) {
        this.email = e;
    }

    public void setBirthday( String b ) {
        this.Birthday = b;
    }

    // ------------------- HashCode & Equals --------------------

    @Override
    public boolean equals( Object o ) {
        
        // if the object passed as a parametrer is not a instance of Client -> Throw an error
        if ( !(o instanceof Customer ) ) {
           // throw new EntityErrorException("Error: Object is not an instance of Cliente "); 
        }
        
        boolean res = false;
        // We need a primary key to get the client, for that we will use the surname & email
        Customer n = (Customer) o;

        if ( this.getSurName().equals(n.surname) && this.getEmail().equals(n.email) ) {
            res = true;
        }

        return res; 
    }
    
    @Override
    public int hashCode() {
        return this.getEmail().hashCode() + this.getSurName().hashCode();
    }


}
