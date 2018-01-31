package sm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sm.daos.DadosDAO;
import sm.daos.EntregasDAO;
import sm.daos.ProdutoDAO;
import sm.daos.VendasDAO;

@Controller
public class UsersControllers {

	ProdutoDAO pdao = new ProdutoDAO();
	VendasDAO vdao = new VendasDAO();
	DadosDAO ddao = new DadosDAO();
	EntregasDAO edao = new EntregasDAO();
	
	
	@RequestMapping("login")
	public String form() {
		
		return "login";
	}
	
	public ModelAndView login(String email, String senha) {
		
		int tipo = ddao.getTipo(email, senha);
		
		if(tipo == 1) {
			//
		}else if(tipo == 2){
			//
		}else if(tipo == 3) {
			//
		}else if(tipo == 4) {
			//
		}else if(tipo == 5) {
			//
		}else if(tipo < 1 || tipo > 5) {
			//
		}
		
		return null;
	}
}
