package org.zerock.ex6.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.ex6.dto.MovieDTO;
import org.zerock.ex6.dto.PageRequestDTO;
import org.zerock.ex6.service.MovieService;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
@Log4j2
public class MovieController {
	private final MovieService movieService;
	@GetMapping("/register")
	public void register(){

	}
	@PostMapping("/register")
	public String register(MovieDTO movieDTO, RedirectAttributes ra){
		long mno=movieService.register(movieDTO);
		ra.addFlashAttribute("msg",mno);
		return "redirect:/movie/list";
	}

	@GetMapping("/list")
	public void list(PageRequestDTO pageRequestDTO, Model model){
		model.addAttribute("result",movieService.getList(pageRequestDTO));

	}
}