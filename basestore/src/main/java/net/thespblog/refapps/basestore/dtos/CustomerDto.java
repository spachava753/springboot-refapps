package net.thespblog.refapps.basestore.dtos;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;

public class CustomerDto {

    public Optional<String> id;

    public Optional<String> firstName;
    public Optional<String> lastName;

    public CustomerDto() {}

    public CustomerDto(String firstName, String lastName) {
        this.firstName = Optional.ofNullable(firstName);
        this.lastName = Optional.ofNullable(lastName);
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}