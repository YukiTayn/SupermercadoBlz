package sm.controllers;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sm.daos.DadosDAO;
import sm.daos.EntregasDAO;
import sm.daos.ProdutoDAO;
import sm.models.Dados;
import sm.models.Entregas;
import sm.models.Produto;

@Controller
public class EntregasController {

	DadosDAO ddao = new DadosDAO();
	EntregasDAO edao = new EntregasDAO();
	ProdutoDAO pdao = new ProdutoDAO();
	Entregas e = new Entregas();

	// // Link
	// @GetMapping("entregas/nova")
	// public String formEntrega(Entregas e, HttpSession s) {
	//
	// String email = (String) s.getAttribute("email");
	//
	// long gerente = ddao.getID(email);
	// Calendar dataP = Calendar.getInstance();
	// int stt = 1;
	//
	// e.setGerente(gerente);
	// e.setDataPedido(dataP);
	// e.setStt(stt);
	//
	// System.out.println(e.getGerente());
	// System.out.println(e.getEntregador());
	// System.out.println(e.getProduto());
	// System.out.println(e.getQtd());
	// System.out.println(e.getDataPedido());
	// System.out.println(e.getStt());
	//
	// // if(ddao.getTipoByEmail(email) == 3) {
	// // return "entregas/form";
	// // }else {
	// // return "acesso negado";
	// // }
	//
	// return "redirect:/";
	//
	// }

	// Ações das entregas
	@PostMapping(value = "entregas/nova")
	public String nova(Entregas ent, HttpSession s) {

		String email = (String) s.getAttribute("email");

		long gerente = ddao.getID(email);
		Calendar dataP = Calendar.getInstance();
		int stt = 1;

		ent.setGerente(gerente);
		ent.setDataPedido(dataP);
		ent.setStt(stt);

		if (ddao.getTipoByEmail(email) == 3 || ddao.getTipoByEmail(email) == 4) {

			if (edao.PedirEntrega(ent) == true) {

				List<Entregas> abertas = edao.Abertas();
				List<Entregas> pegas = edao.Pegas();
				List<Entregas> conc = edao.Concluidos();
				List<Entregas> neg = edao.Negados();
				List<Produto> produtos = pdao.getProdutos();
				List<Dados> dados = ddao.getEntregadores();
				// List<Dados> ent = ddao.getEntregadores();

				s.setAttribute("abertas", abertas);
				s.setAttribute("pegas", pegas);
				s.setAttribute("conc", conc);
				s.setAttribute("neg", neg);
				s.setAttribute("produtos", produtos);
				s.setAttribute("ent", dados);

				return "redirect:/";

			} else {

				return "redirect:bkp/error";
			}

		} else {

			return "redirect:bkp/acessoNegado";
		}

		// String email = (String)s.getAttribute("email");
		//
		// if(email != null) {
		//
		// if(ddao.getTipoByEmail(email) == 3) {
		// Calendar cal = Calendar.getInstance();
		// ent.setDataPedido(cal);
		// ent.setStt(1);
		// edao.PedirEntrega(ent);
		//
		// return blank();
		//
		// }else {
		//
		// System.out.println("Sem acesso");
		// return blank();
		// }
		//
		// }else {
		// System.out.println("Sem login");
		// return blank();
		// }

	}

	@GetMapping(value = "entregas/cancelar")
	public String cancelar(long id, HttpSession s) {

		String email = (String) s.getAttribute("email");

		if (email != null && ddao.getTipoByEmail(email) == 3) {

			if (ddao.getTipoByEmail(email) == 3 || ddao.getTipoByEmail(email) == 5) {
				edao.CancelarEntrega(id);

				List<Entregas> abertas = edao.Abertas();
				List<Entregas> pegas = edao.Pegas();
				List<Entregas> conc = edao.Concluidos();
				List<Entregas> neg = edao.Negados();
				List<Produto> produtos = pdao.getProdutos();
				List<Dados> dados = ddao.getEntregadores();
				// List<Dados> ent = ddao.getEntregadores();

				s.setAttribute("abertas", abertas);
				s.setAttribute("pegas", pegas);
				s.setAttribute("conc", conc);
				s.setAttribute("neg", neg);
				s.setAttribute("produtos", produtos);
				s.setAttribute("ent", dados);

				return "redirect:/smercado/painel";
			} else {

				System.out.println("Sem acesso");
				return "redirect:bkp/acessoNegado";
			}

		} else {
			System.out.println("Sem login");
			return "bkp/error";
		}
	}

