package com.jhb0430.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhb0430.spring.test.mvc.domain.Realtor;
import com.jhb0430.spring.test.mvc.service.RealtorService;

@Controller
@RequestMapping("/mvc/realtor")
public class RealtorController {

	@Autowired
	private RealtorService realtorService;
	
	
	
	@PostMapping("/create")
//	@ResponseBody
	public String createRealtor(
				@RequestParam("office") String office
				,@RequestParam("phoneNumber") String phoneNumber
				,@RequestParam("address") String address
				,@RequestParam("grade") String grade
				, Model model
				)
	{
		
		// 정보 가질러 가용 
		// 폼으로 정보 받아와야하니까 얘는 파라미터 받아야하네...
		
		Realtor realtor = new Realtor();
			realtor.setOffice(office);
			realtor.setPhoneNumber(phoneNumber);
			realtor.setAddress(address);
			realtor.setGrade(grade);
		
				
		int count = realtorService.addRealtor(realtor);

		
//		return "입력 성공 : " + count + " id  : " + realtor.getId();
		
		model.addAttribute("realtor", realtor);
//		model.addAttribute("title", "공인중개사 정보");
		
		return "mvc/realtorInfo";
		
	}
	
	
	
	
	
	// html 리턴받는 객체
	
	@GetMapping("/input")
	public String realtorInput() {
			
		return "mvc/realtorInput";
	}
	
	
	@GetMapping("/info")
	public String realtorInfo() {
		
		return "mvc/realtorInfo";
	}
	
	/*
	@GetMapping("/info")
	public String realtorInfo(Model model) {
		
		Realtor realtor = realtorService.getRealtor();
		model.addAttribute("result", realtor);
		model.addAttribute("title", "공인중개사 정보");
		
		return "mvc/realtorInfo";
	}
	*/
	
	
}
