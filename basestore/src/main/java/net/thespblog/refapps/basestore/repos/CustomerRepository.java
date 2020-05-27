package net.thespblog.refapps.basestore.repos;

import java.util.List;

import net.thespblog.refapps.basestore.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findAllByFirstName(String firstName);

    List<Customer> findAllByLastName(String lastName);

    Customer findByFirstName(String lastName);

    Customer findByLastName(String lastName);

}