	@GetMapping(value = "entregas/fechar")
	public String fechar(long id, HttpSession s) {

		String email = (String) s.getAttribute("email");

		if (email != null && ddao.getTipoByEmail(email) == 3) {

			if (ddao.getTipoByEmail(email) == 3) {

				edao.FecharEntrega(id);

				List<Entregas> abertas = edao.Abertas();
				List<Entregas> pegas = edao.Pegas();
				List<Entregas> conc = edao.Concluidos();
				List<Entregas> neg = edao.Negados();
				List<Produto> produtos = pdao.getProdutos();
				List<Dados> dados = ddao.getEntregadores();
				// List<Dados> ent = ddao.getEntregadores();

				s.setAttribute("abertas", abertas);
				s.setAttribute("pegas", pegas);
				s.setAttribute("conc", conc);
				s.setAttribute("neg", neg);
				s.setAttribute("produtos", produtos);
				s.setAttribute("ent", dados);

				return "redirect:/";

			} else {

				System.out.println("Sem acesso");
				return "redirect:bkp/acessoNegado";
			}

		} else {
			System.out.println("Sem login");
			return "redirect:bkp/error";
		}
	}

	@GetMapping(value = "entregas/pegar")
	public String pegar(long id, HttpSession s) {

		String email = (String) s.getAttribute("email");

		if (email != null && ddao.getTipoByEmail(email) == 5) {

			if (ddao.getTipoByEmail(email) == 5) {

				edao.PegarEntrega(id);

				
				long idd = ddao.getID(email);
				List<Entregas> abertas = edao.getEntAbID(idd);
				List<Entregas> pegas = edao.getEntPgID(idd);
				List<Entregas> conc = edao.getEntConcID(idd);
				List<Entregas> neg = edao.getEntNegID(idd);
				s.setAttribute("abertas", abertas);
				s.setAttribute("pegas", pegas);
				s.setAttribute("conc", conc);
				s.setAttribute("neg", neg);

				return "redirect:/";

			} else {

				System.out.println("Sem acesso");
				return "redirect:bkp/acessoNegado";
			}

		} else {
			System.out.println("Sem login ou sem acesso");
			return "redirect:bkp/error";
		}
	}

	@GetMapping("entregas/negar")
	public String negar(long id, HttpSession s) {

		String email = (String) s.getAttribute("email");
		

		if (email != null && ddao.getTipoByEmail(email) == 5) {

			long idd = ddao.getID(email);
			
			if (ddao.getTipoByEmail(email) == 5) {

				edao.NegarEntrega(id);

				List<Entregas> abertas = edao.getEntAbID(idd);
				List<Entregas> pegas = edao.getEntPgID(idd);
				List<Entregas> conc = edao.getEntConcID(idd);
				List<Entregas> neg = edao.getEntNegID(idd);
				s.setAttribute("abertas", abertas);
				s.setAttribute("pegas", pegas);
				s.setAttribute("conc", conc);
				s.setAttribute("neg", neg);

				return "redirect:/";

			} else {

				System.out.println("Sem acesso");
				return "redirect:bkp/acessoNegado";
			}

		} else {
			System.out.println("Sem login ou sem acesso");
			return "redirect:bkp/error";
		}
	}

	@GetMapping(value = "entregas/lista")
	public ModelAndView lista(HttpSession s) {

		String email = (String) s.getAttribute("email");
		ModelAndView mav = new ModelAndView();

		if (ddao.getTipoByEmail(email) == 3 || ddao.getTipoByEmail(email) == 4) {
			List<Entregas> lista = edao.getEnt();
			mav.addObject("lista", lista);
			mav.setViewName("entregas/lista");
		} else {
			mav.setViewName("bkp/acessoNegado");
		}

		return mav;
	}

}
