package com.jhb0430.spring.test.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhb0430.spring.test.jpa.domain.Company;
import com.jhb0430.spring.test.jpa.repository.CompanyRepository;

@Service
public class CompanyService {

	
	@Autowired
	private CompanyRepository companyReposiroy;
	
	public Company addCompany(String name, String business, String scale, int headcount) {
		
		Company company = Company.builder()
											.name(name)
											.business(business)
											.scale(scale)
											.headcount(headcount)
											.build();
		
		Company result = companyReposiroy.save(company);
		 
		return company;
	}
	
	
	public Company updateCompany(int id, String scale, int headcount) {
		
		// null일수도 있다는게 조회했는데 없으면 null이구나....
		
		// id로 조회할거니까
		Optional<Company> optionalCompany = companyReposiroy.findById(id);
		
		Company company = optionalCompany.orElse(null);
		
		company = company.toBuilder()
									.scale(scale)
									.headcount(headcount)
									.build();
		
		Company result = companyReposiroy.save(company);
		
		return result;
	}
	
	public void deleteCompany(int id) {
		
		Optional<Company> optionalCompany = companyReposiroy.findById(id);
		
		Company company = optionalCompany.orElse(null);
		
		companyReposiroy.delete(company);
		
		
	}
	
}
