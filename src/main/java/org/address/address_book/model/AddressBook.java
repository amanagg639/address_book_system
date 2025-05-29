package org.address.address_book.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.address.address_book.dto.AddressBookDto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Scope("prototype")
@Data
@NoArgsConstructor
@Table(name = "address_book")
public class AddressBook {
    @Id
    int id;
    String first_name;
    String last_name;
    String address;
    String city;
    int phone_number;
    public AddressBook(AddressBookDto addressBookDto) {
        this.updateAddressBook(addressBookDto);
    }

    public void updateAddressBook(AddressBookDto addressBookDto) {
        this.first_name = addressBookDto.getFirst_name();
        this.last_name = addressBookDto.getLast_name();
        this.address = addressBookDto.getAddress();
        this.city = addressBookDto.getCity();
        this.phone_number = addressBookDto.getPhone_number();
    }
}
