package org.zerock.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.dto.TodoDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

// 1번
@Controller
// 2번
@RequestMapping("/todo")
@Log4j
@RequiredArgsConstructor
public class TodoController {

//	@NonNull
//	private TodoMapper todoMapper;

	// 4.3 버젼부터 지원 , get방식일 때 사용
	// 동일한 URL 처리 방식
	@GetMapping({ "/add", "/add2" })
	public void add() {
		log.info("get..........");
	}

	// 실제 처리
	// annotation은 default가 value , 여러개 사용하려면 속성을 주면 된다 ( produces 어떤 데이터를 만들어서
	// 보내줄건지 ( mime 타입)
	// responseBody는 반환하는 문자 자체가 response 데이터
//	@PostMapping(value = "/add" , produces = "text/plain" )
//	@ResponseBody
//	public String addPost(TodoDTO todoDTO) {
//		log.info(todoDTO);
//		
////		// todoDTO를 Todo로 바꾸어주어야 한다 
////		Todo todo = Todo.builder().title(todoDTO.getTitle())
////								  .complete(todoDTO.getComplete())
////								  .build();
////		
//////		// Mapper에 insert하는 건 Todo 타입
//////		todoMapper.insert(todo);
//		
//		
//		
//		return "success";
//	}

	@PostMapping(value = "/add")
	// rediectAttributes 사용할거면 명시적으로 파라미터 넣어준다
	public String addPost(@Valid TodoDTO todoDTO, BindingResult result, RedirectAttributes rttr) {
		log.info(todoDTO);
		// 검증했는데 잘못된 것이 있으면 다시 입력하는 페이지로 보내야한다
		if (result.hasErrors()) {
			log.info("has errors" + result);
			return "/todo/add";
		}

		rttr.addFlashAttribute("msg", "success");

		return "redirect:/todo/list";
	}

	@GetMapping("/list")
	public void list(Model model) {
		log.info("list.......");
		// map
		List<TodoDTO> list = IntStream.rangeClosed(1, 10).mapToObj(i -> {
			TodoDTO dto = new TodoDTO();
			dto.setTno(i);
			dto.setTitle("타이틀");
			return dto;
		}).collect(Collectors.toList());

		model.addAttribute("list", list);

	}

	@PostMapping(value = "/add2")
	@ResponseBody
	// rediectAttributes 사용할거면 명시적으로 파라미터 넣어준다
	public Object add2Post(@Valid TodoDTO todoDTO, BindingResult result) {
		log.info(todoDTO);
		// 검증했는데 잘못된 것이 있으면 다시 입력하는 페이지로 보내야한다
		if (result.hasErrors()) {
			log.info("has errors" + result);
			// 모든 에러들 확인하는 코드
			//result.getAllErrors();
			
			return result.getAllErrors();
		}

		return null;
	}

}
