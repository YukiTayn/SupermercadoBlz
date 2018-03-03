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

	@GetMapping("dados/cadastro")
	public String cliente(HttpSession s) {

		s.invalidate();
		return "usuarios/form/form";
	}

	@PostMapping(value = "dados/cadastro")
	public String cliente(Dados d, HttpSession s) {

		s.setAttribute("nomeC", d.getNome());
		System.out.println(d.getTipo());

		if (d.getTipo() == 0) {
			d.setTipo(1);
		}

		if (ddao.novo(d) == true) {
			
			List<Dados> dados = ddao.getContas();
			s.removeAttribute("contas");
			s.setAttribute("contas", dados);
			
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
			return cliente(s);
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

	@GetMapping(value = "dados/apagar")
	public ModelAndView apagar() {

		ModelAndView mav = new ModelAndView("dados/apagar");
		return mav;
	}

	@PostMapping(value = "dados/apagar")
	public String apagar(Dados d, HttpSession s) {

		System.out.println(">>> Dados apagados");
		System.out.println(d.getEmail());
		System.out.println(d.getSenha());

		if (ddao.remover(d) == true) {
			System.out.println("Apagado com sucesso");
		} else {
			System.out.println("Erro ao apagar");
		}
		
		s.invalidate();

		return "redirect:/";
	}

	@GetMapping(value = "dados/alterar")
	public ModelAndView alterar(long id) {

		d = ddao.getByID(id);

		ModelAndView modelAndView = new ModelAndView("dados/alterar");
		modelAndView.addObject("dados", d);

		return modelAndView;
	}

	@PostMapping(value = "dados/alterar")
	public String alterar(Dados d, HttpSession s) {

		ddao.alterar(d);
		s.setAttribute("nome", d.getNome());

		return painel(s);
	}

	@GetMapping(value = "dados/login")
	public String login(HttpSession s) {

		s.removeAttribute("contas");
		List<Dados> contas = ddao.getContas();
		s.setAttribute("contas", contas);

		return "login/form";
	}

	@PostMapping(value = "login")
	public String login(Dados d, HttpSession s) {

		s.removeAttribute("mensagem");

		if (ddao.existe(d.getEmail()) == 1) {

			if (ddao.login(d) == 1) {

				s.setAttribute("email", d.getEmail());
				int tipo = ddao.getTipo(d.getEmail(), d.getSenha());
				s.setAttribute("id", ddao.getID(d.getEmail()));

				if (tipo == 2) {
					s.setAttribute("vendedor", d.getEmail());
				} else {
					s.setAttribute("cliente", d.getEmail());
				}

				String nome = ddao.getNome(d.getEmail());
				s.setAttribute("nome", nome);

				if (tipo == 1) {
					s.setAttribute("cargo", "cliente");
					return loginCliente(d.getEmail(), s);
				}
				if (tipo == 2) {
					s.setAttribute("cargo", "vendedor");
					return loginVend(d.getEmail(), s);
				}
				if (tipo == 3) {
					s.setAttribute("cargo", "gerente");
					return loginGerente(d.getEmail(), s);
				}
				if (tipo == 4) {
					s.setAttribute("cargo", "administrador");
					return loginAdmin(d.getEmail(), s);
				}
				if (tipo == 5) {
					s.setAttribute("cargo", "entregador");
					return loginEntreg(d.getEmail(), s);
				}

			} else {
				System.out.println("Erro nas entradas");

				String me = "Erro ao tentar logar, verifique seu email e senha e tente novamente";
				s.setAttribute("mensagem", me);
				return login(s);
			}

		} else {
			System.out.println("Email não existe");
			return cliente(s);
		}

		return null;

	}

	public String loginCliente(String email, HttpSession s) {

		long id = ddao.getID(email);

		List<Vendas> compras = vdao.getVendasByID(id);
		List<Vendas> comprasOn = vdao.getVendasOnline(id);

		s.setAttribute("compras", compras);
		s.setAttribute("comprasOn", comprasOn);

		return "redirect:/";

	}

	public String loginVend(String email, HttpSession s) {

		long id = ddao.getID(email);

		s.setAttribute("vendedor", email);

		List<Vendas> vendas = vdao.getVendasVend(id);
		List<Produto> produtos = pdao.getProdutos();
		s.setAttribute("vendas", vendas);
		s.setAttribute("produtos", produtos);

		List<Dados> ent = ddao.getEntregadores();
		s.setAttribute("ent", ent);

		return "redirect:/";
	}

	public String loginGerente(String email, HttpSession s) {

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

		return "redirect:/";
	}

	public String loginAdmin(String email, HttpSession s) {

		List<Vendas> vendas = vdao.getVendas();
		s.setAttribute("vendas", vendas);

		return "redirect:/";
	}

	public String loginEntreg(String email, HttpSession s) {

		long id = ddao.getID(email);

		List<Entregas> abertas = edao.getEntAbID(id);
		List<Entregas> pegas = edao.getEntPgID(id);
		List<Entregas> conc = edao.getEntConcID(id);
		List<Entregas> neg = edao.getEntNegID(id);
		s.setAttribute("abertas", abertas);
		s.setAttribute("pegas", pegas);
		s.setAttribute("conc", conc);
		s.setAttribute("neg", neg);

		return "redirect:/";
	}

	@GetMapping("logout")
	public String logout(HttpSession s) {

		s.invalidate();
		return "redirect:/";
	}

}
