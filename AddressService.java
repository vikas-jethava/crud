package com.vikas.JpaManyToMany.Service;

import com.vikas.JpaManyToMany.CustomException.AddressNotFoundExeception;
import com.vikas.JpaManyToMany.Entity.Address;
import com.vikas.JpaManyToMany.Repository.AddressRepo;
import com.vikas.JpaManyToMany.dto.AddressDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

//    @Autowired
//    private AddressDto addressDto;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;


    // Convert Entity to DTO
    private AddressDto convertToDto(Address address) {
        return modelMapper.map(address, AddressDto.class);
    }

    // Convert DTO to Entity
    private Address convertToEntity(AddressDto addressDto) {
        return modelMapper.map(addressDto, Address.class);
    }

    public AddressDto saveAddress(AddressDto addressDto) {
        Address address = convertToEntity(addressDto);
        return convertToDto(addressRepo.save(address));
    }

    public List<AddressDto> getAllAddress() {
        return addressRepo.findAll().stream().map(address -> convertToDto(address)).collect(Collectors.toList());
    }

    public AddressDto findById(int id) throws AddressNotFoundExeception {
        Address address = addressRepo.findById(id).orElseThrow(() -> new AddressNotFoundExeception("Address with "+id+" not found"));
        return convertToDto(address);
    }

    //    id, user_id,line1, line2, street, city, state, country


    public AddressDto updateAddress(int id, AddressDto addressDto) throws AddressNotFoundExeception {
        Address existingAddress = addressRepo.findById(id).orElseThrow(() -> new AddressNotFoundExeception("Address with "+id+" not found"));

        existingAddress.setCity(addressDto.getCity());
        existingAddress.setLine1(addressDto.getLine1());
        existingAddress.setLine2(addressDto.getLine2());
        existingAddress.setState(addressDto.getState());
        existingAddress.setCountry(addressDto.getCountry());

        return convertToDto(addressRepo.save(existingAddress));

    }

//    Delete Address
    public void deleteAddress(int id) throws AddressNotFoundExeception {
        Address address = addressRepo.findById(id)
                .orElseThrow(() -> new AddressNotFoundExeception("Address with ID " + id + " not found"));

        addressRepo.delete(address);
    }
}
