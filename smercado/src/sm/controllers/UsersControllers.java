package sm.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sm.daos.DadosDAO;
import sm.daos.EntregasDAO;
import sm.daos.ProdutoDAO;
import sm.daos.UserDAO;
import sm.daos.VendasDAO;

@Controller
public class UsersControllers {

	ProdutoDAO pdao = new ProdutoDAO();
	VendasDAO vdao = new VendasDAO();
	DadosDAO ddao = new DadosDAO();
	EntregasDAO edao = new EntregasDAO();
	UserDAO udao = new UserDAO();

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView form() {
		
		ModelAndView modelAndView = new ModelAndView("login/form");
		
		return modelAndView;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(String email, String senha, HttpSession session) {

		boolean aux = false;

		if (udao.login(email, senha) == true) {

			int tipo = ddao.getTipo(email, senha);

			if (tipo == 1) {
				//
			} else if (tipo == 2) {
				//
			} else if (tipo == 3) {
				//
			} else if (tipo == 4) {

				session.setAttribute("usuario", email);
				aux = true;

			} else if (tipo == 5) {
				//
			} else if (tipo < 1 || tipo > 5) {
				//
			}

		}

		if (aux == true) {
			ModelAndView modelAndView = new ModelAndView("login/sess");
			return modelAndView;
			
		} else {
			ModelAndView modelAndView = new ModelAndView("login/error");
			return modelAndView;
			
		}

	}
}
