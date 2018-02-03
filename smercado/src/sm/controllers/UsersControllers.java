package sm.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sm.daos.DadosDAO;
import sm.daos.EntregasDAO;
import sm.daos.ProdutoDAO;
import sm.daos.VendasDAO;
import sm.models.Entregas;
import sm.models.Produto;
import sm.models.Vendas;

@Controller
public class UsersControllers {

	ProdutoDAO pdao = new ProdutoDAO();
	VendasDAO vdao = new VendasDAO();
	DadosDAO ddao = new DadosDAO();
	EntregasDAO edao = new EntregasDAO();

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView form() {

		ModelAndView modelAndView = new ModelAndView("login/form");

		return modelAndView;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(String email, String senha, HttpSession session) {

		String aux = "usuarios/error";

		ModelAndView modelAndView = new ModelAndView(aux);

		if (ddao.login(email, senha) == true) {

			int tipo = ddao.getTipo(email, senha);
			long id = ddao.getID(email);

			if (tipo == 1) {

				// 1 - Usuário normal
				List<Vendas> compras = vdao.getVendasByID(id);
				List<Vendas> comprasOn = vdao.getVendasOnline(id);
				modelAndView.addObject("compras", compras);
				modelAndView.addObject("comprasOn", comprasOn);

				aux = "usuarios/1";

			} else if (tipo == 2) {

				// 2 - Vendedor
				List<Vendas> vendas = vdao.getVendasVend(id);
				List<Produto> produtos = pdao.getProdutos();
				modelAndView.addObject("vendas", vendas);
				modelAndView.addObject("produtos", produtos);

				aux = "usuarios/2";

			} else if (tipo == 3) {

				// 3 - Gerente
				List<Entregas> abertas = edao.Abertas();
				List<Entregas> pegas = edao.Pegas();
				List<Entregas> conc = edao.Concluidos();
				List<Entregas> neg = edao.Negados();
				modelAndView.addObject("abertas", abertas);
				modelAndView.addObject("pegas", pegas);
				modelAndView.addObject("conc", conc);
				modelAndView.addObject("neg", neg);

				aux = "usuarios/3";

			} else if (tipo == 4) {

				// 4 - Administrador
				List<Vendas> vendas = vdao.getVendas();
				modelAndView.addObject("vendas", vendas);

				aux = "usuarios/4";

			} else if (tipo == 5) {

				// 5 - Entregador
				List<Entregas> abertas = edao.getEntAbID(id);
				List<Entregas> pegas = edao.getEntPgID(id);
				List<Entregas> conc = edao.getEntConcID(id);
				List<Entregas> neg = edao.getEntNegID(id);
				modelAndView.addObject("abertas", abertas);
				modelAndView.addObject("pegas", pegas);
				modelAndView.addObject("conc", conc);
				modelAndView.addObject("neg", neg);

			}

		}

		return modelAndView;

	}
}
