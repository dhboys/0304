package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.mapper.TimeMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
// component scan할 때 이 클래스의 객체를 빈에 등록하라는 annotation -> controller로 빈등록 끝
@Controller
@Log4j
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {
	
	private final TimeMapper timeMapper;

	@RequestMapping("/doA")
	// 화면에 전달하고 싶으면 Model 을 추가해주면 된다( parameter로 )
	public void doA(Model model) {
		log.info("doA.....");
		String now = timeMapper.getTime();
		log.info(now);
		// request.setAttribute와 같은 역할
		model.addAttribute("time", now);
	}
	
	@RequestMapping("/doB")
	public void doB() {
		log.info("doB....");
	}
	
	
	
}
