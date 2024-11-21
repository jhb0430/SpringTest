package com.jhb0430.spring.test.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhb0430.spring.test.jpa.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
