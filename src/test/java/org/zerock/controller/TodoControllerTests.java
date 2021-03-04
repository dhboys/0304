package org.zerock.controller;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;

import lombok.extern.log4j.Log4j;
@Log4j
public class TodoControllerTests extends AbstractControllerTests{

	@Test
	public void test1() throws Exception{
		log.info(mockMvc);
		
		mockMvc.perform(post("/todo/add")
				.param("title", "sample....")
				.param("complete", "true"));
	}
}
