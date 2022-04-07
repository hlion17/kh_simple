package web.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import web.dao.face.HelloDao;
import web.dto.Dept;
import web.service.face.HelloService;

@Component
public class HelloServiceImpl implements HelloService {

	private static final Logger logger = LoggerFactory.getLogger(HelloService.class);
	
	@Autowired
	private HelloDao helloDao;
	
	@Override
	public List<Dept> serviceTest() {
		logger.info("serviceTest() 메소드 시작");
		
		List<Dept> list = helloDao.selectDept();
		
		return list;
	}

}
