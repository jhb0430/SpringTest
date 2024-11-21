package com.jhb0430.spring.test.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhb0430.spring.test.jpa.domain.Company;
import com.jhb0430.spring.test.jpa.service.CompanyService;

@RequestMapping("/jpa/company")
@Controller
public class CompanyController {

	
	@Autowired
	private CompanyService companyService;
	
	// create
	/*
	 * 아래 회사 정보들을 테이블에 Insert 하세요.
객체 생성은 builder 패턴을 활용하세요.
저장 성공한 객체들의 정보를 아래와 같이 출력하세요.
	회사명 : 넥손
	사업내용 : 컨텐츠 게임
	규모 : 대기업
	사원수 : 3585명
	
	회사명 : 버블팡
	사업내용 : 여신 금융업
	규모 : 대기업
	사원수 : 6834명
	"버블팡","여신 금융업","대기업",6834
	 * */
	
	@ResponseBody
	@GetMapping("/create")
	public Company createCompany() {
		// create 요청이 들어오면... 
		
		Company company = companyService.addCompany("넥슨", "컨텐츠 게임", "대기업", 3585);
				company = companyService.addCompany("버블팡","여신 금융업","대기업",6834);
		
		
		return company;
		
	}
	
	
	// update 
//	규모를 중소기업, 사원수를 34명 으로 수정하세요.
//	(버블팡의 pk id번호로 업데이트 - workbench에서 조회)
	@ResponseBody
	@GetMapping("/update")
	public Company updateCompany() {
		
		Company company = companyService.updateCompany(8, "중소기업", 34);
		
		return company;
	}
	
	// delete
//	버블팡이 파산하여 회사가 없어졌다.
//	해당 회사 정보를 테이블에서 삭제하세요. (버블팡의 pk id번호로 업데이트 - workbench에서 조회)
//	아래와 같이 출력하세요.
	
	@GetMapping("/delete")
	public String deleteCompany() {
		
		companyService.deleteCompany(8);
		
		return "수행 완료";
		
	}
	
	
}
