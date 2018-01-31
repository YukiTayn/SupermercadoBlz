package supermercado.controller.comandos.produto;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controller.comandos.Comando;
import supermercado.daos.ProdutoDAO;
import supermercado.models.Produtos;

public class ListarProdutos implements Comando{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ProdutoDAO dao = new ProdutoDAO();
		
		List<Produtos> produtos = dao.getLista();
		request.setAttribute("produtos", produtos);
		
		return "lista.jsp";
	}

}
