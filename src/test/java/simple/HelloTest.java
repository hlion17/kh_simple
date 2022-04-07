package simple;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import web.dao.face.HelloDao;
import web.dto.Dept;
import web.service.face.HelloService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
class HelloTest {
	
	@Autowired
	private HelloService helloService;
	
	@Autowired
	private HelloDao HelloDao;

	@Test
	void testServiceTest() {
		List<Dept> list = helloService.serviceTest();
		assertNotNull(list);
	}

}
