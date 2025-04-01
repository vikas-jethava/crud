package com.vikas.JpaManyToMany.Repository;

import com.vikas.JpaManyToMany.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
}
