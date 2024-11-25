package com.jhb0430.spring.test.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhb0430.spring.test.jpa.domain.Recruit;
import com.jhb0430.spring.test.jpa.repository.RecruitRepository;

@RequestMapping("/jpa/recruit")
@Controller
public class RecruitController {
	
	

	@Autowired
	private RecruitRepository recruitRepository;
	
	@ResponseBody
	@GetMapping("/find")
	public Optional<Recruit> selectRecruit() {
//		List<Recruit> recruitList = null;
		
			
//		List<Recruit> recruitList = recruitRepository.findAll();
//		recruitList = recruitRepository.findById(8);
		Optional<Recruit> optionalRecruit = recruitRepository.findById(8);
		return optionalRecruit;
	}
	
	@ResponseBody
	@GetMapping("/findCompany")
	public List<Recruit> findCompanyId(){
		
//		List<Recruit> recruitList = recruitRepository.findByCompanyId(1);
		List<Recruit> recruitList = recruitRepository.findByCompanyIdOrderByIdDesc(1);
		
		return recruitList;
	}
	
	
	@ResponseBody
	@GetMapping("/findPT")
	public List<Recruit> findPositionType(){
		
		List<Recruit> recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자","정규직");
		
		return recruitList;
	}
	 
	//4. 복합 조건 조회
	@ResponseBody
	@GetMapping("/findTandS")
	public List<Recruit> findTypeandSalary(){
		
		List<Recruit> recruitList = recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직",9000);
		
		return recruitList;
	}
	
	@ResponseBody
	@GetMapping("/findsalary")
	public List<Recruit> findSalaryTop(){
		
List<Recruit> recruitList = recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
		
		return recruitList;
		
	}
	
	@ResponseBody
	@GetMapping("/find-region")
	public List<Recruit> findRegion(){
		
		List<Recruit> recruitList = recruitRepository.findByRegionAndSalaryBetween("성남시 분당구",7000,8500);
		
		return recruitList;
		
	}
	@ResponseBody
	@GetMapping("/find-native")
	// LocalDate 로도 되는지 해보기 
	public List<Recruit> findNativeQuery(){
		
		List<Recruit> recruitList = recruitRepository.selectByDST("2026-04-10",8100,"정규직");
		
		return recruitList;
		
	}
	
	
	
}
