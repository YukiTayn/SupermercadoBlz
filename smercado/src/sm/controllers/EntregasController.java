package sm.controllers;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sm.daos.DadosDAO;
import sm.daos.EntregasDAO;
import sm.models.Entregas;

@Controller
public class EntregasController {

	DadosDAO ddao = new DadosDAO();
	EntregasDAO edao = new EntregasDAO();
	Entregas e = new Entregas();
	
	//Link
	@RequestMapping("entregas/nova")
	public String formEntrega(HttpSession s) {
		
		String email = (String) s.getAttribute("email");
		
		if(ddao.getTipoByEmail(email) == 3) {
			return "entregas/form";
		}else {
			return "acesso negado";
		}
		
	}
	
	//Retorno "vazio" para futuras implementações
	public ModelAndView blank() {
		
		return null;
	}
	
	//Ações das entregas
	@RequestMapping(value="entregas/nova", method=RequestMethod.POST)
	public ModelAndView nova(Entregas ent, HttpSession s) {
		
		String email = (String)s.getAttribute("email");
		
		if(email != null) {
			
			if(ddao.getTipoByEmail(email) == 3) {
				Calendar cal = Calendar.getInstance();
				ent.setDataPedido(cal);
				ent.setStt(1);
				edao.PedirEntrega(ent);
				
				return blank();
				
			}else {
				
				System.out.println("Sem acesso");
				return blank();
			}
			
		}else {
			System.out.println("Sem login");
			return blank();
		}
		
		
	}
	
	@RequestMapping(value="entregas/cancelar", method=RequestMethod.GET)
	public ModelAndView cancelar(long id, HttpSession s) {
		
		String email = (String)s.getAttribute("email");
		
		if(email != null && ddao.getTipoByEmail(email) == 3) {
			
			if(ddao.getTipoByEmail(email) == 3 || ddao.getTipoByEmail(email) == 5) {
				edao.CancelarEntrega(id);
				
				return blank();
				
			}else {
				
				System.out.println("Sem acesso");
				return blank();
			}
			
		}else {
			System.out.println("Sem login");
			return blank();
		}
	}
	
	@RequestMapping(value="entregas/fechar", method=RequestMethod.GET)
	public ModelAndView fechar(long id, HttpSession s) {
		
	String email = (String)s.getAttribute("email");
		
		if(email != null && ddao.getTipoByEmail(email) == 3) {
			
			if(ddao.getTipoByEmail(email) == 3) {
				
				edao.FecharEntrega(id);
				
				return blank();
				
			}else {
				
				System.out.println("Sem acesso");
				return blank();
			}
			
		}else {
			System.out.println("Sem login");
			return blank();
		}
	}
	
	@RequestMapping(value="entregas/pegar", method=RequestMethod.GET)
	public ModelAndView pegar(long id, HttpSession s) {
		
	String email = (String)s.getAttribute("email");
		
		if(email != null && ddao.getTipoByEmail(email) == 5) {
			
			if(ddao.getTipoByEmail(email) == 5) {
				
				edao.PegarEntrega(id);
				
				return blank();
				
			}else {
				
				System.out.println("Sem acesso");
				return blank();
			}
			
		}else {
			System.out.println("Sem login ou sem acesso");
			return blank();
		}
	}

	@RequestMapping(value="entregas/lista", method=RequestMethod.GET)
	public ModelAndView lista(HttpSession s) {
		
		String email = (String) s.getAttribute("email");
		ModelAndView mav = new ModelAndView();
		
		if(ddao.getTipoByEmail(email) == 3) {
			List<Entregas> lista = edao.getEnt();
			mav.addObject("lista", lista);
			mav.setViewName("entregas/lista");
			mav.setViewName("");
		}else {
			mav.setViewName("");
		}
		
		return mav;
	}
	
}
