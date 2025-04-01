package com.vikas.JpaManyToMany.Controller;

import com.vikas.JpaManyToMany.CustomException.AddressNotFoundExeception;
import com.vikas.JpaManyToMany.Service.AddressService;
import com.vikas.JpaManyToMany.dto.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    // Create Address
    @PostMapping
    public ResponseEntity<AddressDto> createAddress(AddressDto addressDto) {
        return ResponseEntity.ok(addressService.saveAddress(addressDto));
    }

    // Get All Addresses
    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddress());
    }

    // Get Address by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable int id) throws AddressNotFoundExeception {
        return ResponseEntity.ok(addressService.findById(id));
    }

    // Update Address
    @PutMapping("/{id}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable int id, @RequestBody AddressDto addressDto) throws AddressNotFoundExeception {
        return ResponseEntity.ok(addressService.updateAddress(id, addressDto));
    }

    // Delete Address
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable int id) throws AddressNotFoundExeception {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}

