package sm.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping("/cancelar")
	public String cancelar(HttpSession session) {
		
		ArrayList<Carrinho> carrinho = (ArrayList<Carrinho>) session.getAttribute("carrinho");
		
		carrinho.removeAll(carrinho);
		
		session.setAttribute("carrinho", carrinho);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/carrinho")
	public String addP(Produto p, HttpSession session) {
		
		
		Carrinho c = cdao.getCar(p.getId());
		c.setTotal(c.getQuantidade(), c.getPreco());
		
		ArrayList<Carrinho> carrinho = (ArrayList<Carrinho>) session.getAttribute("carrinho");
		
		if(carrinho == null) {
			carrinho = new ArrayList<Carrinho>();
			System.out.println(">>> Novo carrinho de compras criado");
		}
		
		carrinho.add(c);
		
		for(int i = 0; i < carrinho.size(); i++) {
			c.setIndice(i);
		}
		
		session.setAttribute("carrinho", carrinho);
		
		return "redirect:car";
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
	public String concluir(Carrinho c,  HttpSession session) {
		
		ArrayList<Carrinho> carrinho = (ArrayList<Carrinho>) session.getAttribute("carrinho");

		int id = (int) session.getAttribute("id");
		//long vendedor = (long) s
		
		for(Carrinho cd : carrinho) {
			
			Vendas ve = new Vendas();
			ve.setUsuario(id);
			//ve.setVendedor(v.getVendedor());
			
			if(cdao.getProdId(cd.getProduto()) != 0) {
				ve.setProduto(cdao.getProdId(cd.getProduto()));
			}
			
			ve.setQtd(cd.getQuantidade());
			ve.setValor(cd.getTotal());
			
			Calendar cal = Calendar.getInstance();
			ve.setDataVenda(cal);
			
			if(ve.getVendedor() == 0) {
				vdao.newVendaOnline(ve);
			}else {
				vdao.newVenda(ve);
			}
			
		}
		
		return "redirect:/";
	}
}
