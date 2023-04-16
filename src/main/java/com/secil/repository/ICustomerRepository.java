package com.secil.repository;

import com.secil.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    Optional<Customer> findOptionalByEmail(String email);

    @Query(value = "select cu.name from tblcustomer as cu ",nativeQuery = true)
    List<String> findByName();
}
