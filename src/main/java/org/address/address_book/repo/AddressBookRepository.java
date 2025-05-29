package org.address.address_book.repo;

import org.address.address_book.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
}
