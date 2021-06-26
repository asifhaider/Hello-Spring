package com.example.demoform;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customers, Integer> {

}
