package sm.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sm.daos.CarrinhoDAO;
import sm.daos.DadosDAO;
import sm.daos.EntregasDAO;
import sm.daos.ProdutoDAO;
import sm.daos.VendasDAO;
import sm.models.Carrinho;
import sm.models.Produto;
import sm.models.Vendas;

@Controller
public class CarrinhoController {

	VendasDAO vdao = new VendasDAO();
	DadosDAO ddao = new DadosDAO();
	EntregasDAO edao = new EntregasDAO();
	ProdutoDAO pdao = new ProdutoDAO();
	CarrinhoDAO cdao = new CarrinhoDAO();

	// Compra online
	@GetMapping("/cancelar")
	public String cancelar(HttpSession session) {

		ArrayList<Carrinho> carrinho = (ArrayList<Carrinho>) session.getAttribute("carrinho");

		carrinho.removeAll(carrinho);

		session.setAttribute("carrinho", carrinho);

		return "redirect:/";

	}

	@PostMapping("/carrinho")
	public String addP(Produto p, HttpSession session, long qCompra) {

		Carrinho c = cdao.getCar(p.getId());
		c.setqCompra(qCompra);
		c.setTotal(c.getqCompra(), c.getPreco());

		ArrayList<Carrinho> carrinho = (ArrayList<Carrinho>) session.getAttribute("carrinho");

		if (carrinho == null) {
			carrinho = new ArrayList<Carrinho>();
			System.out.println(">>> Novo carrinho de compras criado");
		}

		carrinho.add(c);

		for (int i = 0; i < carrinho.size(); i++) {
			c.setIndice(i);
		}

		session.setAttribute("carrinho", carrinho);

		return "redirect:/car";
	}

	@GetMapping("/car")
	public String car() {

		return "carrinho/car";
	}

	@GetMapping("/retirar")
	public String remover(Carrinho c, HttpSession session) {

		ArrayList<Carrinho> carrinho = (ArrayList<Carrinho>) session.getAttribute("carrinho");

		carrinho.remove(c.getIndice());

		session.setAttribute("carrinho", carrinho);

		return "redirect:car";
	}

	@GetMapping("/concluir")
	public ModelAndView concluir(Carrinho c, Produto p, HttpSession session) {

		ArrayList<Carrinho> carrinho = (ArrayList<Carrinho>) session.getAttribute("carrinho");

		// int id = (int) session.getAttribute("id");
		String vendedor = (String) session.getAttribute("vendedor");
		String cliente = (String) session.getAttribute("cliente");

		for (Carrinho cd : carrinho) {

			Vendas ve = new Vendas();
			// ve.setUsuario(id);

			ve.setProduto(cdao.getProdId(cd.getProduto()));
			ve.setQtd(cd.getqCompra());
			ve.setValor(ve.getQtd() * cd.getPreco());

			if (vendedor != null) {

				long vend = ddao.getID(vendedor);
				ve.setVendedor(vend);
				return addCliente(ve);

			} else {
				long user = ddao.getID(cliente);
				ve.setUsuario(user);
			}

			Calendar cal = Calendar.getInstance();
			ve.setDataVenda(cal);

			vdao.newVendaOnline(ve);

			pdao.attCompra(pdao.getQtd(ve.getProduto()), ve.getQtd(), ve.getProduto());

		}

		carrinho.removeAll(carrinho);

		session.setAttribute("carrinho", carrinho);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}

	@GetMapping("/add")
	public ModelAndView preCar(HttpSession s, Produto p, Carrinho c) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("carrinho/pre");

		Produto pp = pdao.getProdutoByID(p.getId());
		mav.addObject("produto", pp);

		return mav;
	}

	public ModelAndView addCliente(Vendas ve) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("vendas", ve);
		mav.setViewName("carrinho/cliente");

		return mav;
	}

	@PostMapping("/cVendedor")
	public ModelAndView comVendedor(Vendas ve, String eCliente, HttpSession session) {

		String vendedor = (String) session.getAttribute("vendedor");

		ArrayList<Carrinho> carrinho = (ArrayList<Carrinho>) session.getAttribute("carrinho");
		ModelAndView mav = new ModelAndView();

		for (Carrinho c : carrinho) {

			Vendas v = new Vendas();

			v.setVendedor(ddao.getID(vendedor));
			v.setProduto(cdao.getProdId(c.getProduto()));
			v.setQtd(c.getqCompra());
			v.setValor(v.getQtd() * c.getPreco());
			v.setUsuario(ddao.getID(eCliente));

			Calendar cal = Calendar.getInstance();
			v.setDataVenda(cal);

			vdao.newVenda(v);

			pdao.attCompra(pdao.getQtd(ve.getProduto()), ve.getQtd(), ve.getProduto());

		}

		carrinho.removeAll(carrinho);

		session.setAttribute("carrinho", carrinho);
		
		attVend(session);

		mav.setViewName("redirect:/");

		return mav;
	}
	
	public void attVend(HttpSession s) {
		
		String vendedor = (String) s.getAttribute("vendedor");
		long vend = ddao.getID(vendedor);
		
		List<Vendas> vendas = vdao.getVendasVend(vend);
		List<Produto> produtos = pdao.getProdutos();
		s.setAttribute("vendas", vendas);
		s.setAttribute("produtos", produtos);
		
	}

}
