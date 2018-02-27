package sm.controllers;

import java.util.List;

import javax.servlet.http.HttpServlet;
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
import sm.daos.VendasDAO;
import sm.models.Dados;
import sm.models.Entregas;
import sm.models.Produto;
import sm.models.Vendas;

@Controller
public class DadosController {

	VendasDAO vdao = new VendasDAO();
	DadosDAO ddao = new DadosDAO();
	EntregasDAO edao = new EntregasDAO();
	ProdutoDAO pdao = new ProdutoDAO();

	Dados d = new Dados();

	// Chamados dos forms
	@GetMapping("dados/cadastro")
	public String cliente() {

		return "usuarios/form/form";
	}

	// Cadastros
	@PostMapping(value = "dados/cadastro")
	public String cliente(Dados d, HttpSession s) {

		s.setAttribute("nome", d.getNome());
		System.out.println(d.getTipo());

		if (ddao.novo(d) == true) {
			return "usuarios/form/obg";
		} else {
			return "bkp/error";
		}

	}

	@GetMapping("painel")
	public String painel(HttpSession s) {

		String email = (String) s.getAttribute("email");

		if (email != null) {

			int aux = ddao.getTipoByEmail(email);

			String retorno = "usuarios/" + aux;

			return retorno;

		} else {
			return "cadastro";
		}

	}

	@GetMapping(value = "dados/listar")
	public ModelAndView listar(HttpSession s) {

		String email = (String) s.getAttribute("email");
		ModelAndView mav = new ModelAndView();

		if (email != null && ddao.getTipoByEmail(email) == 4) {
			List<Dados> dados = ddao.getLista();
			mav.setViewName("dados/listar");
			mav.addObject("dados", dados);
		} else {
			mav.setViewName("bkp/acessoNegado");
		}

		return mav;
	}

	// Apagar
	@GetMapping(value = "dados/apagar")
	public ModelAndView apagar() {

		ModelAndView mav = new ModelAndView("dados/apagar");
		return mav;
	}

	@PostMapping(value = "dados/apagar")
	public String apagar(Dados d) {

		System.out.println(">>> Dados apagados");
		System.out.println(d.getEmail());
		System.out.println(d.getSenha());

		if (ddao.remover(d) == true) {
			System.out.println("Apagado com sucesso");
		} else {
			System.out.println("Erro ao apagar");
		}

		return "redirect:/";
	}

	// Alterar
	@GetMapping(value = "dados/alterar")
	public ModelAndView alterar(long id) {

		d = ddao.getByID(id);

		ModelAndView modelAndView = new ModelAndView("dados/alterar");
		modelAndView.addObject("dados", d);

		return modelAndView;
	}

	@PostMapping(value = "dados/alterar")
	public String alterar(Dados d) {

		ddao.alterar(d);

		return "painel";
	}

	// Login
	@GetMapping(value = "dados/login")
	public String login(HttpSession s) {
		
		List<Dados> contas = ddao.getContas();
		s.setAttribute("contas", contas);
		
		return "login/form";
	}

	@PostMapping(value = "login")
	public String login(Dados d, HttpSession s) {

		if (ddao.existe(d.getEmail()) == 1) {

			if (ddao.login(d) == 1) {

				s.setAttribute("email", d.getEmail());
				int tipo = ddao.getTipo(d.getEmail(), d.getSenha());

				s.setAttribute("id", ddao.getID(d.getEmail()));

				if (tipo == 1) {
					return loginCliente(d.getEmail(), s);
				}
				if (tipo == 2) {
					return loginVend(d.getEmail(), s);
				}
				if (tipo == 3) {
					return loginGerente(d.getEmail(), s);
				}
				if (tipo == 4) {
					return loginAdmin(d.getEmail(), s);
				}
				if (tipo == 5) {
					return loginEntreg(d.getEmail(), s);
				}

			} else {
				System.out.println("Erro nas entradas");
				return null;
			}

		} else {
			System.out.println("Email não existe");
			return null;
		}

		return null;

	}

