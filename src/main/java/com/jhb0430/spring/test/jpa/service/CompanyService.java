package com.jhb0430.spring.test.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhb0430.spring.test.jpa.domain.Company;
import com.jhb0430.spring.test.jpa.repository.CompanyRepository;

@Service
public class CompanyService {

	
	@Autowired
	private CompanyRepository companyRepository;
	
	public Company addCompany(String name, String business, String scale, int headcount) {
		
		Company company = Company.builder()
											.name(name)
											.business(business)
											.scale(scale)
											.headcount(headcount)
											.build();
		
		Company result = companyRepository.save(company);
		 
		return company;
	}
	
	
	public Company updateCompany(int id, String scale, int headcount) {
		
		// null일수도 있다는게 조회했는데 없으면 null이구나....
		
		// id로 조회할거니까
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
		// 정확한 사용법을 위해서는 null처리를 어떻게 해줄지를 지정해줘야한다
//		if(company == null) {
//		}
		if(optionalCompany.isPresent()) {
			// null이 아닌 실제 객체가 있다면.
			// optional 객체에 데이터 객체가 null 이 아닌 경우 
			Company company = optionalCompany.get();
			
			company = company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build();
			Company result = companyRepository.save(company);
			
			return result;
		} 
//		 else {
//				return null;
//			}
		return null;
/*			
		Company company = optionalCompany.orElse(null);
		
			company = company.toBuilder()
			.scale(scale)
			.headcount(headcount)
			.build();
		
		Company result = companyReposiroy.save(company);
		return result;
 */		
	}
	
	
	
	
	public void deleteCompany(int id) {
		
		Optional<Company> optionalCompany = companyRepository.findById(id);
//		if(optionalCompany.isPresent()) {
//			companyReposiroy.delete(optionalCompany.get());
//		}
		
		// 람다식 표현
		// null이 아닐때 수행할 기능 등록
		
		optionalCompany.ifPresent(company -> companyRepository.delete(company));
		
//		Company company = optionalCompany.orElse(null);
		
//		companyReposiroy.delete(company);
		
		
	}
	
}
