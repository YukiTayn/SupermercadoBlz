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
	public String concluir(Carrinho c, Produto p, HttpSession session) {

		ArrayList<Carrinho> carrinho = (ArrayList<Carrinho>) session.getAttribute("carrinho");

		int id = (int) session.getAttribute("id");
		String vendedor = (String) session.getAttribute("vendedor");
		long vend = ddao.getID(vendedor);

		for (Carrinho cd : carrinho) {

			Vendas ve = new Vendas();
			ve.setUsuario(id);

			if (cdao.getProdId(cd.getProduto()) != 0) {
				ve.setProduto(cdao.getProdId(cd.getProduto()));
			}
			
			if(vendedor != null) {
				ve.setVendedor(vend);
			}

			ve.setQtd(cd.getqCompra());
			ve.setValor(ve.getQtd() * cd.getPreco());

			Calendar cal = Calendar.getInstance();
			ve.setDataVenda(cal);

			if (ve.getVendedor() == 0) {
				vdao.newVendaOnline(ve);
			} else {
				vdao.newVenda(ve);
			}

			pdao.attCompra(pdao.getQtd(ve.getProduto()), ve.getQtd(), ve.getProduto());

		}

		carrinho.removeAll(carrinho);

		session.setAttribute("carrinho", carrinho);

		return "redirect:/";
	}

	@GetMapping("/add")
	public ModelAndView preCar(HttpSession s, Produto p, Carrinho c) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("carrinho/pre");

		Produto pp = pdao.getProdutoByID(p.getId());
		mav.addObject("produto", pp);

		return mav;
	}

	
	
	//Física
	@GetMapping("/newvenda")
	public String newVenda() {
		
		return null;
	}
	
	@GetMapping("/vcarrinho")
	public String newCarrinho(HttpSession s, Produto p, long qCompra) {
		
		List<Carrinho> carrinho = (List<Carrinho>) s.getAttribute("carrinho");
		
		
		if(carrinho == null) {
			carrinho = new ArrayList<Carrinho>();
		}
		
		if(p != null) {
			
			Carrinho c = new Carrinho();
			c.setProduto(p.getNome());
			
			
		}
		
		//adicionar produto
		//set array na session
		//volta para o carrinho jsp
		
		//métodos de meio de caminho
		//se terminar, vai pra conc
		
		
		return null;
	}
	
	
	
	
	// Compra física
	@GetMapping("/cancelarv")
	public String cancelarv(HttpSession session) {

		ArrayList<Carrinho> carrinho = (ArrayList<Carrinho>) session.getAttribute("carrinho");

		carrinho.removeAll(carrinho);

		session.setAttribute("carrinho", carrinho);

		return "redirect:/";

	}

	@PostMapping("/carrinhoF")
	public String addF(Produto p, HttpSession session, long qCompra) {

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

		return "redirect:/carv";
	}

	@PostMapping("/carv")
	public String carv() {

		return "carrinho/carv";
	}

	public String removerv(Carrinho c, HttpSession session) {

		ArrayList<Carrinho> carrinho = (ArrayList<Carrinho>) session.getAttribute("carrinho");

		carrinho.remove(c.getIndice());

		session.setAttribute("carrinho", carrinho);

		return "redirect:carv";

	}

	@GetMapping("/concluirv")
	public String concFisica(Carrinho c, Produto p, HttpSession session) {

		ArrayList<Carrinho> carrinho = (ArrayList<Carrinho>) session.getAttribute("carrinho");

		// int id = (int) session.getAttribute("id");
		String vendedor = (String) session.getAttribute("vendedor");
		String comprador = (String) session.getAttribute("cliente");

		long vend = ddao.getID(vendedor);
		long comp = ddao.getID(comprador);

		for (Carrinho cd : carrinho) {

			Vendas ve = new Vendas();
			ve.setUsuario(comp);
			ve.setVendedor(vend);

			if (cdao.getProdId(cd.getProduto()) != 0) {
				ve.setProduto(cdao.getProdId(cd.getProduto()));
			}

			ve.setQtd(cd.getqCompra());
			ve.setValor(ve.getQtd() * cd.getPreco());

			Calendar cal = Calendar.getInstance();
			ve.setDataVenda(cal);

			System.out.println(ve.getUsuario());
			System.out.println(ve.getVendedor());

			// vdao.newVenda(ve);

			// pdao.attCompra(pdao.getQtd(ve.getProduto()), ve.getQtd(), ve.getProduto());

		}

		// carrinho.removeAll(carrinho);
		//
		// session.setAttribute("carrinho", carrinho);

		return "redirect:/";
	}

	@GetMapping("/addf")
	public ModelAndView preF(HttpSession s, Produto p, Carrinho c) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("carrinho/prev");

		Produto pp = pdao.getProdutoByID(p.getId());
		mav.addObject("produto", pp);

		return mav;
	}

	@GetMapping("/produtosv")
	public String listav() {

		return "produtos/listav";
	}

	@GetMapping("/vendaF")
	public String confirm() {
		
		return "carrinho/prev";
	}
}
