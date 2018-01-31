package sm.controllers;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sm.daos.EntregasDAO;
import sm.models.Entregas;

@Controller
public class EntregasController {

	EntregasDAO edao = new EntregasDAO();
	Entregas e = new Entregas();
	
	//Link
	@RequestMapping("entregas/nova")
	public String formEntrega() {
		
		return "entregas/form";
	}
	
	//Retorno "vazio" para futuras implementações
	public ModelAndView blank() {
		
		return null;
	}
	
	//Ações das entregas
	@RequestMapping(value="entregas/nova", method=RequestMethod.POST)
	public ModelAndView nova(Entregas ent) {
		
		Calendar cal = Calendar.getInstance();
		ent.setDataPedido(cal);
		edao.PedirEntrega(ent);
		
		return blank();
	}
	
	@RequestMapping(value="entregas/cancelar", method=RequestMethod.GET)
	public ModelAndView cancelar(long id) {
		
		edao.CancelarEntrega(id);
		
		return blank();
	}
	
	@RequestMapping(value="entregas/fechar", method=RequestMethod.GET)
	public ModelAndView fechar(long id) {
		
		edao.FecharEntrega(id);
		
		return blank();
	}
	
	@RequestMapping(value="entregas/pegar", method=RequestMethod.GET)
	public ModelAndView pegar(long id) {
		
		edao.PegarEntrega(id);
		
		return blank();
	}

	
	
}
