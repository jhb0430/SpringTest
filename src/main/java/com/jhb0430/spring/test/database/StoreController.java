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

//	↓ ☆★서비스에서 기능 만들었으면 여기로 돌아오자☆★
	@Autowired
//	②그 위에 @Autowired 어노테이션을 붙여주면 
//	스프링이 알아서 서비스 클래스의 객체를 생성해서 관리해준다.			↓
	
//	①마찬가지로 멤버변수 형태로 객체를 저장할 변수를 먼저 선언하고  ↑
	private StoreService storeService;
	
	
	
		@RequestMapping("/db/store/list")
		// store 테이블의 모든 정보를 json 으로 response에 담는다.
		@ResponseBody
		public List<Store> storeList(){
			// 가게 정보 얻어 오기
			// 비즈니스 레이어를 수행할 클래스가 따로 만들어져야함 
			// 필요한 기능은 서비스를 통해 이루어져야한다
			
//	→ ③그럼 우린 이거 가져다 쓰면 됨 ㅎㅁㅎ
//							↓
//				이제 리턴되니까 리턴타입 적어줄 수 있음!
			List<Store> storeList = storeService.getStoreList();
			
			return storeList;
			
//					그럼 얘는 service 를 통해 테이블 정보를 모두 가져와서 리스트로 리턴해주고,
//					그걸 그대로 @ResponseBody기반으로 리턴해주면
//					해당하는 리스트 안에 있는 객체의 내용들을 
//					http  메세지 컨버터가 
//					아 이건 ResponseBody에 문자로 담기 위해 json으로 변경 해야겠다~ 하고 
//					잭슨 라이브러리를 통해 해당 리스트 객체 내용을 json 문자로 변형해서
//					ResponseBody에 담아준다
			
			
			
			
		}
//		-> 자연스럽게 컨트롤러는 서비스를 통해 기능을 수행하고
//		서비스는 필요한 정보를 레파지토리로 얻어오는 흐름이 이어진다.
	
}
