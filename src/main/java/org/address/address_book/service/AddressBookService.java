package org.address.address_book.service;

import lombok.extern.slf4j.Slf4j;
import org.address.address_book.dto.AddressBookDto;
import org.address.address_book.exception.AddressBookException;
import org.address.address_book.model.AddressBook;
import org.address.address_book.repo.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    public List<AddressBook> getData() {

        return addressBookRepository.findAll();
    }

    public AddressBook getDataById(int addressId) {

        return addressBookRepository
                .findById(addressId)
                .orElseThrow(() -> new AddressBookException("Address Id not found"));
    }

    public void addData(AddressBookDto addressBookDto) {
        AddressBook addressBook = new AddressBook(addressBookDto);
        log.debug("Creating address book " + addressBook.toString());
        addressBookRepository.save(addressBook);
    }

    public AddressBook updateData(int addressId, AddressBookDto addressBookDto) {
        AddressBook addressBook = getDataById(addressId);
        addressBook.updateAddressBook(addressBookDto);
        return addressBookRepository.save(addressBook);
    }

    public void deleteData(int addressId) {
        AddressBook addressBook = getDataById(addressId);
        addressBookRepository.delete(addressBook);
    }
}
