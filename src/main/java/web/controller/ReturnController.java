package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnController {
	
	private static final Logger logger = LoggerFactory.getLogger(ParamController.class);
	
	@RequestMapping(value = "/return/test1")
	public void returnTesr1(Model model) {
		
		// viewName: return/test1
		// view: /WEB-INF/views/return/test1.jsp
		
		// 모델값 지정하기
		model.addAttribute("data", "MODEL DATA 1");
		
		model.addAttribute("another", "두 번째 모델 값");
	}
	
	@RequestMapping(value = "/return/test2")
	public String returnTest2(Model model) {
		
		model.addAttribute("data", 123);
		model.addAttribute("another", 456);
		
//		return null;  // null 리턴일 경우 void 리턴타입과 같은 동작을 한다.
		
		return "return/test1";  // 반호나되는 문자열값을 viewName으로 활용한다.
	}
	
	@RequestMapping(value = "/return/test3")
	public ModelAndView returnTest3( ModelAndView mav) {
		
//		return null;  // JSP를 아예 선택하지 않는다, 하얀 화면이 응답됨(아무런 응답도 보내지 않음)
		
		// -----------------------------------------------------
//		ModelAndView mav = new ModelAndView();
		
		// 뷰네임 지정하기
//		mav.setViewName(null);  // void 리턴과 같은 동작
		mav.setViewName("return/test1");
		
		
		// 모델값 지정하기
		mav.addObject("data", "ModelAndView 반환");
		mav.addObject("another", "TEST");
		
		return mav;
	}
	
	@RequestMapping("/param/test")
	public void paramTest(@RequestParam String data) {
		logger.info("/param/test");
		logger.info("test : {}", data);
	}

}
