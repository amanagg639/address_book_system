package org.address.address_book.dto;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDto {
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z\\s]{2,50}$", message = "Name must be 2-50 letters and spaces")
    private String first_name;

    @Pattern(regexp = "^[A-Za-z\\s]{2,50}$", message = "Name must be 2-50 letters and spaces")
    private String last_name;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private int phone_number;
}
