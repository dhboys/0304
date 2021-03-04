package org.zerock.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

// junit은 생성자가 없어서 required 안먹는다
// autowired 같은 annotation을 사용할 수 있게 해준다
@RunWith(SpringJUnit4ClassRunner.class)
// applicationContext를 구성하여 빈을 가져온다 -> 빈에 등록되는 것은 아니다 하지만
// applicationContext를 통해서 autowired를 받기해야한다
// xml의 빈들을 가져온다
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {

	@Autowired
	TimeMapper timeMapper;
	
	@Test
	public void testGetTime2() {
		log.info(timeMapper.getTime2());
	}
	
	@Test
	public void testGetTime() {
		
		log.info(timeMapper);
		
		log.info(timeMapper.getTime());
		
	}
	
}