	public String loginCliente(String email, HttpSession s) {

		// ModelAndView mav = new ModelAndView();
		// mav.setViewName("usuarios/1");

		long id = ddao.getID(email);

		List<Vendas> compras = vdao.getVendasByID(id);
		List<Vendas> comprasOn = vdao.getVendasOnline(id);

		s.setAttribute("compras", compras);
		s.setAttribute("comprasOn", comprasOn);

		return "redirect:/";

	}

	public String loginVend(String email, HttpSession s) {

		// ModelAndView mav = new ModelAndView();
		// mav.setViewName("usuarios/2");

		long id = ddao.getID(email);
		
		s.setAttribute("vendedor", email);

		List<Vendas> vendas = vdao.getVendasVend(id);
		List<Produto> produtos = pdao.getProdutos();
		s.setAttribute("vendas", vendas);
		s.setAttribute("produtos", produtos);
		
		//Painel - Fazer pedido
		List<Dados> ent = ddao.getEntregadores();
		s.setAttribute("ent", ent);

		return "redirect:/";
	}

	public String loginGerente(String email, HttpSession s) {

		// ModelAndView mav = new ModelAndView();
		// mav.setViewName("usuarios/3");

		List<Entregas> abertas = edao.Abertas();
		List<Entregas> pegas = edao.Pegas();
		List<Entregas> conc = edao.Concluidos();
		List<Entregas> neg = edao.Negados();
		List<Produto> produtos = pdao.getProdutos();
		List<Dados> ent = ddao.getEntregadores();
		
		s.setAttribute("abertas", abertas);
		s.setAttribute("pegas", pegas);
		s.setAttribute("conc", conc);
		s.setAttribute("neg", neg);
		s.setAttribute("produtos", produtos);
		s.setAttribute("ent", ent);
		
		for(Dados de : ent) {
			System.out.println(de.getNome());
		}

		return "redirect:/";
	}

	public String loginAdmin(String email, HttpSession s) {

		// ModelAndView mav = new ModelAndView();
		// mav.setViewName("usuarios/4");

		List<Vendas> vendas = vdao.getVendas();
		s.setAttribute("vendas", vendas);

		return "redirect:/";
	}

	public String loginEntreg(String email, HttpSession s) {

		// ModelAndView mav = new ModelAndView();
		// mav.setViewName("usuarios/5");

		long id = ddao.getID(email);

		List<Entregas> abertas = edao.getEntAbID(id);
		List<Entregas> pegas = edao.getEntPgID(id);
		List<Entregas> conc = edao.getEntConcID(id);
		List<Entregas> neg = edao.getEntNegID(id);
		s.setAttribute("abertas", abertas);
		s.setAttribute("pegas", pegas);
		s.setAttribute("conc", conc);
		s.setAttribute("neg", neg);

		List<Entregas> ent = edao.getEnt();

		for (Entregas ex : ent) {
			System.out.println(ex.getProduto());
		}

		return "redirect:/";
	}

	@GetMapping("logout")
	public String logout(HttpSession s) {

		s.invalidate();
		return "redirect:/";
	}

	// public String entregador() {
	//
	// return "usuarios/form/ent";
	// }
	//
	// public String gerente() {
	//
	// return "usuarios/form/gerente";
	// }
	//
	// public String vendedor() {
	//
	// return "usuarios/form/vendedor";
	// }

	// @RequestMapping(value="dados/ent", method=RequestMethod.POST)
	// public ModelAndView entregador(Dados d) {
	//
	// d.setTipo(5);
	// ddao.novo(d);
	//
	// return listar();
	// }
	//
	// @RequestMapping(value="dados/gerente", method=RequestMethod.POST)
	// public ModelAndView gerente(Dados d) {
	//
	// d.setTipo(3);
	// ddao.novo(d);
	//
	// return listar();
	// }
	//
	// @RequestMapping(value="dados/vendedor", method=RequestMethod.POST)
	// public ModelAndView vendedor(Dados d) {
	//
	// d.setTipo(2);
	// ddao.novo(d);
	//
	// return listar();
	// }

}
