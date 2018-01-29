package supermercado.controller.comandos.produto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.ProdutoDAO;
import supermercado.models.Produtos;

public class AlterarProduto implements Comando{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String idtxt = request.getParameter("id");
		long id = Long.parseLong(idtxt);
		
		String nome = request.getParameter("nome");
		String marca = request.getParameter("marca");
		String tipo = request.getParameter("tipo");
		
		String quantidade = request.getParameter("quantidade");
		long qtde = Long.parseLong(quantidade);
		
		Produtos p = new Produtos();
		p.setId(id);
		p.setNome(nome);
		p.setMarca(marca);
		p.setTipo(tipo);
		p.setQuantidade(qtde);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.alterar(p);
		
		return "supermercado?logica=ListarProdutos";
	}

}
