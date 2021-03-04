package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.dto.TodoDTO;
import org.zerock.entity.Todo;
import org.zerock.mapper.TodoMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
// 1번
@Controller
// 2번
@RequestMapping("/todo")
@Log4j
@RequiredArgsConstructor
public class TodoController {
	
	@NonNull
	private TodoMapper todoMapper;
	
	// 4.3 버젼부터 지원 , get방식일 때 사용
	@GetMapping("/add")
	public void add() {
		log.info("get..........");
	}
	
	// 실제 처리
	@PostMapping("/add")
	public String addPost(TodoDTO todoDTO) {
		log.info(todoDTO);
		
		// todoDTO를 Todo로 바꾸어주어야 한다 
		Todo todo = Todo.builder().title(todoDTO.getTitle())
								  .complete(todoDTO.isComplete())
								  .build();
		
		// Mapper에 insert하는 건 Todo 타입
		todoMapper.insert(todo);
		
		return "redirect:/todo/list";
	}
	
	@GetMapping("/list")
	public void list() {
		log.info("list.......");
	}
	
	
	
}
