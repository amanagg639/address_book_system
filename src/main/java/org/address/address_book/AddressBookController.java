package org.address.address_book;

import jakarta.validation.Valid;
import org.address.address_book.dto.AddressBookDto;
import org.address.address_book.model.AddressBook;
import org.address.address_book.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping(value = "/addressbook")
@Validated
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<AddressBook>> getData() {
        List<AddressBook> data = addressBookService.getData();

        return ResponseEntity.ok(data);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressBook> getDataById(@PathVariable int addressId) {
        return ResponseEntity.ok(addressBookService.getDataById(addressId));
    }

    @PostMapping(value = {"", "/"})
    public void addData(@Valid @RequestBody AddressBookDto addressBookDto) {
        addressBookService.addData(addressBookDto);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<AddressBook> updateData(@PathVariable int addressId, @Valid @RequestBody AddressBookDto addressBookDto) {
        return ResponseEntity.ok(addressBookService.updateData(addressId, addressBookDto));
    }

    @DeleteMapping("deleteData/{addressId}")
    public ResponseEntity<String> deleteData(@PathVariable int addressId) {
        addressBookService.deleteData(addressId);
        return ResponseEntity.ok("Deleted");
    }
}
