package web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Dept;
import web.service.face.HelloService;

@Component
public class HelloController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value = "/test/hello", method = RequestMethod.GET)
	public String hello(Model model) {
		logger.info("/test/hello [GET]");
		
		// 서비스 메소드 호출
		List<Dept> list = helloService.serviceTest();
		
		// 모델값 지정
		model.addAttribute("list", list);
		
		return "test/hello";
	}

}
