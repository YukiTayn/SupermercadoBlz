package sm.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Testes {

	@RequestMapping("sess")
	public ModelAndView sess(String nome, HttpSession session) {
		
		ModelAndView modelAndView = new ModelAndView("testes/aft");
		session.setAttribute("nome", nome);
		
		return modelAndView;
	}
	
	@RequestMapping("sess/form")
	public String sess() {
		
		return "testes/form";
	}
}
