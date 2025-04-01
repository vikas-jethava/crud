package com.vikas.JpaManyToMany;

import com.vikas.JpaManyToMany.Repository.AddressRepo;
import com.vikas.JpaManyToMany.Repository.UserRepo;
import com.vikas.JpaManyToMany.Entity.Address;
import com.vikas.JpaManyToMany.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaManyToManyApplication {




	public static void main(String[] args) {





		SpringApplication.run(JpaManyToManyApplication.class, args);




	}
}
