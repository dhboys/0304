package org.zerock.dao;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.entity.Todo;
import org.zerock.mapper.TodoMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//applicationContext를 구성하여 빈을 가져온다 -> 빈에 등록되는 것은 아니다 하지만
//applicationContext를 통해서 autowired를 받기해야한다
//xml의 빈들을 가져온다
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TodoMapperTests {

	@Autowired
	TodoMapper todoMapper;
	
	@Test
	public void testInsert() {
		
		IntStream.rangeClosed(1, 100)
		.forEach(i -> {
			Todo todo = Todo.builder().title("t"+i).build();
			todoMapper.insert(todo);
		});
	}
	
}
