package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
{"file:src/main/webapp/WEB-INF/spring/root-context.xml",
 "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
// web쪽 test를 위한 annotation ( WebApplicationContext를 생성할 수 있도록 하는 annotation
@WebAppConfiguration
public class AbstractControllerTests {

	@Autowired
	// URL을 던지면 찾아서 해결해주는 역할
	WebApplicationContext ctx;
	
	MockMvc mockMvc;
	
	// 가짜 MVC 준비
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		log.info("setup........");
	}
	
//	@Test
//	public void test1() {
//		log.info(ctx);
//		log.info(mockMvc);
//	}
//	
//	// server를 안띄워도 test 가능
//	@Test
//	public void testDoA() throws Exception{
//		
//		// perform은 RequestBuilder를 파라미터로 받는다
//		// MockMvcRequestBuilders를 static import 하면 get만 사용할 수 있다
////		mockMvc.perform(MockMvcRequestBuilders.get("/sample/doA"));
//		mockMvc.perform(get("/sample/doA"));
//	}
	
}
