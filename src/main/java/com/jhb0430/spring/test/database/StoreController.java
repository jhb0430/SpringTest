package com.jhb0430.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhb0430.spring.test.database.domain.Store;
import com.jhb0430.spring.test.database.service.StoreService;

// request, response 처리 담당
@Controller
public class StoreController {

	// 서비스 먼저 생성하고 다시 오자....  아니 아니네...
	@Autowired
	private StoreService storeService;
	
	// store 테이블의 모든 정보를 json 으로 response에 담는다.
		
		@RequestMapping("/db/store/list")
		@ResponseBody
		public List<Store> storeList(){
			// 중고 물품 게시글 정보 얻어 오기
			// 비즈니스 레이어를 수행할 클래스가 따로 만들어져야함 
			// 필요한 기능은 서비스를 통해 이루어져야한다
			
			List<Store> storeList = storeService.getStoreList();
			
			return storeList;
			
		}
	
	
}
