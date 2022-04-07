package web.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.dto.User;


@Controller
public class ParamController {
	
	private static final Logger logger = LoggerFactory.getLogger(ParamController.class);

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void method() {
//		System.out.println("/test [GET]");
		
		logger.trace("로그 테스트 - trace");
		logger.debug("로그 테스트 - debug");
		logger.info("로그 테스트 - info");
		logger.warn("로그 테스트 - warn");
		logger.error("로그 테스트 - erorr");
		
		// -----------------------------------------
		
		// 로그 메소드는 String 타입을 매개변수로 사용한다.
		// 	-> 객체를 출력할 땐 .toString() 호출 필요
		
//		Object obj = null;
//		logger.info(obj.toString());
		
		// -----------------------------------------
		
		logger.info("출력 데이터 {} 파라미터", 123);
		
		logger.info("{}, {}", 1, 2);
		
		// 에러
//		logger.debug("a:{}, B:{}, C:{}", "출력", "파라미터", "지정");
		
		// -----------------------------------------
		
		int idx = 0;
		
		logger.debug("{}. 에러 메시지 표현", idx++);
		
		logger.debug("{}. 주석대신 사용하는 것도 가능", idx++);
		
		logger.debug("{}. 개발할 때 로그를 적용하는 방법", idx++);
		
		
	}
	
	@RequestMapping(value = "/param/requestParam", method = RequestMethod.GET)
	public String paramForm() {
		logger.info("/param/requestParam [GET]");
		
		//return null;  // void 리턴과 같은 효과
		//return "";
		return "param/paramForm";  // viewName으로 사용될 문자열을 반환
	}
	
	@RequestMapping(value = "/param/requestParam", method = RequestMethod.POST)
	public String paramReuslt(@RequestParam(value = "aaaa", required = false) String username, @RequestParam("bbbb") int userage) {
		int logIdx = 1;
		logger.debug("#{}. paramResult() 메소드 시작", logIdx++);
		
		logger.info("/param/requestParam [POST]");

		logger.debug("#{}. 중간 확인", logIdx++);
		logger.info("파라미터 aaaa : {}", username);
		logger.info("파라미터 bbbb : {}", userage);
		
		
		logger.debug("#{}. viewName지정, 포워드", logIdx++);
		
		return "param/paramResult";
	}
	
	@RequestMapping("/board/list")
	public void boardlist(
//			@RequestParam(defaultValue = "1") String curPage
			
			@RequestParam(defaultValue = "0")  int curPage
			) {
		logger.info("/board/list");
		
		logger.info("curPage : {}", curPage);
	}
	
	@RequestMapping("/param/required")
	public void requiredTest( 
//			@RequestParam(required = true) String test
			@RequestParam(required = false) String test
			
			// 여러가지 속성을 나열해서 사용할 수 있다.
			, @RequestParam(value = "c", required = false, defaultValue = "default") String test1
			) {
		logger.info("/param/required - test : {}", test);
	}
	
	@RequestMapping(value = "/param/map", method = RequestMethod.GET)
	public void paramMapForm() {
		logger.info("/param/map [GET]");
	}
	
	@RequestMapping(value = "/param/map", method = RequestMethod.POST)
	public String paramMapResult(
			@RequestParam HashMap<String, String> map  // 전달 파라미터 저장 맵
			, Model model  // 모델값 전달 객체
			) {
		logger.info("/param/map [POST]");
		
		logger.info("{}", map);
		
		// 맵 객체 자체를 모델값으로 전달한다.
		model.addAttribute("m", map);
		
		// 맵 객체 내부의 키=값 쌍을 각각의 모델값으로 분리해서 전달한다.
		model.addAllAttributes(map);
		
		return "param/mapResult";
	}
	
	@RequestMapping(value = "/param/dto", method = RequestMethod.GET)
	public void paramDtoForm() {
		logger.info("/param/dto [GET]");
	}
	
	@RequestMapping(value = "/param/dto", method = RequestMethod.POST)
	public String paramDto(
			User user  // 커맨드 객체, Command Object
			, @ModelAttribute("m2") User user2  // ModelAttribute 어노테이션을 생략해도 자동으로 적용되도록 되어 있다.
			, Model model  // 모델값 처리 객체 
			) {
		logger.info("/param/dto [POST]");
		
		logger.info("{}", user);
		logger.info("{}", user2);
		
		// 커맨드 객체를 이용하여 DB조회 한 이후에 Model객체를 이용하여 모델값 전달을 수행한다.
		model.addAttribute("userData", user);
		
		return "param/dtoResult";
		
	}
}
